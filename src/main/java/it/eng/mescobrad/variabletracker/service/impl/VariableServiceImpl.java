package it.eng.mescobrad.variabletracker.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import it.eng.mescobrad.variabletracker.config.VariableConfig;
import it.eng.mescobrad.variabletracker.exception.HostNotFoundException;
import it.eng.mescobrad.variabletracker.model.VariableDTO;
import it.eng.mescobrad.variabletracker.service.VariableService;
import reactor.core.publisher.Flux;

@Service
public class VariableServiceImpl implements VariableService {

    @Autowired
    private VariableConfig config;

    @Override
    public ResponseEntity<List<VariableDTO>> matchVariable(String variableName, List<String> categoryNames, String dataType) {

        StringBuilder requestPath = new StringBuilder();
        requestPath.append(String.format("/variables?select=*,concept:concepts(name,type)&name=like.*%s*", variableName));
        requestPath.append("&concepts.or=(");
        requestPath.append(categoryNames.stream().map(name -> String.format("name.like.*%s*", name)).collect(Collectors.joining(",")));
        requestPath.append(")");
        requestPath.append(String.format("&data_type=like.*%s*", dataType));

        WebClient.Builder builder = WebClient.builder();
        WebClient client = builder.baseUrl(config.getHost() + requestPath.toString()).build();

        try {
            Flux<VariableDTO> variables = client.get().exchangeToFlux(response -> {
                if (response.statusCode().equals(HttpStatus.OK)) {
                    return response.bodyToFlux(VariableDTO.class);
                }
                else {
                    return response.createException().flatMapMany(Flux::error);
                }
            });
            return ResponseEntity.ok(variables.collectList().block());
        } catch (Exception e) {
            throw new HostNotFoundException("Metadata Manager is not available at url " + config.getHost());
        }
    }

}
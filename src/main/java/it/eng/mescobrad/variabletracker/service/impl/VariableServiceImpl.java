package it.eng.mescobrad.variabletracker.service.impl;

import java.util.List;

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
    public ResponseEntity<List<VariableDTO>> matchVariable(String variableName, String categoryName, String dataType) {

        String requestPath = String.format("/variables?select=*,concept:concepts(name,type)&name=like.*%s*&concept.name=like.*%s*&data_type=like.*%s*", variableName, categoryName, dataType);

        WebClient.Builder builder = WebClient.builder();
        WebClient client = builder.baseUrl(config.getHost() + requestPath).build();

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
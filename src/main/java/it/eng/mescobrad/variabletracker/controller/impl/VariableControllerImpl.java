package it.eng.mescobrad.variabletracker.controller.impl;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import it.eng.mescobrad.variabletracker.controller.VariableController;
import it.eng.mescobrad.variabletracker.model.VariableDTO;
import it.eng.mescobrad.variabletracker.service.VariableService;

@RestController
public class VariableControllerImpl implements VariableController {

    @Autowired
    private VariableService service;

    @Override
    public ResponseEntity<List<VariableDTO>> getFilteredVariables(String variableName, List<String> categoryNames, String dataType) {
        return service.matchVariable(variableName, categoryNames, dataType);
    }
    
}

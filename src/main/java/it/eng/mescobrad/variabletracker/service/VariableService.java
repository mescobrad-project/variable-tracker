package it.eng.mescobrad.variabletracker.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import it.eng.mescobrad.variabletracker.model.VariableDTO;

public interface VariableService {

    ResponseEntity<List<VariableDTO>> matchVariable(String variableName, List<String> categoryNames, String dataType);
    
}

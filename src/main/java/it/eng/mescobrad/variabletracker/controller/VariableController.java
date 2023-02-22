package it.eng.mescobrad.variabletracker.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.eng.mescobrad.variabletracker.model.VariableDTO;

@RequestMapping("/variables")
public interface VariableController {

    @PostMapping("")
    public ResponseEntity<List<VariableDTO>> getFilteredVariables(@RequestParam String variableName, @RequestParam String categoryName, @RequestParam String dataType);
    
}

package it.eng.mescobrad.variabletracker.service;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;
import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import it.eng.mescobrad.variabletracker.config.VariableConfig;
import it.eng.mescobrad.variabletracker.model.VariableDTO;
import it.eng.mescobrad.variabletracker.service.impl.VariableServiceImpl;

@SpringBootTest
public class VariableServiceTest {

    @Autowired
    VariableConfig config;

    @Autowired
    private VariableServiceImpl underTest;

    @Test
    void canMatchVariable() {
        //Given
        String variableName = "Sleep";
        List<String> categoryNames = Arrays.asList("Disorder","Onset");
        String dataType = "boolean";
        //When
        ResponseEntity<List<VariableDTO>> testresult = this.underTest.matchVariable(variableName, categoryNames, dataType);
        //Then
        assertDoesNotThrow(() -> this.underTest.matchVariable(variableName, categoryNames, dataType));
        assertNotNull(testresult);
    }
    
}

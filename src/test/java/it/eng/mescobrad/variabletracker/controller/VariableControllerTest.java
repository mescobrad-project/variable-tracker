package it.eng.mescobrad.variabletracker.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class VariableControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testServerUp() throws Exception {
        this.mockMvc.perform(post("/variables")
        .param("variableName", "Sleep")
        .param("categoryNames", "Disorder","Onset")
        .param("dataType", "boolean"))
        .andExpect(status().isOk());
    }
    
}

package it.eng.mescobrad.variabletracker.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

@Configuration
@ConfigurationProperties(prefix = "variable")
@Data
public class VariableConfig {

    private String host;
    
}

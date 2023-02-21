package it.eng.mescobrad.variabletracker.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class VariableDTO {

    @JsonProperty("variable_id")
    private String variableId;

    private String name;

    @JsonProperty("creation_date")
    private String creationDate;

    @JsonProperty("measure_level")
    private String measureLevel;

    @JsonProperty("data_type")
    private String dataType;

    @JsonProperty("measure_unit")
    private String measureUnit;

    private String direct;

    private String formula;

    @JsonProperty("answer_number")
    private int answerNumber;

    private boolean personaldata;

    private String owner;
    
    @JsonProperty("concept")
    private List<CategoryDTO> category;
    
}

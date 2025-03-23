package edu.icet.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Question {
    @JsonIgnore
    private Integer id;
    @JsonIgnore
    private Integer examId;
    private String text;
    private String options;
    private String correctAnswer;
    private Integer points;



}

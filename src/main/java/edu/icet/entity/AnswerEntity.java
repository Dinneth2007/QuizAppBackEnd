package edu.icet.entity;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AnswerEntity {
    private Integer id;
    @Column(name = "paperId")
    private Integer paperId;
    @Column(name = "question_id")
    private Integer questionId;
    private String answer;
    private Boolean isCorrect;
}

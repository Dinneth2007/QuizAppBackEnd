package edu.icet.dto;

import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Exam {
   private Integer id;
    private String examName;
    private String description;
    private Integer courseId;
    private String timeLimit;
    private Integer passingScore;
    private Integer questionCount;
    @OneToMany
    List<Question> questions;
}

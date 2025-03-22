package edu.icet.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

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
}

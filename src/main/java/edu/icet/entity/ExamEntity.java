package edu.icet.entity;

import edu.icet.dto.Question;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ToString
@Table(name = "exam")
public class ExamEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String examName;
    private String description;
    private Integer courseId;
    private String timeLimit;
    private Integer passingScore;
    private Integer questionCount;
    @OneToMany(mappedBy = "examId" ,cascade = CascadeType.ALL)
    private List<QuestionEntity> questions;
}

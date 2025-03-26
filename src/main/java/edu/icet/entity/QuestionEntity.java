package edu.icet.entity;

import edu.icet.dto.Exam;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "question")
public class QuestionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "exam_id")
    private Integer examId;
    private String text;
    private String options;
    private String correctAnswer;
    private Integer points;
//    @ManyToOne
//    @JoinColumn(name = "exam_id")
//    private ExamEntity exam;

}

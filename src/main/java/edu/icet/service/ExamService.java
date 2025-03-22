package edu.icet.service;

import edu.icet.dto.Exam;

import java.util.List;

public interface ExamService {
    void createExam(Exam exam);
    List <Exam> getExamByCourseId(Integer id);
    List<Exam> getAll();
    void updateExam(Exam exam);
    void deleteExamById(Integer id);
    void deleteExamByCourseId(Integer id);

}

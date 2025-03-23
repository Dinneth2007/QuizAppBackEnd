package edu.icet.service;

import edu.icet.dto.Question;

import java.util.List;

public interface QuestionService {
    List<Question> getByExamId(Integer id);
}

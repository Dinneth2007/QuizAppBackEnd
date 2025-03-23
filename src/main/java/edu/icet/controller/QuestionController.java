package edu.icet.controller;

import edu.icet.dto.Question;
import edu.icet.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/question")
public class QuestionController {
    @Autowired
    QuestionService service;
    @GetMapping("/getAllByExam/{id}")
    List<Question> getAllQuestionsByExam(@PathVariable Integer id){
        return  service.getByExamId(id);
    }
}

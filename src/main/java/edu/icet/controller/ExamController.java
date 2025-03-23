package edu.icet.controller;

import edu.icet.dto.Exam;
import edu.icet.entity.ExamEntity;
import edu.icet.service.ExamService;
import edu.icet.service.impl.ExamServiceImpl;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/exam")
@RequiredArgsConstructor
public class ExamController {
//    http://localhost:8080/exam/create-exam

   final ExamService service;

    @PostMapping("/create-exam")
    public void createExam(@RequestBody Exam exam){

        service.createExam(exam);
    }
    @GetMapping("/get-exam-by-course-id/{id}")
    public List<Exam> getExamByCourseId(@PathVariable Integer id){

        return service.getExamByCourseId(id);
    }
    @GetMapping("/getAll")
    public List<Exam> getAllExams(){

        return service.getAll();
    }
    @Transactional
    @DeleteMapping("/delete/{id}")
    void deleteByCourseId(@PathVariable Integer id){
        service.deleteExamByCourseId(id);
    }


}

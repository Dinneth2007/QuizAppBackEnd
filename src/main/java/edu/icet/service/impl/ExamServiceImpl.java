package edu.icet.service.impl;

import edu.icet.dto.Exam;
import edu.icet.dto.Question;
import edu.icet.entity.ExamEntity;
import edu.icet.entity.QuestionEntity;
import edu.icet.repository.ExamRepository;
import edu.icet.repository.QuestionRepository;
import edu.icet.service.ExamService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ExamServiceImpl implements ExamService {
    final ExamRepository repository;
    @Autowired
    private QuestionRepository questionRepository;
    final ModelMapper mapper;

    @Override
    public void createExam(Exam exam) {
        System.out.println("before mapped"+exam);
        ExamEntity map = mapper.map(exam, ExamEntity.class);

        System.out.println("After Mapped"+map);
        ExamEntity save = repository.save(map);
        //Set the examId of each question in the Questions list to the examId
        for(QuestionEntity ent:map.getQuestions()){

            ent.setExamId(save.getId());
            questionRepository.save(ent);
        }



    }

    @Override
    public List<Exam> getExamByCourseId(Integer id) {
    List<Exam> examDto= new ArrayList<>();

        List<ExamEntity> allByCourseId = repository.findAllByCourseId(id);
        for(ExamEntity entity: allByCourseId){
            examDto.add(mapper.map(entity,Exam.class));
        }
        return examDto;
    }

    @Override
    public List<Exam> getAll() {
        List<Exam> examDtoList= new ArrayList<Exam>();
        for(ExamEntity ent:repository.findAll()){
            examDtoList.add(mapper.map(ent,Exam.class));

        }
        return examDtoList;
    }

    @Override
    public void updateExam(Exam exam) {
//        ExamEntity examEntity = repository.findById(exam.g()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
//        examEntity.setExamName(exam.getExamName());
//         examEntity.setDescription(exam.getDescription());
//         examEntity.setCourseId(exam.getCourseId());
//         examEntity.setTimeLimit(exam.getTimeLimit());
//         examEntity.setPassingScore(exam.getPassingScore());
//         examEntity.setQuestionCount(exam.getQuestionCount());
//        repository.save(examEntity);
    }

    @Override
    public void deleteExamById(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public void deleteExamByCourseId(Integer id) {
        repository.deleteByCourseId(id);
    }
}

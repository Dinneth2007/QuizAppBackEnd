package edu.icet.service.impl;

import edu.icet.dto.Exam;
import edu.icet.entity.ExamEntity;
import edu.icet.repository.ExamRepository;
import edu.icet.service.ExamService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
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
    final ModelMapper mapper;

    @Override
    public void createExam(Exam exam) {
        ExamEntity map = mapper.map(exam, ExamEntity.class);
        System.out.println(map);
        repository.save(mapper.map(exam, ExamEntity.class));
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

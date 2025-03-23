package edu.icet.service.impl;

import edu.icet.dto.Question;
import edu.icet.entity.QuestionEntity;
import edu.icet.repository.QuestionRepository;
import edu.icet.service.QuestionService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.Inet4Address;
import java.util.ArrayList;
import java.util.List;
@Slf4j
@Service
@AllArgsConstructor
public class QuestionServiceImpl implements QuestionService {
    @Autowired
    QuestionRepository questionRepository;
    final ModelMapper mapper;
    @Override
    public List<Question> getByExamId(Integer id) {
        List<Question> examDtoList = new ArrayList<>();
        for (QuestionEntity ent:questionRepository.findAllByExamId(id)){
            examDtoList.add(mapper.map(ent,Question.class));
        }
        return examDtoList;
    }
}

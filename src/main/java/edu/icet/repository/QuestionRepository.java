package edu.icet.repository;

import edu.icet.entity.QuestionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository<QuestionEntity,Integer> {
    List<QuestionEntity> findAllByExamId(Integer id);
}

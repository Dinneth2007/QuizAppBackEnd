package edu.icet.repository;

import edu.icet.dto.Exam;
import edu.icet.entity.ExamEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExamRepository extends JpaRepository<ExamEntity,Integer> {
    List<ExamEntity> findAllByCourseId(Integer id);
    void deleteByCourseId(Integer id);
    ExamEntity findByCourseId(Integer id);
}

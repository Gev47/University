package com.example.university.repository;
import com.example.university.dto.SubjectCountDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.example.university.model.Subject;

import java.util.List;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Long> {
    @Query("SELECT new com.example.university.dto.SubjectCountDTO(s.examType, COUNT(s)) " +
            "FROM Subject s GROUP BY s.examType")
    List<SubjectCountDTO> countSubjectsByExamType();
}

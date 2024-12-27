package com.example.university.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.university.model.Teacher;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {
}



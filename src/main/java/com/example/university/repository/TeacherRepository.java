package com.example.university.repository;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.example.university.model.Teacher;
import org.springframework.data.domain.Pageable;
import java.util.List;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {

    @Query("SELECT t FROM Teacher t WHERE t.department = :department AND t.academicDegree = :degree")
    List<Teacher> findByDepartmentAndAcademicDegree(@Param("department") String department, @Param("degree") String degree);

    Page<Teacher> findAll(Pageable pageable);
}




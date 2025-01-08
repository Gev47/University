package com.example.university.repository;
import com.example.university.dto.ClassSessionDetailDTO;
import com.example.university.model.ClassSession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ClassSessionRepository extends JpaRepository<ClassSession, Long> {
    @Query("SELECT new com.example.university.dto.ClassSessionDetailDTO(cs.date, cs.time, t.fullName, s.name) " +
            "FROM ClassSession cs " +
            "JOIN cs.teacher t " +
            "JOIN cs.subject s")
    List<ClassSessionDetailDTO> findAllClassSessionDetails();

    @Modifying
    @Query("UPDATE ClassSession cs SET cs.auditorium = :newAuditorium WHERE cs.groupName = :groupName")
    int updateAuditoriumByGroupName(@Param("groupName") String groupName, @Param("newAuditorium") String newAuditorium);

}

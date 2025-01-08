package com.example.university.service;
import org.springframework.data.domain.Page;
import com.example.university.dto.TeacherDTO;
import com.example.university.mapper.TeacherMapper;
import com.example.university.model.Teacher;
import com.example.university.repository.TeacherRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TeacherService {

    private final TeacherRepository teacherRepository;

    public TeacherService(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    public ResponseEntity<List<TeacherDTO>> getAllTeachers(int page, int size) {
        Page<Teacher> teacherPage = teacherRepository.findAll(PageRequest.of(page, size));
        List<TeacherDTO> teacherDTOs = teacherPage.getContent().stream()
                .map(TeacherMapper::toDTO)
                .collect(Collectors.toList());

        if (teacherDTOs.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(teacherDTOs);
    }

    public ResponseEntity<TeacherDTO> createTeacher(TeacherDTO teacherDTO) {
        Teacher teacher = TeacherMapper.toEntity(teacherDTO);
        Teacher savedTeacher = teacherRepository.save(teacher);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(TeacherMapper.toDTO(savedTeacher));
    }


    public ResponseEntity<TeacherDTO> getTeacherById(Long id) {
        Teacher teacher = teacherRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Teacher not found with id: " + id));
        return ResponseEntity.ok(TeacherMapper.toDTO(teacher));
    }

    public ResponseEntity<TeacherDTO> updateTeacher(Long id, TeacherDTO updatedTeacherDTO) {
        Teacher updatedTeacher = teacherRepository.findById(id)
                .map(teacher -> {
                    teacher.setFullName(updatedTeacherDTO.getFullName());
                    teacher.setDepartment(updatedTeacherDTO.getDepartment());
                    teacher.setAcademicDegree(updatedTeacherDTO.getAcademicDegree());
                    teacher.setPosition(updatedTeacherDTO.getPosition());
                    return teacherRepository.save(teacher);
                })
                .orElseThrow(() -> new RuntimeException("Teacher not found with id: " + id));

        return ResponseEntity.ok(TeacherMapper.toDTO(updatedTeacher));
    }

    public ResponseEntity<TeacherDTO> deleteTeacher(Long id) {
        Teacher teacher = teacherRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Teacher not found with id: " + id));

        teacherRepository.deleteById(id);
        return ResponseEntity.ok(TeacherMapper.toDTO(teacher));
    }
        public ResponseEntity<List<TeacherDTO>> getTeachersByDepartmentAndDegree(String department, String degree) {
            List<TeacherDTO> teacherDTOs = teacherRepository.findByDepartmentAndAcademicDegree(department, degree)
                    .stream()
                    .map(TeacherMapper::toDTO)
                    .collect(Collectors.toList());

            if (teacherDTOs.isEmpty()) {
                return ResponseEntity.noContent().build();
            }
            return ResponseEntity.ok(teacherDTOs);
        }

    public ResponseEntity<List<TeacherDTO>> getAllTeachersSorted(String sortBy) {
        List<TeacherDTO> sortedTeachers = teacherRepository.findAll(Sort.by(Sort.Direction.ASC, sortBy))
                .stream()
                .map(TeacherMapper::toDTO)
                .collect(Collectors.toList());

        if (sortedTeachers.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(sortedTeachers);
    }
}

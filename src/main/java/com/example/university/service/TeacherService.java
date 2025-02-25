package com.example.university.service;

import com.example.university.dto.TeacherDTO;
import com.example.university.mapper.TeacherMapper;
import com.example.university.model.Teacher;
import com.example.university.repository.TeacherRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TeacherService {

    private final TeacherRepository teacherRepository;

    public TeacherService(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    public List<TeacherDTO> getAllTeachers(int page, int size) {
        Page<Teacher> teacherPage = teacherRepository.findAll(PageRequest.of(page, size));
        return teacherPage.getContent()
                .stream()
                .map(TeacherMapper::toDTO)
                .collect(Collectors.toList());
    }

    public TeacherDTO createTeacher(TeacherDTO teacherDTO) {
        Teacher teacher = TeacherMapper.toEntity(teacherDTO);
        Teacher savedTeacher = teacherRepository.save(teacher);
        return TeacherMapper.toDTO(savedTeacher);
    }

    public TeacherDTO getTeacherById(Long id) {
        Teacher teacher = teacherRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Teacher not found with id: " + id));
        return TeacherMapper.toDTO(teacher);
    }

    public TeacherDTO updateTeacher(Long id, TeacherDTO updatedTeacherDTO) {
        Teacher updatedTeacher = teacherRepository.findById(id)
                .map(teacher -> {
                    teacher.setFullName(updatedTeacherDTO.getFullName());
                    teacher.setDepartment(updatedTeacherDTO.getDepartment());
                    teacher.setAcademicDegree(updatedTeacherDTO.getAcademicDegree());
                    teacher.setPosition(updatedTeacherDTO.getPosition());
                    return teacherRepository.save(teacher);
                })
                .orElseThrow(() -> new RuntimeException("Teacher not found with id: " + id));
        return TeacherMapper.toDTO(updatedTeacher);
    }

    public TeacherDTO deleteTeacher(Long id) {
        Teacher teacher = teacherRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Teacher not found with id: " + id));
        teacherRepository.deleteById(id);
        return TeacherMapper.toDTO(teacher);
    }

    public List<TeacherDTO> getTeachersByDepartmentAndDegree(String department, String degree) {
        return teacherRepository.findByDepartmentAndAcademicDegree(department, degree)
                .stream()
                .map(TeacherMapper::toDTO)
                .collect(Collectors.toList());
    }

    public List<TeacherDTO> getAllTeachersSorted(String sortBy) {
        return teacherRepository.findAll(Sort.by(Sort.Direction.ASC, sortBy))
                .stream()
                .map(TeacherMapper::toDTO)
                .collect(Collectors.toList());
    }
}

package com.example.university.controller;

import com.example.university.dto.TeacherDTO;
import com.example.university.service.TeacherService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teachers")
public class TeachersController {

    private final TeacherService teacherService;

    public TeachersController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @GetMapping
    public ResponseEntity<List<TeacherDTO>> getAllTeachers(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "2") int size) {
        List<TeacherDTO> teachers = teacherService.getAllTeachers(page, size);
        if (teachers.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(teachers);
    }

    @PostMapping
    public ResponseEntity<TeacherDTO> createTeacher(@RequestBody TeacherDTO teacherDTO) {
        TeacherDTO createdTeacher = teacherService.createTeacher(teacherDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdTeacher);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TeacherDTO> getTeacherById(@PathVariable Long id) {
        TeacherDTO teacher = teacherService.getTeacherById(id);
        return ResponseEntity.ok(teacher);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TeacherDTO> updateTeacher(@PathVariable Long id, @RequestBody TeacherDTO updatedTeacherDTO) {
        TeacherDTO updatedTeacher = teacherService.updateTeacher(id, updatedTeacherDTO);
        return ResponseEntity.ok(updatedTeacher);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<TeacherDTO> deleteTeacher(@PathVariable Long id) {
        TeacherDTO deletedTeacher = teacherService.deleteTeacher(id);
        return ResponseEntity.ok(deletedTeacher);
    }

    @GetMapping("/filter")
    public ResponseEntity<List<TeacherDTO>> getTeachersByDepartmentAndDegree(
            @RequestParam String department,
            @RequestParam String degree) {
        List<TeacherDTO> teachers = teacherService.getTeachersByDepartmentAndDegree(department, degree);
        if (teachers.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(teachers);
    }

    @GetMapping("/sorted")
    public ResponseEntity<List<TeacherDTO>> getAllTeachersSorted(
            @RequestParam(defaultValue = "fullName") String sortBy) {
        List<TeacherDTO> teachers = teacherService.getAllTeachersSorted(sortBy);
        if (teachers.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(teachers);
    }
}

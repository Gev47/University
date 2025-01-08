package com.example.university.controller;

import com.example.university.service.TeacherService;
import com.example.university.dto.TeacherDTO;
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
        return teacherService.getAllTeachers(page, size);
    }

    @PostMapping
    public ResponseEntity<TeacherDTO> createTeacher(@RequestBody TeacherDTO teacherDTO) {
        return teacherService.createTeacher(teacherDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TeacherDTO> getTeacherById(@PathVariable Long id) {
        return teacherService.getTeacherById(id);
    }


    @PutMapping("/{id}")
    public ResponseEntity<TeacherDTO> updateTeacher(@PathVariable Long id, @RequestBody TeacherDTO updatedTeacherDTO) {
        return teacherService.updateTeacher(id, updatedTeacherDTO);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<TeacherDTO> deleteTeacher(@PathVariable Long id) {
        return teacherService.deleteTeacher(id);
    }

    @GetMapping("/filter")
    public ResponseEntity<List<TeacherDTO>> getTeachersByDepartmentAndDegree(@RequestParam String department, @RequestParam String degree) {
        return teacherService.getTeachersByDepartmentAndDegree(department, degree);
    }

    @GetMapping("/sorted")
    public ResponseEntity<List<TeacherDTO>> getAllTeachersSorted(
            @RequestParam(defaultValue = "fullName") String sortBy) {
        return teacherService.getAllTeachersSorted(sortBy);
    }

}
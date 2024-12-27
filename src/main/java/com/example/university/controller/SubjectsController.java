package com.example.university.controller;

import com.example.university.service.SubjectService;
import com.example.university.dto.SubjectDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subjects")
public class SubjectsController {

    private final SubjectService subjectService;

    public SubjectsController(SubjectService subjectService) {
        this.subjectService = subjectService;
    }

    @GetMapping
    public ResponseEntity<List<SubjectDTO>> getSubjects() {
        return subjectService.getAllSubjects();
    }

    @PostMapping
    public ResponseEntity<SubjectDTO> createSubject(@RequestBody SubjectDTO subjectDTO) {
        return subjectService.createSubject(subjectDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SubjectDTO> getSubject(@PathVariable long id) {
        return subjectService.getSubjectById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SubjectDTO> updateSubject(@PathVariable long id, @RequestBody SubjectDTO updatedSubjectDTO) {
        return subjectService.updateSubject(id, updatedSubjectDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<SubjectDTO> deleteSubject(@PathVariable long id) {
        return subjectService.deleteSubject(id);
    }
}

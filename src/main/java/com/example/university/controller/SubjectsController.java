package com.example.university.controller;

import com.example.university.dto.SubjectCountDTO;
import com.example.university.dto.SubjectDTO;
import com.example.university.service.SubjectService;
import org.springframework.http.HttpStatus;
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
        List<SubjectDTO> subjects = subjectService.getAllSubjects();
        if (subjects.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(subjects);
    }

    @PostMapping
    public ResponseEntity<SubjectDTO> createSubject(@RequestBody SubjectDTO subjectDTO) {
        SubjectDTO createdSubject = subjectService.createSubject(subjectDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdSubject);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SubjectDTO> getSubject(@PathVariable long id) {
        SubjectDTO subject = subjectService.getSubjectById(id);
        return ResponseEntity.ok(subject);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SubjectDTO> updateSubject(@PathVariable long id, @RequestBody SubjectDTO updatedSubjectDTO) {
        SubjectDTO updatedSubject = subjectService.updateSubject(id, updatedSubjectDTO);
        return ResponseEntity.ok(updatedSubject);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<SubjectDTO> deleteSubject(@PathVariable long id) {
        SubjectDTO deletedSubject = subjectService.deleteSubject(id);
        return ResponseEntity.ok(deletedSubject);
    }

    @GetMapping("/count-by-exam-type")
    public ResponseEntity<List<SubjectCountDTO>> countSubjectsByExamType() {
        List<SubjectCountDTO> counts = subjectService.countSubjectsByExamType();
        if (counts.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(counts);
    }
}

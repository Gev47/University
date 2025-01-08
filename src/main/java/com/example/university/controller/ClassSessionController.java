package com.example.university.controller;

import com.example.university.dto.ClassSessionDTO;
import com.example.university.dto.ClassSessionDetailDTO;
import com.example.university.service.ClassSessionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/class-sessions")
public class ClassSessionController {

    private final ClassSessionService classSessionService;

    public ClassSessionController(ClassSessionService classSessionService) {
        this.classSessionService = classSessionService;
    }

    @GetMapping
    public ResponseEntity<List<ClassSessionDTO>> getAllClassSessions() {
        return classSessionService.getAllClassSessions();
    }

    @PostMapping
    public ResponseEntity<ClassSessionDTO> createClassSession(@RequestBody ClassSessionDTO classSessionDTO) {
        return classSessionService.createClassSession(classSessionDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClassSessionDTO> getClassSessionById(@PathVariable Long id) {
        return classSessionService.getClassSessionById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClassSessionDTO> updateClassSession(@PathVariable Long id, @RequestBody ClassSessionDTO classSessionDTO) {
        return classSessionService.updateClassSession(id, classSessionDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ClassSessionDTO> deleteClassSession(@PathVariable Long id) {
        return classSessionService.deleteClassSession(id);
    }
    @GetMapping("/details")
    public ResponseEntity<List<ClassSessionDetailDTO>> getClassSessionDetails() {
       return classSessionService.getClassSessionDetails();
    }
    @PutMapping("/update-auditorium")
    public ResponseEntity<String> updateAuditoriumByGroupName(
            @RequestParam String groupName,
            @RequestParam String newAuditorium) {
        return classSessionService.updateAuditoriumByGroupName(groupName, newAuditorium);
    }
}

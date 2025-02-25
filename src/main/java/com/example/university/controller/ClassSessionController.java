package com.example.university.controller;

import com.example.university.dto.ClassSessionDTO;
import com.example.university.dto.ClassSessionDetailDTO;
import com.example.university.service.ClassSessionService;
import org.springframework.http.HttpStatus;
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
        List<ClassSessionDTO> sessions = classSessionService.getAllClassSessions();
        if (sessions.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(sessions);
    }

    @PostMapping
    public ResponseEntity<ClassSessionDTO> createClassSession(@RequestBody ClassSessionDTO classSessionDTO) {
        ClassSessionDTO createdSession = classSessionService.createClassSession(classSessionDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdSession);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClassSessionDTO> getClassSessionById(@PathVariable Long id) {
        ClassSessionDTO session = classSessionService.getClassSessionById(id);
        return ResponseEntity.ok(session);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClassSessionDTO> updateClassSession(@PathVariable Long id, @RequestBody ClassSessionDTO classSessionDTO) {
        ClassSessionDTO updatedSession = classSessionService.updateClassSession(id, classSessionDTO);
        return ResponseEntity.ok(updatedSession);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ClassSessionDTO> deleteClassSession(@PathVariable Long id) {
        ClassSessionDTO deletedSession = classSessionService.deleteClassSession(id);
        return ResponseEntity.ok(deletedSession);
    }

    @GetMapping("/details")
    public ResponseEntity<List<ClassSessionDetailDTO>> getClassSessionDetails() {
        List<ClassSessionDetailDTO> details = classSessionService.getClassSessionDetails();
        if (details.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(details);
    }

    @PutMapping("/update-auditorium")
    public ResponseEntity<String> updateAuditoriumByGroupName(
            @RequestParam String groupName,
            @RequestParam String newAuditorium) {
        int updatedRows = classSessionService.updateAuditoriumByGroupName(groupName, newAuditorium);
        if (updatedRows > 0) {
            return ResponseEntity.ok("Successfully updated " + updatedRows + " session(s).");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

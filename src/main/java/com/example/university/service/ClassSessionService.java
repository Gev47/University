package com.example.university.service;

import com.example.university.dto.ClassSessionDTO;
import com.example.university.mapper.ClassSessionMapper;
import com.example.university.model.ClassSession;
import com.example.university.repository.ClassSessionRepository;
import com.example.university.repository.SubjectRepository;
import com.example.university.repository.TeacherRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClassSessionService {

    private final ClassSessionRepository classSessionRepository;
    private final TeacherRepository teacherRepository;
    private final SubjectRepository subjectRepository;

    public ClassSessionService(ClassSessionRepository classSessionRepository, TeacherRepository teacherRepository, SubjectRepository subjectRepository) {
        this.classSessionRepository = classSessionRepository;
        this.teacherRepository = teacherRepository;
        this.subjectRepository = subjectRepository;
    }

    public ResponseEntity<List<ClassSessionDTO>> getAllClassSessions() {
        List<ClassSessionDTO> sessions = classSessionRepository.findAll()
                .stream()
                .map(ClassSessionMapper::toDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(sessions);
    }

    public ResponseEntity<ClassSessionDTO> createClassSession(ClassSessionDTO classSessionDTO) {
        ClassSession classSession = ClassSessionMapper.toEntity(classSessionDTO, teacherRepository, subjectRepository);
        ClassSession savedClassSession = classSessionRepository.save(classSession);
        return ResponseEntity.status(HttpStatus.CREATED).body(ClassSessionMapper.toDTO(savedClassSession));
    }

    public ResponseEntity<ClassSessionDTO> getClassSessionById(Long id) {
        ClassSession classSession = classSessionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("ClassSession not found with ID: " + id));
        return ResponseEntity.ok(ClassSessionMapper.toDTO(classSession));
    }

    public ResponseEntity<ClassSessionDTO> updateClassSession(Long id, ClassSessionDTO updatedClassSessionDTO) {
        ClassSession updatedSession = classSessionRepository.findById(id)
                .map(existingSession -> {
                    ClassSession session = ClassSessionMapper.updateEntity(existingSession, updatedClassSessionDTO, teacherRepository, subjectRepository);
                    return classSessionRepository.save(session);
                })
                .orElseThrow(() -> new RuntimeException("ClassSession not found with ID: " + id));
        return ResponseEntity.ok(ClassSessionMapper.toDTO(updatedSession));
    }

    public ResponseEntity<ClassSessionDTO> deleteClassSession(Long id) {
        ClassSession classSession = classSessionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("ClassSession not found with ID: " + id));
        classSessionRepository.deleteById(id);
        return ResponseEntity.ok(ClassSessionMapper.toDTO(classSession));
    }
}

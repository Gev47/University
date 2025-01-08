package com.example.university.service;

import com.example.university.dto.SubjectCountDTO;
import com.example.university.dto.SubjectDTO;
import com.example.university.mapper.SubjectMapper;
import com.example.university.model.Subject;
import com.example.university.repository.SubjectRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SubjectService {

    private final SubjectRepository subjectRepository;

    public SubjectService(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    public ResponseEntity<SubjectDTO> createSubject(SubjectDTO subjectDTO) {
        Subject sb = SubjectMapper.toEntity(subjectDTO);
        Subject savedSubject = subjectRepository.save(sb);
        return ResponseEntity.status(HttpStatus.CREATED).body(SubjectMapper.toDTO(savedSubject));
    }

    public ResponseEntity<SubjectDTO> updateSubject(long id, SubjectDTO updatedSubjectDTO) {
        Subject updatedSubject = subjectRepository.findById(id)
                .map(subject -> {
                    subject.setName(updatedSubjectDTO.getName());
                    subject.setHours(updatedSubjectDTO.getHours());
                    subject.setMandatory(updatedSubjectDTO.isMandatory());
                    subject.setExamType(updatedSubjectDTO.getExamType());
                    return subjectRepository.save(subject);
                })
                .orElseThrow(() -> new RuntimeException("Subject not found with id: " + id));
        return ResponseEntity.ok(SubjectMapper.toDTO(updatedSubject));
    }

    public ResponseEntity<List<SubjectDTO>> getAllSubjects() {
        List<SubjectDTO> subjects = subjectRepository.findAll()
                .stream()
                .map(SubjectMapper::toDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(subjects);
    }

    public ResponseEntity<SubjectDTO> getSubjectById(Long id) {
        Subject subject = subjectRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Subject not found with id: " + id));
        return ResponseEntity.ok(SubjectMapper.toDTO(subject));
    }

    public ResponseEntity<SubjectDTO> deleteSubject(long id) {
        Subject subject = subjectRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Subject not found with id: " + id));
        subjectRepository.deleteById(id);
        return ResponseEntity.ok(SubjectMapper.toDTO(subject));
    }
    public ResponseEntity<List<SubjectCountDTO>> countSubjectsByExamType() {
        List<SubjectCountDTO> result = subjectRepository.countSubjectsByExamType();
        if (result.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(result);
    }
}

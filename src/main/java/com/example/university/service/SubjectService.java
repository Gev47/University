package com.example.university.service;

import com.example.university.dto.SubjectCountDTO;
import com.example.university.dto.SubjectDTO;
import com.example.university.mapper.SubjectMapper;
import com.example.university.model.Subject;
import com.example.university.repository.SubjectRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SubjectService {

    private final SubjectRepository subjectRepository;

    public SubjectService(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    public SubjectDTO createSubject(SubjectDTO subjectDTO) {
        Subject subjectEntity = SubjectMapper.toEntity(subjectDTO);
        Subject savedSubject = subjectRepository.save(subjectEntity);
        return SubjectMapper.toDTO(savedSubject);
    }

    public SubjectDTO updateSubject(long id, SubjectDTO updatedSubjectDTO) {
        Subject updatedSubject = subjectRepository.findById(id)
                .map(subject -> {
                    subject.setName(updatedSubjectDTO.getName());
                    subject.setHours(updatedSubjectDTO.getHours());
                    subject.setMandatory(updatedSubjectDTO.isMandatory());
                    subject.setExamType(updatedSubjectDTO.getExamType());
                    return subjectRepository.save(subject);
                })
                .orElseThrow(() -> new RuntimeException("Subject not found with id: " + id));
        return SubjectMapper.toDTO(updatedSubject);
    }

    public List<SubjectDTO> getAllSubjects() {
        return subjectRepository.findAll()
                .stream()
                .map(SubjectMapper::toDTO)
                .collect(Collectors.toList());
    }

    public SubjectDTO getSubjectById(Long id) {
        Subject subject = subjectRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Subject not found with id: " + id));
        return SubjectMapper.toDTO(subject);
    }

    public SubjectDTO deleteSubject(long id) {
        Subject subject = subjectRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Subject not found with id: " + id));
        subjectRepository.deleteById(id);
        return SubjectMapper.toDTO(subject);
    }

    public List<SubjectCountDTO> countSubjectsByExamType() {
        return subjectRepository.countSubjectsByExamType();
    }
}

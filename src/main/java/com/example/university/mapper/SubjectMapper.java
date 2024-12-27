package com.example.university.mapper;
import com.example.university.model.Subject;
import com.example.university.dto.SubjectDTO;

public class SubjectMapper {
    public static SubjectDTO toDTO(Subject subject) {
        return new SubjectDTO(
                subject.getName(),
                subject.getHours(),
                subject.isMandatory(),
                subject.getExamType()
        );
    }
    public static Subject toEntity(SubjectDTO dto) {
        Subject subject = new Subject();
        subject.setName(dto.getName());
        subject.setHours(dto.getHours());
        subject.setMandatory(dto.isMandatory());
        subject.setExamType(dto.getExamType());
        return subject;
    }

}

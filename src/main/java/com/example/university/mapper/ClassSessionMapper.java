package com.example.university.mapper;

import com.example.university.dto.ClassSessionDTO;
import com.example.university.model.ClassSession;
import com.example.university.model.Subject;
import com.example.university.model.Teacher;
import com.example.university.repository.SubjectRepository;
import com.example.university.repository.TeacherRepository;

public class ClassSessionMapper {

    public static ClassSessionDTO toDTO(ClassSession classSession) {
        return new ClassSessionDTO(
                classSession.getId(),
                classSession.getDate(),
                classSession.getTime(),
                classSession.getAuditorium(),
                classSession.getClassType(),
                classSession.getGroupName(),
                classSession.getTeacher().getId(),
                classSession.getSubject().getId()
        );
    }

    public static ClassSession toEntity(ClassSessionDTO classSessionDTO, TeacherRepository teacherRepository, SubjectRepository subjectRepository) {
        Teacher teacher = teacherRepository.findById(classSessionDTO.getTeacherId())
                .orElseThrow(() -> new RuntimeException("Teacher not found with ID: " + classSessionDTO.getTeacherId()));
        Subject subject = subjectRepository.findById(classSessionDTO.getSubjectId())
                .orElseThrow(() -> new RuntimeException("Subject not found with ID: " + classSessionDTO.getSubjectId()));

        ClassSession classSession = new ClassSession();
        classSession.setDate(classSessionDTO.getDate());
        classSession.setTime(classSessionDTO.getTime());
        classSession.setAuditorium(classSessionDTO.getAuditorium());
        classSession.setClassType(classSessionDTO.getClassType());
        classSession.setGroupName(classSessionDTO.getGroupName());
        classSession.setTeacher(teacher);
        classSession.setSubject(subject);
        return classSession;
    }

    public static ClassSession updateEntity(ClassSession existingSession, ClassSessionDTO updatedDTO, TeacherRepository teacherRepository, SubjectRepository subjectRepository) {
        Teacher teacher = teacherRepository.findById(updatedDTO.getTeacherId())
                .orElseThrow(() -> new RuntimeException("Teacher not found with ID: " + updatedDTO.getTeacherId()));
        Subject subject = subjectRepository.findById(updatedDTO.getSubjectId())
                .orElseThrow(() -> new RuntimeException("Subject not found with ID: " + updatedDTO.getSubjectId()));

        existingSession.setDate(updatedDTO.getDate());
        existingSession.setTime(updatedDTO.getTime());
        existingSession.setAuditorium(updatedDTO.getAuditorium());
        existingSession.setClassType(updatedDTO.getClassType());
        existingSession.setGroupName(updatedDTO.getGroupName());
        existingSession.setTeacher(teacher);
        existingSession.setSubject(subject);
        return existingSession;
    }
}

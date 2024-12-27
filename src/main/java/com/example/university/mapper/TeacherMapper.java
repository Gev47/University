package com.example.university.mapper;

import com.example.university.dto.TeacherDTO;
import com.example.university.model.Teacher;

public class TeacherMapper {

    public static TeacherDTO toDTO(Teacher teacher) {
        return new TeacherDTO(
                teacher.getId(),
                teacher.getFullName(),
                teacher.getDepartment(),
                teacher.getAcademicDegree(),
                teacher.getPosition()
        );
    }

    public static Teacher toEntity(TeacherDTO teacherDTO) {
        Teacher teacher = new Teacher();
        teacher.setId(teacherDTO.getId());
        teacher.setFullName(teacherDTO.getFullName());
        teacher.setDepartment(teacherDTO.getDepartment());
        teacher.setAcademicDegree(teacherDTO.getAcademicDegree());
        teacher.setPosition(teacherDTO.getPosition());
        return teacher;
    }
}

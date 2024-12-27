package com.example.university.dto;

public class TeacherDTO {
    private Long id;
    private String fullName;
    private String department;
    private String academicDegree;
    private String position;

    public TeacherDTO() {}

    public TeacherDTO(Long id, String fullName, String department, String academicDegree, String position) {
        this.id = id;
        this.fullName = fullName;
        this.department = department;
        this.academicDegree = academicDegree;
        this.position = position;
    }

    public Long getId() {
        return id;
    }
    public String getFullName() {
        return fullName;
    }
    public String getDepartment() {
        return department;
    }

    public String getAcademicDegree() {
        return academicDegree;
    }

    public String getPosition() {
        return position;
    }

}

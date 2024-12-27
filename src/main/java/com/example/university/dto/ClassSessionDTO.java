package com.example.university.dto;

import java.time.LocalDate;
import java.time.LocalTime;

public class ClassSessionDTO {
    private Long id;
    private LocalDate date;
    private LocalTime time;
    private String auditorium;
    private String classType;
    private String groupName;
    private Long teacherId;
    private Long subjectId;

    // Constructors
    public ClassSessionDTO() {}

    public ClassSessionDTO(Long id, LocalDate date, LocalTime time, String auditorium, String classType, String groupName, Long teacherId, Long subjectId) {
        this.id = id;
        this.date = date;
        this.time = time;
        this.auditorium = auditorium;
        this.classType = classType;
        this.groupName = groupName;
        this.teacherId = teacherId;
        this.subjectId = subjectId;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public String getAuditorium() {
        return auditorium;
    }

    public void setAuditorium(String auditorium) {
        this.auditorium = auditorium;
    }

    public String getClassType() {
        return classType;
    }

    public void setClassType(String classType) {
        this.classType = classType;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public Long getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Long teacherId) {
        this.teacherId = teacherId;
    }

    public Long getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Long subjectId) {
        this.subjectId = subjectId;
    }
}

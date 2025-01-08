package com.example.university.dto;

import java.time.LocalDate;
import java.time.LocalTime;

public class ClassSessionDetailDTO {
    private LocalDate date;
    private LocalTime time;
    private String teacherName;
    private String subjectName;

    public ClassSessionDetailDTO(LocalDate date, LocalTime time, String teacherName, String subjectName) {
        this.date = date;
        this.time = time;
        this.teacherName = teacherName;
        this.subjectName = subjectName;
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

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }
}


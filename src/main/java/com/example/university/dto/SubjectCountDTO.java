package com.example.university.dto;

public class SubjectCountDTO {
    private String examType;
    private long count;

    public SubjectCountDTO(String examType, long count) {
        this.examType = examType;
        this.count = count;
    }

    public String getExamType() {
        return examType;
    }

    public void setExamType(String examType) {
        this.examType = examType;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }
}

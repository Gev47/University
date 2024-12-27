package com.example.university.dto;
// record class ????
public class SubjectDTO {
    private final String name;
    private final int hours;
    private final boolean mandatory;
    private final String examType;
    public SubjectDTO(String name, int hours, boolean mandatory, String examType) {
        this.name = name;
        this.hours = hours;
        this.mandatory = mandatory;
        this.examType = examType;
    }

    public String getName() {
        return name;
    }
    public int getHours() {
        return hours;
    }
    public boolean isMandatory() {
        return mandatory;
    }
    public String getExamType() {
        return examType;
    }

    @Override
    public String toString() {
        return "SubjectDTO{" +
                "name='" + name + '\'' +
                ", hours=" + hours +
                ", mandatory=" + mandatory +
                ", examType='" + examType + '\'' +
                '}';
    }
}


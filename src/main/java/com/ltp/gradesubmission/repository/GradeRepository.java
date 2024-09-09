package com.ltp.gradesubmission.repository;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import com.ltp.gradesubmission.Grade;

public class GradeRepository {
    private List<Grade> studentGrades = new ArrayList<>();

    public Grade getStudentGrade(int index) {
        return studentGrades.get(index);
    }

    public void addGrade(Grade grade) {
        studentGrades.add(grade);
    }

    public void updateGrade(int index, @Valid Grade grade) {
        studentGrades.set(index, grade);
    }

    public List<Grade> getStudentGrades() {
        return studentGrades;
    }

    
    
}

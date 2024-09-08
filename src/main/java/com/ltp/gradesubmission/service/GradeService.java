package com.ltp.gradesubmission.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ltp.gradesubmission.Constants;
import com.ltp.gradesubmission.Grade;
import com.ltp.gradesubmission.repository.GradeRepository;

@Service 
public class GradeService {

    @Autowired
    GradeRepository gradeRepository;
        
    public Grade getStudentGrade(int index) {
        return gradeRepository.getStudentGrade(index);
    }

    public void addGrade(Grade grade) {
        gradeRepository.addGrade(grade);
    }

    public void updateGrade(int index,Grade grade) {
        gradeRepository.updateGrade(index, grade);
    }

    public List<Grade> getStudentGrades() {
        return gradeRepository.getStudentGrades();
    }

    public int getGradeIndex(String id){
        for (int i = 0; i < getStudentGrades().size(); i++) {
            if (getStudentGrades().get(i).getId().equals(id)) return i;
        }
        return Constants.NOT_FOUND;
    }

    public Grade getGradeById(String id){
        int index = getGradeIndex(id);
        return index == Constants.NOT_FOUND ? new Grade() : getStudentGrade(index);
    }

    public void submitGrade(Grade grade){
        int index = getGradeIndex(grade.getId());
        if (index == Constants.NOT_FOUND) {
            addGrade(grade);
        } else {
            updateGrade(index,grade);
        }
    }
}

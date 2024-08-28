package com.ltp.gradesubmission;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ltp.gradesubmission.repository.GradeRepository;

@Configuration
public class AppConfig {

    @Bean
    public GradeRepository gradeRepository(){
        return new GradeRepository();
    }
}

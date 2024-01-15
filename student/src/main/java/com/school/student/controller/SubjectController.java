package com.school.student.controller;

import com.school.student.entity.SubjectEntity;
import com.school.student.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/subjects")
public class SubjectController {
    private final SubjectService service;
    @Autowired
    public SubjectController(SubjectService service) {
        this.service = service;
    }

    @GetMapping("/class/{classId}")
    public List<SubjectEntity> getAllSubjects(@PathVariable int classId){
        return service.getAllSubjectsByClass(classId);
    }
}

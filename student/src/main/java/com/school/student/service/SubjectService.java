package com.school.student.service;

import com.school.student.dao.SubjectsDao;
import com.school.student.entity.SubjectEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectService {

    private SubjectsDao subjectsDao;

    @Autowired
    public SubjectService(SubjectsDao subjectsDao) {
        this.subjectsDao = subjectsDao;
    }
    public List<SubjectEntity> getAllSubjectsByClass(int classId){
        return subjectsDao.findByClassEntity_Id(classId);
    }
}

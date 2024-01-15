package com.school.student.dao;

import com.school.student.entity.SubjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubjectsDao extends JpaRepository<SubjectEntity,Integer> {

    public List<SubjectEntity> findByClassEntity_Id( int classId) ;
}

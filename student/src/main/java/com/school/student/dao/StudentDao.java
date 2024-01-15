package com.school.student.dao;

import com.school.student.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentDao extends JpaRepository<StudentEntity,Integer> {
    List<StudentEntity> findByClassEntity_Id(int classId);

}

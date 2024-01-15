package com.school.student.dao;

import com.school.student.entity.ClassEntity;
import com.school.student.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClassDao extends JpaRepository<ClassEntity,Integer> {
    //ClassEntity findByClassName(int classid);
}

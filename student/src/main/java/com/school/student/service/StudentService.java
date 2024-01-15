package com.school.student.service;

import com.school.student.dao.ClassDao;
import com.school.student.dao.StudentDao;
import com.school.student.entity.ClassEntity;
import com.school.student.entity.StudentEntity;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class StudentService {
    private final StudentDao studentDao;

    @Autowired
    public StudentService(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

   public List<StudentEntity> getStudentsByClass(int classId){
       List<StudentEntity> students = studentDao.findByClassEntity_Id(classId);
       System.out.println("Retrieved students: " + students);
       return students;
   }
   public List<StudentEntity> getAllStudents(){
       List<StudentEntity> students =studentDao.findAll();
       System.out.println("all students :" + students);
       return studentDao.findAll();
   }
   @Transactional
   public StudentEntity addNewStudent(StudentEntity student){

        return studentDao.save(student);

   }


   public void addStudentsFromExcel(MultipartFile file) throws IOException
    {
        List<StudentEntity> students= ExcelUtils.readStudentsFromExcel(file);
        for (StudentEntity student:students){
            StudentEntity student1 = convertToEntity(student);
            studentDao.save(student1);
        }
    }

    private StudentEntity convertToEntity(StudentEntity student) {
    StudentEntity studentEntity = new StudentEntity();
    studentEntity.setRoll_number(student.getRoll_number());
    studentEntity.setName(student.getName());

    ClassEntity classEntity = student.getClassEntity();
    studentEntity.setClassEntity(classEntity);

    return studentEntity;
}

}

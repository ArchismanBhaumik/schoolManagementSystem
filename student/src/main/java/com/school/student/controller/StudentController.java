package com.school.student.controller;

import com.school.student.entity.StudentEntity;
import com.school.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/student")
public class StudentController {
    private  final StudentService studentService;
    @Autowired
    public StudentController(StudentService stuudentService) {
        this.studentService = stuudentService;
    }

    @GetMapping ("/class/{classId}")
    public List<StudentEntity> getAllStudentsbyClass(@PathVariable int classId){
        if(classId != -1 && classId <=12 ){
            return studentService.getStudentsByClass(classId);
        }
   return null;
    }
    @GetMapping("/all")
    public List<StudentEntity> getAllStudents(){
        return studentService.getAllStudents();
    }

    @PostMapping("/newstudent")

    public StudentEntity addNewStudent(@RequestBody StudentEntity student){
        return studentService.addNewStudent(student);
    }

    @PostMapping ("/upload")

    public ResponseEntity<String> addStudentEntities(@RequestParam("file") MultipartFile file)  {
        try {
            studentService.addStudentsFromExcel(file);
            return ResponseEntity.ok("File uploaded succesfully!");
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("Failed to upload file") ;
        } catch (Exception e) {
            throw e;
        }
    }

}

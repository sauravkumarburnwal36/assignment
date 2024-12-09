package com.assignment3.collegemanagementsystem.College.Management.System.controller;

import com.assignment3.collegemanagementsystem.College.Management.System.entities.AdmissionRecordEntity;
import com.assignment3.collegemanagementsystem.College.Management.System.entities.StudentEntity;
import com.assignment3.collegemanagementsystem.College.Management.System.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.*;
@RestController
@RequestMapping(path="/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService){
        this.studentService=studentService;
    }

    @GetMapping(path="/{studentId}")
    public StudentEntity getStudentById(@PathVariable Long studentId){
        return studentService.getStudentById(studentId);
    }

    @GetMapping
    public List<StudentEntity> getAllStudents(){
        return studentService.getAllStudents();
    }

    @PostMapping
    public StudentEntity createNewStudent(@RequestBody StudentEntity studentEntity){
        return studentService.createNewStudent(studentEntity);
    }

    @PutMapping(path="{studentId}/study/{subjectId}")
    public StudentEntity assignSubjectToStudent(@PathVariable Long studentId,@PathVariable Long subjectId){
        return studentService.assignSubjectToStudent(studentId,subjectId);
    }

}

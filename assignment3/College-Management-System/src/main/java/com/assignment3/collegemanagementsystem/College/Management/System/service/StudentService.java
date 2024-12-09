package com.assignment3.collegemanagementsystem.College.Management.System.service;

import com.assignment3.collegemanagementsystem.College.Management.System.entities.StudentEntity;
import com.assignment3.collegemanagementsystem.College.Management.System.entities.SubjectEntity;
import com.assignment3.collegemanagementsystem.College.Management.System.repositories.StudentRepository;
import com.assignment3.collegemanagementsystem.College.Management.System.repositories.SubjectRepository;
import org.springframework.stereotype.Service;
import java.util.*;
@Service
public class StudentService {

    private final StudentRepository studentRepository;
    private final SubjectRepository subjectRepository;

    public StudentService(StudentRepository studentRepository,
                          SubjectRepository subjectRepository){
        this.studentRepository=studentRepository;
        this.subjectRepository = subjectRepository;
    }
    public StudentEntity getStudentById(Long studentId) {
        return studentRepository.findById(studentId).orElse(null);
    }

    public List<StudentEntity> getAllStudents() {
        return studentRepository.findAll();
    }

    public StudentEntity createNewStudent(StudentEntity studentEntity) {
        return studentRepository.save(studentEntity);
    }

    public StudentEntity assignSubjectToStudent(Long studentId, Long subjectId) {
        Optional<StudentEntity> studentEntity=studentRepository.findById(studentId);
        Optional<SubjectEntity> subjectEntity=subjectRepository.findById(subjectId);

        return studentEntity.flatMap(student->
                subjectEntity.map(subject->{
                    subject.getStudents().add(student);
                    subjectRepository.save(subject);
                    student.getSubjects().add(subject);
                    return student;
                })).orElse(null);
    }
}

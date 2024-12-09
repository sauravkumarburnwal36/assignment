package com.assignment3.collegemanagementsystem.College.Management.System.service;

import com.assignment3.collegemanagementsystem.College.Management.System.entities.ProfessorEntity;
import com.assignment3.collegemanagementsystem.College.Management.System.entities.StudentEntity;
import com.assignment3.collegemanagementsystem.College.Management.System.entities.SubjectEntity;
import com.assignment3.collegemanagementsystem.College.Management.System.repositories.ProfessorRepository;
import com.assignment3.collegemanagementsystem.College.Management.System.repositories.StudentRepository;
import com.assignment3.collegemanagementsystem.College.Management.System.repositories.SubjectRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProfessorService {

    private final ProfessorRepository professorRepository;
    private final SubjectRepository subjectRepository;
    private final StudentRepository studentRepository;

    public ProfessorService(ProfessorRepository professorRepository,
                            SubjectRepository subjectRepository,
                            StudentRepository studentRepository){
        this.professorRepository=professorRepository;
        this.subjectRepository = subjectRepository;
        this.studentRepository = studentRepository;
    }
    public List<ProfessorEntity> getAllProfessors() {
        return professorRepository.findAll();
    }

    public ProfessorEntity getProfessorById(Long professorId) {
        return professorRepository.findById(professorId).orElse(null);
    }

    public ProfessorEntity createNewProfessor(ProfessorEntity professorEntity) {
        return professorRepository.save(professorEntity);
    }

    public ProfessorEntity assignSubjectToProfessor(Long professorId, Long subjectId) {
        Optional<ProfessorEntity> professorEntity=professorRepository.findById(professorId);
        Optional<SubjectEntity> subjectEntity=subjectRepository.findById(subjectId);
        return professorEntity.flatMap(professor->
                subjectEntity.map(subject->{
                    subject.setProfessor(professor);
                    subjectRepository.save(subject);
                    professor.getSubjects().add(subject);
                    return professor;
                })).orElse(null);
    }

    public ProfessorEntity getAssignedSubjectToProfessor(Long professorId) {
        return professorRepository.findById(professorId).orElse(null);
    }

    public ProfessorEntity assignStudentToProfessor(Long professorId, Long studentId) {
        Optional<ProfessorEntity> professorEntity=professorRepository.findById(professorId);
        Optional<StudentEntity> studentEntity=studentRepository.findById(studentId);
        return professorEntity.flatMap(professor->
                studentEntity.map(student->{
                    student.getProfessors().add(professor);
                    studentRepository.save(student);
                    professor.getStudents().add(student);
                    return professor;
                })).orElse(null);
    }
}

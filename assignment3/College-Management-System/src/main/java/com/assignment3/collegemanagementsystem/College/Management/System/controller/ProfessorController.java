package com.assignment3.collegemanagementsystem.College.Management.System.controller;

import java.util.*;
import com.assignment3.collegemanagementsystem.College.Management.System.entities.ProfessorEntity;
import org.springframework.web.bind.annotation.*;
import com.assignment3.collegemanagementsystem.College.Management.System.service.ProfessorService;

@RestController
@RequestMapping(path="/professors")
public class ProfessorController {

    private final ProfessorService professorService;

    public ProfessorController(ProfessorService professorService){
        this.professorService=professorService;
    }

    @GetMapping
    public List<ProfessorEntity> getAllProfessors(){
        return professorService.getAllProfessors();
    }

    @GetMapping(path="/{professorId}")
    public ProfessorEntity getProfessorById(@PathVariable Long professorId){
        return professorService.getProfessorById(professorId);
    }

    @PostMapping
    public ProfessorEntity createNewProfessor(@RequestBody ProfessorEntity professorEntity){
        return professorService.createNewProfessor(professorEntity);
    }

    @PutMapping(path="/{professorid}/teaches/{subjectId}")
    public ProfessorEntity assignSubjectToProfessor(@PathVariable Long professorId,@PathVariable Long subjectId){
        return professorService.assignSubjectToProfessor(professorId,subjectId);
    }

    @GetMapping(path="/assignedSubjectToProfessor/{professorId}")
    public ProfessorEntity getAssignedSubjectToProfessor(@PathVariable Long professorId){
        return professorService.getAssignedSubjectToProfessor(professorId);
    }

    @PutMapping(path="/{professorId}/teach/{studentId}")
    public ProfessorEntity assignStudentToProfessor(@PathVariable Long professorId,@PathVariable Long studentId){
        return professorService.assignStudentToProfessor(professorId,studentId);
    }
}

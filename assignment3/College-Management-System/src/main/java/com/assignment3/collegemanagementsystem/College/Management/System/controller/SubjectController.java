package com.assignment3.collegemanagementsystem.College.Management.System.controller;

import com.assignment3.collegemanagementsystem.College.Management.System.entities.SubjectEntity;
import org.springframework.web.bind.annotation.*;
import com.assignment3.collegemanagementsystem.College.Management.System.service.SubjectService;

import java.util.*;

@RestController
@RequestMapping(path="/subjects")
public class SubjectController {

    private final SubjectService subjectService;

    public SubjectController(SubjectService subjectService){
        this.subjectService=subjectService;
    }

    @GetMapping
    public List<SubjectEntity> getAllSubjects(){
        return subjectService.getAllSubjects();
    }

    @GetMapping(path="/{subjectId}")
    public SubjectEntity getSubjectById(@PathVariable Long subjectId){
        return subjectService.getSubjectById(subjectId);
    }

    @PostMapping
    public SubjectEntity createNewSubject(@RequestBody SubjectEntity subjectEntity){
        return subjectService.createNewSubject(subjectEntity);
    }
}

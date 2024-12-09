package com.assignment3.collegemanagementsystem.College.Management.System.controller;

import com.assignment3.collegemanagementsystem.College.Management.System.entities.AdmissionRecordEntity;
import org.springframework.web.bind.annotation.*;
import com.assignment3.collegemanagementsystem.College.Management.System.service.AdmissionRecordService;

import java.util.*;

@RestController
@RequestMapping(path="/admissionRecords")
public class AdmissionRecordController {
    private final AdmissionRecordService admissionRecordService;

    public AdmissionRecordController(AdmissionRecordService admissionRecordService){
        this.admissionRecordService=admissionRecordService;
    }

    @GetMapping
    public  List<AdmissionRecordEntity> getAdmissionRecords(){
        return admissionRecordService.getAdmissionRecords();
    }

    @GetMapping(path="/{admissionRecordId}")
    public AdmissionRecordEntity getAdmissionRecordById(@PathVariable Long admissionRecordId){
        return admissionRecordService.getAdmissionRecordById(admissionRecordId);
    }

    @PostMapping
    public AdmissionRecordEntity createNewAdmissionRecord(@RequestBody AdmissionRecordEntity admissionRecordEntity){
        return admissionRecordService.createNewAdmissionRecord(admissionRecordEntity);
    }

    @PutMapping(path="/{admissionId}/admissions/{studentId}")
    public AdmissionRecordEntity assignAdmissionToStudents(@PathVariable Long admissionId,@PathVariable Long
                                                           studentId)
    {
        return admissionRecordService.assignAdmissionToStudents(admissionId,studentId);
    }
}

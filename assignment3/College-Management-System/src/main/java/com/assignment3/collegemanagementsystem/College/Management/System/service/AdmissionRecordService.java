package com.assignment3.collegemanagementsystem.College.Management.System.service;

import com.assignment3.collegemanagementsystem.College.Management.System.entities.AdmissionRecordEntity;
import com.assignment3.collegemanagementsystem.College.Management.System.entities.StudentEntity;
import com.assignment3.collegemanagementsystem.College.Management.System.repositories.AdmissionRecordRepository;
import com.assignment3.collegemanagementsystem.College.Management.System.repositories.StudentRepository;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class AdmissionRecordService {
    private final AdmissionRecordRepository admissionRecordRepository;
    private final StudentRepository studentRepository;

    public AdmissionRecordService(AdmissionRecordRepository admissionRecordRepository,
                                  StudentRepository studentRepository){
        this.admissionRecordRepository=admissionRecordRepository;
        this.studentRepository = studentRepository;
    }


    public List<AdmissionRecordEntity> getAdmissionRecords() {
        return admissionRecordRepository.findAll();
    }

    public AdmissionRecordEntity getAdmissionRecordById(Long admissionRecordId) {
        return admissionRecordRepository.findById(admissionRecordId).orElse(null);
    }

    public AdmissionRecordEntity createNewAdmissionRecord(AdmissionRecordEntity admissionRecordEntity) {
        return admissionRecordRepository.save(admissionRecordEntity);
    }

    public AdmissionRecordEntity assignAdmissionToStudents(Long admissionId, Long studentId) {
        Optional<AdmissionRecordEntity> admissionRecordEntity = admissionRecordRepository.findById(admissionId);
        Optional<StudentEntity> studentEntity = studentRepository.findById(studentId);

        return admissionRecordEntity.flatMap(admission->
                studentEntity.map(student->{
//                    admission.setStudent(student);
//                    return admissionRecordRepository.save(admission);
                    student.setAdmissionRecord(admission);

                })).orElse(null);
    }
}

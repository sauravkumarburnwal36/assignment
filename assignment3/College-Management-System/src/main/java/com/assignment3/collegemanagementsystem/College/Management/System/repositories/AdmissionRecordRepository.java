package com.assignment3.collegemanagementsystem.College.Management.System.repositories;

import com.assignment3.collegemanagementsystem.College.Management.System.entities.AdmissionRecordEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdmissionRecordRepository extends JpaRepository<AdmissionRecordEntity,Long> {
}

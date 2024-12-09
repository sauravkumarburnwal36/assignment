package com.assignment3.collegemanagementsystem.College.Management.System.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import java.util.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name="students")
public class StudentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @ManyToMany(mappedBy ="students")
    private Set<ProfessorEntity> professors;

    @ManyToMany
    @JoinTable(name ="student_subjects",
    joinColumns =@JoinColumn(name ="student_id"),
    inverseJoinColumns =@JoinColumn(name="subject_id"))
    @JsonIgnore
    private Set<SubjectEntity> subjects;

    @OneToOne(mappedBy ="student")
    private AdmissionRecordEntity admissionRecord;



}

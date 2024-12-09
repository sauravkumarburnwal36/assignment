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
@Table(name="professors")
public class ProfessorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @ManyToMany
    @JoinTable(name="professor_student",
    joinColumns =@JoinColumn(name="professor_id"),
    inverseJoinColumns =@JoinColumn(name="student_id"))
    @JsonIgnore
    private Set<StudentEntity> students;

    @OneToMany(mappedBy ="professor",fetch =FetchType.LAZY)
    private Set<SubjectEntity> subjects;

}

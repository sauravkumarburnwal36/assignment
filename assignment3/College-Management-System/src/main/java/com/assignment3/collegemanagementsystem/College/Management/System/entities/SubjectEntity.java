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
@Table(name="subjects")
public class SubjectEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @ManyToOne(cascade =CascadeType.ALL)
    @JoinColumn(name ="professor_subject_id",referencedColumnName ="id")
    private ProfessorEntity professor;

    @ManyToMany(mappedBy ="subjects")
    private Set<StudentEntity> students;

}

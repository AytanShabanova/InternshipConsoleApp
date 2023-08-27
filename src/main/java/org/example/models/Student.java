package org.example.models;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.List;


@Entity
@Table(name = "students")
@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long id;
    @Column
    String name;
    @Column
    String surName;
    @ManyToOne
    @JoinColumn(name = "teacher_id",referencedColumnName = "id")
    Teacher teacher;
    @ManyToMany
    @JoinTable(name = "intern_student",
            joinColumns = {@JoinColumn(name = "intern_id",referencedColumnName = "id")},inverseJoinColumns = @JoinColumn(name = "student_id",referencedColumnName = "id"))
    List<Intern>interns;
}

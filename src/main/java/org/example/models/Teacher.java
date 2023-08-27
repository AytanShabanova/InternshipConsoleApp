package org.example.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Check;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "teacher_seq")
    @SequenceGenerator(name = "teacher_seq",allocationSize = 1)
    private Long id;
    @Column(unique = true)
    private String finCode;
    @Column(nullable = false)
    private String name;
    @Column
    private String surName;
    @Column
    private Integer salary;
    @OneToMany(mappedBy = "teacher")
    private List<Student>students;
    @OneToOne(mappedBy = "teacher")
    Intern intern;

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", finCode='" + finCode + '\'' +
                ", name='" + name + '\'' +
                ", surName='" + surName + '\'' +
                ", salary=" + salary +

                ", intern=" + intern +
                '}';
    }
}

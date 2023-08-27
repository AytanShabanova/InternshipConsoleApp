package org.example.models;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "interns")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Intern {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long id;
    String internName;
    String address;
    @OneToOne
    @JoinColumn(name = "teacher_id")
    Teacher teacher;


}

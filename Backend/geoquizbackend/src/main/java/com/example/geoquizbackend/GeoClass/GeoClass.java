package com.example.geoquizbackend.GeoClass;

import com.example.geoquizbackend.Professor.Professor;
import com.example.geoquizbackend.Student.Student;
import jakarta.persistence.*;

import java.util.Set;

@Entity
public class GeoClass {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;
    String name;
    @ManyToOne
    @JoinColumn(name="professor_id")
    Professor professor;
    @OneToMany(mappedBy = "geoClass")
    Set<Student> student;
}

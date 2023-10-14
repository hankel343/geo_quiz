package com.example.geoquizbackend.Student;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    Student findById(long id);

    @Transactional
    void deleteById(long id);
}

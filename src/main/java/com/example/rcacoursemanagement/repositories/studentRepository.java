package com.example.rcacoursemanagement.repositories;

import com.example.rcacoursemanagement.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface studentRepository extends JpaRepository<Student,Long> {
    Student findStudentsByNames(String names);
}

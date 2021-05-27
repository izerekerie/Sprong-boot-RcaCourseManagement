package com.example.rcacoursemanagement.repositories;

import com.example.rcacoursemanagement.models.Marks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface marksRepository extends JpaRepository<Marks,Long> {
    List<Marks> findMarksByStudentNames(String  names);

}

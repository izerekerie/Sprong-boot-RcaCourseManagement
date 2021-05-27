package com.example.rcacoursemanagement.repositories;


import com.example.rcacoursemanagement.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface courseRepository  extends JpaRepository<Course,Long> {
    Course findCourseByCourseCode(String courseCode);
}

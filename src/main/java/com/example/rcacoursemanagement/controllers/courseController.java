package com.example.rcacoursemanagement.controllers;


import com.example.rcacoursemanagement.models.Course;
import com.example.rcacoursemanagement.models.Student;
import com.example.rcacoursemanagement.repositories.courseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin

@RequestMapping("api/courses")
public class courseController {

    @Autowired
    private courseRepository courseRepo;

    @GetMapping// get all courses
    public List<Course> getAll(){
        return  courseRepo.findAll();
    }
    @GetMapping("/{id}")// get all courses
    public Object getOne(@PathVariable Long id){
        Optional<Course> course=courseRepo.findById(id);
        if(course.isEmpty())  return  "course with id "+id+" not found";
        return  courseRepo.getOne(id);
    }
    @GetMapping("by_code/{code}")
    public Object getByCode(@PathVariable String code){
        if(courseRepo.findCourseByCourseCode(code) == null){
            return "No such course found";
        }
       return  courseRepo.findCourseByCourseCode(code);
    }
    @PostMapping// create  course
    public Course createCourse(@RequestBody Course newCourse){

        return  courseRepo.save(newCourse);
    }
    @PutMapping("/{id}") // update by  course id
    public String updateCourse(@PathVariable Long id,@RequestBody Course updatedCourse){
        Optional<Course> course=courseRepo.findById(id);
        if(course.isEmpty())  return  "course with id "+id+" not found";

        updatedCourse.setId(course.get().getId());
        courseRepo.save(updatedCourse);
        return "course with id "+id+" is updated";
    }
    @DeleteMapping("/{id}") //delete course by id
    public String deleteById(@PathVariable Long id){
        Optional<Course> course=courseRepo.findById(id);
        if(course.isEmpty())  return  "course with id "+id+" not found";

        courseRepo.deleteById(id);
        return "course with id "+id+" is deleted";
    }
    @DeleteMapping// delete all courses
    public String deleteAll(@PathVariable Long id){
        Optional<Course> course=courseRepo.findById(id);
        if(course.isEmpty())   return  "course with id "+id+" not found";

        courseRepo.deleteAll();
        return "All courses are deleted";
    }


}

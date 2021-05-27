package com.example.rcacoursemanagement.controllers;

import com.example.rcacoursemanagement.models.Student;
import com.example.rcacoursemanagement.repositories.studentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin

@RequestMapping("api/students")
public class studentController {
    @Autowired
    private studentRepository studentRepo;

    @GetMapping// get all students
    public List<Student> getAllStudent(){
        return  studentRepo.findAll();
    }
    @GetMapping("/{id}")// get student by id
    public Object getById(@PathVariable Long id){
        Optional<Student> student=studentRepo.findById(id);
        if(student.isEmpty())  return  "student with id "+id+" not found";
        return  studentRepo.getOne(id);
    }
    @GetMapping("by_names/{names}")// get student by names
    public Object getByCode(@PathVariable String names){
        if(studentRepo.findStudentsByNames(names) == null){
            return  names+ " student not found";
        }
        return  studentRepo.findStudentsByNames(names);
    }
    @PostMapping// create student
    public  Student createStudent(@RequestBody Student newStudent){

        return  studentRepo.save(newStudent);
    }
    @PutMapping("/{id}") // update by id
    public String updateStudent(@PathVariable Long id,@RequestBody Student updatedStu){
        Optional<Student> student=studentRepo.findById(id);
        if(student.isEmpty())  return  "student with id "+id+" not found";

        updatedStu.setId(student.get().getId());
        studentRepo.save(updatedStu);
        return "Student  with id "+ id+ " is updated";
    }
    @DeleteMapping("/{id}") //delete by id
    public String deleteById(@PathVariable Long id){
        Optional<Student> student=studentRepo.findById(id);
        if(student.isEmpty())  return  "student with id "+id+" not found";

        studentRepo.deleteById(id);
        return "Student  with id "+ id+ " is deleted";
    }
    @DeleteMapping// delete all student
    public String deleteAll(@PathVariable Long id){
        Optional<Student> student=studentRepo.findById(id);
        if(student.isEmpty())  return  "student with id "+id+" not found";

        studentRepo.deleteAll();
        return "All student are deleted";
    }


}




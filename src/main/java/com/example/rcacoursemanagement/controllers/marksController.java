package com.example.rcacoursemanagement.controllers;


import com.example.rcacoursemanagement.models.Course;
import com.example.rcacoursemanagement.models.Marks;
import com.example.rcacoursemanagement.repositories.marksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin

@RequestMapping("api/marks")
public class marksController {

    @Autowired
    private marksRepository marksRepo;

    @GetMapping // get all marks
    public List<Marks> getAll(){
        return  marksRepo.findAll();
    }

//    @GetMapping("/by_student_names/{names}") // get marks by student name
//    public List<Marks>  getMark(@PathVariable String names){
//        return  marksRepo.findMarksByStudentNames(names);
//    }


    @PostMapping
    public  Marks createMark(@RequestBody Marks newMark){
        return  marksRepo.save(newMark);
    }

    @PutMapping("/{id}") // update by  marks id
    public String updateCourse(@PathVariable Long id,@RequestBody Marks updatedMarks){
        Optional<Marks> marks=marksRepo.findById(id);
        if(marks.isEmpty())  return  "marks with id "+id+" not found";

        updatedMarks.setId(marks.get().getId());
        marksRepo.save(updatedMarks);
        return "marks with id "+id+" is updated";
    }
    @DeleteMapping("/{id}") //delete marks by id
    public String deleteById(@PathVariable Long id){
        Optional<Marks> marks=marksRepo.findById(id);
        if(marks.isEmpty())  return  "marks with id "+id+" not found";

        marksRepo.deleteById(id);
        return "marks with id "+id+" is deleted";
    }
    @DeleteMapping// delete all marks
    public String deleteAll(@PathVariable Long id){
        Optional<Marks> marks=marksRepo.findById(id);
        if(marks.isEmpty())   return  "marks with id "+id+" not found";

        marksRepo.deleteAll();
        return "All marks are deleted";
    }


}

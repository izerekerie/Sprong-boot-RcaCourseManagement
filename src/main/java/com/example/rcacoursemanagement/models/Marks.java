package com.example.rcacoursemanagement.models;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
public class Marks {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "course_id", nullable = false)
    private Course course;
    @NotNull
    private   int score, maximum;

    public Marks() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getMaximum() {
        return maximum;
    }

    public Marks(Long id, Student student, Course course, int score, int maximum) {
        this.id = id;
        this.student = student;
        this.course = course;
        this.score = score;
        this.maximum = maximum;
    }

    public void setMaximum(int maximum) {
        this.maximum = maximum;
    }
}

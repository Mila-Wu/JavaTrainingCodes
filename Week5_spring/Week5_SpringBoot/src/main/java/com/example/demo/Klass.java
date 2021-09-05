package com.example.demo;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Klass {
    private String id;
    private String name;
    private List<Student> students = new ArrayList<>();

    public Klass(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public void addStudent(Student student) {
        students.add(student);
    }

}

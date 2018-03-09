package com.example.sanyo.inclass03;

import java.io.Serializable;

/**
 * Created by sanyo on 1/29/2018.
 */

public class Student implements Serializable {
    String name, email, department;
    int mood;

    public Student(String name, String email, String department, int mood) {
        this.name = name;
        this.email = email;
        this.department = department;
        this.mood = mood;
    }
}

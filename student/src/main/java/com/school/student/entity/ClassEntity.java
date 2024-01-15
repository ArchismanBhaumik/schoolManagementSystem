package com.school.student.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "Class")
public class ClassEntity {
    @Id
    private int id;
    private String class_name;

    // getters and setters


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getClass_name() {
        return class_name;
    }

    public void setClass_name(String class_name) {
        this.class_name = class_name;
    }

    @Override
    public String toString() {
        return "ClassEntity{" +
                "id=" + id +
                ", class_name='" + class_name + '\'' +
                '}';
    }
}

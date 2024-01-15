package com.school.student.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "Student")

public class StudentEntity {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "roll_number")
    private int roll_number;
    @Column(name = "name")
    private String name;

    @Override
    public String toString() {
        return "StudentEntity{" +
                "roll_number=" + roll_number +
                ", name='" + name + '\'' +
                ", classEntity=" + classEntity +
                '}';
    }

    @ManyToOne
    @JoinColumn(name = "class_id")
    private ClassEntity classEntity;

    // getters and setters

    public int getRoll_number() {
        return roll_number;
    }

    public void setRoll_number(int roll_number) {
        this.roll_number = roll_number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ClassEntity getClassEntity() {
        return classEntity;
    }

    public void setClassEntity(ClassEntity classEntity) {
        this.classEntity = classEntity;
    }
}

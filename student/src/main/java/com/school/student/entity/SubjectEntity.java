package com.school.student.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "Subject")
public class SubjectEntity {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String subject_name;

    @ManyToOne
    @JoinColumn(name = "class_id")
    private ClassEntity classEntity;

    // getters and setters

    @Override
    public String toString() {
        return "SubjectEntity{" +
                "id=" + id +
                ", subject_name='" + subject_name + '\'' +
                ", classEntity=" + classEntity +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSubject_name() {
        return subject_name;
    }

    public void setSubject_name(String subject_name) {
        this.subject_name = subject_name;
    }

    public ClassEntity getClassEntity() {
        return classEntity;
    }

    public void setClassEntity(ClassEntity classEntity) {
        this.classEntity = classEntity;
    }
}

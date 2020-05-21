package com.example.service;
import com.example.model.Student;

public interface IStudentService {
    Student create(Student student);
    Student read(Integer index);
    Student update(Student student);
    void delete(Integer index);
}
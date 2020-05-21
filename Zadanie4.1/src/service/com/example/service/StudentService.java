package com.example.service;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import com.example.model.Student;
import com.example.service.IStudentService;

public class StudentService implements IStudentService {
    private FileOutputStream fileOut;
    private ObjectOutputStream objectOut;
    private FileInputStream fileIn;
    private ObjectInputStream objectIn;
    static final String filepath= "test";

    private List<Student> getAll(){
        try {
            fileIn = new FileInputStream(filepath);
            objectIn = new ObjectInputStream(fileIn);
            ArrayList<Student> students = new ArrayList<>();
            Object obj = null;

            obj = objectIn.readObject();
            students = (ArrayList<Student>) obj;

            objectIn.close();

            return students;

        } catch (Exception ex) {
            return new ArrayList<>();
        }
    }

    @Override
    public Student create(Student student) {
        ArrayList<Student> students = (ArrayList<Student>) getAll();
        students.add(student);

        try {
            File file = new File("test");
            file.createNewFile();

            fileOut = new FileOutputStream(filepath);
            objectOut = new ObjectOutputStream(fileOut);

            objectOut.writeObject(students);

            objectOut.close();
            return student;
        } catch (Exception ex){
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public Student read(Integer index) {
        ArrayList<Student> students = (ArrayList<Student>) getAll();
        Optional<Student> stud = students.stream().filter(student -> student.getIndex().equals(index)).findFirst();

        if(stud.isPresent()){
            return stud.get();
        }
        else {
            throw new IllegalArgumentException("Student with index " + index + " does not exists!");
        }
    }

    @Override
    public void delete(Integer index) {
        ArrayList<Student> students = (ArrayList<Student>) getAll();
        read(index);

        students = (ArrayList<Student>) students.stream().filter(student -> !student.getIndex().equals(index)).collect(Collectors.toList());

        try{
            File file = new File("test");
            file.createNewFile();

            fileOut = new FileOutputStream(filepath);
            objectOut = new ObjectOutputStream(fileOut);

            objectOut.writeObject(students);

        }catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public Student update(Student student) {
        ArrayList<Student> students = (ArrayList<Student>) getAll();
        read(student.getIndex());

        Student stud = students.stream().filter(s -> s.getIndex().equals(student.getIndex())).findFirst().get();
        stud.setName(student.getName());
        stud.setSurname(student.getSurname());

        try{
            File file = new File("test");
            file.createNewFile();

            fileOut = new FileOutputStream(filepath);
            objectOut = new ObjectOutputStream(fileOut);

            objectOut.writeObject(students);

            objectOut.close();
            return stud;

        }catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
}
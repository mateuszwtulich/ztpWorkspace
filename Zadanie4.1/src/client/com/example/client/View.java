package com.example.client;
import com.example.model.Student;

public class View {

    public void displayHelp(){
        System.out.println("\ncreate index name surname --> creates Student");
        System.out.println("update index name surname --> updates Student");
        System.out.println("read index --> shows Student");
        System.out.println("delete index --> deletes Student\n");
    }

    public void displayStudent(Student student){
        System.out.println(student.toString() + "\n");
    }

    public void displayStart(){
        System.out.println("#############################################################");
        System.out.println("\t\tWelcome in students notebook");
        System.out.println("#############################################################");
        System.out.println("To see possible commands write: help.\nWrite exit to quit.\n");
    }
}

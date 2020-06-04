package com.example.client;

import java.util.Scanner;
import com.example.model.Student;
import com.example.service.StudentService;

public class Controller {
    private View view;
    private StudentService studentService = new StudentService();

    public Controller(View view){
        this.view = view;
    }

    public void initApp(){
        view.displayStart();
        String string = "";
        while(!string.equals("exit")) {
            string = new Scanner(System.in).nextLine();
            if(string.equals("help")) {
                view.displayHelp();
            }
            else if(!string.equals("exit")){
                try {
                    manageCommand(string);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            }
        }
    }

    private void manageCommand(String command){
        if (command.split("\\s+").length > 1) {
            String[] splited = command.split("\\s+");
            detectCommand(splited);
        } else{
            throw new IllegalArgumentException("Command not recognized!");
        }
    }

    private void detectCommand(String[] splited) {

        switch (splited[0]){
            case "create": {
                createStudent(splited);
                break;
            }
            case "update": {
                updateStudent(splited);
                break;
            }
            case "delete": {
                deleteStudent(splited);
                break;
            }
            case "read": {
                readStudent(splited);
                break;
            }
            default: {
                System.out.println("Command does not exists!");
                break;
            }
        }
    }

    private void createStudent(String[] splited){
        if(splited.length == 4){
            try{
                Integer index = Integer.parseInt(splited[1]);
                view.displayStudent(studentService.create(new Student(index, splited[2], splited[3])));
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        } else {
        System.out.println("Command is not valid");
        }
    }

    private void updateStudent(String[] splited){
        if(splited.length == 4){
            try{
                Integer index = Integer.parseInt(splited[1]);
                view.displayStudent(studentService.update(new Student(index, splited[2], splited[3])));
            } catch (Exception ex){
                System.out.println(ex.getMessage());
            }
        } else {
            System.out.println("Command is not valid");
        }
    }

    private void deleteStudent(String[] splited){
        if(splited.length == 2){
            try{
                Integer index = Integer.parseInt(splited[1]);
                studentService.delete(index);
                System.out.println("Student " + index + " has been deleted");
            } catch (Exception ex){
                System.out.println(ex.getMessage());
            }
        } else {
            System.out.println("Command is not valid");
        }
    }

    private void readStudent(String[] splited) {
        if (splited.length == 2) {
            try {
                Integer index = Integer.parseInt(splited[1]);
                view.displayStudent(studentService.read(index));
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        } else {
            System.out.println("Command is not valid");
        }
    }
}

package com.company.service;

import java.util.Scanner;

public class Manager {
    private Parser parser;

    public Manager(Parser parser) {
        this.parser = parser;
    }

    public void initMenu(){
        System.out.println("#############################################################");
        System.out.println("Welcome in Java class Code generator");
        System.out.println("#############################################################");
        System.out.println("To see possible commands write: help.\nWrite exit to quit.\n");

        String string = "";
        while(!string.equals("exit")) {
            string = new Scanner(System.in).nextLine();
            if(string.equals("help")) {
                displayHelpInfo();
            }
            else if(!string.equals("exit")){
                parser.parse(string);
            }
        }
    }

    public static void handleError(String message){
        System.out.println(message);
    }

    private void displayHelpInfo(){
        System.out.println(getHelpString());
    }

    private String getHelpString(){
        String result = "\nWyrażenia:\n<tworzenie klasy> ::= create <nazwa klasy>" +
                "\n<tworzenie klasy z polem> ::= create <nazwa klasy> <nazwa pola>: <typ> [ = <wartość>]" +
                "\n<tworznie klasy z polami> ::= create <nazwa klasy> <nazwa1>: <typ1> [ = <wartość1>], <nazwa2>: <typ2> [ = <wartość2>]" +
                "\n<dodanie flagi> ::= create <nazwa klasy> --<nazwa flagi>" +
                "\n<wyświetlenie informacji> ::= help" +
                "\n\nZnaczenie:\n<dodanie getterów> ::= --getters" +
                "\n<dodanie seterów> ::= --setters" +
                "\n<dodanie buildera> ::= --builder" +
                "\n<zapisanie do pliku> ::= --save" +
                "\n\nWartości:\n<typ> ::= byte | short | int | long | char | String | float | double | boolean" +
                "\n<flaga> ::= --getters | --setters | --builder | --save" +
                "\n<nazwa klasy> ::= <znak który nie jest cyfrą><znaki>" +
                "\n<int> ::= <zapis dzisiętny>" +
                "\n<long> ::= <zapis dzisiętny>" +
                "\n<short> ::= <zapis dzisiętny>" +
                "\n<byte> ::= <zapis dzisiętny>" +
                "\n<char> ::= ‘<pojedynczy znak>’" +
                "\n<boolean> ::= false | true" +
                "\n<float> ::= <cyfry>.<cyfry>" +
                "\n<double> ::= <cyfry>.<cyfry>" +
                "\n<string> ::= “<znaki>”" +
                "\n<null> ::= null\n";
        return result;
    }
}
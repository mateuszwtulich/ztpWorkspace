package com.company;

import com.company.pizza.*;
import com.company.state.PizzaZamowiona;

import java.util.ArrayList;
import java.util.Scanner;

public class Restauracja {
    private ArrayList<Pizza> pizzas = new ArrayList<>();

    public void test() throws InterruptedException {
        selectOptionInMenu();
    }

    private void displayMenu(){
        System.out.println("\n----------------PIZZERIA----------------");
        System.out.println("Wybierz pizze [P]");
        System.out.println("Wyjdz [X]");
        System.out.print("\nWybierz opcje: ");
    }

    private void displayToppings(){
        System.out.println("\n----------------DODATKI----------------");
        System.out.println("Ananas [A]");
        System.out.println("Mozarella [M]");
        System.out.println("Papryka [PA]");
        System.out.println("Pieczarki [PI]");
        System.out.println("Pomidor [PO]");
        System.out.println("Szynka [S]");
        System.out.println("Zamow aktualna pizze [Z]");
        System.out.println("Wyjdz [X]");
        System.out.print("\nWybierz opcje: ");
    }

    private void selectOptionInMenu() throws InterruptedException {
        boolean isMenuEnabled = true;
        do {
            displayMenu();
            Scanner scan = new Scanner(System.in);
            switch (scan.nextLine()) {
                case "P": {
                    Pizza pizza = new Pizza();
                    selectToppings(pizza);
                    break;
                }
                case "X": {
                    isMenuEnabled = false;
                    break;
                }
                default: {
                    System.out.println();
                    System.out.println("Nie ma takiej opcji. Sprobuj ponownie!");
                    break;
                }
            }
        }while(isMenuEnabled);
    }

    private void selectToppings(Pizza pizza) throws InterruptedException {
        boolean isMenuEnabled = true;
        do {
            System.out.println("\n###########################################################################################");
            System.out.println("Aktualna " + pizza.toString());
            System.out.println("###########################################################################################");
            displayToppings();
            Scanner scan = new Scanner(System.in);
            switch (scan.nextLine()) {
                case "A": {
                    pizza = new PizzaZAnanasem(pizza);
                    break;
                }
                case "M": {
                    pizza = new PizzaZMozarella(pizza);
                    break;
                }
                case "PA": {
                    pizza = new PizzaZPapryka(pizza);
                    break;
                }
                case "PI": {
                    pizza = new PizzaZPieczarkami(pizza);
                    break;
                }
                case "PO": {
                    pizza = new PizzaZPomidorem(pizza);
                    break;
                }
                case "S": {
                    pizza = new PizzaZSzynka(pizza);
                    break;
                }
                case "Z": {
                    pizzas.add(pizza);
                    runProcess(pizza);
                    isMenuEnabled = false;
                    break;
                }
                case "X": {
                    isMenuEnabled = false;
                    ((PizzaZDodatkami) pizza).clearList();
                    break;
                }
                default: {
                    System.out.println();
                    System.out.println("Nie ma takiej opcji. Sprobuj ponownie!");
                    break;
                }
            }
        }while(isMenuEnabled);
    }

    private void runProcess(Pizza pizza) throws InterruptedException {
        System.out.println("\n\n###########################################################################################");
        pizza.setStatusPizzy(new PizzaZamowiona());
        pizza.Request();
        pizza.Request();
        pizza.Request();
        ((PizzaZDodatkami) pizza).clearList();
        System.out.println("###########################################################################################");
    }
}

package com.company;

import com.company.model.*;
import com.company.visitor.NodeVisitorPrinter;

public class Main {

    public static void main(String[] args) {
        Value a = new Value(2);
        Value b = new Value(5);
        Value c = new Value(8);
        UnaryOperator increment = new UnaryOperator("++", "incrementation");
        BinaryOperator addition = new BinaryOperator("+", "addition");
        BinaryOperator multiplication = new BinaryOperator("*", "multiplication");

        //In postfix expression order
        Node[] node = {a, increment, b, c, addition, multiplication};
        Tree tree = new Tree();
        tree.constructTree(node);

        System.out.println("\nInfix expression order: \n");
        tree.accept(new NodeVisitorPrinter());
    }
}

package com.company.visitor;

import com.company.model.BinaryOperator;
import com.company.model.Tree;
import com.company.model.UnaryOperator;
import com.company.model.Value;

public class NodeVisitorPrinter implements NodeVisitor {
    @Override
    public void visit(Value value) {
        System.out.println(value.toString());
    }

    @Override
    public void visit(UnaryOperator unaryOperator) {
        System.out.println(unaryOperator.toString());
    }

    @Override
    public void visit(BinaryOperator binaryOperator) {
        System.out.println(binaryOperator.toString());
    }

    public void visit(Tree tree) {
        System.out.println(tree.toString());
    }
}

package com.company.model;

import com.company.visitor.NodeVisitor;

public class BinaryOperator extends Node {
    private final String identifier;
    private final String description;

    public void accept(NodeVisitor visitor) {
        visitor.visit(this);
    }

    public BinaryOperator(String identifier, String description) {
        this.identifier = identifier;
        this.description = description;
    }

    @Override
    public String toString() {
        return String.format("BinaryOperator{identifier='%s', description='%s'}", identifier, description);
    }
}

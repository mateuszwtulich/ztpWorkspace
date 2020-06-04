package com.company.model;

import com.company.visitor.NodeVisitor;

public class UnaryOperator extends Node {
    private final String identifier;
    private final String description;

    public void accept(NodeVisitor visitor) {
        visitor.visit(this);
    }

    public UnaryOperator(String identifier, String description) {
        this.identifier = identifier;
        this.description = description;
    }

    @Override
    public String toString() {
        return String.format("UnaryOperator{identifier='%s', description='%s'}", identifier, description);
    }
}

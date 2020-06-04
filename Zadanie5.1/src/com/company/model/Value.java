package com.company.model;

import com.company.visitor.NodeVisitor;

public class Value extends Node {
    private final Number number;

    public void accept(NodeVisitor visitor) {
        visitor.visit(this);
    }

    public Value(Number number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return String.format("Value{number=%s}", number.toString());
    }
}

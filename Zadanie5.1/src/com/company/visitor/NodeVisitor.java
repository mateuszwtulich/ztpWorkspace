package com.company.visitor;

import com.company.model.BinaryOperator;
import com.company.model.UnaryOperator;
import com.company.model.Value;

public interface NodeVisitor {
    void visit(Value value);
    void visit(UnaryOperator unaryOperator);
    void visit(BinaryOperator binaryOperator);
}

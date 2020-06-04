package com.company.model;

import com.company.visitor.NodeVisitor;

public class Node implements INode{
    private Node left, right;

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public void accept(NodeVisitor visitor) {
    }
}

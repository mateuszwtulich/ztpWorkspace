package com.company.model;

import com.company.visitor.NodeVisitor;

import java.util.Stack;

public class Tree implements INode {
    private Node node;

    public Tree() {
    }

    public void constructTree(Node[] nodes){
        Stack<Node> stack = new Stack<>();
        Node t, t1, t2;

        for (Node node: nodes) {
            if(node.getClass().equals(Value.class)){
                stack.push(node);
            } else if (node.getClass().equals(UnaryOperator.class)){
                t1 = stack.pop();
                node.setLeft(t1);
                stack.push(node);
            } else if (node.getClass().equals(BinaryOperator.class)){
                t1 = stack.pop();
                t2 = stack.pop();
                node.setRight(t1);
                node.setLeft(t2);
                stack.push(node);
            }
        }
        t = stack.peek();
        stack.pop();
        this.node = t;
    }

    public void accept(NodeVisitor visitor) {
        visitInorder(this.node, visitor);
    }

    private void visitInorder(Node t, NodeVisitor visitor){
        if (t != null) {
            visitInorder(t.getLeft(), visitor);
            t.accept(visitor);
            visitInorder(t.getRight(), visitor);
        }
    }

    @Override
    public String toString() {
        return String.format("Tree{node=%s}", node.toString());
    }
}

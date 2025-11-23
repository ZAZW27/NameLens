package org.main.namelens.backend;

public class Node {
    private char key;
    private Object value;
    private Node right;
    private Node left;

    // FIX: Add 'transient' here to stop the infinite loop
    private transient Node parent;

    private boolean red;

    public Node(char key, Object value){
        this.key = key;
        this.value = value;
        this.red = true;
    }

    public char getKey() { return key; }
    public void setKey(char key) { this.key = key; }

    public Object getValue() { return value; }
    public void setValue(Object value) { this.value = value; }

    public Node getRight() { return right; }
    public void setRight(Node right) { this.right = right; }

    public Node getLeft() { return left; }
    public void setLeft(Node left) { this.left = left; }

    public Node getParent() { return parent; }
    public void setParent(Node parent) { this.parent = parent; }

    public boolean isRed() { return red; }
    public void setRed(boolean red) { this.red = red; }
}
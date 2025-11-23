package org.main.namelens.backend;

public class HashMap {
    private Node root;

    public Node getRoot(){return root;}

    public boolean add(char key, Object value) {
        Node node = new Node(key, value);
        if(root == null){
            node.setRed(false);
            root = node;
            return true;
        }

        Node current = root;
        Node parent = null;

        while (current != null){
            parent = current;
            if(key < current.getKey()){
                current = current.getLeft();
            } else if (key > current.getKey()){
                current = current.getRight();
            } else {
                current.setValue(value);
                return true;
            }
        }

        node.setParent(parent);
        if(key < parent.getKey()){
            parent.setLeft(node);
        }else{
            parent.setRight(node);
        }

        fixInsert(node);
        return true;
    }

    private void fixInsert(Node node){
        while(node != root && node.getParent().isRed()){
            Node parent = node.getParent();
            Node grandpa = parent.getParent();

            if(parent == grandpa.getLeft()){
                Node uncle = grandpa.getRight();

                if(uncle != null && uncle.isRed()){
                    parent.setRed(false);
                    uncle.setRed(false);

                    grandpa.setRed(true);
                    node = grandpa;
                }else{
                    if(node == parent.getRight()){
                        node = parent;
                        rotateToLeft(node);
                        parent = node.getParent();
                        grandpa = parent.getParent();
                    }

                    parent.setRed(false);
                    grandpa.setRed(true);
                    rotateToRight(grandpa);
                }
            } else {
                Node uncle = grandpa.getLeft();
                if (uncle != null && uncle.isRed()) {
                    parent.setRed(false);
                    uncle.setRed(false);
                    grandpa.setRed(true);
                    node = grandpa;
                } else {
                    if (node == parent.getLeft()) {
                        node = parent;
                        rotateToRight(node);
                        parent = node.getParent();
                        grandpa = parent.getParent();
                    }
                    parent.setRed(false);
                    grandpa.setRed(true);
                    rotateToLeft(grandpa);
                }
            }
        }
        root.setRed(false);
    }


    private void rotateToRight(Node current){
        Node leftChild = current.getLeft();
        current.setLeft(leftChild.getRight());

        if (current.getLeft() != null) {
            current.getLeft().setParent(current);
        }

        leftChild.setParent(current.getParent());

        if(current.getParent() == null){
            root = leftChild;
        } else if (current == current.getParent().getRight()){
            current.getParent().setRight(leftChild);
        } else {
            current.getParent().setLeft(leftChild);
        }

        leftChild.setRight(current);
        current.setParent(leftChild);
    }
    private void rotateToLeft(Node current) {
        Node rightChild = current.getRight();
        current.setRight(rightChild.getLeft());

        if (current.getRight() != null) {
            current.getRight().setParent(current);
        }

        rightChild.setParent(current.getParent());

        if (current.getParent() == null) {
            root = rightChild;
        } else if (current == current.getParent().getLeft()) {
            current.getParent().setLeft(rightChild);
        } else {
            current.getParent().setRight(rightChild);
        }

        rightChild.setLeft(current);
        current.setParent(rightChild);
    }


//    public boolean remove(char key){
//        Node z = root;
//        while(z != null){
//            if(key < z.getKey()){
//                z = z.getLeft();
//            }else if (key > z.getKey()){
//                z = z.getRight();
//            } else{
//                break;
//            }
//        }
//
//        if (z == null){ return false; }
//
//        Node y = z;
//        Node x;
//        boolean yOriginRed = y.isRed();
//        Node xParent;
//
//        if (z.getLeft() == null) {
//            x = z.getRight();
//            xParent = z.getParent();
//            transplant(z, z.getRight());
//        } else if (z.getRight() == null) {
//            x = z.getLeft();
//            xParent = z.getParent();
//            transplant(z, z.getLeft());
//        } else{
//            y = minimum
//        }
//
//        return true;
//    }
//

}

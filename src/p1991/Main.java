package p1991;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int numOfNodes = Integer.parseInt(br.readLine());

            Tree tree = new Tree();

            for (int i = 0; i < numOfNodes; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");

                String value = st.nextToken();
                String left = st.nextToken();
                String right = st.nextToken();

                tree.insertNode(value, left, right);
            }

            tree.preRun();
            tree.inorderRun();
            tree.postRun();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

class Tree {

    Node head;

    public void insertNode(String value, String left, String right) {
        if (this.head == null) {
            this.head = new Node(value);
            this.head.setLeft(left.equals(".") ? null : new Node(left));
            this.head.setRight(right.equals(".") ? null : new Node(right));
        } else {
            findAndInsertNode(this.head, value, left, right);
        }
    }

    public void findAndInsertNode(Node root, String value, String left, String right) {
        if (root.value.equals(value)) {
            root.setLeft(left.equals(".") ? null : new Node(left));
            root.setRight(right.equals(".") ? null : new Node(right));
        } else {
            if (root.left != null) findAndInsertNode(root.left, value, left, right);
            if (root.right != null) findAndInsertNode(root.right, value, left, right);
        }
    }

    public void preRun() {
        if(this.head != null) this.head.preRun();
        System.out.println();
    }

    public void inorderRun() {
        if(this.head != null) this.head.inorderRun();
        System.out.println();
    }

    public void postRun() {
        if(this.head != null) this.head.postRun();
        System.out.println();
    }
}

class Node {

    String value;
    Node left;
    Node right;

    public Node(String value) {
        this.value = value;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public void setRight(Node right) {
        this.right = right;
    }


    public void preRun() {
        System.out.print(this.value);
        if(this.left != null) this.left.preRun();
        if(this.right != null) this.right.preRun();
    }

    public void inorderRun() {
        if(this.left != null) this.left.inorderRun();
        System.out.print(this.value);
        if(this.right != null) this.right.inorderRun();
    }

    public void postRun() {
        if(this.left != null) this.left.postRun();
        if(this.right != null) this.right.postRun();
        System.out.print(this.value);
    }
}
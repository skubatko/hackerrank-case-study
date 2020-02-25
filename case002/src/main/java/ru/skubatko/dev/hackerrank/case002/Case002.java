package ru.skubatko.dev.hackerrank.case002;

import java.util.Scanner;

public class Case002 {
    /*

    class Node
        int data;
        Node left;
        Node right;
    */
    public static void levelOrder(Node root) {
        int levels = levels(root);
        for (int i = 0; i < levels; i++) {
            levelOrder(root, i);
        }
    }

    private static void levelOrder(Node root, int level) {
        if (root == null) {
            return;
        }

        if (level == 0) {
            System.out.print(root.data + " ");
            return;
        }

        levelOrder(root.left, level - 1);
        levelOrder(root.right, level - 1);
    }

    public static int levels(Node root) {
        if (root == null) {
            return 0;
        }

        return Math.max(levels(root.left), levels(root.right)) + 1;
    }

    public static Node insert(Node root, int data) {
        if (root == null) {
            return new Node(data);
        } else {
            Node cur;
            if (data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        Node root = null;
        while (t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        scan.close();
        levelOrder(root);
    }
}

class Node {
    Node left;
    Node right;
    int data;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

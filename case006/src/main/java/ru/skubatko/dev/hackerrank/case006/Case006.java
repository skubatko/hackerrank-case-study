package ru.skubatko.dev.hackerrank.case006;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Case006 {

    static int[][] swapNodes(int[][] indexes, int[] queries) {
        Tree tree = new Tree(indexes);
        int[][] result = new int[queries.length][];
        for (int i = 0; i < queries.length; i++) {
            tree.swap(queries[i]);
            result[i] = tree.traverseInOrder();
        }

        return result;
    }

    static class Tree {
        private Node root = new Node(1, 1);

        Tree(int[][] indexes) {
            Queue<Node> queue = new LinkedList<>();
            queue.add(root);
            for (int i = 0; i < indexes.length; i++) {
                Node current = queue.remove();
                int leftValue = indexes[i][0];
                if (leftValue != -1) {
                    current.left = new Node(leftValue, current.level + 1);
                    queue.add(current.left);
                }
                int rightValue = indexes[i][1];
                if (rightValue != -1) {
                    current.right = new Node(rightValue, current.level + 1);
                    queue.add(current.right);
                }
            }
        }

        int[] traverseInOrder() {
            List<Integer> result = new ArrayList<>();
            traverseInOrder(root, result);
            return result.stream().mapToInt(Integer::intValue).toArray();
        }

        private void traverseInOrder(Node current, List<Integer> result) {
            if (current == null) {
                return;
            }

            traverseInOrder(current.left, result);
            result.add(current.value);
            traverseInOrder(current.right, result);
        }

        void swap(int k) {
            swap(root, k);
        }

        private void swap(Node current, int k) {
            if (current == null) {
                return;
            }

            if (current.level % k == 0) {
                Node tmp = current.left;
                current.right = current.left;
                current.left = tmp;
            }

            swap(current.left, k);
            swap(current.right, k);
        }

        static class Node {
            Node left;
            Node right;
            int value;
            int level;

            Node(int value, int level) {
                this.value = value;
                this.level = level;
            }
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(scanner.nextLine().trim());

        int[][] indexes = new int[n][2];

        for (int indexesRowItr = 0; indexesRowItr < n; indexesRowItr++) {
            String[] indexesRowItems = scanner.nextLine().split(" ");

            for (int indexesColumnItr = 0; indexesColumnItr < 2; indexesColumnItr++) {
                int indexesItem = Integer.parseInt(indexesRowItems[indexesColumnItr].trim());
                indexes[indexesRowItr][indexesColumnItr] = indexesItem;
            }
        }

        int queriesCount = Integer.parseInt(scanner.nextLine().trim());

        int[] queries = new int[queriesCount];

        for (int queriesItr = 0; queriesItr < queriesCount; queriesItr++) {
            int queriesItem = Integer.parseInt(scanner.nextLine().trim());
            queries[queriesItr] = queriesItem;
        }

        int[][] result = swapNodes(indexes, queries);

        for (int resultRowItr = 0; resultRowItr < result.length; resultRowItr++) {
            for (int resultColumnItr = 0; resultColumnItr < result[resultRowItr].length; resultColumnItr++) {
                bufferedWriter.write(String.valueOf(result[resultRowItr][resultColumnItr]));

                if (resultColumnItr != result[resultRowItr].length - 1) {
                    bufferedWriter.write(" ");
                }
            }

            if (resultRowItr != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();
    }
}

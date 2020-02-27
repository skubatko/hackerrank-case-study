package ru.skubatko.dev.hackerrank.case006;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
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
        private int[] nodes;

        public Tree(int[][] indexes) {
            nodes = new int[2 * indexes.length + 1];
            nodes[0] = 1;
            for (int i = 0; i < indexes.length; i++) {
                nodes[2 * i + 1] = indexes[i][0];
                nodes[2 * i + 2] = indexes[i][1];
            }
        }

        int[] traverseInOrder() {
            List<Integer> list = new ArrayList<>();
            traverseInOrder(0, list);
            return list.stream().mapToInt(Integer::intValue).toArray();
        }

        private void traverseInOrder(int current, List<Integer> result) {
            if (current < nodes.length) {
                traverseInOrder(2 * current + 1, result);

                int value = nodes[current];
                if (value != -1) {
                    result.add(value);
                }

                traverseInOrder(2 * current + 2, result);
            }
        }

        public void swap(int query) {

        }

        static class Node {
            int value;
            Node left;
            Node right;

            Node(int value) {
                this.value = value;
                right = null;
                left = null;
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

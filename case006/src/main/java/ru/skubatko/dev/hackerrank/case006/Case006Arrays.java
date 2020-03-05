package ru.skubatko.dev.hackerrank.case006;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Case006Arrays {

    private static int[] leftArray;
    private static int[] rightArray;
    private static int[] depthArray;
    private static int[][] resultArray;

    static int[][] swapNodes(int[][] indexes, int[] queries) {
        int depthLength = indexes.length + 1;

        leftArray = new int[depthLength];
        rightArray = new int[depthLength];
        for (int i = 0; i < indexes.length; i++) {
            leftArray[i + 1] = indexes[i][0];
            rightArray[i + 1] = indexes[i][1];
        }

        depthArray = new int[depthLength];
        calcDepth(1, 1);

        resultArray = new int[queries.length][];
        for (int i = 0; i < queries.length; i++) {
            for (int depth = 1; depth < depthLength; depth++) {
                if (depthArray[depth] % queries[i] == 0) {
                    swap(depth);
                }
            }
            traverseInOrder(i);
        }

        return resultArray;
    }

    private static void traverseInOrder(int query) {
        List<Integer> resultList = new ArrayList<>();

        traverseInOrder(1, resultList);

        resultArray[query] = resultList.stream().mapToInt(Integer::intValue).toArray();
    }

    private static void traverseInOrder(int idx, List<Integer> resultList) {
        if (leftArray[idx] > 0) {
            traverseInOrder(leftArray[idx], resultList);
        }

        resultList.add(idx);

        if (rightArray[idx] > 0) {
            traverseInOrder(rightArray[idx], resultList);
        }
    }

    private static void swap(int depth) {
        int tmp = leftArray[depth];
        leftArray[depth] = rightArray[depth];
        rightArray[depth] = tmp;
    }

    private static void calcDepth(int idx, int depth) {
        depthArray[idx] = depth;

        if (leftArray[idx] > 0) {
            calcDepth(leftArray[idx], depth + 1);
        }
        if (rightArray[idx] > 0) {
            calcDepth(rightArray[idx], depth + 1);
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

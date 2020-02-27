package ru.skubatko.dev.hackerrank.case005;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Case005 {

    static double[] runningMedian(int[] a) {
        double[] result = new double[a.length];
        Heap heap = new Heap();
        for (int i = 0; i < a.length; i++) {
            heap.add(a[i]);
            result[i] = heap.getMedian();
        }

        return result;
    }

    static class Heap {
        private Queue<Integer> minHeap = new PriorityQueue<>();
        private Queue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());

        void add(int num) {
            if (minHeap.size() == maxHeap.size()) {
                maxHeap.offer(num);
                minHeap.offer(maxHeap.poll());
            } else {
                minHeap.offer(num);
                maxHeap.offer(minHeap.poll());
            }
        }

        double getMedian() {
            double median;
            if (minHeap.size() > maxHeap.size()) {
                median = minHeap.peek();
            } else {
                median = (minHeap.peek() + maxHeap.peek()) / 2.0;
            }
            return median;
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int aCount = Integer.parseInt(scanner.nextLine().trim());

        int[] a = new int[aCount];

        for (int aItr = 0; aItr < aCount; aItr++) {
            int aItem = Integer.parseInt(scanner.nextLine().trim());
            a[aItr] = aItem;
        }

        double[] result = runningMedian(a);

        for (int resultItr = 0; resultItr < result.length; resultItr++) {
            bufferedWriter.write(String.valueOf(result[resultItr]));

            if (resultItr != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();
    }
}

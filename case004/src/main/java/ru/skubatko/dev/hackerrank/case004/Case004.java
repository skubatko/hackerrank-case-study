package ru.skubatko.dev.hackerrank.case004;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Case004 {
    /*
     * Complete the contacts function below.
     */
    static int[] contacts(String[][] queries) {
        List<String> contacts = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < queries.length; i++) {
            String command = queries[i][0];
            String s = queries[i][1];
            switch (command) {
                case "add":
                    contacts.add(s);
                    break;
                case "find":
                    int count = (int) contacts.stream().filter(c -> c.startsWith(s)).count();
                    result.add(count);
                    break;
                default:
                    break;
            }
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int queriesRows = Integer.parseInt(scanner.nextLine().trim());

        String[][] queries = new String[queriesRows][2];

        for (int queriesRowItr = 0; queriesRowItr < queriesRows; queriesRowItr++) {
            String[] queriesRowItems = scanner.nextLine().split(" ");

            for (int queriesColumnItr = 0; queriesColumnItr < 2; queriesColumnItr++) {
                String queriesItem = queriesRowItems[queriesColumnItr];
                queries[queriesRowItr][queriesColumnItr] = queriesItem;
            }
        }

        int[] result = contacts(queries);

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

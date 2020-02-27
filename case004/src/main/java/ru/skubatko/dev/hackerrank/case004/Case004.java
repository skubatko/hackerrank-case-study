package ru.skubatko.dev.hackerrank.case004;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Case004 {

    static int[] contacts(String[][] queries) {
        List<Integer> result = new ArrayList<>();

        Trie trie = new Trie();
        for (int i = 0; i < queries.length; i++) {
            String command = queries[i][0];
            String s = queries[i][1];
            switch (command) {
                case "add":
                    trie.add(s);
                    break;
                case "find":
                    int count = trie.find(s);
                    result.add(count);
                    break;
                default:
                    break;
            }
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    static class Trie {
        private TrieNode root;

        Trie() {
            root = new TrieNode();
        }

        void add(String word) {
            TrieNode current = root;

            for (int i = 0; i < word.length(); i++) {
                current = current.children.computeIfAbsent(word.charAt(i), c -> new TrieNode());
                current.counter++;
            }
        }

        private int find(String s) {
            TrieNode current = root;

            for (int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);
                TrieNode node = current.children.get(ch);
                if (node == null) {
                    return 0;
                }

                current = node;
            }

            return current.counter;
        }

         static class TrieNode {
            Map<Character, TrieNode> children = new HashMap<>();
            int counter;
        }
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

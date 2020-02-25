package ru.skubatko.dev.hackerrank.case003;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Case003 {

    // Complete the isBalanced function below.
    static String isBalanced(String s) {
        String openBrackets = "({[";
        String closedBrackets = ")}]";

        String no = "NO";
        String yes = "YES";

        Deque<Character> stack = new LinkedList<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int openIdx = openBrackets.indexOf(c);
            int closedIdx = closedBrackets.indexOf(c);

            if (openIdx != -1) {
                stack.push(c);
            } else if (closedIdx != -1) {
                if (stack.isEmpty()){
                    return no;
                }

                char saved = stack.pop();
                int savedIdx = openBrackets.indexOf(saved);
                if (savedIdx != closedIdx){
                    return no;
                }
            } else {
                return no;
            }

        }

        if (stack.isEmpty()) {
            return yes;
        }

        return no;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            String s = scanner.nextLine();

            String result = isBalanced(s);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}

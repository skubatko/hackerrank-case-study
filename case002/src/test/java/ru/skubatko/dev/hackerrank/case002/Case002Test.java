package ru.skubatko.dev.hackerrank.case002;

import static org.assertj.core.api.Assertions.assertThat;
import static ru.skubatko.dev.hackerrank.case002.Case002.insert;
import static ru.skubatko.dev.hackerrank.case002.Case002.levelOrder;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

public class Case002Test {

    @Rule
    public Timeout timeout = Timeout.seconds(5);

    @Test
    public void levelOrderCase1() throws Exception {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));

        Node root = null;
        root = insert(root, 1);
        root = insert(root, 2);
        root = insert(root, 5);
        root = insert(root, 3);
        root = insert(root, 4);
        root = insert(root, 6);

        levelOrder(root);

        assertThat(baos.toString(StandardCharsets.UTF_8.name())).isEqualTo("1 2 5 3 6 4 ");
    }
}

package ru.skubatko.dev.hackerrank.case001;

import static org.assertj.core.api.Assertions.assertThat;
import static ru.skubatko.dev.hackerrank.case001.Case001.height;
import static ru.skubatko.dev.hackerrank.case001.Case001.insert;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

public class Case001Test {

    @Rule
    public Timeout timeout = Timeout.seconds(5);

    @Test
    public void heightCase1() {
        Node root = null;
        root = insert(root, 3);
        root = insert(root, 2);
        root = insert(root, 1);
        root = insert(root, 5);
        root = insert(root, 4);
        root = insert(root, 6);
        root = insert(root, 7);

        int result = height(root);

        assertThat(result).isEqualTo(3);
    }

    @Test
    public void heightCase2() {
        Node root = null;
        root = insert(root, 15);

        int result = height(root);

        assertThat(result).isEqualTo(0);
    }

    @Test
    public void heightCase3() {
        Node root = null;
        root = insert(root, 3);
        root = insert(root, 1);
        root = insert(root, 7);
        root = insert(root, 5);
        root = insert(root, 4);

        int result = height(root);

        assertThat(result).isEqualTo(3);
    }
}

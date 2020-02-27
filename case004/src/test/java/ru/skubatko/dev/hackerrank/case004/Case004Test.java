package ru.skubatko.dev.hackerrank.case004;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

public class Case004Test {

    @Rule
    public Timeout timeout = Timeout.seconds(5);

    @Test
    public void contactsCase1() {
        String[][] queries = {
                {"add", "hack"},
                {"add", "hackerrank"},
                {"find", "hac"},
                {"find", "hak"},
        };

        int[] expected = {2, 0};

        int[] result = Case004.contacts(queries);

        assertThat(result).isEqualTo(expected);
    }
}

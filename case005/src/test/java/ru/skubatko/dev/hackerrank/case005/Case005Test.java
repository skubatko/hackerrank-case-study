package ru.skubatko.dev.hackerrank.case005;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

public class Case005Test {

    @Rule
    public Timeout timeout = Timeout.seconds(5);

    @Test
    public void runningMedianCase1() {
        int[] source = {};
        double[] actual = {};

        double[] result = Case005.runningMedian(source);

        assertThat(result).isEqualTo(actual);
    }
}

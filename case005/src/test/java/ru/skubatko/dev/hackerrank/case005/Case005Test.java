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
        int[] source = {12, 4, 5, 3, 8, 7};
        double[] actual = {12.0, 8.0, 5.0, 4.5, 5.0, 6.0};

        double[] result = Case005.runningMedian(source);

        assertThat(result).isEqualTo(actual);
    }
}

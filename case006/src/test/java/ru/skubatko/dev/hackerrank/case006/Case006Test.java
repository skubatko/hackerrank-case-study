package ru.skubatko.dev.hackerrank.case006;

import static org.assertj.core.api.Assertions.assertThat;
import static ru.skubatko.dev.hackerrank.case006.Case006.swapNodes;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

public class Case006Test {

    @Rule
    public Timeout timeout = Timeout.seconds(5);

    @Test
    public void swapNodesCase1() {
        int[][] indexes = {
                {2, 3},
                {-1, -1},
                {-1, -1}
        };
        int[] queries = {1, 1};

        int[][] actual = {
                {3, 1, 2},
                {2, 1, 3}
        };

        int[][] result = swapNodes(indexes, queries);

        assertThat(result).isEqualTo(actual);
    }
}

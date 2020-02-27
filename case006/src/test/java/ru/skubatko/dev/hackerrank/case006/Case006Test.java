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

    @Test
    public void swapNodesCase2() {
        int[][] indexes = {
                {2, 3},
                {-1, 4},
                {-1, 5},
                {-1, -1},
                {-1, -1}
        };
        int[] queries = {2};

        int[][] actual = {
                {4, 2, 1, 5, 3}
        };

        int[][] result = swapNodes(indexes, queries);

        assertThat(result).isEqualTo(actual);
    }

    @Test
    public void swapNodesCase3() {
        int[][] indexes = {
                {2, 3},
                {4, -1},
                {5, -1},
                {6, -1},
                {7, 8},
                {-1, 9},
                {-1, -1},
                {10, 11},
                {-1, -1},
                {-1, -1},
                {-1, -1}
        };
        int[] queries = {2, 4};

        int[][] actual = {
                {2, 9, 6, 4, 1, 3, 7, 5, 11, 8, 10},
                {2, 6, 9, 4, 1, 3, 7, 5, 10, 8, 11}
        };

        int[][] result = swapNodes(indexes, queries);

        assertThat(result).isEqualTo(actual);
    }
}

package br.leetcode.solutions;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class P0069_SqrtX {

    private final static int MAX_SQRT = 46340;

    public int mySqrt(int x) {
        if (x == 0) {
            return 0;
        } else if (x <= 3) {
            return 1;
        } else if (x >= MAX_SQRT * MAX_SQRT) {
            return MAX_SQRT;
        }

        var start = 0;
        var end = Math.min(x, MAX_SQRT);

        while (true) {

            var sqrt = start + (end - start) / 2;

            if ((sqrt * sqrt) <= x && (x < ((sqrt + 1) * (sqrt + 1)))) {
                return sqrt;
            } else if (sqrt * sqrt > x) {
                end = sqrt;
            } else {
                start = sqrt;
            }
        }
    }

    public static class TestSolution {

        @ParameterizedTest
        @CsvSource({
                "4,          2",
                "5,          2",
                "8,          2",
                "9,          3",
                "2147395600, 46340",
                "2147483647, 46340",
        })
        public final void testSuccess(int x, int expected) {
            var problem = new P0069_SqrtX();
            var result = problem.mySqrt(x);
            assertEquals(expected, result);
        }
    }
}

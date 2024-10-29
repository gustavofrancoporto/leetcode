package br.leetcode.solutions;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class P0070_ClimbingStairs {


    public int climbStairs(int n) {
        if (n <= 3) {
            return n;
        }
        int current = 4;
        int x = 2, y = 3;
        while (current++ <= n) {
            int sum = x + y;
            x = y;
            y = sum;
        }
        return y;
    }

    public static class TestSolution {

        @ParameterizedTest
        @CsvSource({
                "1, 1",
                "2, 2",
                "3, 3",
                "4, 5",
                "5, 8",
                "6, 13",
                "7, 21",
                "8, 34",
                "9, 55",
                "10, 89",
                "45, 1836311903"
        })
        public final void testSuccess(int n, int expected) {
            var problem = new P0070_ClimbingStairs();
            var result = problem.climbStairs(n);
            assertEquals(expected, result);
        }
    }
}
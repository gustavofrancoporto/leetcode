package br.leetcode.solutions;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class P1545_FindKthBitInNthBinaryString {

    public char findKthBit(int n, int k) {

        if (n == 1) {
            return '0';
        }
        int middle = (int) Math.pow(2, n - 1);

        if (k == middle) {
            return '1';
        }

        return k < middle ?
                findKthBit(n - 1, k) :
                revert(findKthBit(n - 1, middle * 2 - k));
    }

    private char revert(char c) {
        return c == '0' ? '1' : '0';
    }

    public static class TestSolution {

        @ParameterizedTest
        @CsvSource({
                "3, 1,  0",
                "4, 11, 1"
        })
        public final void testSuccess(int n, int k, char expected) {
            var problem = new P1545_FindKthBitInNthBinaryString();
            var result = problem.findKthBit(n, k);
            assertEquals(expected, result);
        }
    }
}

package br.leetcode.solutions;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class P0066_PlusOne {

    public int[] plusOne(int[] digits) {

        for (var i = digits.length - 1; i >= 0; i--) {

            if (digits[i] != 9) {
                digits[i]++;
                break;
            } else {
                digits[i] = 0;
                if (i == 0) {
                    var newDigits = new int[digits.length + 1];
                    newDigits[0] = 1;
                    return newDigits;
                }
            }
        }
        return digits;
    }

    public static class TestSolution {

        static Stream<Arguments> paramProvider() {
            return Stream.of(
                    arguments(new int[]{1, 2, 3}, new int[]{1, 2, 4}),
                    arguments(new int[]{4, 3, 2, 1}, new int[]{4, 3, 2, 2}),
                    arguments(new int[]{4, 3, 2, 9}, new int[]{4, 3, 3, 0}),
                    arguments(new int[]{9}, new int[]{1, 0})
            );
        }

        @ParameterizedTest
        @MethodSource("paramProvider")
        public final void testSuccess(int[] digits, int[] expected) {
            var problem = new P0066_PlusOne();
            var result = problem.plusOne(digits);
            assertArrayEquals(expected, result);
        }
    }
}
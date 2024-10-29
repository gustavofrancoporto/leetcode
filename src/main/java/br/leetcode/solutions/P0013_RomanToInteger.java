package br.leetcode.solutions;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class P0013_RomanToInteger {

    public int romanToInt(String s) {

        var number = 0;
        var previousValue = 0;

        for (var i = s.length() - 1; i >= 0; i--) {

            var currentValue = switch (s.charAt(i)) {
                case 'I' -> 1;
                case 'V' -> 5;
                case 'X' -> 10;
                case 'L' -> 50;
                case 'C' -> 100;
                case 'D' -> 500;
                default -> 1000;
            };

            if (currentValue >= previousValue) {
                number += currentValue;
            } else {
                number -= currentValue;
            }
            previousValue = currentValue;
        }
        return number;
    }

    public static class TestSolution {

        @ParameterizedTest
        @CsvSource({
                "III, 3",
                "LVIII, 58",
                "MCMXCIV, 1994"
        })
        public final void testSuccess(String romanNumber, int expected) {
            var problem = new P0013_RomanToInteger();
            var result = problem.romanToInt(romanNumber);
            assertEquals(expected, result);
        }
    }
}
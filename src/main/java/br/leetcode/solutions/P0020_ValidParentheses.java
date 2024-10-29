package br.leetcode.solutions;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Stack;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class P0020_ValidParentheses {

    public boolean isValid(String s) {

        if (s.isEmpty() || s.length() % 2 != 0) {
            return false;
        }

        var stack = new char[s.length()];
        var j = 0;

        for (int i = 0; i < s.length(); i++) {

            var current = s.charAt(i);
            if (current == '(' || current == '{' || current == '[') {
                stack[j++] = current;
            } else if (j == 0) {
                return false;
            } else {
                var previous = stack[--j];
                if (
                        (previous == '(' && current != ')') ||
                        (previous == '[' && current != ']') ||
                        (previous == '{' && current != '}')
                ) {
                    return false;
                }
            }
        }

        return j == 0;
    }

    public static class TestSolution {

        @ParameterizedTest
        @CsvSource({
                "((,     false",
                "[,      false",
                "(),     true",
                "()[]{}, true",
                "(],     false",
                "([]),   true",
        })
        public final void testSuccess(String s, boolean expected) {
            var problem = new P0020_ValidParentheses();
            var result = problem.isValid(s);
            assertEquals(expected, result);
        }
    }
}

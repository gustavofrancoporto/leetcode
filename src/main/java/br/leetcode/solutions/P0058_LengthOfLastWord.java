package br.leetcode.solutions;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class P0058_LengthOfLastWord {

    public int lengthOfLastWord(String s) {

        var length = 0;
        var i = s.length() - 1;

        while (i >= 0) {
            if (s.charAt(i) != ' ') {
                length++;
            } else if (length > 0) {
                break;
            }
            i--;
        }

        return length;
    }

    public static class TestSolution {

        @ParameterizedTest
        @CsvSource({
                "Hello World,                   5",
                "'   fly me   to   the moon  ', 4",
                "luffy is still joyboy,         6",
                "a,                             1"
        })
        public final void testSuccess(String s, int expected) {
            var problem = new P0058_LengthOfLastWord();
            var result = problem.lengthOfLastWord(s);
            assertEquals(expected, result);
        }
    }
}
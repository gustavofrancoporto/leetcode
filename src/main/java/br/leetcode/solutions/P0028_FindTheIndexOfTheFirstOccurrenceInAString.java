package br.leetcode.solutions;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class P0028_FindTheIndexOfTheFirstOccurrenceInAString {

    public int strStr(String haystack, String needle) {

        for (int i = 0; i < haystack.length(); i++) {

            var j = 0;
            while ((i + j) < haystack.length() && j < needle.length() && haystack.charAt(i + j) == needle.charAt(j)) {
                j++;
            }
            if (j == needle.length()) {
                return i;
            }
        }

        return -1;
    }

    public static class TestSolution {

        @ParameterizedTest
        @CsvSource({
                "sadbutsad, sad,   0",
                "leetcode,  leeto, -1",
                "hello,     ll,    2"
        })
        public final void testSuccess(String haystack , String needle , int expected) {
            var problem = new P0028_FindTheIndexOfTheFirstOccurrenceInAString();

            var result = problem.strStr(haystack, needle);

            assertEquals(expected, result);
        }
    }
}

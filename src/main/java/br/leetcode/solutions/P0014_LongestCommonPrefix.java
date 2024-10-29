package br.leetcode.solutions;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.HashMap;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class P0014_LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {

        var longestCommonPrefix = strs[0];

        for (var i = 1; i < strs.length; i++) {

            var str = strs[i];
            var length = Math.min(longestCommonPrefix.length(), str.length());
            for (var j = 0; j < length; j++) {
                if (longestCommonPrefix.charAt(j) != str.charAt(j)) {
                    longestCommonPrefix = longestCommonPrefix.substring(0, j);
                    break;
                }
            }
            if (longestCommonPrefix.length() > length) {
                longestCommonPrefix = longestCommonPrefix.substring(0, length);
            }
        }

        return longestCommonPrefix;
    }

    public static class TestSolution {

        static Stream<Arguments> paramProvider() {
            return Stream.of(
                    arguments(new String[]{"flower","flow","flight"}, "fl"),
                    arguments(new String[]{"dog","racecar","car"}, ""),
                    arguments(new String[]{"a","b"}, "")
            );
        }

        @ParameterizedTest
        @MethodSource("paramProvider")
        public final void testSuccess(String[] strs, String expected) {
            var problem = new P0014_LongestCommonPrefix();
            var result = problem.longestCommonPrefix(strs);
            assertEquals(expected, result);
        }
    }
}
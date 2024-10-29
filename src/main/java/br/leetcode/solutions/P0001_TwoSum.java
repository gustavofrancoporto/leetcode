package br.leetcode.solutions;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.HashMap;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class P0001_TwoSum {

    public int[] twoSum(int[] nums, int target) {

        var map = new HashMap<Integer, Integer>();

        for (var i = 0; i < nums.length; i++) {
            var diff = target - nums[i];
            if (map.containsKey(nums[i])) {
                return new int[]{map.get(nums[i]), i};
            }
            map.put(diff, i);
        }
        return null;
    }

    public static class TestSolution {

        static Stream<Arguments> paramProvider() {
            return Stream.of(
                    arguments(new int[]{2, 7, 11, 15}, 9, new int[]{0, 1}),
                    arguments(new int[]{3, 2, 4}, 6, new int[]{1, 2}),
                    arguments(new int[]{3, 3}, 6, new int[]{0, 1})
            );
        }

        @ParameterizedTest
        @MethodSource("paramProvider")
        public final void testSuccess(int[] nums, int target, int[] expected) {
            var problem = new P0001_TwoSum();
            var result = problem.twoSum(nums, target);
            assertArrayEquals(expected, result);
        }
    }
}
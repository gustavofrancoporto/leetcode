package br.leetcode.solutions;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class P2044_CountNumberOfMaximumBitwiseOrSubsets {

    private int max;
    private int count;
    private int[] nums;

    public int countMaxOrSubsets(int[] nums) {

        this.max = 0;
        this.count = 0;
        this.nums = nums;

        for (var num : nums) {
            this.max = this.max | num;
        }

        dfs(0, 0);

        return count;

    }

    private void dfs(int index, int orValue) {

        if (index == this.nums.length) {
            if (orValue == max) {
                this.count++;

            }
            return;
        }

        dfs(index + 1, orValue);
        dfs(index + 1, orValue | this.nums[index]);
    }

    public static class TestSolution {

        static Stream<Arguments> paramProvider() {
            return Stream.of(
                    arguments(new int[]{3, 1}, 2),
                    arguments(new int[]{2, 2, 2}, 7),
                    arguments(new int[]{3, 2, 1, 5}, 6)
            );
        }

        @ParameterizedTest
        @MethodSource("paramProvider")
        public final void testSuccess(int[] nums, int expected) {
            var problem = new P2044_CountNumberOfMaximumBitwiseOrSubsets();
            var result = problem.countMaxOrSubsets(nums);
            assertEquals(expected, result);
        }
    }
}

package br.leetcode.solutions;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class P0026_RemoveDuplicatesFromSortedArray {

    public int removeDuplicates(int[] nums) {

        int j = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[j] != nums[i]) {
                nums[++j] = nums[i];
            }
        }
        return j + 1;
    }

    public static class TestSolution {

        static Stream<Arguments> paramProvider() {
            return Stream.of(
                    arguments(new int[]{1, 1, 2}, 2),
                    arguments(new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4}, 5)
            );
        }


        @ParameterizedTest
        @MethodSource("paramProvider")
        public final void testSuccess(int[] nums, int expected) {
            var problem = new P0026_RemoveDuplicatesFromSortedArray();

            var result = problem.removeDuplicates(nums);

            assertEquals(expected, result);
        }
    }
}

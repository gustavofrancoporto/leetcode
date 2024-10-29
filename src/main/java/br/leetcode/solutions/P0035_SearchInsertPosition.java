package br.leetcode.solutions;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class P0035_SearchInsertPosition {

    public int searchInsert(int[] nums, int target) {
        if (target < nums[0]) {
            return 0;
        }
        if (target > nums[nums.length - 1]) {
            return nums.length;
        }

        var start = 0;
        var end = nums.length - 1;

        while (start <= end) {

            var middle = (start + end) / 2;
            if (nums[middle] == target) {
                return middle;
            } else if (nums[middle] < target) {
                start = middle + 1;
            } else {
                end = middle - 1;
            }
        }

        return start;
    }

    public static class TestSolution {

        static Stream<Arguments> paramProvider() {
            return Stream.of(
                    arguments(new int[]{1,3,5,6}, 5, 2),
                    arguments(new int[]{1,3,5,6}, 2, 1),
                    arguments(new int[]{1,3,5,6}, 7, 4),
                    arguments(new int[]{1,3,5}, 3, 1),
                    arguments(new int[]{2,3,5,6,9}, 7, 4)
            );
        }


        @ParameterizedTest
        @MethodSource("paramProvider")
        public final void testSuccess(int[] nums, int target, int expected) {
            var problem = new P0035_SearchInsertPosition();

            var result = problem.searchInsert(nums, target);

            assertEquals(expected, result);
        }
    }
}

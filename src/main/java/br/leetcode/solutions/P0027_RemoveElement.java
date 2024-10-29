package br.leetcode.solutions;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class P0027_RemoveElement {

    public int removeElement(int[] nums, int val) {

        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[j++] = nums[i];
            }
        }
        return j;
    }

    public static class TestSolution {

        static Stream<Arguments> paramProvider() {
            return Stream.of(
                    arguments(new int[]{3, 2, 2, 3}, 3, 2),
                    arguments(new int[]{0, 1, 2, 2, 3, 0, 4, 2}, 2, 5)
            );
        }


        @ParameterizedTest
        @MethodSource("paramProvider")
        public final void testSuccess(int[] nums, int val, int expected) {
            var problem = new P0027_RemoveElement();

            var result = problem.removeElement(nums, val);

            assertEquals(expected, result);
        }
    }
}

package br.leetcode.solutions;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class P0088_MergeSortedArray {

    public void merge(int[] nums1, int m, int[] nums2, int n) {

        var c1 = m - 1;
        var c2 = n - 1;
        var c = m + n - 1;

        while (c >= 0) {

            if (c1 < 0 && c2 >= 0) {
                nums1[c--] = nums2[c2--];
            } else if (c1 >= 0 && c2 >= 0){
                nums1[c--] = nums1[c1] > nums2[c2] ? nums1[c1--] : nums2[c2--];
            } else {
                break;
            }
        }
    }

    public static class TestSolution {

        static Stream<Arguments> paramProvider() {
            return Stream.of(
                    arguments(new int[]{1, 2, 3, 0, 0, 0}, 3, new int[]{2, 5, 6}, 3, new int[]{1, 2, 2, 3, 5, 6}),
                    arguments(new int[]{1}, 1, new int[]{}, 0, new int[]{1}),
                    arguments(new int[]{0}, 0, new int[]{1}, 1, new int[]{1})
            );
        }


        @ParameterizedTest
        @MethodSource("paramProvider")
        public final void testSuccess(int[] nums1, int m, int[] nums2, int n, int[] expected) {
            var problem = new P0088_MergeSortedArray();

            problem.merge(nums1, m, nums2, n);

            assertArrayEquals(expected, nums1);
        }
    }
}

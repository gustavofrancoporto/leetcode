package br.leetcode.solutions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class P0021_MergeTwoSortedLists {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }

        var fakeHead = new ListNode();
        var current = fakeHead;

        while (list1 != null && list2 != null) {

            if (list1.val <= list2.val) {
                current.next = list1;
                list1 = list1.next;
            } else {
                current.next = list2;
                list2 = list2.next;
            }
            current = current.next;
        }

        current.next = (list1 == null) ? list2 : list1;

        return fakeHead.next;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ListNode {
        int val;
        ListNode next;

        public static ListNode fromArray(int[] list) {
            if (list == null || list.length == 0) {
                return null;
            }

            var node = new ListNode(list[list.length - 1], null);
            for (int i = list.length - 2; i >= 0; i--) {
                node = new ListNode(list[i], node);
            }
            return node;
        }

        public static int[] toArray(ListNode node) {
            var list = new ArrayList<Integer>();
            while (node != null) {
                list.add(node.val);
                node = node.next;
            }
            return list.stream().mapToInt(i -> i).toArray();
        }
    }

    public static class TestSolution {

        static Stream<Arguments> paramProvider() {
            return Stream.of(
                    arguments(new int[]{1, 2, 4}, new int[]{1, 3, 4}, new int[]{1, 1, 2, 3, 4, 4}),
                    arguments(new int[]{}, new int[]{}, new int[]{}),
                    arguments(new int[]{}, new int[]{0}, new int[]{0}),
                    arguments(new int[]{5}, new int[]{1, 2, 4}, new int[]{1, 2, 4, 5})
            );
        }


        @ParameterizedTest
        @MethodSource("paramProvider")
        public final void testSuccess(int[] list1, int[] list2, int[] expected) {
            var problem = new P0021_MergeTwoSortedLists();

            var listNode1 = ListNode.fromArray(list1);
            var listNode2 = ListNode.fromArray(list2);

            var result = problem.mergeTwoLists(listNode1, listNode2);

            var resultArray = ListNode.toArray(result);

            assertArrayEquals(expected, resultArray);
        }
    }
}

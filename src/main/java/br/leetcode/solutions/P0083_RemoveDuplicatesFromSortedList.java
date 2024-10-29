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

public class P0083_RemoveDuplicatesFromSortedList {

    public ListNode deleteDuplicates(ListNode listNode) {

        var head = listNode;
        while (listNode != null && listNode.next != null) {

            if (listNode.val == listNode.next.val) {
                listNode.next = listNode.next.next;
            } else {
                listNode = listNode.next;
            }
        }

        return head;
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
                    arguments(new int[]{1, 1, 2}, new int[]{1, 2}),
                    arguments(new int[]{1, 1, 1}, new int[]{1}),
                    arguments(new int[]{1, 1, 2, 3, 3}, new int[]{1, 2, 3})
            );
        }


        @ParameterizedTest
        @MethodSource("paramProvider")
        public final void testSuccess(int[] list, int[] expected) {
            var problem = new P0083_RemoveDuplicatesFromSortedList();

            var listNode = ListNode.fromArray(list);

            var result = problem.deleteDuplicates(listNode);

            var resultArray = ListNode.toArray(result);

            assertArrayEquals(expected, resultArray);
        }
    }
}

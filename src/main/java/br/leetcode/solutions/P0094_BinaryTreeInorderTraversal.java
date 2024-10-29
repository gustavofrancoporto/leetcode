package br.leetcode.solutions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;

public class P0094_BinaryTreeInorderTraversal {

    public List<Integer> inorderTraversal(TreeNode root) {
        var numbers = new ArrayList<Integer>();
        var stack = new Stack<TreeNode>();

        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            numbers.add(root.val);
            root = root.right;
        }

        return numbers;
    }
//    public List<Integer> inorderTraversal(TreeNode root) {
//
//        var numbers = new ArrayList<Integer>();
//        if (root != null) {
//            walk(root, numbers);
//        }
//        return numbers;
//    }
//
//    public void walk(TreeNode node, List<Integer> numbers) {
//
//        if (node.left != null) {
//            walk(node.left, numbers);
//        }
//        numbers.add(node.val);
//        if (node.right != null) {
//            walk(node.right, numbers);
//        }
//    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    @Nested
    class TestSolution {

        @Test
        public final void test() {

            var root = new TreeNode(
                    2,
                    new TreeNode(3,
                            new TreeNode(1), null),
                    null
            );

            var problem = new P0094_BinaryTreeInorderTraversal();
            var result = problem.inorderTraversal(root);
            assertIterableEquals(Arrays.asList(1, 3, 2), result);
        }
    }
}
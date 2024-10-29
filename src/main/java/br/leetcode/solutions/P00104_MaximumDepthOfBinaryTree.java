package br.leetcode.solutions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class P00104_MaximumDepthOfBinaryTree {

    public int maxDepth(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int[] maxDepth = new int[1];

        walkTree(root.left, 1, maxDepth);
        walkTree(root.right, 1, maxDepth);

        return maxDepth[0] + 1;
    }

    public void walkTree(TreeNode node, int currentDepth, int[] maxDepth) {

        if (node != null) {
            maxDepth[0] = Math.max(maxDepth[0], currentDepth);

            walkTree(node.left, currentDepth + 1, maxDepth);
            walkTree(node.right, currentDepth + 1, maxDepth);
        }
    }

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
                    1,
                    new TreeNode(2,
                            new TreeNode(3),
                            new TreeNode(4)),
                    new TreeNode(2,
                            new TreeNode(4),
                            new TreeNode(3))
            );

            var problem = new P00104_MaximumDepthOfBinaryTree();
            var result = problem.maxDepth(root);
            assertEquals(3, result);
        }
    }
}
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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;

public class P00100_SameTree {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        } else if ((p == null || q == null) || (p.val != q.val)) {
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
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
                    2,
                    new TreeNode(3,
                            new TreeNode(1), null),
                    null
            );

            var problem = new P00100_SameTree();
            var result = problem.isSameTree(root, root);
            assertEquals(true, result);
        }
    }
}
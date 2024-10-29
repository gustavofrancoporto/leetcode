package br.leetcode.solutions;

import com.sun.source.tree.Tree;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class P00101_SymmetricTree {

    public boolean isSymmetric(TreeNode root) {

        var stack = new LinkedList<TreeNode>();
        stack.push(root.left);
        stack.push(root.right);

        while (!stack.isEmpty()) {

            var node1 = stack.removeFirst();
            var node2 = stack.removeFirst();

            if (node1 == null && node2 == null) {
                continue;
            }

            if (node1 == null || node2 == null || node1.val != node2.val) {
                return false;
            }

            stack.push(node1.left);
            stack.push(node2.right);
            stack.push(node1.right);
            stack.push(node2.left);
        }
        return true;
    }
    /*
    public boolean isSymmetric(TreeNode root) {
        return isSymmetric(root.left, root.right);
    }

    public boolean isSymmetric(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        } else if ((p == null || q == null) || (p.val != q.val)) {
            return false;
        }
        return isSymmetric(p.left, q.right) && isSymmetric(p.right, q.left);
    }
    */

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

            var problem = new P00101_SymmetricTree();
            var result = problem.isSymmetric(root);
            assertEquals(true, result);
        }
    }
}
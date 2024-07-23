package org.example.uber.section2.binaryTree;

import java.util.Stack;

/*
Given the root of a binary tree and an integer targetSum,
return true if the tree has a root-to-leaf path such that adding up all the values along the path equals targetSum.
A leaf is a node with no children.
 */

public class PathSum {
    public static void main(String[] args) {
        TreeNode rt1 = new TreeNode(1);
        TreeNode rt2 = new TreeNode(4, null, rt1);
        TreeNode rtl1 = new TreeNode(13);
        TreeNode rt3 = new TreeNode(8, rtl1, rt2);

        TreeNode lt1 = new TreeNode(7);
        TreeNode lt2 = new TreeNode(2);
        TreeNode lt3 = new TreeNode(11, lt1, lt2);

        TreeNode lt4 = new TreeNode(4, lt3, null);

        TreeNode root = new TreeNode(5, lt4, rt3);

        boolean pathFound = isPathPresent(root, 20);
        System.out.println("Path found: "+pathFound);
    }

    private static boolean isPathPresent(TreeNode root, int pathVal) {

        Stack<TreeNode> nodes = new Stack<>();
        Stack<Integer> sumOfPath = new Stack<>();
        if(root == null){
            return false;
        }
        nodes.add(root);
        sumOfPath.add(root.val);
        while (!nodes.isEmpty()){
            TreeNode node = nodes.pop();
            int tempSum = sumOfPath.pop();

            if(node.right == null && node.left == null &&tempSum == pathVal){
                return true;
            }

            if(node.right != null){
                nodes.push(node.right);
                sumOfPath.push(node.right.val + tempSum);
            }

            if(node.left != null){
                nodes.push(node.left);
                sumOfPath.push(node.left.val+ tempSum);
            }
        }
        return false;
    }
}

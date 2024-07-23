package org.example.uber.section2.binaryTree;

import org.example.uber.inheritance.A;

import java.util.*;
/*
Given the root of a binary tree, return its maximum depth.
A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 */
public class MaximumDepthOfBinaryTree {
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

        int maxDepth = findMaxDepth2(root);
        System.out.println("Maximum depth is :"+maxDepth);
    }

    private static int findMaxDepth2(TreeNode root) {
        if(root == null){
            return 0;
        }

        int leftSubHeight = findMaxDepth2(root.left);
        int rightSubHeight = findMaxDepth2(root.right);

        return Math.max(leftSubHeight , rightSubHeight)+1;
    }

    /*private static int findMaxDepth(TreeNode root) {

        List<List<Integer>> ans = new ArrayList<>();
        if(root == null){
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int count = 0;
        while (!queue.isEmpty()){
            int levelSize = queue.size();
            count++;
            List<Integer> levelNode = new ArrayList<>();

            for(int i = 0; i< levelSize; i++){
                TreeNode tempNode = queue.poll();
                levelNode.add(tempNode.val);

                if(tempNode.left != null){
                    queue.add(tempNode.left);
                }
                if(tempNode.right != null){
                    queue.add(tempNode.right);
                }
            }
            ans.add(levelNode);
        }
        System.out.println(ans);
        return count;
    }*/
}

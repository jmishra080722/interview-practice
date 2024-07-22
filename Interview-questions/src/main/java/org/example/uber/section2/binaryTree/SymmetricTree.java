package org.example.uber.section2.binaryTree;

import java.util.Stack;

//Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).
public class SymmetricTree {
    public static void main(String[] args) {
        /*TreeNode t1 = new TreeNode(3);
        TreeNode t2 = new TreeNode(4);
        TreeNode t3 = new TreeNode(2, t1, t2);
        TreeNode t4 = new TreeNode(2, t2, t1);
        TreeNode root = new TreeNode(1, t3, t4);*/
        //[1,2,2,2,null,2]
        TreeNode t3 = new TreeNode(2);
        TreeNode t5 = new TreeNode(2);
        TreeNode t1 = new TreeNode(2, t3, null);
        TreeNode t2 = new TreeNode(2, t5, null);
        TreeNode root = new TreeNode(1, t1, t2);

        boolean isSymmetric = checkSymmetric(root);
        System.out.println(isSymmetric);
    }

    private static boolean checkSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }
        return helper(root.left, root.right);
    }

    private static boolean helper(TreeNode root1, TreeNode root2) {
        if(root1 == null && root2 == null){
            return true;
        }
        if(root1 == null || root2 == null){
            return false;
        }
        return root1.val == root2.val && helper(root1.left, root2.right) && helper(root1.right, root2.left);
    }


}

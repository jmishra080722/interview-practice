package org.example.uber.section2.binaryTree;

import java.util.LinkedList;
import java.util.List;

public class IsBinarySearchTree {
    public static void main(String[] args) {
        TreeNode leftTreeNode = new TreeNode(1);
        TreeNode rightTreeNode = new TreeNode(3);
        TreeNode treeNode = new TreeNode(2, leftTreeNode,  rightTreeNode);

        boolean isBST = checkBST(treeNode);
        System.out.println(isBST);
    }

    private static boolean checkBST(TreeNode treeNode) {

        List<Integer> inOrderList = new LinkedList<>();
        helper(treeNode, inOrderList);
        boolean isBST = true;
        int prev = inOrderList.get(0);
        for(int i = 1; i< inOrderList.size(); i++){
            if(prev >= inOrderList.get(i)){
                isBST = false;
            }
        }
        return isBST;
    }

    private static void helper(TreeNode treeNode, List<Integer> inOrderList) {

        if(treeNode == null){
            return;
        }
        helper(treeNode.left, inOrderList);
        inOrderList.add(treeNode.val);
        helper(treeNode.right, inOrderList);
    }
}

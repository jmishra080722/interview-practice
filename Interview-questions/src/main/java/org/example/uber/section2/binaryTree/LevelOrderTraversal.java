package org.example.uber.section2.binaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal {
    public static void main(String[] args) {
        TreeNode leftTreeNode1 = new TreeNode(9);
        TreeNode leftTreeNode2 = new TreeNode(15);
        TreeNode rightTreeNode2 = new TreeNode(7);
        TreeNode rightTreeNode1 = new TreeNode(20, leftTreeNode2, rightTreeNode2 );
        TreeNode treeNode = new TreeNode(3, leftTreeNode1,  rightTreeNode1);
        List<List<Integer>> nodes = orderTraversal2(treeNode);
        System.out.println(nodes);
    }

    private static List<List<Integer>> orderTraversal2(TreeNode treeNode) {
        List<List<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> treeNodeQueue = new LinkedList<>();
        if(treeNode == null){
            return ans;
        }

        treeNodeQueue.add(treeNode);
        while (!treeNodeQueue.isEmpty()){
            int levelSize = treeNodeQueue.size();
            List<Integer> levelNodes = new ArrayList<>();

            for(int i=0; i<levelSize; i++){
                TreeNode node = treeNodeQueue.poll();
                levelNodes.add(node.val);
                if(node.left != null){
                    treeNodeQueue.add(node.left);
                }
                if(node.right != null){
                    treeNodeQueue.add(node.right);
                }
            }
            ans.add(levelNodes);
        }
    return ans;
    }

    /*private static void orderTraversal(TreeNode treeNode) {
        Queue<TreeNode> treeNodeQueue = new LinkedList<>();

        if(treeNode == null){
            System.out.println("N0 node present");
        }
        treeNodeQueue.add(treeNode);
        while (!treeNodeQueue.isEmpty()){

            TreeNode node = treeNodeQueue.poll();
            System.out.print(node.val + " , ");

            if(node.left != null){
                treeNodeQueue.add(node.left);
            }

            if(node.right != null){
                treeNodeQueue.add(node.right);
            }

        }
    }*/
}

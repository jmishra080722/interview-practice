package org.example.uber.section2.binaryTree;

//Given an integer n,
// return the number of structurally unique BST's (binary search trees)
// which has exactly n nodes of unique values from 1 to n.
public class UniqueBinarySearchTrees {

    public static void main(String[] args) {
        int num = 3;
        int numOfTree = findNumOfUniqTree(num);
        System.out.println(numOfTree);
    }

    private static int findNumOfUniqTree(int num) {
        if(num < 0){
            return  0;
        }

        int[] treeCount = new int[num + 1];
        treeCount[0] = 1;
        treeCount[1] = 1;
        for(int i = 2; i <= num; i++){
            for(int j = 1; j <= i; j++){
                treeCount[i] += treeCount[j -1] * treeCount[i- j ];
            }
        }
        return treeCount[num];
    }
}

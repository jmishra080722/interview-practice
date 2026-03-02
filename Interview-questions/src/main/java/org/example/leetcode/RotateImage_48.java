package org.example.leetcode;

import org.example.leetcode150.Util;

public class RotateImage_48 {
    public static void main(String[] args) {
        int[][] matrix =
                {{1, 2, 3},
                        {4, 5, 6},
                        {7, 8, 9}};

        rotate2(matrix);
        for(int i = 0; i<matrix[0].length ; i++){
            Util.print(matrix[i]);
        }
    }

    private static void rotate2(int[][] matrix) {
        int n = matrix.length;
        for(int i =0; i< (n + 1)/2; i++){
            for(int j = 0; j< n/2; j++){
                //Start 4 way swap
                //temp = Bottom left
                int temp = matrix[n-1-j][i];

                //Bottom left  = bottom right
                matrix[n - 1 - j][i] = matrix[n - 1 - i][n  -j - 1];

                //Bottom right =   top right
                matrix[n - 1 -i][n-j-1] = matrix[j][n-1-i];

                //top right = top left
                matrix[j][n-1-i] = matrix[i][j];

                //top left = temp
                matrix[i][j] = temp;
            }
        }
    }

    private static void rotate(int[][] matrix) {
        int n = matrix.length;
        if (n == 0) {
            return;
        }

        // Transpose the matrix
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // Reverse each row to get 90-degree clockwise rotation
        for (int i = 0; i < n; i++) {
            int left = 0;
            int right = n - 1;
            while (left < right) {
                int temp = matrix[i][left];
                matrix[i][left] = matrix[i][right];
                matrix[i][right] = temp;
                left++;
                right--;
            }
        }
    }

}

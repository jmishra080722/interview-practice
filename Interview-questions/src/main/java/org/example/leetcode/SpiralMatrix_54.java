package org.example.leetcode;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix_54 {
    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3, 4},
                {5, 6, 7, 8},
                { 9, 10, 11, 12}};
        List<Integer> spiral = spiralOrder(matrix);
        System.out.println(spiral);
    }

    private static List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> result = new ArrayList<>();
        int rowBeg = 0;
        int rowEnd = matrix.length - 1;

        int colBeg = 0;
        int colEnd = matrix[0].length - 1;

        while (rowBeg <= rowEnd && colBeg <= colEnd){

            //Travers right
            for(int i = colBeg; i<= colEnd; i++){
                result.add(matrix[rowBeg][i]);
            }
            rowBeg++;

            //Travers down
            for(int i = rowBeg; i<= rowEnd; i++){
                result.add(matrix[i][colEnd]);
            }
            colEnd--;

            //Travers left
            if(rowBeg <= rowEnd){
                for (int i = colEnd; i >= colBeg; i--){
                    result.add(matrix[rowEnd][i]);
                }
            }
            rowEnd--;

            //Travers up
            if(colBeg <= colEnd){
                for (int i = rowEnd; i >= rowBeg; i--){
                    result.add(matrix[i][colBeg]);
                }
            }
            colBeg++;

        }
        return result;
    }
}

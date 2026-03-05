package org.example.leetcode;

import java.util.*;
import java.util.stream.Collectors;

public class N_Queens_II_52 {
    public static void main(String[] args) {
        int n = 4;
        int  totalNQueens= totalNQueens(n);
        System.out.println(totalNQueens);
    }

    private static int totalNQueens(int n) {
        Set<Integer> columns = new HashSet<>();
        Set<Integer> positiveDiagonals = new HashSet<>(); //(row+column)
        Set<Integer> negativeDiagonals = new HashSet<>();  //(row - column)

        List<List<String>> result = new ArrayList<>();
        String[][] board = new String[n][n];
        for(int i =0; i < n; i++){
            for (int j = 0; j < n; j++){
                board[i][j] = ".";
            }
        }

        backtrack(0, n, board, result, columns, positiveDiagonals, negativeDiagonals);

        return result.size();
    }

    private static void backtrack(int r, int n, String[][] board, List<List<String>> result,
                                  Set<Integer> columns, Set<Integer> positiveDiagonals, Set<Integer> negativeDiagonals) {
        if(r == n){
            List<String> temp = Arrays.stream(board)
                    .map(row -> Arrays.stream(row).collect(Collectors.joining(" ")))
                    .collect(Collectors.toList());
            result.add(temp);
            return;
        }

        for (int c = 0; c< n; c++){
            if(columns.contains(c) || positiveDiagonals.contains(r+c) || negativeDiagonals.contains(r - c)){
                continue;
            }

            columns.add(c);
            positiveDiagonals.add(r + c);
            negativeDiagonals.add(r - c);
            board[r][c] = "Q";

            backtrack(r +1, n, board, result,columns, positiveDiagonals, negativeDiagonals);

            columns.remove(c);
            positiveDiagonals.remove(r + c);
            negativeDiagonals.remove(r - c);
            board[r][c] = ".";
        }
    }
}

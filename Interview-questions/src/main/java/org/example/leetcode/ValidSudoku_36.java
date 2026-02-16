package org.example.leetcode;

import java.util.*;

public class ValidSudoku_36 {
    public static void main(String[] args) {
        String[][] board =
                {{"5","3",".",".","7",".",".",".","."}
,{"6",".",".","1","9","5",".",".","."}
,{".","9","8",".",".",".",".","6","."}
,{"8",".",".",".","6",".",".",".","3"}
,{"4",".",".","8",".","3",".",".","1"}
,{"7",".",".",".","2",".",".",".","6"}
,{".","6",".",".",".",".","2","8","."}
,{".",".",".","4","1","9",".",".","5"}
,{".",".",".",".","8",".",".","7","9"}};
        boolean isValid = isValidSudoku(board);
        System.out.println(isValid);
    }

    private static boolean isValidSudoku(String[][] board) {
        Map<Integer, Set<String>> rows = new HashMap<>();
        Map<Integer, Set<String>> columns = new HashMap<>();
        Map<String, Set<String>> squares = new HashMap<>();
        for(int r = 0; r < 9; r++){
            for(int c  = 0; c < 9;  c++){
                String currentStr = board[r][c];
                if(Objects.equals(currentStr, ".")){
                    continue;
                }
                String squareKey = r/3+","+c/3;
                if(rows.computeIfAbsent(r, k -> new HashSet<>()).contains(currentStr)  ||
                       columns.computeIfAbsent(c, k -> new HashSet<>()).contains(currentStr) ||
                        squares.computeIfAbsent(squareKey, k -> new HashSet<>()).contains(currentStr)){
                    return false;
                }
                rows.get(r).add(currentStr);
                columns.get(c).add(currentStr);
                squares.get(squareKey).add(currentStr);
            }
        }
        return true;
    }
}

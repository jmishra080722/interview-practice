package org.example.leetcode;

public class SudokuSolver_37 {
    public static void main(String[] args) {
        char[][] board = {
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        };
        printBoard(board);
        solveSudoku(board);
        System.out.println("================");
        printBoard(board);
    }

    public static void solveSudoku(char[][] board) {
        solve(board);
    }

    private static boolean solve(char[][] board) {
        for(int r = 0; r < 9; r++){
            for(int c = 0; c< 9; c++){

                if(board[r][c] == '.'){

                    for(char ch = '1'; ch<='9'; ch++){

                        if(isValid(board, r, c, ch)){
                            board[r][c] = ch;

                            if(solve(board)){
                                return true;
                            }

                            board[r][c] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean isValid(char[][] board, int row, int col, char ch) {
        for(int i = 0; i< 9; i++){
            if(board[row][i] == ch){
                return false;
            }
            if(board[i][col] == ch){
                return false;
            }
            int boxRow = 3 * (row/3)  + i/3;
            int boxCol = 3 * (col/3) + i%3;
            if(board[boxRow][boxCol] == ch){
                return false;
            }
        }
        return true;
    }

    public static void printBoard(char[][] board) {
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[r].length; c++) {
                System.out.print(board[r][c] + " ");
            }
            System.out.println();
        }
    }
}

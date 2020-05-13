/*
 * Project: java-strategy
 *
 * File Created at 2018/12/6
 *
 * Copyright 2016 CMCC Corporation Limited.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * ZYHY Company. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license.
 */

package Q37;

/**
 * @Type Solution.java
 * @Desc
 * @Author chentuoyi
 * @Date 2018/12/6 12:41
 * @Version 1.0
 */
public class Solution {
    public static boolean dfs(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == '.') {
                    for (int k = 1; k < 10; k++) {
                        board[i][j] = (char) (k + 48);
                        boolean result = check(board, i, j);
                        if (result) {
                            result = dfs(board);
                            if (result) {
                                return true;
                            }
                        }

                    }
                    board[i][j] = '.';
                    return false;
                }
            }
        }
        return true;
    }
    public static void solveSudoku(char[][] board) {
        dfs(board);
        print(board);
    }

    private static void print(char[][] board) {
        for (int i1 = 0; i1 < 9; i1++) {
            for (int j1 = 0; j1 < 9; j1++) {
                System.out.print(board[i1][j1] + " ");
            }
            System.out.println();
        }
    }

    private static boolean check(char[][] board, int x, int y) {
        int m = board.length;
        int n = board[0].length;
        //列判重
        for (int i = 0; i < m; i++) {
            if (board[x][y] == board[i][y] && x != i) {
                return false;
            }
        }
        //行判重
        for (int i = 0; i < n; i++) {
            if (board[x][y] == board[x][i] && y != i) {
                return false;
            }

        }
        int xStart = x / 3 * 3;
        int yStart = y / 3 * 3;
        for (int i = xStart; i < xStart + 3; i++) {
            for (int j = yStart; j < yStart + 3; j++) {
                if (board[x][y] == board[i][j] && x != i && y != j) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] board = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'},
        };
        solveSudoku(board);
    }
}

/*
 * Revision history
 * -------------------------------------------------------------------------
 *
 * Date Author Note
 * -------------------------------------------------------------------------
 * 2018/12/6 chentuoyi create
 */
package Q55;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        int a = 0;
        int c = 0;
        int d = 0;
        int[] array = new int[n];

        solveNQueens(result, a, c, d, 0, n, array);

        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().solveNQueens(4));
    }

    private void solveNQueens(List<List<String>> result, int a, int c, int d, int k, int n, int[] array) {
        if (k == n) {
            result.add(transfer(n, array));
        } else {
            for (int i = 0; i < n; i++) {
                if (checkRow(a, i) && checkLeftDiagonal(c, i, k) && checkRightDiagonal(d, i, k, n)) {
                    a = a + (1 << i);
                    c = c + (1 << (i + k));
                    d = d + (1 << (i - k + n - 1));
                    array[k] = i;
                    solveNQueens(result, a, c, d, k + 1, n, array);
                    a = a - (1 << i);
                    c = c - (1 << (i + k));
                    d = d - (1 << (i - k + n - 1));
                }
            }
        }
    }

    private boolean checkRightDiagonal(int d, int i, int k, int n) {
        return (d & (1 << (i - k + n - 1))) == 0;
    }

    private boolean checkLeftDiagonal(int c, int i, int k) {
        return (c & (1 << (i + k))) == 0;

    }

    private boolean checkRow(int a, int i) {
        return (a & (1 << i)) == 0;
    }



    private List<String> transfer(int n, int[] array) {

        List<String> result = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            StringBuilder s = new StringBuilder();
            for (int j = 0; j < n; j++) {
                if (array[i] == j) {
                    s.append("Q");
                } else {
                    s.append('.');
                }
            }
            result.add(s.toString());
        }

        return result;
    }

}

package Q51;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Solution {


    public int totalNQueens(int n) {
        int a = 0;
        int c = 0;
        int d = 0;
        AtomicInteger atomicInteger=new AtomicInteger();



        solveNQueens(atomicInteger,a, c, d, 0, n);
        return atomicInteger.get();

    }

    public static void main(String[] args) {
        System.out.println(new Solution().totalNQueens(9));
    }

    private void solveNQueens(AtomicInteger atomicInteger, int a, int c, int d, int k, int n) {
        if (k == n) {
            atomicInteger.getAndAdd(1);
        } else {
            for (int i = 0; i < n; i++) {
                if (checkRow(a, i) && checkLeftDiagonal(c, i, k) && checkRightDiagonal(d, i, k, n)) {
                    a = a + (1 << i);
                    c = c + (1 << (i + k));
                    d = d + (1 << (i - k + n - 1));
                    solveNQueens(atomicInteger, a, c, d, k + 1, n);
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



}

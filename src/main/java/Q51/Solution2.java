package Q51;


import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution2 {
    public List<List<String>> solveNQueens(int n) {

        List<List<String>> result = new ArrayList<>();
        String[][] table = new String[n][n];
        for (int i=0;i<n;i++){
            for (int j=0;j<n;j++){
                table[i][j]=".";
            }
        }
        solveNQueens(n, 0, table, result);
        return result;
    }

    private void solveNQueens(int n, int c, String[][] table, List<List<String>> result) {
        if (c == n) {
            result.add(produce(n, table));
            return;
        }
        for (int i = 0; i < n; i++) {
            if (check(n, c, i, table)) {
                table[c][i] = "Q";
                solveNQueens(n, c + 1, table, result);
                table[c][i] = ".";
            }
        }
    }

    private List<String> produce(int n, String[][] table) {
        List<String> line = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            line.add(String.join("", table[i]));
        }
        return line;
    }

    private boolean check(int n, int c, int b, String[][] table) {
        //列检查
        for (int i = 0; i < n; i++) {
            if (table[i][b].equals("Q")) {
                return false;
            }
        }
        //斜向检查
        int i = c, j = b;
        while ((i < n && j < n)) {
            if (table[i][j].equals("Q")) {
                return false;
            }
            i = i + 1;
            j = j + 1;
        }
        i = c;
        j = b;
        while ((i >= 0 && j >= 0)) {
            if (table[i][j].equals("Q")) {
                return false;
            }
            i = i - 1;
            j = j - 1;
        }

        i = c;
        j = b;
        while ((i >= 0 && j < n)) {
            if (table[i][j].equals("Q")) {
                return false;
            }
            i = i - 1;
            j = j + 1;
        }
        i = c;
        j = b;
        while ((i < n && j >= 0)) {
            if (table[i][j].equals("Q")) {
                return false;
            }
            i = i + 1;
            j = j - 1;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution2().solveNQueens(4));
    }
}
//leetcode submit region end(Prohibit modification and deletion)

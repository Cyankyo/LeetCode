package Q60;

public class Solution {
    int[] factorial = new int[]{1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880};

    //
    public String getPermutation(int n, int k) {
        int fullSet = (1 << (n)) - 1;
        return getPermutation(fullSet, n, k,n);
    }

    public String getPermutation(int fullSet, int n, int k,int m) {
        if (n == 0 || k == 0) {
            return "";
        }
        int f = (k - 1) / factorial[n - 1];
        int t = getFirst(fullSet, m, f + 1);
        fullSet = fullSet - (1 << t);
        return String.valueOf(t + 1) + getPermutation(fullSet, n - 1, k - f * factorial[n - 1],m);
    }

    private int getFirst(int fullSet, int n, int j) {
        int c = 0;
        for (int i = 0; i < n; i++) {
            if ((fullSet & (1 << i)) != 0) {
                c++;
            }
            if (j == c) {
                return i;
            }
        }
        return 1;
    }

    public static void main(String[] args) {
//        System.out.println(1 << 10);
        System.out.println(new Solution().getPermutation(9, 40320));
    }
}

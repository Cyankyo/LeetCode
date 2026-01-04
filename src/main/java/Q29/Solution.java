package Q29;

class Solution {
    public int divide(int dividend, int divisor) {
        Long div= (long) dividend;
        Long divsor= (long) divisor;
        return (int) Math.min(Math.max(div / divsor,Integer.MIN_VALUE),Integer.MAX_VALUE);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().divide(-2147483648,-1));
    }
}

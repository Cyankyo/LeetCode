package Q45;

class Solution {
    public int jump1(int[] nums) {
        int n = nums.length;
        int[] jumpTimes = new int[n];
        for (int i = 0; i < n; i++) {
            jumpTimes[i] = i;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if ((jumpTimes[j] + 1 < jumpTimes[i]) && (nums[j] >= (i - j))) {
                    jumpTimes[i] = jumpTimes[j] + 1;
                }
            }
        }
        return jumpTimes[n - 1];
    }

    public int jump(int[] nums) {
        int length = nums.length;
        int end = 0;
        int maxPosition = 0;
        int steps = 0;
        for (int i = 0; i < length - 1; i++) {
            maxPosition = Math.max(maxPosition, i + nums[i]);
            if (i == end) {
                end = maxPosition;
                steps++;
            }
        }
        return steps;

    }

    public static void main(String[] args) {
        System.out.println(new Solution().jump(new int[]{2, 3, 0, 1, 4}));
    }
}


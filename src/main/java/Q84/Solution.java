package Q84;

import java.util.Stack;

public class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int n = heights.length;
        int[] left = new int[n];
        for (int i = 0; i < n; i++) {

            while ((!stack.isEmpty()) && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            left[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        stack.clear();
        int[] right = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            while ((!stack.isEmpty()) && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            right[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }
        int size = 0;
        for (int i = 0; i < n; i++) {
            size = Math.max(size, heights[i] * (right[i] - left[i] - 1));
        }
        return size;
    }

    public static void main(String[] args) {
        int[] a = new int[]{2, 4};
        System.out.println(new Solution().largestRectangleArea(a));

    }
}
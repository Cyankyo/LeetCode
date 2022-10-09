/*
 * Project: LeetCode
 *
 * File Created at 2022/2/25
 *
 * Copyright 2016 cyan Corporation Limited.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * cyan Company. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license.
 */

package Q42;

/***
 * @Type
 * @Desc
 * @Author cyankyo
 * @Date 2022/2/25 17:55
 * @Version 1.0
 */
public class Solution {
    public int trap(int[] height) {
        int leftMax = 0;
        int rightMax = 0;
        int left = 0;
        int right = height.length - 1;
        int size = 0;
        while (left < right) {
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);
            int min = Math.min(leftMax, rightMax);
            if (leftMax <= rightMax) {
                if (height[left] < min) {
                    size = size + min - height[left];
                }
                left++;
            } else {
                if (height[right] < min) {
                    size = size + min - height[right];
                }
                right--;
            }
        }
        return size;
    }

    public static void main(String[] args) {
        int[] a = new int[]{4,2,0,3,2,5};
        System.out.println(new Solution().trap(a));
    }
}

/*
 * Revision history
 * -------------------------------------------------------------------------
 *
 * Date Author Note
 * -------------------------------------------------------------------------
 * 2022/2/25 cyankyo create
 */
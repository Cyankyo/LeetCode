/*
 * Project: java-strategy
 *
 * File Created at 2018/11/26
 *
 * Copyright 2016 CMCC Corporation Limited.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * ZYHY Company. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license.
 */

package Q11;

/**
 * @Type Solution.java
 * @Desc
 * @Author chentuoyi
 * @Date 2018/11/26 19:50
 * @Version 1.0
 */
public class Solution {
    public static int maxArea(int[] height) {
        int i = 0;
        int j = height.length-1;
        int max = 0;

        while (i != j) {
            int h = Math.min(height[i], height[j]);
            max = Math.max(max, h * (j - i));
            if (height[i]>height[j]){
                j--;
            }else {
                i++;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
    }
}

/*
 * Revision history
 * -------------------------------------------------------------------------
 *
 * Date Author Note
 * -------------------------------------------------------------------------
 * 2018/11/26 chentuoyi create
 */
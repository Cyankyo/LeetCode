///*
// * Project: LeetCode
// *
// * File Created at 2022/2/25
// *
// * Copyright 2016 cyan Corporation Limited.
// * All rights reserved.
// *
// * This software is the confidential and proprietary information of
// * cyan Company. ("Confidential Information").  You shall not
// * disclose such Confidential Information and shall use it only in
// * accordance with the terms of the license.
// */
//
//package Q42;
//
///***
// * @Type
// * @Desc
// * @Author cyankyo
// * @Date 2022/2/25 17:55
// * @Version 1.0
// */
//public class Solution {
//    public int trap(int[] height) {
//        int leftMax = 0;
//        int rightMax = 0;
//        int left = 0;
//        int right = height.length - 1;
//        int size = 0;
//        while (left != right) {
//            leftMax = Math.max(leftMax, height[left]);
//            rightMax = Math.max(rightMax, height[right]);
//            int max = Math.max(leftMax, rightMax);
//            if (height[left] > height[right]) {
//                size += max - height[right];
//                right++;
//            }
//        }
//    }
//
//    public static void main(String[] args) {
//
//    }
//}
//
///*
// * Revision history
// * -------------------------------------------------------------------------
// *
// * Date Author Note
// * -------------------------------------------------------------------------
// * 2022/2/25 cyankyo create
// */
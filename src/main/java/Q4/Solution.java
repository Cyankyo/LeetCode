///*
// * Project: java-strategy
// *
// * File Created at 2018/12/17
// *
// * Copyright 2016 kyo Corporation Limited.
// * All rights reserved.
// *
// * This software is the confidential and proprietary information of
// * kyo Company. ("Confidential Information").  You shall not
// * disclose such Confidential Information and shall use it only in
// * accordance with the terms of the license.
// */
//
//package Q4;
//
///**
// * @Type Solution.java
// * @Desc
// * @Author cyankyo
// * @Date 2018/12/17 13:45
// * @Version 1.0
// */
//class Solution {
//    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
//        int m = nums1.length;
//        int n = nums2.length;
//        int len = m + n;
//        int i = 0;
//        int j = 0;
//        while ((i + j) < (m + n) / 2) {
//            if (nums1[i] < nums2[j]) {
//                i++;
//                if (i == m) {
//                    return (double) (nums1[i - 1] + nums1[i]) / 2;
//                }
//            } else {
//                j++;
//                if (j == n) {
//
//                }
//            }
//        }
//    }
//    public boolean isOdd(int n) {
//        return (n & 1) == 1;
//    }
//}
//
///*
// * Revision history
// * -------------------------------------------------------------------------
// *
// * Date Author Note
// * -------------------------------------------------------------------------
// * 2018/12/17 cyankyo create
// */
///*
// * Project: java-strategy
// *
// * File Created at 2018/11/26
// *
// * Copyright 2016 CMCC Corporation Limited.
// * All rights reserved.
// *
// * This software is the confidential and proprietary information of
// * ZYHY Company. ("Confidential Information").  You shall not
// * disclose such Confidential Information and shall use it only in
// * accordance with the terms of the license.
// */
//
//package Q12;
//
///**
// * @Type Solution.java
// * @Desc
// * @Author chentuoyi
// * @Date 2018/11/26 19:58
// * @Version 1.0
// */
//public class Solution {
//
//    public static String intToRoman(int num) {
////        I             1
////        V             5
////        X             10
////        L             50
////        C             100
////        D             500
////        M             1000
//        int[] bit = new int[7];
//        bit[0] = num / 1000;
//        bit[1] = (num - bit[0] * 1000) / 900;
//        bit[2] = ((bit[0] - bit[1]) % 900) / 500;
//        bit[] =(num % 500) / 100;
//        bit[3] = (num % 100) / 50;
//        bit[4] = (num % 50) / 10;
//        bit[5] = (num % 10) / 5;
//        bit[6] = num % 5;
//        String[] c = new String[]{"M", "D", "C", "L", "X", "V", "I"};
//        int[] value = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
//        StringBuilder rome = new StringBuilder();
//        for (int i = 0; i < 7; i++) {
//            if (bit[i] > 3) {
//                rome.append(c[i - 1]).append(c[i - 2]);
//                rome.replace(, )
//                continue;
//            }
//            for (int j = 0; j < bit[i]; j++) {
//                rome.append(c[i]);
//            }
//        }
//        return rome.toString();
//    }
//
//    public static void main(String[] args) {
//        System.out.println(intToRoman(1994));
//    }
//
//}
//
///*
// * Revision history
// * -------------------------------------------------------------------------
// *
// * Date Author Note
// * -------------------------------------------------------------------------
// * 2018/11/26 chentuoyi create
// */
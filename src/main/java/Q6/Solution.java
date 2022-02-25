/*
 * Project: java-strategy
 *
 * File Created at 2018/11/26
 *
 * Copyright 2016 kyo Corporation Limited.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * kyo Company. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license.
 */

package Q6;

/**
 * @Type Solution.java
 * @Desc
 * @Author cyankyo
 * @Date 2018/11/26 19:08
 * @Version 1.0
 */
public class Solution {
    public static String convert(String s, int numRows) {
        char[][] chart = new char[numRows][s.length()];
        if (numRows == 1) return s;
        int x = -1;
        int y = 0;
        //0:朝下 1:斜向上
        int direct = 0;
        for (int i = 0; i < s.length(); i++) {
            switch (direct) {
                case 0:
                    x++;
                    chart[x][y] = s.charAt(i);
                    if (x == numRows - 1) {
                        direct = 1;
                    }
                    break;
                case 1:
                    x--;
                    y++;
                    chart[x][y] = s.charAt(i);
                    if (x == 0) {
                        direct = 0;
                    }
                    break;
            }
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < chart[0].length; j++) {
                if (Character.MIN_VALUE!=chart[i][j]) {
//                    System.out.print(" ");
                } else {
//                    System.out.print(chart[i][j]);
                    result.append(chart[i][j]);
                    System.out.println(i + " " + j);
                }

            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(convert("Apalindromeisaword,phrase,number,orothersequenceofunitsthatcanbereadthesamewayineitherdirection,withgeneralallowancesforadjustmentstopunctuationandworddividers.", 1));
    }
}

/*
 * Revision history
 * -------------------------------------------------------------------------
 *
 * Date Author Note
 * -------------------------------------------------------------------------
 * 2018/11/26 cyankyo create
 */
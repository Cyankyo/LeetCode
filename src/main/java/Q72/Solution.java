/*
 * Project: java-strategy
 *
 * File Created at 2018/11/19
 *
 * Copyright 2016 CMCC Corporation Limited.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * ZYHY Company. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license.
 */

package Q72;

/**
 * @Type Solution.java
 * @Desc
 * @Author chentuoyi
 * @Date 2018/11/19 19:08
 * @Version 1.0
 */
public class Solution {
    public static int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        String[][] route = new String[word1.length() + 1][word2.length() + 1];
        dp[0][0] = 0;
        for (int i = 1; i < word1.length() + 1; i++) {
            dp[i][0] = i;
        }
        for (int j = 1; j < word2.length() + 1; j++) {
            dp[0][j] = j;
        }
        for (int i = 0; i < word1.length(); i++) {
            for (int j = 0; j < word2.length(); j++) {
                if (word1.charAt(i) == word2.charAt(j)) {
                    dp[i + 1][j + 1] = dp[i][j];
                } else {
                    int min;
                    min = min(dp[i][j + 1], dp[i + 1][j], dp[i][j]);
                    dp[i + 1][j + 1] = min + 1;
                }
            }
        }

        return dp[word1.length()][word2.length()];
    }

    private static int min(int i, int i1, int i2) {
        return Math.min(Math.min(i, i1), i2);
    }

    public static void main(String[] args) {
//        System.out.println(minDistance("", "s"));
        System.out.println(minDistance("pneumonoultramicroscopicsilicovolcanoconiosis", "ultramicroscopically"));
    }
}

/*
 * Revision history
 * -------------------------------------------------------------------------
 *
 * Date Author Note
 * -------------------------------------------------------------------------
 * 2018/11/19 chentuoyi create
 */
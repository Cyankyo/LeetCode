/*
 * Project: java-strategy
 *
 * File Created at 2018/11/19
 *
 * Copyright 2016 kyo Corporation Limited.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * kyo Company. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license.
 */

package Q44;

/**
 * @Type Solution.java
 * @Desc
 * @Author cyankyo
 * @Date 2018/11/19 17:13
 * @Version 1.0
 */
public class Solution {


    private boolean isMatch(String s, String p) {
        if (s == null) {
            return false;
        }
        if (p == null) {
            return false;
        }
        char[] sArray = s.toCharArray();
        char[] pArray = p.toCharArray();
        boolean[][] dp = new boolean[sArray.length + 1][pArray.length + 1];
        dp[0][0] = true;
        for (int i = 0; i < sArray.length; i++) {
            dp[i + 1][0] = false;
        }
        for (int j = 0; j < pArray.length; j++) {
            dp[0][j + 1] = dp[0][j] && pArray[j] == '*';
        }
        for (int i = 0; i < sArray.length; i++) {
            for (int j = 0; j < pArray.length; j++) {
                dp[i + 1][j + 1] = dp[i][j + 1] && (pArray[j] == '*') ||
                        dp[i][j] && atomicMatch(sArray[i], pArray[j]) ||
                        dp[i + 1][j] && pArray[j] == '*';
                System.out.println(" i:" + i + " j:" + j + " " + dp[i + 1][j + 1]);
            }
        }
        return dp[sArray.length][pArray.length];
    }

    public static boolean atomicMatch(char s, char p) {
        return p == '?' || p == s || p == '*';
    }

    public static void main(String[] args) {

        System.out.println(new Solution().isMatch("aa", "a"));

    }
}

/*
 * Revision history
 * -------------------------------------------------------------------------
 *
 * Date Author Note
 * -------------------------------------------------------------------------
 * 2018/11/19 cyankyo create
 */
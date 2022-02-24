/*
 * Project: java-strategy
 *
 * File Created at 2018/11/19
 *
 * Copyright 2016 kyo Corporation Limited.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * ZYHY Company. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license.
 */

package Q10;

/**
 * @Type Solution2.java
 * @Desc
 * @Author cyankyo
 * @Date 2018/11/19 10:07
 * @Version 1.0
 */
public class Solution2 {
    private static String[] transform(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '*') {
                count++;
            }
        }
        String[] list = new String[s.length() - count];
        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '*') {
                list[j - 1] += c;
            } else {
                list[j] = "" + c;
                j++;
            }
        }
        return list;
    }



    private static boolean isMatch(String s, String p) {
        String[] sArray = transform(s);
        String[] pArray = transform(p);
        boolean[][] dp = new boolean[sArray.length + 1][pArray.length + 1];
        dp[0][0] = true;
        for (int i = 0; i < sArray.length; i++) {
            dp[i + 1][0] = false;
//            System.out.println(" i:" + (i + 1) + " j:" + 0 + " " + dp[i + 1][0]);
        }
        System.out.println(sArray.length + " " + pArray.length);
        for (int j = 0; j < pArray.length; j++) {
            dp[0][j + 1] = dp[0][j] && pArray[j].contains("*");
//            System.out.println(" i:" + 0 + " j:" + (j + 1) + " " + dp[0][j + 1]);
        }
        for (int i = 0; i < sArray.length; i++) {
            for (int j = 0; j < pArray.length; j++) {
//                System.out.println(" i:" + i + " j:" + j + " ");
                dp[i + 1][j + 1] = dp[i][j + 1] && (atomicMatch(sArray[i], pArray[j]) && pArray[j].contains("*")) ||
                        dp[i][j] && atomicMatch(sArray[i], pArray[j]) ||
                        dp[i + 1][j] && pArray[j].contains("*");
//                System.out.println(" i:" + i + " j:" + j + " " + dp[i + 1][j + 1]);
            }
        }
        return dp[sArray.length][pArray.length];
    }

    public static boolean atomicMatch(String s, String p) {
        return p.contains(".") || p.contains(s);
    }

    public static void main(String[] args) {
//        System.out.println(isMatch("aa", "a*"));
//        System.out.println(isMatch("mississippi", "mis*is*p*."));
//        System.out.println(isMatch("ab", ".*"));
//        System.out.println(isMatch("a", "ab*"));
//        System.out.println(isMatch("a", "aa"));
//        System.out.println(isMatch("", ".*"));
//        System.out.println(isMatch("aaaaaaaaaaaaab", "a*a*a*a*a*a*a*a*a*a*c"));

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
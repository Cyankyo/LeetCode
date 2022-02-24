/*
 * Project: java-strategy
 *
 * File Created at 2018/12/17
 *
 * Copyright 2016 kyo Corporation Limited.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * ZYHY Company. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license.
 */

package Q4;

/**
 * @Type Solution.java
 * @Desc
 * @Author cyankyo
 * @Date 2018/12/17 13:45
 * @Version 1.0
 */
public class Solution {
    public static String longestPalindrome(String s) {
        int max = -1;
        String maxStr = "";
        int length = s.length();
        if (length == 1) {
            return s;
        }
        for (int mid = 0; mid < length; mid++) {
//            System.out.println("mid:"+mid);

            for (int l = 0; l <= Math.min(length - mid - 1, mid) && s.charAt(mid - l) == s.charAt(mid + l); l++) {
//                System.out.println("l:" + l);
//                System.out.println("left:" + (mid - l) + " right:" + (mid + l));
                if (l * 2 + 1 > max) {
                    maxStr = s.substring(mid - l, mid + l + 1);
                    max = l * 2 + 1;
//                    System.out.println("maxStr:" + maxStr);
                }
            }
            for (int l = 1; l <= Math.min(length - mid , mid) && mid - l >= 0 && mid + l - 1 >= 0 && s.charAt(mid - l) == s.charAt(mid + l - 1); l++) {
//                System.out.println("双数 l:" + l);
//                System.out.println("双数 left:" + (mid - l) + " right:" + (mid + l - 1));
                if (l * 2 > max) {
                    maxStr = s.substring(mid - l, mid + l);
                    max = 2 * l;
//                    System.out.println("maxStr:" + maxStr);
                }
            }


        }
        return maxStr;
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("abababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababa"));
    }
}

/*
 * Revision history
 * -------------------------------------------------------------------------
 *
 * Date Author Note
 * -------------------------------------------------------------------------
 * 2018/12/17 cyankyo create
 */
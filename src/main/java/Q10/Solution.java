/*
 * Project: java-strategy
 *
 * File Created at 2018/11/14
 *
 * Copyright 2016 kyo Corporation Limited.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * kyo Company. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license.
 */

package Q10;

import java.util.Arrays;

/**
 * @Type Solution.java
 * @Desc
 * @Author cyankyo
 * @Date 2018/11/14 19:00
 * @Version 1.0
 */
public class Solution {

    public static boolean isMatch(char pre, String s, String p) {

        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == p.charAt(j)) {
                printStat(pre, s, p, i, j);
                pre = p.charAt(j);
                j++;
            } else if (p.charAt(j) == '.') {
                printStat(pre, s, p, i, j);
                pre = p.charAt(j);
                j++;
            } else if (p.charAt(j) == '*') {
                printStat(pre, s, p, i, j);
                return (p.length() != (j + 1) && isMatch(pre, s.substring(i, s.length()), p.substring(j + 1, p.length()))) || (pre == s.charAt(i) && isMatch(pre, s.substring(i + 1, s.length()), p.substring(j + 1, p.length())));
            } else {
                return false;
            }

        }
        if (j == p.length()) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isMatch(String s, String p) {
        String[] sArray = transform(s);
        String[] pArray = transform(p);

        return isMatch(sArray, pArray);
    }

    public static boolean isMatch(String[] s, String[] p) {
//        if (p.length == 0 && s.length != 0) {
//            return false;
//        }
//        if (p.length != 0 && s.length == 0) {
//            return false;
//        }
//        int j = 0;
        int i = 0, j = 0;
        for (; i < s.length && j < p.length; i++) {
            if (s[i].equals(p[j])) {
                printStat(s, p, i, j);
                j++;
            } else if (".".equals(p[j])) {
                printStat(s, p, i, j);
                j++;
            } else if (p[j].contains("*")) {
                printStat(s, p, i, j);
                return (isMatch(Arrays.copyOfRange(s, i, s.length), Arrays.copyOfRange(p, j + 1, p.length)))
                        || ((p[j].contains(s[i]) || p[j].contains(".")) && isMatch(Arrays.copyOfRange(s, i + 1, s.length), Arrays.copyOfRange(p, j + 1, p.length))) ||
                        ((p[j].contains(s[i]) || p[j].contains(".")) && isMatch(Arrays.copyOfRange(s, i + 1, s.length), Arrays.copyOfRange(p, j, p.length)));


            } else {
                return false;
            }
        }
//        System.out.println(i + " " + j +" "+s.length);
        if (j == p.length && i == s.length) {
            return true;
        } else if (i == s.length) {
            for (int k = j; k < p.length; k++) {
                if (!p[k].contains("*")) {
                    return false;
                }
            }
            return true;
        } else {
            return false;
        }
    }

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

    private static void printStat(char pre, String s, String p, int i, int j) {
        System.out.println("pre: " + pre + " s:" + s + " p:" + p + " i:" + i + " j:" + j);

    }

    private static void printStat(String[] s, String[] p, int i, int j) {
        System.out.println("s:" + Arrays.toString(s) + " p:" + Arrays.toString(p) + " i:" + i + " j:" + j);

    }

    public static void main(String[] args) {
        System.out.println(isMatch("aa", "a*"));
        System.out.println(isMatch("mississippi", "mis*is*p*."));
        System.out.println(isMatch("ab", ".*"));
        System.out.println(isMatch("a", "ab*"));
        System.out.println(isMatch("a", "aa"));
        System.out.println(isMatch("", ".*"));
        System.out.println(isMatch("aaaaaaaaaaaaab", "a*a*a*a*a*a*a*a*a*a*c"));

    }

}

/*
 * Revision history
 * -------------------------------------------------------------------------
 *
 * Date Author Note
 * -------------------------------------------------------------------------
 * 2018/11/14 cyankyo create
 */
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

package Q62;

/**
 * @Type Solution.java
 * @Desc
 * @Author chentuoyi
 * @Date 2018/11/19 18:23
 * @Version 1.0
 */
public class Solution {
    public static int uniquePaths(int m, int n) {
        int[][] route = new int[m][n];

        for (int i = 0; i < m; i++) {
            route[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            route[0][i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                route[i][j] = route[i - 1][j] + route[i][j - 1];
            }

        }
        return route[m-1][n-1];
    }

    public static void main(String[] args) {
         System.out.println(uniquePaths(7,3));
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
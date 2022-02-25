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

package Q63;

/**
 * @Type Solution.java
 * @Desc
 * @Author cyankyo
 * @Date 2018/11/19 18:29
 * @Version 1.0
 */
public class Solution {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid[0].length;
        int m = obstacleGrid.length;
        int[][] route = new int[m][n];
        route[0][0] = obstacleGrid[0][0] == 0 ? 1 : 0;
        for (int i = 1; i < m; i++) {
            if (obstacleGrid[i][0] == 0 && route[i - 1][0] == 1) {
                route[i][0] = 1;
            }
        }
        for (int i = 1; i < n; i++) {
            if (obstacleGrid[0][i] == 0 && route[0][i - 1] == 1) {
                route[0][i] = 1;
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j]==1){
                    continue;
                }
                if (obstacleGrid[i][j - 1] == 0) {
                    route[i][j] += route[i][j - 1];
                }
                if (obstacleGrid[i - 1][j] == 0) {
                    route[i][j] += route[i - 1][j];
                }
            }

        }
        return route[m - 1][n - 1];
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
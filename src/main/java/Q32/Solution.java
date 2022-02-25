/*
 * Project: LeetCode
 *
 * File Created at 2022/2/24
 *
 * Copyright 2016 kyo Corporation Limited.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * kyo Company. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license.
 */

package Q32;

import java.util.Stack;

/***
 * @Type
 * @Desc
 * @Author cyankyo
 * @Date 2022/2/24 16:33
 * @Version 1.0
 */
public class Solution {
    public int longestValidParentheses(String s) {
        int max = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int length = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);//最近一个完整括号对之后 右括号位置
                } else {
                    max = Math.max(max, i - stack.peek());
                }
            }

        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().longestValidParentheses(")()())"));
    }

}

/*
 * Revision history
 * -------------------------------------------------------------------------
 *
 * Date Author Note
 * -------------------------------------------------------------------------
 * 2022/2/24 cyankyo create
 */
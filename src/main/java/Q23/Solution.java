/*
 * Project: java-strategy
 *
 * File Created at 2019/2/1
 *
 * Copyright 2016 kyo Corporation Limited.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * kyo Company. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license.
 */

package Q23;

/**
 * @Type Solution.java
 * @Desc
 * @Author cyankyo
 * @Date 2019/2/1 19:19
 * @Version 1.0
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

public class Solution {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        int num = lists.length;
        if (num == 0) {
            return null;
        }
        for (int i = 0; i < num - 1; i++) {
            ListNode a = lists[i];
            ListNode b = lists[i + 1];
            ListNode c = null;
            ListNode first = null;
            while (a != null && b != null) {
                ListNode temp;
                if (a.val < b.val) {
                    temp = new ListNode(a.val);
                    a = a.next;
                } else {
                    temp = new ListNode(b.val);
                    b = b.next;
                }
                if (c != null) {
                    c.next = temp;
                    c = c.next;
                } else {
                    c = temp;
                    first = c;
                }
            }
            if (c != null) {
                if (a != null) {
                    c.next = a;
                } else if (b != null) {
                    c.next = b;
                }
            } else if (a != null) {
                first = a;
            } else if (b != null) {
                first = b;
            }
            lists[i + 1] = first;
        }
        return lists[num - 1];
    }

    public static void main(String[] args) {

    }
}

/*
 * Revision history
 * -------------------------------------------------------------------------
 *
 * Date Author Note
 * -------------------------------------------------------------------------
 * 2019/2/1 cyankyo create
 */
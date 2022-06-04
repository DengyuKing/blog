/*
 * @lc app=leetcode.cn id=23 lang=java
 *
 * [23] 合并K个升序链表
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null) {
            return null;
        }

        ListNode result = new ListNode();
        ListNode q = result;

       
        ListNode [] p = new ListNode[lists.length];

        for(int i = 0;i<lists.length;i++) {
            p[i] = lists[i];
        }


        while (!isAllNull(p)){
             int smallIndex = 0;
             int smallValue = Integer.MAX_VALUE;
            for (int i = 0;i<lists.length;i++) {
            if (p[i] == null) {
                continue;
            }

            if (p[i].val < smallValue) {
                smallIndex = i;
                smallValue = p[i].val;
            }
         }

            ListNode tmp = new ListNode(smallValue);
            q.next = tmp;
            q = q.next;
            p[smallIndex] = p[smallIndex].next;

        }

        return result.next;
    }

    private boolean isAllNull(ListNode [] p ) {
        boolean result =true;
        for (int i = 0;i<p.length;i++) {
            if (p[i] != null) {
                return false;
            }
        }

        return true;
    }
}
// @lc code=end


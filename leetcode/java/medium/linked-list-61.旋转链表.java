/*
 * @lc app=leetcode.cn id=61 lang=java
 *
 * [61] 旋转链表
 *
 * https://leetcode-cn.com/problems/rotate-list/description/
 *
 * algorithms
 * Medium (41.79%)
 * Likes:    630
 * Dislikes: 0
 * Total Accepted:    195.5K
 * Total Submissions: 468K
 * Testcase Example:  '[1,2,3,4,5]\n2'
 *
 * 给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：head = [1,2,3,4,5], k = 2
 * 输出：[4,5,1,2,3]
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：head = [0,1,2], k = 4
 * 输出：[2,0,1]
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 链表中节点的数目在范围 [0, 500] 内
 * -100 
 * 0 
 * 
 * 
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
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k<=0) {
            return head;
        }

        int length = 0;
        ListNode p = head;
        while(p != null) {
            p = p.next;
            length ++;
        }

        k = k % length;
        if (k == 0) {
            return head;
        }

        ListNode list1 = head;
        p = head;
        
        for (int i = 1; (length-i)<k;i++) {
            p = p.next;
            i++;
        }

        ListNode tail1 = p,list2 = p.next,tail2 = null;
        
        reaverse(list1, tail1);
        reaverse(list2,tail2);
        tail1.next = list2;
        tail2.next = null;
        reaverse(list1, tail2);
        tail2.next = null;
        return list1;
    }
    /**
     * 翻转链表
     * @param head
     * @param tail
     * @return
     */
    private void reaverse(ListNode head,ListNode tail) {
        if (head.next == tail) {
            return head;
        }

        ListNode p=head,q=p.next,r = null;
        
        while (q != null) {
            r = q.next;
            q.next = p;
            p = q;
            q = r;
        }

        tail = head;
        head = p;
    }

    
}
// @lc code=end


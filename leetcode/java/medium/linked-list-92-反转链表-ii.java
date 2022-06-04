/*
 * @lc app=leetcode.cn id=92 lang=java
 *
 * [92] 反转链表 II
 *
 * https://leetcode-cn.com/problems/reverse-linked-list-ii/description/
 *
 * algorithms
 * Medium (55.34%)
 * Likes:    1286
 * Dislikes: 0
 * Total Accepted:    296.5K
 * Total Submissions: 535.9K
 * Testcase Example:  '[1,2,3,4,5]\n2\n4'
 *
 * 给你单链表的头指针 head 和两个整数 left 和 right ，其中 left  。请你反转从位置 left 到位置 right 的链表节点，返回
 * 反转后的链表 。
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：head = [1,2,3,4,5], left = 2, right = 4
 * 输出：[1,4,3,2,5]
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：head = [5], left = 1, right = 1
 * 输出：[5]
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 链表中节点数目为 n
 * 1 
 * -500 
 * 1 
 * 
 * 
 * 
 * 
 * 进阶： 你可以使用一趟扫描完成反转吗？
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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == right) {
            return head;
        }

        ListNode result = new ListNode();
        result.next = head;
        ListNode p = result,q = head;

        int leftCount = 1,rightCount = 1;
        while (q != null) {
            if (leftCount < left) {
                p = p.next;
                leftCount ++;
            }

            if (rightCount<right) {
                q = q.next;
                rightCount++;
            }

            if (right == rightCount) {
                break;
            }
        }

        ListNode tmp = p.next;

        ListNode lhead =  reverseList(tmp, q);
        p.next = lhead;

        return result.next;

        
    }

    ListNode reverseList(ListNode head,ListNode tail) {
        if (head.next == tail) {
            ListNode tmp = new ListNode();

            tmp = tail.next;
            tail.next = head;
            head.next = tmp;
            return tail;
        }

        ListNode p =head ,q = head.next,end =tail.next;

        while (q != end){
            ListNode r = q.next;
            q.next = p;
            p = q;
            q = r;
        }

        head.next = q;
        return tail;

    }
}
// @lc code=end


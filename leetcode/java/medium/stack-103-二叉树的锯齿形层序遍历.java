import java.util.ArrayList;
import java.util.Deque;
import java.util.Queue;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=103 lang=java
 *
 * [103] 二叉树的锯齿形层序遍历
 *
 * https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal/description/
 *
 * algorithms
 * Medium (57.30%)
 * Likes:    641
 * Dislikes: 0
 * Total Accepted:    238.8K
 * Total Submissions: 416.9K
 * Testcase Example:  '[3,9,20,null,null,15,7]'
 *
 * 给你二叉树的根节点 root ，返回其节点值的 锯齿形层序遍历 。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：[[3],[20,9],[15,7]]
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：root = [1]
 * 输出：[[1]]
 * 
 * 
 * 示例 3：
 * 
 * 
 * 输入：root = []
 * 输出：[]
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 树中节点数目在范围 [0, 2000] 内
 * -100 <= Node.val <= 100
 * 
 * 
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        if (root == null) {
            return new ArrayList();
        }

        List<List<Integer>> result = new ArrayList();
        List<Integer> list = new ArrayList<>();

        Deque<TreeNode> queue =  new LinkedList<>() ;
        int levelCount = 1;
        int nextLevelCount =0;
        boolean isZig = true;
        queue.add(root);

        while (!queue.isEmpty()) {
            
            while (levelCount >0){
                if (isZig) {
                    TreeNode current = queue.pollFirst();
                    if (current.left != null) {
                        queue.addLast(current.left);
                        nextLevelCount ++;
                    }

                    if(current.right != null) {
                        queue.addLast(current.right);
                        nextLevelCount++;
                    }

                    list.add(current.val);
                }else {
                    TreeNode current = queue.pollLast();
                    if(current.right != null) {
                        queue.addFirst(current.right);
                        nextLevelCount++;
                    }

                    if (current.left != null) {
                        queue.addFirst(current.left);
                        nextLevelCount ++;
                    }

                    list.add(current.val);

                }
               
                levelCount --;
                
            }
            
            isZig = !isZig;
            levelCount = nextLevelCount;
            nextLevelCount = 0;
            result.add(list);
            list = new ArrayList();
            
        }

        return result;

    }
}
// @lc code=end


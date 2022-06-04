import java.util.LinkedList;
import java.util.List;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=95 lang=java
 *
 * [95] 不同的二叉搜索树 II
 *
 * https://leetcode-cn.com/problems/unique-binary-search-trees-ii/description/
 *
 * algorithms
 * Medium (71.89%)
 * Likes:    1217
 * Dislikes: 0
 * Total Accepted:    132.2K
 * Total Submissions: 183.4K
 * Testcase Example:  '3'
 *
 * 给你一个整数 n ，请你生成并返回所有由 n 个节点组成且节点值从 1 到 n 互不相同的不同 二叉搜索树 。可以按 任意顺序 返回答案。
 * 
 * 
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：n = 3
 * 输出：[[1,null,2,null,3],[1,null,3,2],[2,1,3],[3,1,null,null,2],[3,2,null,1]]
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：n = 1
 * 输出：[[1]]
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 
 * 
 * 
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

 /**
  * 树的问题，一般是采用递归，本题目需要考虑如何构造树，想明白这个问题，题目就会有思路了
    对于一个排序的数组来说，小于当前节点的数都是左子树，大于当前节点的数都是右子树
  */
class Solution {
    public List<TreeNode> generateTrees(int n) {
        if(n == 0) {
            return new LinkedList<TreeNode>();
        }

        return generateTrees(1,n);
    }

    List<TreeNode> generateTrees(int start,int end) {
        List<TreeNode> allTrees = new LinkedList<TreeNode>();
        if (start > end) {
            allTrees.add(null);
            return allTrees;
        }

        for (int i = start;i<=end;i++) {
            // 这里为什么是start 而不是从0 开始呢？start表示了需要生成树的当前范围
            List<TreeNode> leftTrees = generateTrees(start,i-1);
            List<TreeNode> rightTrees = generateTrees(i+1,end);

            for (TreeNode leftTree:leftTrees) {
                for (TreeNode rightTree:rightTrees) {
                    TreeNode current = new TreeNode(i,leftTree,rightTree);
                    allTrees.add(current);
                }
            }
        }

        return allTrees;
    }
}
// @lc code=end


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=113 lang=java
 *
 * [113] 路径总和 II
 *
 * https://leetcode-cn.com/problems/path-sum-ii/description/
 *
 * algorithms
 * Medium (63.13%)
 * Likes:    756
 * Dislikes: 0
 * Total Accepted:    257.6K
 * Total Submissions: 407.9K
 * Testcase Example:  '[5,4,8,11,null,13,4,7,2,null,null,5,1]\n22'
 *
 * 给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。
 * 
 * 叶子节点 是指没有子节点的节点。
 * 
 * 
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
 * 输出：[[5,4,11,2],[5,8,4,5]]
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：root = [1,2,3], targetSum = 5
 * 输出：[]
 * 
 * 
 * 示例 3：
 * 
 * 
 * 输入：root = [1,2], targetSum = 0
 * 输出：[]
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 树中节点总数在范围 [0, 5000] 内
 * -1000 
 * -1000 
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
class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
            if (root == null) {
                return new ArrayList<>();
            }

            LinkedList<Integer> path = new LinkedList<>();
            List<List<Integer>> paths = new ArrayList<>();
            getPath(root, targetSum, path, paths);

            return paths;
    }

    private void getPath(TreeNode root, int targetSum,LinkedList<Integer> path, List<List<Integer>> paths) {
        if (root == null) {
            return ;
        }

        if(root.left == null && root.right == null) {
            if (targetSum == root.val) {
               path.add(root.val);
               List<Integer> list = new LinkedList<>(path);
               paths.add(list);
               path.removeLast();
               return ;
            }
        }
        
        path.add(root.val);
        getPath(root.left, targetSum-root.val, path, paths);
        getPath(root.right, targetSum-root.val, path, paths);
        path.removeLast();
    }
}
// @lc code=end


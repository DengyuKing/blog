import java.util.List;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=99 lang=java
 *
 * [99] 恢复二叉搜索树
 *
 * https://leetcode-cn.com/problems/recover-binary-search-tree/description/
 *
 * algorithms
 * Medium (60.44%)
 * Likes:    722
 * Dislikes: 0
 * Total Accepted:    102.7K
 * Total Submissions: 169.9K
 * Testcase Example:  '[1,3,null,null,2]'
 *
 * 给你二叉搜索树的根节点 root ，该树中的 恰好 两个节点的值被错误地交换。请在不改变其结构的情况下，恢复这棵树 。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：root = [1,3,null,null,2]
 * 输出：[3,1,null,null,2]
 * 解释：3 不能是 1 的左孩子，因为 3 > 1 。交换 1 和 3 使二叉搜索树有效。
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：root = [3,1,4,null,null,2]
 * 输出：[2,1,4,null,null,3]
 * 解释：2 不能在 3 的右子树中，因为 2 < 3 。交换 2 和 3 使二叉搜索树有效。
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 树上节点的数目在范围 [2, 1000] 内
 * -2^31 <= Node.val <= 2^31 - 1
 * 
 * 
 * 
 * 
 * 进阶：使用 O(n) 空间复杂度的解法很容易实现。你能想出一个只使用 O(1) 空间的解决方案吗？
 * 
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
// 对于交换后的两个元素，在原来的队列中，肯定有一个数是极大值，一个数是极小值，遍历一次，记录两个极值，进行数值交换
// 采用公共变量记录pre的值
class Solution {

    TreeNode pre = null;
    public void recoverTree(TreeNode root) {
        if (root == null) {
            return ;
        }
    
        List<TreeNode> list = new ArrayList();

        middleRoot(root, list);
        if(list.size() == 2) {
            TreeNode one = list.get(0);
            TreeNode two = list.get(1);
            int tmp = one.val;
            one.val = two.val;
            two.val = tmp;
        }else {
            if (list.get(0).val > list.get(2).val) {
                int tmp = list.get(0).val;
                list.get(0).val = list.get(3).val;
                list.get(3).val = tmp;
            }else {
                int tmp =  list.get(1).val;
                list.get(1).val = list.get(2).val;
                list.get(2).val = tmp;
            }
        }

    }

    void  middleRoot(TreeNode root,List<TreeNode> list) {
        if (root == null) {
            return ;
        }

        middleRoot(root.left,list);
        if (pre != null && pre.val>root.val) {
            list.add(pre);
            list.add(root);
        }

        pre = root;

        middleRoot(root.right,list);
        
    }

}
// @lc code=end

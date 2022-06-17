import javax.swing.TransferHandler;

/*
 * @lc app=leetcode.cn id=105 lang=java
 *
 * [105] 从前序与中序遍历序列构造二叉树
 *
 * https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/
 *
 * algorithms
 * Medium (71.03%)
 * Likes:    1615
 * Dislikes: 0
 * Total Accepted:    364K
 * Total Submissions: 512.2K
 * Testcase Example:  '[3,9,20,15,7]\n[9,3,15,20,7]'
 *
 * 给定两个整数数组 preorder 和 inorder ，其中 preorder 是二叉树的先序遍历， inorder
 * 是同一棵树的中序遍历，请构造二叉树并返回其根节点。
 * 
 * 
 * 
 * 示例 1:
 * 
 * 
 * 输入: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
 * 输出: [3,9,20,null,null,15,7]
 * 
 * 
 * 示例 2:
 * 
 * 
 * 输入: preorder = [-1], inorder = [-1]
 * 输出: [-1]
 * 
 * 
 * 
 * 
 * 提示:
 * 
 * 
 * 1 <= preorder.length <= 3000
 * inorder.length == preorder.length
 * -3000 <= preorder[i], inorder[i] <= 3000
 * preorder 和 inorder 均 无重复 元素
 * inorder 均出现在 preorder
 * preorder 保证 为二叉树的前序遍历序列
 * inorder 保证 为二叉树的中序遍历序列
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
  * 前序序列中可以知道根是那个，中序序列中可以知道是否有左右子树，构建时，先构建左子树，然后构建右子树
  */
class Solution {
    static Integer preIndex = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {


      TreeNode root =  build(preorder, inorder, 0, inorder.length-1);
      preIndex = 0;
      return root;
      
    }

    private TreeNode build(int [] preorder,int[] inorder ,int inStart,int inEnd) {
      // 先找到根节点
      // 确定左右子树
      // 构造左右子树

      if (preIndex>= preorder.length || inEnd < inStart) {
        return null;
      }

      int i = inStart;
      while (i<= inEnd) {
        if (inorder[i] == preorder[preIndex]) {
          break;
        }

        i++;
      }

      TreeNode root = new TreeNode(preorder[preIndex]);

      // 左子树不为NULl
      if (i > inStart) {
        preIndex++;
        root.left = build(preorder, inorder, inStart, i-1);
      }

      // 右子树不为NUll 
      if (i < inEnd) {
        preIndex++;
        root.right = build(preorder, inorder, i+1, inEnd);
      }

      return root;
    }
}
// @lc code=end


/*
 * @lc app=leetcode.cn id=18 lang=java
 *
 * [18] 四数之和
 *
 * https://leetcode-cn.com/problems/4sum/description/
 *
 * algorithms
 * Medium (39.43%)
 * Likes:    689
 * Dislikes: 0
 * Total Accepted:    140.4K
 * Total Submissions: 355.9K
 * Testcase Example:  '[1,0,-1,0,-2,2]\n0'
 *
 * 给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c
 * + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
 * 
 * 注意：
 * 
 * 答案中不可以包含重复的四元组。
 * 
 * 示例：
 * 
 * 给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
 * 
 * 满足要求的四元组集合为：
 * [
 * ⁠ [-1,  0, 0, 1],
 * ⁠ [-2, -1, 1, 2],
 * ⁠ [-2,  0, 0, 2]
 * ]
 * 
 * 
 */

 /**
  * 两数之和，排序后可以用双指针，因为排序后 利用双指针可以缩小问题的规模
 *           可以用Map存储，这样可以遍历一次就可以完成搜索
 *  三数之和  三数之和如果不采用排序的方法，则可先确定一个数，再去确定另外一个数，找第三个数，这样的时间复杂度为O(N*N*N)
 * 如果采用 排序后的方法，则可以使用缩小问题规模的方法对原问题进行削减。
 * 
 * 四数之和 四数之和采用的方法与三数之和类似，先进行排序，固定其中一个数后，采用三数之和的办法进行求解
  */

// @lc code=start
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {

    }
}
// @lc code=end


import java.util.HashSet;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=128 lang=java
 *
 * [128] 最长连续序列
 *
 * https://leetcode-cn.com/problems/longest-consecutive-sequence/description/
 *
 * algorithms
 * Medium (54.85%)
 * Likes:    1268
 * Dislikes: 0
 * Total Accepted:    269.6K
 * Total Submissions: 490.8K
 * Testcase Example:  '[100,4,200,1,3,2]'
 *
 * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 * 
 * 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：nums = [100,4,200,1,3,2]
 * 输出：4
 * 解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
 * 
 * 示例 2：
 * 
 * 
 * 输入：nums = [0,3,7,2,5,8,4,6,0,1]
 * 输出：9
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 0 
 * -10^9 
 * 
 * 
 */



// @lc code=start

/**
 * 题目有意思，多种方法解题，了解并查集的用法,题目用了优化方法
 */
class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int longMark = 0;

        Set<Integer> set = new HashSet<>();
        for (int i :nums) {set.add(i);}

        for (int i:set) {
            if (!set.contains(i-1)) {
                int currentNum = i;
                int markCount = 1;
                while(set.contains(currentNum+1)) {
                    currentNum++;
                    markCount ++;
                }

                longMark = Math.max(longMark, markCount);
            }

           
        }

        return longMark;


    }
}
// @lc code=end


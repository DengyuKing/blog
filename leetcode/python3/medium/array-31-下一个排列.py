#
# @lc app=leetcode.cn id=31 lang=python3
#
# [31] 下一个排列
#
# https://leetcode-cn.com/problems/next-permutation/description/
#
# algorithms
# Medium (36.26%)
# Likes:    863
# Dislikes: 0
# Total Accepted:    123.9K
# Total Submissions: 341.6K
# Testcase Example:  '[1,2,3]'
#
# 实现获取 下一个排列 的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
# 
# 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
# 
# 必须 原地 修改，只允许使用额外常数空间。
# 
# 
# 
# 示例 1：
# 
# 
# 输入：nums = [1,2,3]
# 输出：[1,3,2]
# 
# 
# 示例 2：
# 
# 
# 输入：nums = [3,2,1]
# 输出：[1,2,3]
# 
# 
# 示例 3：
# 
# 
# 输入：nums = [1,1,5]
# 输出：[1,5,1]
# 
# 
# 示例 4：
# 
# 
# 输入：nums = [1]
# 输出：[1]
# 
# 
# 
# 
# 提示：
# 
# 
# 1 
# 0 
# 
# 如果序列是降序的，则直接返回升序的序列
# 检查序列最后一个升序的子序列，然后对调最后两个元素返回
# 可以从数组最后面开始检查对调
# 
# @lc code=start
class Solution:
    def nextPermutation(self, nums: List[int]) -> None:
                                                                                                                                                                  
        """
        Do not return anything, modify nums in-place instead.
        """                                 
# @lc code=end


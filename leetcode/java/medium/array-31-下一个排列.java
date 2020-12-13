/*
 * @lc app=leetcode.cn id=31 lang=java
 *
 * [31] 下一个排列
 *
 * https://leetcode-cn.com/problems/next-permutation/description/
 *
 * algorithms
 * Medium (36.26%)
 * Likes:    863
 * Dislikes: 0
 * Total Accepted:    123.9K
 * Total Submissions: 341.6K
 * Testcase Example:  '[1,2,3]'
 *
 * 实现获取 下一个排列 的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
 * 
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 * 
 * 必须 原地 修改，只允许使用额外常数空间。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：nums = [1,2,3]
 * 输出：[1,3,2]
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：nums = [3,2,1]
 * 输出：[1,2,3]
 * 
 * 
 * 示例 3：
 * 
 * 
 * 输入：nums = [1,1,5]
 * 输出：[1,5,1]
 * 
 * 
 * 示例 4：
 * 
 * 
 * 输入：nums = [1]
 * 输出：[1]
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 
 * 0 
 * 
 * 
 */

/**
 * 判断最后一个升序的子序列，对调子序列的最后两个字母 ,这种方式不可以，比如 1,3,2 如果
 * 按照以上算法，则得出3,1,2的错误结论，正确应该是2,1,3 ，下一个最小的序列，应该极力保证改动变大，但是变大的幅度尽可能小。
 * 
 * 这个题分析了，但是没有分析到位，找到合适的节点后，交换反转，本来降序的排列，交换后就最小了
 * 
 *  2,3,1 下一个排列应该是 3,1,2;第二次更改后给出结果为3,2,1
 * 
 * 
 * 
 * 数组反转的研究 ，反转能够实现数组的位置交换
 * 
 * 
 */

// @lc code=start
class Solution {
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length == 0 || nums.length == 1){
            return ;
        }
        // 查找上升序列
        for (int i=nums.length-1;i>0;i--){
            if (nums[i]>nums[i-1]){
                // 找第一个大于nums[i-1]的元素，如果找到，则插入到i-1位置，其他的元素依次后移
                int one = findOne(nums, i, nums.length, nums[i - 1]);
                // 先交换，然后反转子序列
                swap(nums, one, i - 1);
                revease(nums, i, nums.length - 1);
                return;
            }
        }
        // 没找到，直接升序排列
        Arrays.sort(nums);


    }
    
    // 最接近的怎么判断？
    private int findOne (int [] nums ,int l,int r,int comPare){
        int max =0x7fffffff;
        int result = l;
        for (int i = l;i<r;i++){
             int re =  nums[i] - comPare;
             // 这里不能相等
             if (re>0){
                max = Math.min(re,max);
                result = i;
             }else {
                 break;
             }
        }
        return result;
    }

    private void swap(int [] nums,int l,int r){
        int tmp = nums[l];
        nums[l] = nums[r];
        nums[r] = tmp;
    }
    private void revease(int [] nums,int l,int r){

        while (l<r){
            swap(nums,l,r);
            l++;
            r--;
        }

    }
}
// @lc code=end


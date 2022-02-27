/*
 * @lc app=leetcode.cn id=80 lang=java
 *
 * [80] 删除有序数组中的重复项 II
 *
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array-ii/description/
 *
 * algorithms
 * Medium (61.69%)
 * Likes:    611
 * Dislikes: 0
 * Total Accepted:    157.6K
 * Total Submissions: 255.1K
 * Testcase Example:  '[1,1,1,2,2,3]'
 *
 * 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使每个元素 最多出现两次 ，返回删除后数组的新长度。
 * 
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 * 
 * 
 * 
 * 说明：
 * 
 * 为什么返回数值是整数，但输出的答案是数组呢？
 * 
 * 请注意，输入数组是以「引用」方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。
 * 
 * 你可以想象内部操作如下:
 * 
 * 
 * // nums 是以“引用”方式传递的。也就是说，不对实参做任何拷贝
 * int len = removeDuplicates(nums);
 * 
 * // 在函数里修改输入数组对于调用者是可见的。
 * // 根据你的函数返回的长度, 它会打印出数组中 该长度范围内 的所有元素。
 * for (int i = 0; i < len; i++) {
 * print(nums[i]);
 * }
 * 
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：nums = [1,1,1,2,2,3]
 * 输出：5, nums = [1,1,2,2,3]
 * 解释：函数应返回新长度 length = 5, 并且原数组的前五个元素被修改为 1, 1, 2, 2, 3 。
 * 不需要考虑数组中超出新长度后面的元素。
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：nums = [0,0,1,1,1,1,2,3,3]
 * 输出：7, nums = [0,0,1,1,2,3,3]
 * 解释：函数应返回新长度 length = 7, 并且原数组的前五个元素被修改为 0, 0, 1, 1, 2, 3, 3 。
 * 不需要考虑数组中超出新长度后面的元素。
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 
 * -10^4 
 * nums 已按升序排列
 * 
 * 双指针，其中一个指针指向当前遍历到的元素(位置靠后)，另一个指针指向当前合法的数组(位置靠前)
 * 
 * 维护一个技术器初始为1，当两个指针的内容相同，计数器加1，当计数器>=2时，快指针右移，直到两个指针内容不一样。
 * 
 */

// @lc code=start
class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length <=2) {
            return nums.length;
        }

        int left =0,right = 1,sum = 1;
        while(right < nums.length) {
            // 两指针相等
            if (nums[left] == nums[right]) {
                if (++sum <= 2) {
                    nums[++left] = nums[right++];
                }else {
                    right ++;
                }

            } else {
                nums[++left] = nums[right++];
                sum = 1;
            }
        }

        return left + 1;
    }
}
// @lc code=end


import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=46 lang=java
 *
 * [46] 全排列
 *
 * https://leetcode-cn.com/problems/permutations/description/
 *
 * algorithms
 * Medium (77.24%)
 * Likes:    1041
 * Dislikes: 0
 * Total Accepted:    230.6K
 * Total Submissions: 298.2K
 * Testcase Example:  '[1,2,3]'
 *
 * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 * 
 * 示例:
 * 
 * 输入: [1,2,3]
 * 输出:
 * [
 * ⁠ [1,2,3],
 * ⁠ [1,3,2],
 * ⁠ [2,1,3],
 * ⁠ [2,3,1],
 * ⁠ [3,1,2],
 * ⁠ [3,2,1]
 * ]
 * 
 * 全排列， 元素置换,转换完以后要记得复位
 * 
 */

// @lc code=start
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList();
        findOne(nums, list, 0);
        return list;
    }

    private void findOne(int[] nums, List<List<Integer>> list, int index) {
        if (index == nums.length) {// 已经搜集了所有的节点，这种方式多一次函数调用
            List<Integer> re = new ArrayList();
            for (int i = 0; i < nums.length; i++) {// int [] 转 List 没有很好的办法，采取迭代转化
                re.add(nums[i]);
            }
            list.add(re);
            return;
        }
        for (int i = index; i < nums.length; i++) {

            swap(nums, index, i);
            // path.addLast(nums[i]);// 这里维护的path在特定层加入元素后，不能够再本层再换成其他的元素
            findOne(nums, list, index + 1);
            // path.removeLast();
            swap(nums, index, i);

        }

    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
// @lc code=end

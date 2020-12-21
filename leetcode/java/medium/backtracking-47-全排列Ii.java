import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=47 lang=java
 *
 * [47] 全排列 II
 *
 * https://leetcode-cn.com/problems/permutations-ii/description/
 *
 * algorithms
 * Medium (62.31%)
 * Likes:    545
 * Dislikes: 0
 * Total Accepted:    126.2K
 * Total Submissions: 202.5K
 * Testcase Example:  '[1,1,2]'
 *
 * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：nums = [1,1,2]
 * 输出：
 * [[1,1,2],
 * ⁠[1,2,1],
 * ⁠[2,1,1]]
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 
 * -10 
 * 
 *  在全排列的基础上增加去重功能，首先需要对数组进行排序
 *  此题的关键在于去重，总体思路有两个，基于交换的排序和基于记录使用的元素方法
 */

// @lc code=start
class Solution {

    Set<String> set = new HashSet();


    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> list = new ArrayList();
        Arrays.sort(nums);
        findOne(nums, list, 0);
        return list;
    }

    private void findOne(int[] nums, List<List<Integer>> list, int index) {
        if (index == nums.length) {// 已经搜集了所有的节点，这种方式多一次函数调用
            List<Integer> re = new ArrayList();
            StringBuffer sb = new StringBuffer();

            for (int i = 0; i < nums.length; i++) {// int [] 转 List 没有很好的办法，采取迭代转化
                re.add(nums[i]);
                sb.append(nums[i]);
            }
            if (!set.contains(sb.toString())) {
                list.add(re);
                set.add(sb.toString());
            }
            return;
        }
        for (int i = index; i < nums.length; i++) {

            if (i != index && nums[i] == nums[index]){//还是分层思想，分层的时候 index的值是层的初始值
                continue;
            }
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


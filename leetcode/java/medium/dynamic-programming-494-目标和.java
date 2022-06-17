import java.util.Map;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=494 lang=java
 *
 * [494] 目标和
 *
 * https://leetcode.cn/problems/target-sum/description/
 *
 * algorithms
 * Medium (49.08%)
 * Likes:    1258
 * Dislikes: 0
 * Total Accepted:    237.6K
 * Total Submissions: 484K
 * Testcase Example:  '[1,1,1,1,1]\n3'
 *
 * 给你一个整数数组 nums 和一个整数 target 。
 * 
 * 向数组中的每个整数前添加 '+' 或 '-' ，然后串联起所有整数，可以构造一个 表达式 ：
 * 
 * 
 * 例如，nums = [2, 1] ，可以在 2 之前添加 '+' ，在 1 之前添加 '-' ，然后串联起来得到表达式 "+2-1" 。
 * 
 * 
 * 返回可以通过上述方法构造的、运算结果等于 target 的不同 表达式 的数目。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：nums = [1,1,1,1,1], target = 3
 * 输出：5
 * 解释：一共有 5 种方法让最终目标和为 3 。
 * -1 + 1 + 1 + 1 + 1 = 3
 * +1 - 1 + 1 + 1 + 1 = 3
 * +1 + 1 - 1 + 1 + 1 = 3
 * +1 + 1 + 1 - 1 + 1 = 3
 * +1 + 1 + 1 + 1 - 1 = 3
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：nums = [1], target = 1
 * 输出：1
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 
 * 0 
 * 0 
 * -1000 
 * 
 * 
 */

// @lc code=start
class Solution {
    // 这个题经典的由暴力到动态规划的例子，需要掌握,明确的定义很重要
    public int findTargetSumWays(int[] nums, int target) {
         return dfs(nums,target,0,0);
    }

    Map<String,Integer> map = new HashMap();

    /**
     * 返回方法数
     * @param nums
     * @param target
     * @param i
     * @param sum
     * @return
     */
    int dfs(int [] nums,int target,int i ,int sum) {
       
        // 只缓存本层的结果，如果获下层的结果，显得冗余
        String key = String.format("%s_%s", i, sum);
        if (map.containsKey(key)) {
            return map.get(key);
        }

        // 最后一层，要么相等，要么不等
        if (i == nums.length) {
            return sum == target ? 1:0;
        }
        
        // 每次到本层时，如果有符合要求的下层结果，则直接取用，不用再去寻找,需要记录层数和
        int left = dfs(nums,target,i+1,sum - nums[i]);
        int right = dfs(nums,target,i+1,sum + nums[i]);

        if (!map.containsKey(key)) {
            map.put(key,left+right);
        }

        return left+right;
    }
}
// @lc code=end


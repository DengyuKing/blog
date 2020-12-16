import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=39 lang=java
 *
 * [39] 组合总和
 *
 * https://leetcode-cn.com/problems/combination-sum/description/
 *
 * algorithms
 * Medium (71.71%)
 * Likes:    1083
 * Dislikes: 0
 * Total Accepted:    186.5K
 * Total Submissions: 260K
 * Testcase Example:  '[2,3,6,7]\n7'
 *
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * 
 * candidates 中的数字可以无限制重复被选取。
 * 
 * 说明：
 * 
 * 
 * 所有数字（包括 target）都是正整数。
 * 解集不能包含重复的组合。 
 * 
 * 
 * 示例 1：
 * 
 * 输入：candidates = [2,3,6,7], target = 7,
 * 所求解集为：
 * [
 * ⁠ [7],
 * ⁠ [2,2,3]
 * ]
 * 
 * 
 * 示例 2：
 * 
 * 输入：candidates = [2,3,5], target = 8,
 * 所求解集为：
 * [
 * [2,2,2,2],
 * [2,3,3],
 * [3,5]
 * ]
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 <= candidates.length <= 30
 * 1 <= candidates[i] <= 200
 * candidate 中的每个元素都是独一无二的。
 * 1 <= target <= 500
 * 
 * 1 回溯加存储关键结果，可以减少重复的工作量
 * 2 对于这类寻找所有可行解的题，我们都可以尝试用「搜索回溯」的方法来解决[保底算法]
 * 3 每次遇到的问题是一样的，可以采用Map存储搜索过程中已经搜索过的过程。
 * 4 此题仔细想了一下，不能用类似背包问题的动态规划方法求解，因为背包问题里d[i][j]的意思是用 i 和 i 之前的元素组成J时有多少种组成方法，而不是具体的组成方案。故不用
 */

// @lc code=start
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
       // 初始化
       Map<Integer,List<List<Integer>>> map = new HashMap();
       for (int i :candidates){
           List<Integer> li = new ArrayList();
           li.add(i);
           map.put(i,li);
       }

    }

    private void findResult(int [] candidates, int target, Map<Integer,List<List<Integer>>> map,List<List<Integer>> list,LinkedList<Integer> path){
          
        if (target <=0){
            return ;
        }
        // 先查找Map是否有记录
        path.addLast(target);
        for (int i = 0;i<candidates.length;i++){
            if (map.get(target - candidates[i])){
                List<List<Integer>> mList = map.get(target-candidates[i]);
                for (List<Integer> item : mList){
                    item.addAll(path);
                    // 加入全局路径
                    List<Integer> re = new ArrayList();
                    re.addAll(path);
                    re.addAll(item);
                    list.add(re);
                }
            }
        }

        // 递归
        for (int i = 0;i<candidates.length;i++){
            findResult(candidates, target-candidates[i], map, list, path);
        }
        path.removeLast();

    }
}
// @lc code=end


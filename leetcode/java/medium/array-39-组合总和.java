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
 * 
 * 
 * 这个问题从网上看的解题思路是用回溯法，不过回溯法本身有一个缺陷就是算法本身时间复杂度高，并且在回溯的过程中，如果不进行优化，许多搜索路径是重复的，这种算法实际上可以作为一种保底的算法，可采取存储已搜索路劲的方式存储已经找的部分答案。
 * 
 * 回溯法 在此题应用的时候需要记录搜索的路径，这个题目的初步设想是当搜索未完成时，如果已发现接下来要搜索的路径已经被记录(被记录的路径是能够找到解的)，则可把当前节点记录到Map中，从而
 * 
 * 尝试找到解，会存在丢调解  [1,2] 3 ,会丢失 1,1,1 这个解
 */

// @lc code=start
class Solution {
    
    public  List<List<Integer>> combinationSum(int[] candidates, int target) {
        // 初始化

        Arrays.sort(candidates);
        // 此目的为如果节点本身为候选数组里的元素。
        List<List<Integer>> list = new ArrayList();
        LinkedList<Integer> path = new LinkedList<>();

        findResult(candidates, target, list, path, 0);
        return list;

    }

    /**
     *
     * @param candidates
     * @param target
     * @param list
     * @param path
     * @param index      递归时从哪里开始搜索，保证有序
     */

    private  void findResult(int[] candidates, int target, List<List<Integer>> list, LinkedList<Integer> path,
            int index) {
        if (target < 0) {
            return;

        } else if (target == 0) {
            if (isValid(path)) {
                List<Integer> re = new ArrayList<>();
                re.addAll(path);
                list.add(re);
            }
            return;
        }

        // 递归查找，利用升序解达到去重目的
        for (int i = index; i < candidates.length; i++) {
            // 当前节点能够找到解
            path.addLast(candidates[i]);
            findResult(candidates, target - candidates[i], list, path, i);
            path.removeLast();
        }

    }

    private  boolean isValid(List<Integer> list) {
        if (list == null || list.size() == 0) {
            return false;
        }
        if (list.size() == 1) {
            return true;
        }
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) < list.get(i - 1)) {
                return false;
            }
        }
        return true;
    }
}
// @lc code=end


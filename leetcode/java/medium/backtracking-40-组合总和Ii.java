import java.awt.List;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=40 lang=java
 *
 * [40] 组合总和 II
 *
 * https://leetcode-cn.com/problems/combination-sum-ii/description/
 *
 * algorithms
 * Medium (64.28%)
 * Likes:    455
 * Dislikes: 0
 * Total Accepted:    121.6K
 * Total Submissions: 189.2K
 * Testcase Example:  '[10,1,2,7,6,1,5]\n8'
 *
 * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * 
 * candidates 中的每个数字在每个组合中只能使用一次。
 * 
 * 说明：
 * 
 * 
 * 所有数字（包括目标数）都是正整数。
 * 解集不能包含重复的组合。 
 * 
 * 
 * 示例 1:
 * 
 * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
 * 所求解集为:
 * [
 * ⁠ [1, 7],
 * ⁠ [1, 2, 5],
 * ⁠ [2, 6],
 * ⁠ [1, 1, 6]
 * ]
 * 
 * 
 * 示例 2:
 * 
 * 输入: candidates = [2,5,2,1,2], target = 5,
 * 所求解集为:
 * [
 * [1,2,2],
 * [5]
 * ]
 * 
 * 
 */
/**
 * 回溯方法，在深度搜索时，避免使用已经搜索过的元素。
 * 多次修改仍然有bug 
 * 最后超时，不得不采取优化时间措施
 * 看了评论，采用减枝方法
 */

// @lc code=start
class Solution {
    Set<String> set = new HashSet();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        // 排序 为了以后升序防重
        Arrays.sort(candidates);
        List<List<Integer>> list = new ArrayList();
        LinkedList<Integer> path = new LinkedList<>();

        findResult(candidates, target, list, 0, path);
        return list;

    }

    public void findResult(int[] candidates, int target, List<List<Integer>> list, int index,
            LinkedList<Integer> path) {

        if (target < 0) {// 不加的话，也不会无限循环下去，因为再进入数组时已经不满足条件
        }
        if (target == 0) {
            List<Integer> re = new ArrayList();
            // 在此转换为了解决集合更改影响其他集合的问题
            re.addAll(path);
            if (isValid(re)) {
                list.add(re);
            }
            return;
        }

        for (int i = index; i < candidates.length; i++) {
           
            /**
             * 这里用index+1 只能保证数组的两个位置不一样，但是不能保证每个地方的值不一样。
             */
            if (target-candidates[i]<0){ // 当前元素已经不满足了，那后面的元素越来越大，肯定更不满足
                break;
            }
            // 这里再进行减枝的时候，是同一层的需要减枝，i>0这个条件是错误的，在递归的时候一定注意i的范围
            if (i>index && candidates[i] == candidates[i-1]){// 同一层，有元素相同的，跳过
                continue;
            }

            path.addLast(candidates[i]);
            findResult(candidates, target - candidates[i], list, i + 1, path);
            path.removeLast();
        }

    }

    private boolean isValid(List<Integer> list){
        if (null == list || list.size() == 0){
            return false;
        }
        if (list.size() == 1 && !set.contains(list.get(0)+"")){
            set.add(list.get(0) + "");// 这里当只有一个元素时，没有加进来
            return true;
        }
        StringBuffer sb  = new StringBuffer();
        sb.append(String.valueOf(list.get(0)));
        for (int i =1; i<list.size();i++){
            if (list.get(i-1)>list.get(i)){
                return false;
            }
            sb.append(String.valueOf(list.get(i)));

        }

        if (set.contains(sb.toString())){
            return false;
        }
        set.add(sb.toString());// 知道用set防重，但是没有往里面加数据，和没用一样
        return true;
    }

}
// @lc code=end

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=347 lang=java
 *
 * [347] 前 K 个高频元素
 *
 * https://leetcode.cn/problems/top-k-frequent-elements/description/
 *
 * algorithms
 * Medium (63.01%)
 * Likes:    1209
 * Dislikes: 0
 * Total Accepted:    300.5K
 * Total Submissions: 476.8K
 * Testcase Example:  '[1,1,1,2,2,3]\n2'
 *
 * 给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。
 * 
 * 
 * 
 * 示例 1:
 * 
 * 
 * 输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 * 
 * 
 * 示例 2:
 * 
 * 
 * 输入: nums = [1], k = 1
 * 输出: [1]
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 
 * k 的取值范围是 [1, 数组中不相同的元素的个数]
 * 题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的
 * 
 * 
 * 
 * 
 * 进阶：你所设计算法的时间复杂度 必须 优于 O(n log n) ，其中 n 是数组大小。
 * 
 */

// @lc code=start
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        if (k < 1 || nums == null || nums.length ==0) {
            return nums;
        }

        Map<Integer,Obj> map = new HashMap<>();

        for (int i = 0;i<nums.length;i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i],new Obj(nums[i],1));
            }else  {
                Obj obj = map.get(nums[i]);
                obj.setVal(obj.val+1);
            }
        }

        List<Obj> objs = new ArrayList<>(map.values());
        objs.sort(null);
        int [] result = new int[k];
        for (int i = 0;i<k;i++) {
            result[i] = objs.get(objs.size()-1-i).key;
        }

        return result;
    }

    class Obj implements Comparable<Obj>{
        public int key;
        public int val;

        public Obj(int key,int val){
            this.key = key;
            this.val = val;
        }

        public void setVal(int val) {
            this.val = val;
        }
        @Override
        public int compareTo(Obj o) {
            if (this.val<o.val) {
                return -1;
            }else if (this.val>o.val) {
                return 1;
            }else {
                return 0;
            }
        }

    }
}
// @lc code=end


/*
 * @lc app=leetcode.cn id=57 lang=java
 *
 * [57] 插入区间
 *
 * https://leetcode-cn.com/problems/insert-interval/description/
 *
 * algorithms
 * Medium (41.16%)
 * Likes:    489
 * Dislikes: 0
 * Total Accepted:    87.9K
 * Total Submissions: 213.5K
 * Testcase Example:  '[[1,3],[6,9]]\n[2,5]'
 *
 * 给你一个 无重叠的 ，按照区间起始端点排序的区间列表。
 * 
 * 在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：intervals = [[1,3],[6,9]], newInterval = [2,5]
 * 输出：[[1,5],[6,9]]
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 * 输出：[[1,2],[3,10],[12,16]]
 * 解释：这是因为新的区间 [4,8] 与 [3,5],[6,7],[8,10] 重叠。
 * 
 * 示例 3：
 * 
 * 
 * 输入：intervals = [], newInterval = [5,7]
 * 输出：[[5,7]]
 * 
 * 
 * 示例 4：
 * 
 * 
 * 输入：intervals = [[1,5]], newInterval = [2,3]
 * 输出：[[1,5]]
 * 
 * 
 * 示例 5：
 * 
 * 
 * 输入：intervals = [[1,5]], newInterval = [2,7]
 * 输出：[[1,7]]
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 0 
 * intervals[i].length == 2
 * 0 
 * intervals 根据 intervals[i][0] 按 升序 排列
 * newInterval.length == 2
 * 0 
 * 
 * 
 * 关键词 有序，无重叠
 * 有序表示可以采用二分查找法，无重叠表示，不用考虑递归合并
 * 
 * 此题的关键在于新插入的区间，向左找到左边界，向右找到右边界 
 * 新插入的区间和左边的区间有三种情况，包含，交叉和小于
 * 
 * 对于包含来说，继续找左右边界
 * 对于交叉来说，需要合并(左右边界)
 * 对于小于来说，不要合并(左右边界)
 * 
 * 在找边界的过程中，可能找到的边界不是最
 * 
 * 思维逻辑有些混乱，这也是搞不定数学的原因
 * 
 * 二分查找法，这里应用的是二分查找的变种
 */

// @lc code=start
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int [][] result = new int[intervals.length+1][2];
         if (intervals.length == 0) {
             result[0] = newInterval;
            return result;
         }

         int left = findBound(intervals,newInterval,0);
         int right = findBound(intervals, newInterval, 1);
         // 左边界
         
          if (left != -1 && intervals[left][1]>= newInterval[0]) {
             newInterval[0] = intervals[left][0];
         }

          if (right != intervals.length-1 && intervals[right+1][0] <= newInterval[1]){
            newInterval[1] = intervals[right+1][1];
        }

        // 已经合并完区间，怎么把结果搞出来？

        
        int k = 0;
        for (int i = 0;i<intervals.length;i++) {
            if (intervals[i][0]> newInterval[1] || intervals[i][1]<newInterval[0]) {
                result[k++] = intervals[i];
            }

        }

        return result;

    }
        // 只有一个元素时，不满足
        int findBound(int [][] intervals,int [] newInterval,int bound) {

            int l = 0,r = intervals.length-1;
           // 先判断是否是左右边界
           if (intervals[l][bound] >= newInterval[bound]) {
               return -1;
           }

           if (intervals[r][bound]<= newInterval[bound]){
                return intervals.length-1;
           }

           while (r-l>1) { // 这里是关键，写的简直是屎
               int mid = l + (r-l)/2;

               if (intervals[mid][bound] >= newInterval[bound]) {
                   r = mid;// 加一减一，看具体需求，这里如果mid + 1 则可能会丢失解
               }else if (intervals[mid][bound] <= newInterval[bound]) {
                   l = mid;
               }
           }

           return l;
        }
   

}
// @lc code=end


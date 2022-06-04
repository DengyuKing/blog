/*
 * @lc app=leetcode.cn id=57 lang=java
 *
 * [57] 插入区间
 二分查找，计算出来合并后的区间，然后判断区间是否重叠
 */

// @lc code=start
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
  if (intervals.length == 0) {
            return new int[][]{newInterval};
        }
        // 先找左边界
        int leftBound = findBound(intervals,newInterval[0],true);
        // 再找右边界
        int rightBound = findBound(intervals,newInterval[1],false);
        List<String> list = new ArrayList();
        // 合并区间,如果能合并，则合并，不能合并，添加最小的那个,合并区间确保只添加一次
        boolean add = true;
        int j =0;
        while (j<intervals.length) {
            // 可以合并
            if (leftBound<=intervals[j][0] &&rightBound >= intervals[j][1]){
                if (add) {
                    list.add(String.format("%s,%s",leftBound,rightBound));
                    add = false;
                }
                j++;
                continue;
            }else{
                // 不能合并，添加较小的
                if (leftBound<intervals[j][0] && add) {
                    list.add(String.format("%s,%s",leftBound,rightBound));
                    add = false;
                }else {
                    list.add(String.format("%s,%s",intervals[j][0],intervals[j][1]));
                    j++;
                }
            }
        }

        if (add) {
            list.add(String.format("%s,%s",leftBound,rightBound));
        }

        int [][] result = new int[list.size()][2];
        for (int i = 0;i<list.size();i++) {
            String [] str = list.get(i).split(",");
            result[i][0] = Integer.valueOf(str[0]);
            result[i][1] = Integer.valueOf(str[1]);
        }

        return result;

    }

    private int findBound(int[][] intervals,int value,boolean flag) {
        int i = 0,j = intervals.length-1;

        while (i<=j) {
            int mid = i+(j-i)/2;
            if (intervals[mid][0] <= value && intervals[mid][1]>=value) {
                if (flag){
                    return intervals[mid][0];
                }
                return intervals[mid][1];
            }else if (intervals[mid][0]>value) {
                j = mid -1;
            }else {
                i = mid + 1;
            }
        }

        return value;
    }
}
// @lc code=end


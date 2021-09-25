/*
 * @lc app=leetcode.cn id=875 lang=java
 *
 * [875] 爱吃香蕉的珂珂
 *
 * https://leetcode-cn.com/problems/koko-eating-bananas/description/
 *
 * algorithms
 * Medium (47.85%)
 * Likes:    206
 * Dislikes: 0
 * Total Accepted:    44K
 * Total Submissions: 91.9K
 * Testcase Example:  '[3,6,7,11]\n8'
 *
 * 珂珂喜欢吃香蕉。这里有 N 堆香蕉，第 i 堆中有 piles[i] 根香蕉。警卫已经离开了，将在 H 小时后回来。
 * 
 * 珂珂可以决定她吃香蕉的速度 K （单位：根/小时）。每个小时，她将会选择一堆香蕉，从中吃掉 K 根。如果这堆香蕉少于 K
 * 根，她将吃掉这堆的所有香蕉，然后这一小时内不会再吃更多的香蕉。  
 * 
 * 珂珂喜欢慢慢吃，但仍然想在警卫回来前吃掉所有的香蕉。
 * 
 * 返回她可以在 H 小时内吃掉所有香蕉的最小速度 K（K 为整数）。
 * 
 * 
 * 
 * 
 * 
 * 
 * 示例 1：
 * 
 * 输入: piles = [3,6,7,11], H = 8
 * 输出: 4
 * 
 * 
 * 示例 2：
 * 
 * 输入: piles = [30,11,23,4,20], H = 5
 * 输出: 30
 * 
 * 
 * 示例 3：
 * 
 * 输入: piles = [30,11,23,4,20], H = 6
 * 输出: 23
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 <= piles.length <= 10^4
 * piles.length <= H <= 10^9
 * 1 <= piles[i] <= 10^9
 * 思路1 
 * 这个问题需要找出吃香蕉的最小速度，看下这个题的特点，H>=len(piles),那么最大的速度是max(piles),最小的速度是1 需要在最大的速度和最小的速度
 * 之间找到刚好吃完香蕉且不超时的次数，可以考虑用二分法。此处的二分法没有排序好的数组作为背景依托，很难察觉。但这个速度有最大值也有最小值，并且最大值
 * 最小值天然有序，考虑用二分法。二分法结束的条件是 针对找到的K，K-1 不符合要求，K 符合要求。K>=1
 * 
 */

// @lc code=start
class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        if (piles.length == h) {
            return max(piles);
        }

        int r = max(piles);
        int l = 1;

        while (l <= r) {
            int mid = l + (r - l) / 2;
            int k = find(piles, mid, h);
            if (k == 0) {
                return mid;
            } else if (k > 0) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return -1;
    }


    public int max(int [] piles ) {
        int max = -1;
        for (int i = 0;i<piles.length;i++) {
            max = Math.max(max,piles[i]);
        }
        return max;
    }

    public int find(int [] piles,int k,int h) {
        int sum1 = 0;
        int sum2 = 0;
        if (k == 1) {
            return 0;
        }

        for (int i = 0;i<piles.length;i++) {
            sum1 +=piles[i]/k +(piles[i]%(k) ==0?0:1);
            sum2 += (piles[i]/(k-1)) + (piles[i]%(k-1) ==0?0:1);
        }
        if (sum1<=h && sum2>h) {
            return 0;
        }else if (sum2 <=h) {
            return 1;
        }else if (sum1>h) {
            return -1;
        }
        return -1;
    }
}
// @lc code=end


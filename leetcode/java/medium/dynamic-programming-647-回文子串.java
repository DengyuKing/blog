/*
 * @lc app=leetcode.cn id=647 lang=java
 *
 * [647] 回文子串
 *
 * https://leetcode.cn/problems/palindromic-substrings/description/
 *
 * algorithms
 * Medium (66.45%)
 * Likes:    896
 * Dislikes: 0
 * Total Accepted:    191.3K
 * Total Submissions: 287.9K
 * Testcase Example:  '"abc"'
 *
 * 给你一个字符串 s ，请你统计并返回这个字符串中 回文子串 的数目。
 * 
 * 回文字符串 是正着读和倒过来读一样的字符串。
 * 
 * 子字符串 是字符串中的由连续字符组成的一个序列。
 * 
 * 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：s = "abc"
 * 输出：3
 * 解释：三个回文子串: "a", "b", "c"
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：s = "aaa"
 * 输出：6
 * 解释：6个回文子串: "a", "a", "a", "aa", "aa", "aaa"
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 <= s.length <= 1000
 * s 由小写英文字母组成
 * 
 * 
 */

// @lc code=start
class Solution {
    /**
     * 想到了用中心扩散方法解决，但是对于枚举中心节点这个有些疑问，因为枚举分为奇数和偶数两种情况
     */
    public int countSubstrings(String s) {
        if (s.length() <2) {
            return s.length();
        }
        int count = 0;
        for (int i = 0;i<s.length();i++) {
            int left = i,right = i;
            // 这里考虑了 单个字符的情况
            while (left>=0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                
                count++;
                left --;
                right ++;
            }
            left = i;
            right = i+1;

            // 这里如果left != right ;则停止
            while (left >=0 && right<s.length() && s.charAt(left) == s.charAt(right)) {
                    count ++;
                    left --;
                    right ++;
            }
            
        }

        return count;
    }
}
// @lc code=end


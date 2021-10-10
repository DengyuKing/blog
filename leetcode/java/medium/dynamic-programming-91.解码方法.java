/*
 * @lc app=leetcode.cn id=91 lang=java
 *
 * [91] 解码方法
 *
 * https://leetcode-cn.com/problems/decode-ways/description/
 *
 * algorithms
 * Medium (30.70%)
 * Likes:    962
 * Dislikes: 0
 * Total Accepted:    164.7K
 * Total Submissions: 532.7K
 * Testcase Example:  '"12"'
 *
 * 一条包含字母 A-Z 的消息通过以下映射进行了 编码 ：
 * 
 * 
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * 
 * 
 * 要 解码 已编码的消息，所有数字必须基于上述映射的方法，反向映射回字母（可能有多种方法）。例如，"11106" 可以映射为：
 * 
 * 
 * "AAJF" ，将消息分组为 (1 1 10 6)
 * "KJF" ，将消息分组为 (11 10 6)
 * 
 * 
 * 注意，消息不能分组为  (1 11 06) ，因为 "06" 不能映射为 "F" ，这是由于 "6" 和 "06" 在映射中并不等价。
 * 
 * 给你一个只含数字的 非空 字符串 s ，请计算并返回 解码 方法的 总数 。
 * 
 * 题目数据保证答案肯定是一个 32 位 的整数。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：s = "12"
 * 输出：2
 * 解释：它可以解码为 "AB"（1 2）或者 "L"（12）。
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：s = "226"
 * 输出：3
 * 解释：它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
 * 
 * 
 * 示例 3：
 * 
 * 
 * 输入：s = "0"
 * 输出：0
 * 解释：没有字符映射到以 0 开头的数字。
 * 含有 0 的有效映射是 'J' -> "10" 和 'T'-> "20" 。
 * 由于没有字符，因此没有有效的方法对此进行解码，因为所有数字都需要映射。
 * 
 * 
 * 示例 4：
 * 
 * 
 * 输入：s = "06"
 * 输出：0
 * 解释："06" 不能映射到 "F" ，因为字符串含有前导 0（"6" 和 "06" 在映射中并不等价）。
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 
 * s 只包含数字，并且可能包含前导零。
 初始化问题 细节很多，做算法题的时候，脑子要转的快，善于发现问题的规律，对于一些感到吃力的列举问题case问题一定要想清楚，做到不重不漏。
 * 
 * 
 */

// @lc code=start
class Solution {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0 || s.charAt(0) == '0') {
            return 0;
        }
        int count = 0;
        for (int i = 0 ;i<s.length();i++){
            if (s.charAt(i) == '0') {
                count++;
            }else if (count>0) {
                count--;
            }

            if (count >1) {
                return 0;
            }
        }
        int tmp = 1;
        int sum = 1;
        int index = 0;
        while(index<s.length()) {
            int code = code(s,index);
            if (0 == code ) {
                tmp = sum;

            }else if (-1 == code){
                return 0;
            }else {
                int tm = sum;
                sum += tmp;
                tmp = tm;
            }
            index ++;
        }

        return sum;


    }

    int code (String s ,int index) {

        // 后面有零 先与后面的结合,结合成功的
        if (index+1<s.length() && s.charAt(index+1) == '0') {
            int c1 = s.charAt(index) -'0';
            if (c1>2) {
                return -1;
            }

            return 0;
        }
        // 当前为第一个元素
        if (index == 0) {
            return 0;
        }

        char a = s.charAt(index - 1);
        char b = s.charAt(index);
        // 当前或者前一个元素为0 不能结合
        if (b == '0' || a == '0') {
            return 0;
        }


        int a1 = a-'0';
        int a2 = b-'0';
        int c = a1 * 10 + a2;
        if (c>26 || c<1) {
            return 0;
        }
        return 1;
    }
}
// @lc code=end


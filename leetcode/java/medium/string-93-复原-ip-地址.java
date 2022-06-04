/*
 * @lc app=leetcode.cn id=93 lang=java
 *
 * [93] 复原 IP 地址
 *
 * https://leetcode-cn.com/problems/restore-ip-addresses/description/
 *
 * algorithms
 * Medium (56.17%)
 * Likes:    918
 * Dislikes: 0
 * Total Accepted:    227.3K
 * Total Submissions: 403.4K
 * Testcase Example:  '"25525511135"'
 *
 * 有效 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。
 * 
 * 
 * 例如："0.1.2.201" 和 "192.168.1.1" 是 有效 IP 地址，但是 "0.011.255.245"、"192.168.1.312"
 * 和 "192.168@1.1" 是 无效 IP 地址。
 * 
 * 
 * 给定一个只包含数字的字符串 s ，用以表示一个 IP 地址，返回所有可能的有效 IP 地址，这些地址可以通过在 s 中插入 '.' 来形成。你 不能
 * 重新排序或删除 s 中的任何数字。你可以按 任何 顺序返回答案。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：s = "25525511135"
 * 输出：["255.255.11.135","255.255.111.35"]
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：s = "0000"
 * 输出：["0.0.0.0"]
 * 
 * 
 * 示例 3：
 * 
 * 
 * 输入：s = "101023"
 * 输出：["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 <= s.length <= 20
 * s 仅由数字组成
 * 
 * 
 */

// @lc code=start
class Solution {
    public   List<String> restoreIpAddresses(String s) {
        if (s == null || s.length()<4) {
            return new ArrayList();
        }
        List<String> result = new ArrayList();
        StringBuilder sb = new StringBuilder();
        handle(s, result, 1 , sb);
        return result;

    }

     void handle(String s ,List<String> result,int num,StringBuilder sb) {
        if (num == 4) {
            if (s.length() == 1 || (s.length()>1 && s.charAt(0) !='0' && Long.valueOf(s)<=255)) {
                sb.append(s);
                result.add(sb.toString());
                sb.setLength(sb.length()-s.length());
                return ;
            }
        }else if (num<4) {
            for (int i = 1;i<=s.length();i++) {
                String str = s.substring(0, i);
                if (str.length() == 1 || (str.length()>1 && str.charAt(0) !='0' && Long.valueOf(str)<=255)) {
                    sb.append(str).append(".");
                    handle(s.substring(i), result, num+1, sb);
                    sb.setLength(sb.length()-str.length()-1);
                }else {
                    break;
                }
            }
        }

    }
}
// @lc code=end


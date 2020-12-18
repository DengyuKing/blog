/*
 * @lc app=leetcode.cn id=17 lang=java
 *
 * [17] 电话号码的字母组合
 *
 * https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/description/
 *
 * algorithms
 * Medium (55.55%)
 * Likes:    1043
 * Dislikes: 0
 * Total Accepted:    202.7K
 * Total Submissions: 364.6K
 * Testcase Example:  '"23"'
 *
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 * 
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * 
 * 
 * 
 * 示例:
 * 
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * 
 * 
 * 说明:
 * 尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。
 * 
 * 
 * 经典回溯方法(构造组合时有先后顺序)，穷举
 */

// @lc code=start
class Solution {

    Map<Character, String> map = new HashMap<>();
    {
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
    }

    public List<String> letterCombinations(String digits) {
        StringBuffer path = new StringBuffer();
        List<String> list = new ArrayList();
        // 边界
        if (null == digits || digits.length() == 0){
            return list;
        }
        findLetter(digits, 0, list, path);
        return list;
    }

    /**
     * 回溯算法
     * 
     * @param digits
     * @param index  记录层信息，当前处于第几层
     * @param list
     * @param path
     */
    private void findLetter(String digits, int index, List<String> list, StringBuffer path) {

        // 这里需要特别注意边界问题
        if (index == digits.length()) {
            list.add(path.toString());
            return;
        }

        String str = map.get(digits.charAt(index));
        for (int i = 0; i < str.length(); i++) {
            path.append(str.charAt(i));
            findLetter(digits, index + 1, list, path);
            path.deleteCharAt(path.length() - 1);
        }

    }
}
// @lc code=end


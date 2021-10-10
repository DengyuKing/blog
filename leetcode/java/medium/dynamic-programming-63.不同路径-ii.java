/*
 * @lc app=leetcode.cn id=63 lang=java
 *
 * [63] 不同路径 II
 *
 * https://leetcode-cn.com/problems/unique-paths-ii/description/
 *
 * algorithms
 * Medium (39.12%)
 * Likes:    640
 * Dislikes: 0
 * Total Accepted:    183.5K
 * Total Submissions: 468.4K
 * Testcase Example:  '[[0,0,0],[0,1,0],[0,0,0]]'
 *
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 * 
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 * 
 * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
 * 
 * 
 * 
 * 网格中的障碍物和空位置分别用 1 和 0 来表示。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]]
 * 输出：2
 * 解释：
 * 3x3 网格的正中间有一个障碍物。
 * 从左上角到右下角一共有 2 条不同的路径：
 * 1. 向右 -> 向右 -> 向下 -> 向下
 * 2. 向下 -> 向下 -> 向右 -> 向右
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：obstacleGrid = [[0,1],[0,0]]
 * 输出：1
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * m == obstacleGrid.length
 * n == obstacleGrid[i].length
 * 1 
 * obstacleGrid[i][j] 为 0 或 1
 dp [i][j] = max{dp[i-1][j] , dp[i][j+1]}
 障碍的点设置为负数
 * 
 * 
 */
障碍物的可设置为
// @lc code=start
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
             if (obstacleGrid == null || obstacleGrid.length == 0) {
            return 0;
        }
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int [] dp = new int[n];

        // 初始化 , 空间优化
        for (int i =0;i<n;i++ ) {
            if (obstacleGrid[0][i] == 1) {
                break;
            }else {
                dp[i] = 1;
            }
        }

        for (int i = 1;i<m;i++) {
            for (int j = 0;j<n;j++){
                if (obstacleGrid[i][j] == 1) {
                    dp[j] = 0;
                }else if (j !=0) {
                    dp [j] = dp[j-1]+dp[j];
                }
            }
        }

        return dp[n-1];
    }
}
// @lc code=end


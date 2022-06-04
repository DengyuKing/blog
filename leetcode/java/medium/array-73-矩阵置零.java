/*
 * @lc app=leetcode.cn id=73 lang=java
 *
 * [73] 矩阵置零
 */

// @lc code=start
class Solution {
    public  void setZeroes(int[][] matrix) {
        if (matrix == null) {
            return ;
        }

        //

        int col = matrix[0].length;
        int row = matrix.length;
        boolean firstColHasZero = false;
        for (int i = 0;i<row;i++) {
            if (matrix[i][0] == 0) {
                firstColHasZero = true;
            }
        }

        for (int i = 0;i<row;i++) {
            for (int j = 0;j<col; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    break;
                }
            }
        }

        for (int i =0;i<row;i++ ) {
            handleRow(matrix,i,matrix[i][0] == 0);
        }

        if (firstColHasZero) {
            int k = 0;
            while (k<matrix.length) {
                matrix[k][0] =0;
                k++;
            }
        }

        return ;

    }

    private  void handleRow(int [][] matrix,int i ,boolean rowHasZero) {
        for (int j = 1;j<matrix[0].length;j++) {
            if (matrix[i][j] == 0) {
                int k = 0;
                while(k<matrix.length) {
                    matrix[k][j] =0;
                    k++;
                }
            }else if (rowHasZero) {
                matrix[i][j] = 0;
            }
        }

    }
}
// @lc code=end


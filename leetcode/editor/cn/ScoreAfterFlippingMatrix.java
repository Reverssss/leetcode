package editor.cn;//给你一个大小为 m x n 的二元矩阵 grid ，矩阵中每个元素的值为 0 或 1 。
//
// 一次 移动 是指选择任一行或列，并转换该行或列中的每一个值：将所有 0 都更改为 1，将所有 1 都更改为 0。 
//
// 在做出任意次数的移动后，将该矩阵的每一行都按照二进制数来解释，矩阵的 得分 就是这些数字的总和。 
//
// 在执行任意次 移动 后（含 0 次），返回可能的最高分数。 
//
// 
//
// 
// 
//
// 示例 1： 
// 
// 
//输入：grid = [[0,0,1,1],[1,0,1,0],[1,1,0,0]]
//输出：39
//解释：0b1111 + 0b1001 + 0b1111 = 15 + 9 + 15 = 39
// 
//
// 示例 2： 
//
// 
//输入：grid = [[0]]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 20 
// grid[i][j] 为 0 或 1 
// 
//
// Related Topics 贪心 位运算 数组 矩阵 👍 233 👎 0

//Java：|861|翻转矩阵后的得分|ScoreAfterFlippingMatrix|
public class ScoreAfterFlippingMatrix {
    public static void main(String[] args) {
        Solution solution = new ScoreAfterFlippingMatrix().new Solution();
        // TO TEST
        int[][] grid = new int[][]{{0, 0, 1, 1}, {1, 0, 1, 0}, {1, 1, 0, 0}};
        int[][] grid2 = new int[][]{{0}};
        System.out.println(solution.matrixScore(grid2));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int matrixScore(int[][] grid) {
            int rowMax = grid.length;
            int columnMax = grid[0].length;
            int sum = 0;

            for (int row = 0; row < rowMax; row++) {
                if (grid[row][0] == 0) {
                    for (int column = 0; column < columnMax; column++) {
                        if (grid[row][column] == 0) {
                            grid[row][column] = 1;
                        } else {
                            grid[row][column] = 0;
                        }
                    }
                }
            }
            sum = rowMax * (int) Math.pow(2, columnMax - 1);

            for (int column = 1; column < columnMax; column++) {
                int columnSum = 0;
                for (int row = 0; row < rowMax; row++) {
                    columnSum += grid[row][column];
                }
                sum += Math.max(columnSum, rowMax - columnSum) * Math.pow(2, columnMax - column - 1);
            }

            return sum;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}
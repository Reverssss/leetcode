package editor.cn;//在一个 n x n 的国际象棋棋盘上，一个骑士从单元格 (row, column) 开始，并尝试进行 k 次移动。行和列是 从 0 开始 的，所以左上单元格
//是 (0,0) ，右下单元格是 (n - 1, n - 1) 。 
//
// 象棋骑士有8种可能的走法，如下图所示。每次移动在基本方向上是两个单元格，然后在正交方向上是一个单元格。 
//
// 
//
// 每次骑士要移动时，它都会随机从8种可能的移动中选择一种(即使棋子会离开棋盘)，然后移动到那里。 
//
// 骑士继续移动，直到它走了 k 步或离开了棋盘。 
//
// 返回 骑士在棋盘停止移动后仍留在棋盘上的概率 。 
//
// 
//
// 示例 1： 
//
// 
//输入: n = 3, k = 2, row = 0, column = 0
//输出: 0.0625
//解释: 有两步(到(1,2)，(2,1))可以让骑士留在棋盘上。
//在每一个位置上，也有两种移动可以让骑士留在棋盘上。
//骑士留在棋盘上的总概率是0.0625。
// 
//
// 示例 2： 
//
// 
//输入: n = 1, k = 0, row = 0, column = 0
//输出: 1.00000
// 
//
// 
//
// 提示: 
//
// 
// 1 <= n <= 25 
// 0 <= k <= 100 
// 0 <= row, column <= n 
// 
// Related Topics 动态规划 👍 229 👎 0

import java.util.ArrayList;
import java.util.HashMap;

//Java：|688|骑士在棋盘上的概率|KnightProbabilityInChessboard|
public class KnightProbabilityInChessboard{
    public static void main(String[] args) {
        Solution solution = new KnightProbabilityInChessboard().new Solution();
        // TO TEST
        System.out.println(solution.knightProbability(1,0,0,0));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        public double knightProbability(int n, int k, int row, int column) {
            if(k == 0)
                return 1.0;
            int[][] method = new int[][]{{-2,-1},{-1,-2},{2,-1},{1,-2},{-1,2},{-2,1},{1,2},{2,1}};
            double[][][] matrix = new double[k+1][n][n]; // step,i,j
            for(int i = 0 ; i < n ; i++){
                for (int j = 0; j < n ; j++){
                    matrix[0][i][j] = 1;
                }
            }
            for(int step = 1 ; step < k ; step++) {
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {

                        double sum = 0;
                        for (int times = 0; times < 8; times++) {
                            if (i + method[times][0] >= 0 && i + method[times][0] < n && j + method[times][1] >= 0 && j + method[times][1] < n) {
                                sum += matrix[step - 1][i + method[times][0]][j + method[times][1]]/8.0;
                            }
                        }
                        matrix[step][i][j] = sum;

                    }
                }
            }
            double sum = 0;
            for (int times = 0; times < 8; times++) {
                if (row + method[times][0] >= 0 && row + method[times][0] < n && column + method[times][1] >= 0 && column + method[times][1] < n) {
                    sum += matrix[k - 1][row + method[times][0]][column + method[times][1]]/8.0;
                }
            }
            return sum;
        }



}
//leetcode submit region end(Prohibit modification and deletion)

}
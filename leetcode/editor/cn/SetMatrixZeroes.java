package editor.cn;//给定一个 m x n 的矩阵，如果一个元素为 0 ，则将其所在行和列的所有元素都设为 0 。请使用 原地 算法。
//
// 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：matrix = [[1,1,1],[1,0,1],[1,1,1]]
//输出：[[1,0,1],[0,0,0],[1,0,1]]
// 
//
// 示例 2： 
//
// 
//输入：matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
//输出：[[0,0,0,0],[0,4,5,0],[0,3,1,0]]
// 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[0].length 
// 1 <= m, n <= 200 
// -2³¹ <= matrix[i][j] <= 2³¹ - 1 
// 
//
// 
//
// 进阶： 
//
// 
// 一个直观的解决方案是使用 O(mn) 的额外空间，但这并不是一个好的解决方案。 
// 一个简单的改进方案是使用 O(m + n) 的额外空间，但这仍然不是最好的解决方案。 
// 你能想出一个仅使用常量空间的解决方案吗？ 
// 
// Related Topics 数组 哈希表 矩阵 👍 645 👎 0

import java.util.Arrays;

//Java：|73|矩阵置零|SetMatrixZeroes|
public class SetMatrixZeroes{
    public static void main(String[] args) {
        Solution solution = new SetMatrixZeroes().new Solution();
        // TO TEST
        int[][] matrix = new int[][]{{1,1,1},{1,0,1},{1,1,1}};
        solution.setZeroes(matrix);
        for (int[] temp : matrix){
            for (int a : temp){
                System.out.print(a + " ");
            }
            System.out.println();
        }
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void setZeroes(int[][] matrix) {
        int rows = matrix.length;
        int columns = matrix[0].length;
        int[] rowsFlags = new int[rows];
        int[] columnsFlags = new int[columns];
        Arrays.fill(rowsFlags,1);
        Arrays.fill(columnsFlags,1);

        for(int i = 0; i <  rows; i++){
            for (int j = 0 ; j < columns ; j ++){
                if(matrix[i][j] == 0){
                    rowsFlags[i] = 0;
                    columnsFlags[j] = 0;
                }
            }
        }

        for(int i = 0 ; i< rows;i++){
            for (int j = 0 ; j <columns ; j++)
                matrix[i][j] = matrix[i][j] * rowsFlags[i] * columnsFlags[j];
        }


    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
package editor.cn;//给你一个大小为 m x n 的二进制矩阵 grid ，其中 0 表示一个海洋单元格、1 表示一个陆地单元格。
//
// 一次 移动 是指从一个陆地单元格走到另一个相邻（上、下、左、右）的陆地单元格或跨过 grid 的边界。 
//
// 返回网格中 无法 在任意次数的移动中离开网格边界的陆地单元格的数量。 
//
// 
//
// 示例 1： 
//
// 
//输入：grid = [[0,0,0,0],[1,0,1,0],[0,1,1,0],[0,0,0,0]]
//输出：3
//解释：有三个 1 被 0 包围。一个 1 没有被包围，因为它在边界上。
// 
//
// 示例 2： 
//
// 
//输入：grid = [[0,1,1,0],[0,0,1,0],[0,0,1,0],[0,0,0,0]]
//输出：0
//解释：所有 1 都在边界上或可以到达边界。
// 
//
// 
//
// 提示： 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 500 
// grid[i][j] 的值为 0 或 1 
// 
// Related Topics 深度优先搜索 广度优先搜索 并查集 数组 矩阵 👍 66 👎 0

//Java：|1020|飞地的数量|NumberOfEnclaves|
public class NumberOfEnclaves{
    public static void main(String[] args) {
        Solution solution = new NumberOfEnclaves().new Solution();
        // TO TEST
        System.out.println(solution.numEnclaves(new int[][]{{0,0,0,0},{1,0,1,0},{0,1,1,0},{0,0,0,0}}));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        int[][] flag;
        int[][] direction = new int[][]{{-1,0},{1,0},{0,1},{0,-1}};// 0左 1右 2上 3下
        int row;//hang,x
        int column;//lie,y
        int ans;
    public int numEnclaves(int[][] grid) {
        ans = 0;
        row = grid.length;
        column = grid[0].length;
        flag = new int[row][column];

        for(int i = 0 ; i < column ; i++){
            deep(grid,0,i,grid[0][i]);
            deep(grid,row-1,i,grid[row-1][i]);
        }
        for(int i = 0 ; i < row ; i++){
            deep(grid,i,0,grid[i][0]);
            deep(grid,i,column-1,grid[i][column-1]);
        }
        for(int i = 0 ; i < row ; i++){
            for(int j = 0 ; j < column ; j++){
                if(flag[i][j] == 0 && grid[i][j]==1){
                    ans++;
                }
            }
        }

        return ans;
    }

    public void deep(int[][]grid,int x,int y,int value){
        if(flag[x][y] == 1)
            return;
        if(value == 1 && grid[x][y] == 1){
            flag[x][y] = 1;
            if(x - 1 >= 0){
                deep(grid,x-1,y,grid[x][y]);
            }
            if(x + 1 < row){
                deep(grid,x+1,y,grid[x][y]);
            }
            if(y - 1 >= 0){
                deep(grid,x,y-1,grid[x][y]);
            }
            if(y + 1 < column){
                deep(grid,x,y+1,grid[x][y]);
            }
        }else
            return;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
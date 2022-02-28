package editor.cn;//用一个大小为 m x n 的二维网格 grid 表示一个箱子。你有 n 颗球。箱子的顶部和底部都是开着的。
//
// 箱子中的每个单元格都有一个对角线挡板，跨过单元格的两个角，可以将球导向左侧或者右侧。 
//
// 
// 将球导向右侧的挡板跨过左上角和右下角，在网格中用 1 表示。 
// 将球导向左侧的挡板跨过右上角和左下角，在网格中用 -1 表示。 
// 
//
// 在箱子每一列的顶端各放一颗球。每颗球都可能卡在箱子里或从底部掉出来。如果球恰好卡在两块挡板之间的 "V" 形图案，或者被一块挡导向到箱子的任意一侧边上，就
//会卡住。 
//
// 返回一个大小为 n 的数组 answer ，其中 answer[i] 是球放在顶部的第 i 列后从底部掉出来的那一列对应的下标，如果球卡在盒子里，则返回 
//-1 。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：grid = [[1,1,1,-1,-1],[1,1,1,-1,-1],[-1,-1,-1,1,1],[1,1,1,1,-1],[-1,-1,-1,-
//1,-1]]
//输出：[1,-1,-1,-1,-1]
//解释：示例如图：
//b0 球开始放在第 0 列上，最终从箱子底部第 1 列掉出。
//b1 球开始放在第 1 列上，会卡在第 2、3 列和第 1 行之间的 "V" 形里。
//b2 球开始放在第 2 列上，会卡在第 2、3 列和第 0 行之间的 "V" 形里。
//b3 球开始放在第 3 列上，会卡在第 2、3 列和第 0 行之间的 "V" 形里。
//b4 球开始放在第 4 列上，会卡在第 2、3 列和第 1 行之间的 "V" 形里。
// 
//
// 示例 2： 
//
// 
//输入：grid = [[-1]]
//输出：[-1]
//解释：球被卡在箱子左侧边上。
// 
//
// 示例 3： 
//
// 
//输入：grid = [[1,1,1,1,1,1],[-1,-1,-1,-1,-1,-1],[1,1,1,1,1,1],[-1,-1,-1,-1,-1,-1]
//]
//输出：[0,1,2,3,4,-1]
// 
//
// 
//
// 提示： 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 100 
// grid[i][j] 为 1 或 -1 
// 
// Related Topics 深度优先搜索 数组 动态规划 矩阵 模拟 👍 32 👎 0

//Java：|1706|球会落何处|WhereWillTheBallFall|
public class WhereWillTheBallFall{
    public static void main(String[] args) {
        Solution solution = new WhereWillTheBallFall().new Solution();
        // TO TEST
        for(int temp : solution.findBall(new int[][]{{1,1,1,1,1,1},{-1,-1,-1,-1,-1,-1},{1,1,1,1,1,1},{-1,-1,-1,-1,-1,-1}})){
            System.out.print(temp + " ");
        }
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] findBall(int[][] grid) {
        int columnNumber = grid[0].length;
        int[] column = new int[columnNumber];
        int[] ans = new int[columnNumber];
        for (int i = 0; i < columnNumber; i++) {
            column[i] = i;
        }

        for (int i = 0; i < grid.length; i++) { //一行一行动态规划
            for (int j = 0; j < columnNumber; j++) {  //每一列加上参数的值并判断范围
                if (column[j] < columnNumber - 1) {
                    if (grid[i][column[j]] == 1 && grid[i][column[j] + 1] == -1) {
                        ans[j] = -1;
                    }
                } else if (column[j] == columnNumber - 1 && grid[i][column[j]] == 1) {
                    ans[j] = -1;
                }

                if (column[j] > 0) {
                    if (grid[i][column[j] - 1] == 1 && grid[i][column[j]] == -1) {
                        ans[j] = -1;
                    }
                }

                column[j] += grid[i][column[j]];
                if (column[j] >= columnNumber || column[j] < 0) {
                    ans[j] = -1;
                    column[j] = 0;
                }
            }


        }

        for (int i = 0; i < columnNumber; i++) {
            if (ans[i] != -1)
                ans[i] = column[i];
        }


        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
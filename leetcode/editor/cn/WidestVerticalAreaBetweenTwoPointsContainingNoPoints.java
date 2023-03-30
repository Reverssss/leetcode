package editor.cn;//给你 n 个二维平面上的点 points ，其中 points[i] = [xi, yi] ，请你返回两点之间内部不包含任何点的 最宽垂直区域 的宽度。
//
// 垂直区域 的定义是固定宽度，而 y 轴上无限延伸的一块区域（也就是高度为无穷大）。 最宽垂直区域 为宽度最大的一个垂直区域。 
//
// 请注意，垂直区域 边上 的点 不在 区域内。 
//
// 
//
// 示例 1： 
// 
// 
//输入：points = [[8,7],[9,9],[7,4],[9,7]]
//输出：1
//解释：红色区域和蓝色区域都是最优区域。
// 
//
// 示例 2： 
//
// 
//输入：points = [[3,1],[9,0],[1,0],[1,4],[5,3],[8,8]]
//输出：3
// 
//
// 
//
// 提示： 
//
// 
// n == points.length 
// 2 <= n <= 10⁵ 
// points{i].length == 2
// 0 <= xi, yi <= 10⁹ 
// 
//
// Related Topics 数组 排序 👍 63 👎 0

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

//Java：|1637|两点之间不包含任何点的最宽垂直区域|WidestVerticalAreaBetweenTwoPointsContainingNoPoints|
public class WidestVerticalAreaBetweenTwoPointsContainingNoPoints{
    public static void main(String[] args) {
        Solution solution = new WidestVerticalAreaBetweenTwoPointsContainingNoPoints().new Solution();
        // TO TEST
        System.out.println(solution.maxWidthOfVerticalArea(new int[][]{{58,71},{64,41},{96,14},{26,37},{11,67},{84,2},{72,0},{16,95},{74,100},{60,98},{8,45},{6,59},{69,32},{93,12},{26,56},{9,39},{61,84},{54,93},{43,47},{84,40},{95,82},{17,85},{99,41},{96,24},{83,10},{82,62},{26,81},{74,96},{53,0},{11,72},{51,35},{33,3},{33,52},{58,94},{89,92},{54,85}}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxWidthOfVerticalArea(int[][] points) {
            Arrays.sort(points,(x,y) ->x[0]-y[0]);
            int res = Integer.MIN_VALUE;

            for(int i = 0 ; i < points.length-1 ; i++){
                res = Math.max(points[i+1][0]-points[i][0],res);
            }
            return res;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
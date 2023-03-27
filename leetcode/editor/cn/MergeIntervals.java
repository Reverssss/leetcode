package editor.cn;//以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返
//回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。 
//
// 
//
// 示例 1： 
//
// 
//输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
//输出：[[1,6],[8,10],[15,18]]
//解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
// 
//
// 示例 2： 
//
// 
//输入：intervals = [[1,4],[4,5]]
//输出：[[1,5]]
//解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。 
//
// 
//
// 提示： 
//
// 
// 1 <= intervals.length <= 10⁴ 
// intervals[i].length == 2 
// 0 <= starti <= endi <= 10⁴ 
// 
//
// Related Topics 数组 排序 👍 1792 👎 0

import java.util.ArrayList;
import java.util.Arrays;

//Java：|56|合并区间|MergeIntervals|
public class MergeIntervals{
    public static void main(String[] args) {
        Solution solution = new MergeIntervals().new Solution();
        // TO TEST
        for(int[] i : solution.merge(new int[][]{{1,4},{0,4}})) {
            for (int j : i) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] merge(int[][] intervals) {
        ArrayList<int[]> list = new ArrayList();

        Arrays.sort(intervals,(int[]a , int[]b)->{return a[0]-b[0];});
        for(int i = 0 ; i < intervals.length-1 ; i++) {
            if(intervals[i][0] <= intervals[i + 1][0] && intervals[i][1] >= intervals[i + 1][0])
            if (intervals[i][1] >= intervals[i + 1][0]) {
                intervals[i + 1][0] = intervals[i][0];
            } else {
                list.add(intervals[i]);
            }
        }

        list.add(intervals[intervals.length-1]);

        int[][] res = new int[list.size()][2];
        for(int i = 0 ; i < list.size() ; i++){
            res[i] = list.get(i);
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
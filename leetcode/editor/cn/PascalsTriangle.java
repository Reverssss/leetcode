package editor.cn;//给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行。
//
// 在「杨辉三角」中，每个数是它左上方和右上方的数的和。 
//
// 
//
// 
//
// 示例 1: 
//
// 
//输入: numRows = 5
//输出: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
// 
//
// 示例 2: 
//
// 
//输入: numRows = 1
//输出: [[1]]
// 
//
// 
//
// 提示: 
//
// 
// 1 <= numRows <= 30 
// 
// Related Topics 数组 动态规划 👍 677 👎 0

import java.util.ArrayList;
import java.util.List;

//Java：|118|杨辉三角|PascalsTriangle|
public class PascalsTriangle{
    public static void main(String[] args) {
        Solution solution = new PascalsTriangle().new Solution();
        // TO TEST
        for(List<Integer> temp : solution.generate(5)){
            for(Integer i : temp){
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> generate(int numRows) {
        int[] ans = new int[numRows];
        List<List<Integer>> list = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();

        for(int i = 0 ; i < numRows ; i++){

            for(int j = temp.size()-1; j >= 1 ; j--){
                temp.set(j,temp.get(j-1) + temp.get(j));
            }
            temp.add(1);
            list.add(new ArrayList<>(temp));

        }
        return list;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
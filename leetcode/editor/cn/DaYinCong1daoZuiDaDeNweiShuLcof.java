package editor.cn;//输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。
//
// 示例 1: 
//
// 输入: n = 1
//输出: [1,2,3,4,5,6,7,8,9]
// 
//
// 
//
// 说明： 
//
// 
// 用返回一个整数列表来代替打印 
// n 为正整数 
// 
//
// Related Topics 数组 数学 👍 274 👎 0

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Java：|剑指 Offer 17|打印从1到最大的n位数|DaYinCong1daoZuiDaDeNweiShuLcof|
public class DaYinCong1daoZuiDaDeNweiShuLcof{
    public static void main(String[] args) {
        Solution solution = new DaYinCong1daoZuiDaDeNweiShuLcof().new Solution();
        // TO TEST
        System.out.println(solution.printNumbers(1));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] printNumbers(int n) {
        int[] res = new int[(int)Math.pow(10,n)-1];
        for(int i = 1 ; i <= (int)Math.pow(10,n)-1 ; i++){
            res[i-1] = i;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
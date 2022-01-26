package editor.cn;//泰波那契序列 Tn 定义如下：
//
// T0 = 0, T1 = 1, T2 = 1, 且在 n >= 0 的条件下 Tn+3 = Tn + Tn+1 + Tn+2 
//
// 给你整数 n，请返回第 n 个泰波那契数 Tn 的值。 
//
// 
//
// 示例 1： 
//
// 输入：n = 4
//输出：4
//解释：
//T_3 = 0 + 1 + 1 = 2
//T_4 = 1 + 1 + 2 = 4
// 
//
// 示例 2： 
//
// 输入：n = 25
//输出：1389537
// 
//
// 
//
// 提示： 
//
// 
// 0 <= n <= 37 
// 答案保证是一个 32 位整数，即 answer <= 2^31 - 1。 
// 
// Related Topics 记忆化搜索 数学 动态规划 👍 171 👎 0

//Java：1137.第 N 个泰波那契数
public class NThTribonacciNumber{
    public static void main(String[] args) {
        Solution solution = new NThTribonacciNumber().new Solution();
        // TO TEST
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int tribonacci(int n) {
        if(n == 0)
            return 0;
        if(n == 1 || n == 2)
            return 1;
        int[] t = new int[n+1];
        t[0] = 0;
        t[1] = 1;
        t[2] = 1;
        for(int i = 3; i <n+1 ; i++){
            t[i] = t[i-3] + t[i-2] + t[i-1];
        }
        return t[n];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
package editor.cn;//设计一个算法，算出 n 阶乘有多少个尾随零。
//
// 示例 1: 
//
// 输入: 3
//输出: 0
//解释: 3! = 6, 尾数中没有零。 
//
// 示例 2: 
//
// 输入: 5
//输出: 1
//解释: 5! = 120, 尾数中有 1 个零. 
//
// 说明: 你算法的时间复杂度应为 O(log n) 。 
//
// Related Topics 数学 👍 87 👎 0

//Java：|面试题 16.05|阶乘尾数|FactorialZerosLcci|
public class FactorialZerosLcci{
    public static void main(String[] args) {
        Solution solution = new FactorialZerosLcci().new Solution();
        // TO TEST
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int trailingZeroes(int n) {
        return n/5 + n/25 + n/125 + n/625 + n/3125 + n/15625 + n/78125 + n/390625 + n/1953125 + n/9765625 + n/48828125 + n/244140625 + n/1220703125;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
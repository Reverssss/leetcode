package editor.cn;//配对交换。编写程序，交换某个整数的奇数位和偶数位，尽量使用较少的指令（也就是说，位0与位1交换，位2与位3交换，以此类推）。
//
// 示例1: 
//
// 
// 输入：num = 2（或者0b10）
// 输出 1 (或者 0b01)
// 
//
// 示例2: 
//
// 
// 输入：num = 3
// 输出：3
// 
//
// 提示: 
//
// 
// num的范围在[0, 2^30 - 1]之间，不会发生整数溢出。 
// 
//
// Related Topics 位运算 👍 77 👎 0

//Java：|面试题 05.07|配对交换|ExchangeLcci|
public class ExchangeLcci{
    public static void main(String[] args) {
        Solution solution = new ExchangeLcci().new Solution();
        // TO TEST
        System.out.println(solution.exchangeBits(3));

    }
    //0123456789abcdef
    //1032547698badcfe
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int exchangeBits(int num) {

        return (num&0b01010101010101010101010101010101)*2 + (num&0b10101010101010101010101010101010)/2;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
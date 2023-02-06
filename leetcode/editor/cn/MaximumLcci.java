package editor.cn;//编写一个方法，找出两个数字a和b中最大的那一个。不得使用if-else或其他比较运算符。
// 示例： 
// 输入： a = 1, b = 2
//输出： 2
// 
//
// Related Topics 位运算 脑筋急转弯 数学 👍 125 👎 0

//Java：|面试题 16.07|最大数值|MaximumLcci|
public class MaximumLcci{
    public static void main(String[] args) {
        Solution solution = new MaximumLcci().new Solution();
        // TO TEST
        System.out.println(solution.maximum(0,2));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maximum(int a, int b) {
        long val = (long )a-(long)b;
        int[] r=new int[]{a,b};
        return r[(int)(val>>>63)];//负数的最符号位是1，使用无符号位移，高位补0,直接把数移成1或者0，然后直接作为结果的索引
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
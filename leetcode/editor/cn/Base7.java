package editor.cn;//给定一个整数 num，将其转化为 7 进制，并以字符串形式输出。
//
// 
//
// 示例 1: 
//
// 
//输入: num = 100
//输出: "202"
// 
//
// 示例 2: 
//
// 
//输入: num = -7
//输出: "-10"
// 
//
// 
//
// 提示： 
//
// 
// -10⁷ <= num <= 10⁷ 
// 
// Related Topics 数学 👍 123 👎 0

//Java：|504|七进制数|Base7|
public class Base7{
    public static void main(String[] args) {
        Solution solution = new Base7().new Solution();
        // TO TEST
        System.out.println(solution.convertToBase7(0));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String convertToBase7(int num) {
        if(num == 0)
            return "0";
        StringBuilder str = new StringBuilder();
        int yushu ;
        boolean flag = false;
        if(num < 0){
            flag = true;
            num = -num;
        }
        while (num != 0){
            str.append(num%7);
            num /= 7;
        }
        if(flag)
            str.append("-");
        String ans = String.valueOf(str.reverse());
        return ans;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
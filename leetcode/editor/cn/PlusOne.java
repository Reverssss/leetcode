package editor.cn;//给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
//
// 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。 
//
// 你可以假设除了整数 0 之外，这个整数不会以零开头。 
//
// 
//
// 示例 1： 
//
// 
//输入：digits = [1,2,3]
//输出：[1,2,4]
//解释：输入数组表示数字 123。
// 
//
// 示例 2： 
//
// 
//输入：digits = [4,3,2,1]
//输出：[4,3,2,2]
//解释：输入数组表示数字 4321。
// 
//
// 示例 3： 
//
// 
//输入：digits = [0]
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= digits.length <= 100 
// 0 <= digits[i] <= 9 
// 
//
// Related Topics 数组 数学 👍 1153 👎 0

//Java：|66|加一|PlusOne|
public class PlusOne{
    public static void main(String[] args) {
        Solution solution = new PlusOne().new Solution();
        // TO TEST
        int[] nums = new int[]{9,9,9};
        for(int i : solution.plusOne(nums)){
            System.out.print(i+" ");
        }
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] plusOne(int[] digits) {

        int[] ans = new int[digits.length];
        int carry = 1;
        for(int i = digits.length-1 ; i >= 0 ; i-- ){
            int num = digits[i] + carry;
            carry = num/10;
            ans[i] = num%10;
        }
        if(carry == 1){
            int[] ans2 = new int[digits.length+1];
            ans2[0] = 1;
            return ans2;
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
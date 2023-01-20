package editor.cn;//给定一个非空的正整数数组 nums ，请判断能否将这些数字分成元素和相等的两部分。
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,5,11,5]
//输出：true
//解释：nums 可以分割成 [1, 5, 5] 和 [11] 。 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3,5]
//输出：false
//解释：nums 不可以分为和相等的两部分
// 
//
// 
//
// 
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 200 
// 1 <= nums[i] <= 100 
// 
//
// 
//
// 
// 注意：本题与主站 416 题相同： https://leetcode-cn.com/problems/partition-equal-subset-
//sum/ 
//
// Related Topics 数学 字符串 模拟 👍 72 👎 0

//Java：|剑指 Offer II 101|分割等和子集|NUPfPr|
public class NUPfPr{
    public static void main(String[] args) {
        Solution solution = new NUPfPr().new Solution();
        // TO TEST
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        int max = 0;
        for(int i : nums) {
            sum += i;
            max = max > i ?max:i;
        }
        if(sum%2==0){
            if(max > sum/2){
                return false;
            }
            return true;
        }else {
            return false;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
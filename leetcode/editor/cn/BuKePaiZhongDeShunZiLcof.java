package editor.cn;//从若干副扑克牌中随机抽 5 张牌，判断是不是一个顺子，即这5张牌是不是连续的。2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，
//可以看成任意数字。A 不能视为 14。 
//
// 
//
// 示例 1: 
//
// 
//输入: [1,2,3,4,5]
//输出: True 
//
// 
//
// 示例 2: 
//
// 
//输入: [0,0,1,2,5]
//输出: True 
//
// 
//
// 限制： 
//
// 数组长度为 5 
//
// 数组的数取值为 [0, 13] . 
//
// Related Topics 数组 排序 👍 294 👎 0

import java.util.Arrays;
import java.util.HashSet;

//Java：|面试题61|扑克牌中的顺子|BuKePaiZhongDeShunZiLcof|
public class BuKePaiZhongDeShunZiLcof{
    public static void main(String[] args) {
        Solution solution = new BuKePaiZhongDeShunZiLcof().new Solution();
        // TO TEST
        solution.isStraight(new int[]{11,0,9,0,0});
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isStraight(int[] nums) {
        Arrays.sort(nums);

        int zeroNum = 0;
        for(int i = 0 ; i < 4 ; i++){
            if(nums[i] == 0){
                zeroNum++;
            }else if(nums[i] == nums[i+1]){
                return false;
            }
        }
        if(nums[4]-nums[zeroNum]>4)
            return false;

        return true;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
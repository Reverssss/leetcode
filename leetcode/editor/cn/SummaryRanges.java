package editor.cn;//给定一个 无重复元素 的 有序 整数数组 nums 。
//
// 返回 恰好覆盖数组中所有数字 的 最小有序 区间范围列表 。也就是说，nums 的每个元素都恰好被某个区间范围所覆盖，并且不存在属于某个范围但不属于 
//nums 的数字 x 。 
//
// 列表中的每个区间范围 [a,b] 应该按如下格式输出： 
//
// 
// "a->b" ，如果 a != b 
// "a" ，如果 a == b 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [0,1,2,4,5,7]
//输出：["0->2","4->5","7"]
//解释：区间范围是：
//[0,2] --> "0->2"
//[4,5] --> "4->5"
//[7,7] --> "7"
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,2,3,4,6,8,9]
//输出：["0","2->4","6","8->9"]
//解释：区间范围是：
//[0,0] --> "0"
//[2,4] --> "2->4"
//[6,6] --> "6"
//[8,9] --> "8->9"
// 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 20 
// -2³¹ <= nums[i] <= 2³¹ - 1 
// nums 中的所有值都 互不相同 
// nums 按升序排列 
// 
//
// Related Topics 数组 👍 246 👎 0

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//Java：|228|汇总区间|SummaryRanges|
public class SummaryRanges{
    public static void main(String[] args) {
        Solution solution = new SummaryRanges().new Solution();
        // TO TEST

//        for (String a : solution.summaryRanges(new int[]{0,1,2,4,5,7})){
//            System.out.println(a);
//        }
//        System.out.println();
        for (String a : solution.summaryRanges(new int[]{0,1,3,4,5,6})){
            System.out.println(a);
        }
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> summaryRanges(int[] nums) {
        if (nums.length == 0 )
            return new ArrayList<>();

        List<String> res = new ArrayList<>();
        if (nums.length == 1) {
            res.add(String.valueOf(nums[0]));
            return res;
        }

        int start = nums[0];
        for(int i = 0 ; i < nums.length-1 ; i++){
            if(nums[i] == nums[i+1]-1){

            }else {
                if(start == nums[i]){
                    res.add(String.valueOf(start));
                }else {
                    res.add(start + "->" + nums[i]);
                }
                start = nums[i+1];
            }
        }
        if(nums[nums.length-2] == nums[nums.length-1] -1){
            res.add(res.size(),start + "->" + nums[nums.length-1]);
        }else {
            res.add(String.valueOf(nums[nums.length-1]));
        }

        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
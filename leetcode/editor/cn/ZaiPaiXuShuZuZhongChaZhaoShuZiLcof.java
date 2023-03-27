package editor.cn;//统计一个数字在排序数组中出现的次数。
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [5,7,7,8,8,10], target = 8
//输出: 2 
//
// 示例 2: 
//
// 
//输入: nums = [5,7,7,8,8,10], target = 6
//输出: 0 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 10⁵ 
// -10⁹ <= nums[i] <= 10⁹ 
// nums 是一个非递减数组 
// -10⁹ <= target <= 10⁹ 
// 
//
// 
//
// 注意：本题与主站 34 题相同（仅返回值不同）：https://leetcode-cn.com/problems/find-first-and-last-
//position-of-element-in-sorted-array/ 
//
// Related Topics 数组 二分查找 👍 397 👎 0

//Java：|剑指 Offer 53 - I|在排序数组中查找数字 I|ZaiPaiXuShuZuZhongChaZhaoShuZiLcof|
public class ZaiPaiXuShuZuZhongChaZhaoShuZiLcof{
    public static void main(String[] args) {
        Solution solution = new ZaiPaiXuShuZuZhongChaZhaoShuZiLcof().new Solution();
        // TO TEST
        System.out.println(solution.search(new int[]{1,4},4));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int search(int[] nums, int target) {
        if(nums.length == 1){
            return target == nums[0] ? 1 :0;
        }
        int left = 0 ;
        int right = nums.length-1;
        while (left<=right){
            int mid = (left+right)/2;
            if(nums[mid] == target){
                int times = 0;

                left = mid;
                right = mid;
                while (left>=0 && nums[left] == target){
                    left--;
                }
                while (right<nums.length && nums[right] == target){
                    right++;
                }
                return right-left-1;
            }else if(nums[mid]<target){
                left = mid+1;
            }else {
                right = mid-1;
            }
        }
        return 0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
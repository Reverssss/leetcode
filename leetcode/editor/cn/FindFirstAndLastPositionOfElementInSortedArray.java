package editor.cn;//给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
//
// 如果数组中不存在目标值 target，返回 [-1, -1]。 
//
// 进阶： 
//
// 
// 你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？ 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [5,7,7,8,8,10], target = 8
//输出：[3,4] 
//
// 示例 2： 
//
// 
//输入：nums = [5,7,7,8,8,10], target = 6
//输出：[-1,-1] 
//
// 示例 3： 
//
// 
//输入：nums = [], target = 0
//输出：[-1,-1] 
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
// Related Topics 数组 二分查找 👍 1463 👎 0

//Java：|34|在排序数组中查找元素的第一个和最后一个位置|FindFirstAndLastPositionOfElementInSortedArray|
public class FindFirstAndLastPositionOfElementInSortedArray{
    public static void main(String[] args) {
        Solution solution = new FindFirstAndLastPositionOfElementInSortedArray().new Solution();
        // TO TEST
        for (int temp : solution.searchRange(new int[]{1},1)){
            System.out.print(temp + " ");
        }
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] ans = new int[]{0,nums.length-1};

        while (ans[0] <= ans[1] && ans[0] < nums.length && ans[1] >= 0){
            int mid = (ans[0] + ans[1])/2;
            if(nums[mid] < target){
                ans[0] = mid +1;
            }
            if(nums[mid] > target){
                ans[1] = mid-1;
            }
            if(nums[mid] == target){
                ans[0] = mid;
                ans[1] = mid;
                while (ans[0] >= 0){
                    if(nums[ans[0]] == target) {
                        ans[0]--;
                    }else break;
                }
                while (ans[1] < nums.length){
                    if(nums[ans[1]] == target) {
                        ans[1]++;
                    }else break;
                }
                ans[0]++;
                ans[1]--;
                return ans;
            }
        }

        return new int[]{-1,-1};
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
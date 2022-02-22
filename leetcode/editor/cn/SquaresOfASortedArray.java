package editor.cn;//给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。
//
// 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-4,-1,0,3,10]
//输出：[0,1,9,16,100]
//解释：平方后，数组变为 [16,1,0,9,100]
//排序后，数组变为 [0,1,9,16,100] 
//
// 示例 2： 
//
// 
//输入：nums = [-7,-3,2,3,11]
//输出：[4,9,9,49,121]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁴ 
// -10⁴ <= nums[i] <= 10⁴ 
// nums 已按 非递减顺序 排序 
// 
//
// 
//
// 进阶： 
//
// 
// 请你设计时间复杂度为 O(n) 的算法解决本问题 
// 
// Related Topics 数组 双指针 排序 👍 434 👎 0

//Java：|977|有序数组的平方|SquaresOfASortedArray|
public class SquaresOfASortedArray{
    public static void main(String[] args) {
        Solution solution = new SquaresOfASortedArray().new Solution();
        // TO TEST
        for(int temp : solution.sortedSquares(new int[]{-7,-3,2,3,11})){
            System.out.print(temp + " ");
        }
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] sortedSquares(int[] nums) {
        int absMin = 0;
        int left;
        int right;
        int[] ans = new int[nums.length];
        for(int i = 0 ; i < nums.length ; i++){
            if(Math.abs(nums[i]) < Math.abs(nums[absMin])){
                absMin = i;
            }
            if(nums[i] >= 0)
                break;
        }

        left = absMin-1;
        right = absMin+1;

        ans[0] = (int)Math.pow(nums[absMin],2);
        int i = 1;
        while (i < ans.length){
            double leftMax = 100000001;
            double rightMax = 100000001;
            if(left >= 0){
                leftMax = Math.pow(nums[left],2);
            }
            if(right < nums.length){
                rightMax = Math.pow(nums[right],2);
            }
            if(leftMax <= rightMax){
                ans[i] = (int)leftMax;
                left--;
            }else {
                ans[i] = (int)rightMax;
                right++;
            }
            i++;
        }

        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
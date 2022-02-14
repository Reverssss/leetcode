package editor.cn;//给你一个仅由整数组成的有序数组，其中每个元素都会出现两次，唯有一个数只会出现一次。
//
// 请你找出并返回只出现一次的那个数。 
//
// 你设计的解决方案必须满足 O(log n) 时间复杂度和 O(1) 空间复杂度。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [1,1,2,3,3,4,4,8,8]
//输出: 2
// 
//
// 示例 2: 
//
// 
//输入: nums =  [3,3,7,7,10,11,11]
//输出: 10
// 
//
// 
//
// 
//
// 提示: 
//
// 
// 1 <= nums.length <= 10⁵ 
// 0 <= nums[i] <= 10⁵ 
// 
// Related Topics 数组 二分查找 👍 319 👎 0

//Java：|540|有序数组中的单一元素|SingleElementInASortedArray|
public class SingleElementInASortedArray{
    public static void main(String[] args) {
        Solution solution = new SingleElementInASortedArray().new Solution();
        // TO TEST
        System.out.println(solution.singleNonDuplicate(new int[]{1,1,2}));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        int left;
        int right;
    public int singleNonDuplicate(int[] nums) {
        left = 0;
        right = nums.length-1;
        int ans = half(nums,left,right);
        return ans;
    }

    public int half(int[] nums,int left,int right){
        int half = (left + right)/2;
        int ans = 0;
        boolean flag1;
        boolean flag2;
        try {
            flag1 = nums[half] != nums[half+1];
        }catch (Exception e){
            return nums[half];
        }
        try {
            flag2 = nums[half] != nums[half-1];
        }catch (Exception e){
            return nums[half];
        }

        if(flag1 && flag2)
            return  nums[half];

        if(half%2==0){
            if(nums[half] == nums[half-1]){
                right = half-1;
                ans = half(nums,left,right);
            }else if(nums[half] == nums[half+1]){
                left = half+1;
                ans = half(nums,left,right);
            }
        }else {
            if(nums[half] == nums[half-1]){
                left = half+1;
                ans = half(nums,left,right);
            }else if(nums[half] == nums[half+1]){
                right = half-1;
                ans = half(nums,left,right);
            }
        }

        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
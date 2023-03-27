//package editor.cn;//给你一个大小为 n 下标从 0 开始的整数数组 nums 和一个正整数 k 。
////
//// 对于 k <= i < n - k 之间的一个下标 i ，如果它满足以下条件，我们就称它为一个 好 下标：
////
////
//// 下标 i 之前 的 k 个元素是 非递增的 。
//// 下标 i 之后 的 k 个元素是 非递减的 。
////
////
//// 按 升序 返回所有好下标。
////
////
////
//// 示例 1：
////
////
////输入：nums = [2,1,1,1,3,4,1], k = 2
////输出：[2,3]
////解释：数组中有两个好下标：
////- 下标 2 。子数组 [2,1] 是非递增的，子数组 [1,3] 是非递减的。
////- 下标 3 。子数组 [1,1] 是非递增的，子数组 [3,4] 是非递减的。
////注意，下标 4 不是好下标，因为 [4,1] 不是非递减的。
////
//// 示例 2：
////
////
////输入：nums = [2,1,1,2], k = 2
////输出：[]
////解释：数组中没有好下标。
////
////
////
////
//// 提示：
////
////
//// n == nums.length
//// 3 <= n <= 10⁵
//// 1 <= nums[i] <= 10⁶
//// 1 <= k <= n / 2
////
////
//// Related Topics 数组 动态规划 前缀和 👍 31 👎 0
//
//import java.util.List;
//
////Java：|2420|找到所有好下标|FindAllGoodIndices|
//public class FindAllGoodIndices{
//    public static void main(String[] args) {
//        Solution solution = new FindAllGoodIndices().new Solution();
//        // TO TEST
//    }
//
//    //leetcode submit region begin(Prohibit modification and deletion)
//class Solution {
//    public List<Integer> goodIndices(int[] nums, int k) {
//        int increaseLeft = 0;
//        int increaseRight = 0;
//        int decreaseLeft = 0;
//        int decreaseRight = 0;
//
//        for(int i = 0 ; i < nums.length-1; i++){
//            if(nums[i] < nums[i+1]){
//
//            }
//        }
//    }
//}
////leetcode submit region end(Prohibit modification and deletion)
//
//}
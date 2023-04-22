package editor.cn;//给你一个整数数组 nums，返回 nums 中最长等差子序列的长度。
//
// 回想一下，nums 的子序列是一个列表 nums[i1], nums[i2], ..., nums[ik] ，且 0 <= i1 < i2 < ... <
// ik <= nums.length - 1。并且如果 seq[i+1] - seq[i]( 0 <= i < seq.length - 1) 的值都相同，那么
//序列 seq 是等差的。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [3,6,9,12]
//输出：4
//解释： 
//整个数组是公差为 3 的等差数列。
// 
//
// 示例 2： 
//
// 
//输入：nums = [9,4,7,2,10]
//输出：3
//解释：
//最长的等差子序列是 [4,7,10]。
// 
//
// 示例 3： 
//
// 
//输入：nums = [20,1,15,3,10,5,8]
//输出：4
//解释：
//最长的等差子序列是 [20,15,10,5]。
// 
//
// 
//
// 提示： 
//
// 
// 2 <= nums.length <= 1000 
// 0 <= nums[i] <= 500 
// 
//
// Related Topics 数组 哈希表 二分查找 动态规划 👍 289 👎 0

import java.util.*;

//Java：|1027|最长等差数列|LongestArithmeticSubsequence|
public class LongestArithmeticSubsequence{
    public static void main(String[] args) {
        Solution solution = new LongestArithmeticSubsequence().new Solution();
        // TO TEST
        System.out.println(solution.longestArithSeqLength(new int[]{12,28,13,6,34,36,53,24,29,2,23,0,22,25,53,34,23,50,35,43,53,11,48,56,44,53,31,6,31,57,46,6,17,42,48,28,5,24,0,14,43,12,21,6,30,37,16,56,19,45,51,10,22,38,39,23,8,29,60,18}));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int longestArithSeqLength(int[] nums) {
        HashMap<Integer, Map<Integer,Integer>> reduces = new HashMap<>();
        int ans = 0;

        for(int i = 0 ; i < nums.length ; i++){
            for(int j = i+1; j < nums.length ; j++){
                int reduce = nums[j] - nums[i];

                Map<Integer, Integer> endCntMap = reduces.getOrDefault(reduce,new HashMap<>());
                reduces.put(reduce,endCntMap);
                int cnt = endCntMap.getOrDefault(i,0)+1;
                endCntMap.put(j,cnt);
                ans = Math.max(ans,cnt);
            }
        }
        return ans+1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
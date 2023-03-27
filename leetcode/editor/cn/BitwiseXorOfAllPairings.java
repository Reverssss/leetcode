package editor.cn;//给你两个下标从 0 开始的数组 nums1 和 nums2 ，两个数组都只包含非负整数。请你求出另外一个数组 nums3 ，包含 nums1 和 nums2
// 中 所有数对 的异或和（nums1 中每个整数都跟 nums2 中每个整数 恰好 匹配一次）。 
//
// 请你返回 nums3 中所有整数的 异或和 。 
//
// 
//
// 示例 1： 
//
// 输入：nums1 = [2,1,3], nums2 = [10,2,5,0]
//输出：13
//解释：
//一个可能的 nums3 数组是 [8,0,7,2,11,3,4,1,9,1,6,3] 。
//所有这些数字的异或和是 13 ，所以我们返回 13 。
// 
//
// 示例 2： 
//
// 输入：nums1 = [1,2], nums2 = [3,4]
//输出：0
//解释：
//所有数对异或和的结果分别为 nums1[0] ^ nums2[0] ，nums1[0] ^ nums2[1] ，nums1[1] ^ nums2[0] 和 
//nums1[1] ^ nums2[1] 。
//所以，一个可能的 nums3 数组是 [2,5,1,6] 。
//2 ^ 5 ^ 1 ^ 6 = 0 ，所以我们返回 0 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums1.length, nums2.length <= 10⁵ 
// 0 <= nums1[i], nums2[j] <= 10⁹ 
// 
//
// Related Topics 位运算 脑筋急转弯 数组 👍 9 👎 0

import java.util.ArrayList;
import java.util.HashSet;

//Java：|2425|所有数对的异或和|BitwiseXorOfAllPairings|
public class BitwiseXorOfAllPairings{
    public static void main(String[] args) {
        Solution solution = new BitwiseXorOfAllPairings().new Solution();
        // TO TEST
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int xorAllNums(int[] nums1, int[] nums2) {
        int a=0,b=0;
        //计算出`nums1`, `nums2`数组的异或和
        for(int v:nums2)b^=v;
        for(int v:nums1)a^=v;
        //若`len(nums2) % 2 == 0`则`nums1`数组的`n`个异或和为0，否则为1，`nums2`同理
        if(nums2.length%2==0)a=0;
        if(nums1.length%2==0)b=0;
        return a^b;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
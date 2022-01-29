package editor.cn;//给你两个整数数组 nums1 和 nums2 ，请你以数组形式返回两数组的交集。返回结果中每个元素出现的次数，应与元素在两个数组中都出现的次数一致（如果出现
//次数不一致，则考虑取较小值）。可以不考虑输出结果的顺序。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums1 = [1,2,2,1], nums2 = [2,2]
//输出：[2,2]
// 
//
// 示例 2: 
//
// 
//输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
//输出：[4,9] 
//
// 
//
// 提示： 
//
// 
// 1 <= nums1.length, nums2.length <= 1000 
// 0 <= nums1[i], nums2[i] <= 1000 
// 
//
// 
//
// 进阶： 
//
// 
// 如果给定的数组已经排好序呢？你将如何优化你的算法？ 
// 如果 nums1 的大小比 nums2 小，哪种方法更优？ 
// 如果 nums2 的元素存储在磁盘上，内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？ 
// 
// Related Topics 数组 哈希表 双指针 二分查找 排序 👍 642 👎 0

import java.util.HashMap;

//Java：|350|两个数组的交集 II|IntersectionOfTwoArraysIi|
public class IntersectionOfTwoArraysIi{
    public static void main(String[] args) {
        Solution solution = new IntersectionOfTwoArraysIi().new Solution();
        // TO TEST
        int[] nums1 = new int[]{1,2,2,1};
        int[] nums2 = new int[]{2,2};
        int[] ans = solution.intersect(nums1,nums2);
        System.out.println(ans[0] + "   " + ans[1]);
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer[]> map = new HashMap<>();//<number,[nums1,nums2]>

        for(int i = 0; i < nums1.length ; i++){
            int num1Number = map.getOrDefault(nums1[i],new Integer[]{0,0})[0];
            int num2Number = map.getOrDefault(nums1[i],new Integer[]{0,0})[1];

            map.put(nums1[i],new Integer[]{++num1Number,num2Number});
        }

        for(int i = 0; i < nums2.length ; i++){
            int num1Number = map.getOrDefault(nums2[i],new Integer[]{0,0})[0];
            int num2Number = map.getOrDefault(nums2[i],new Integer[]{0,0})[1];

            map.put(nums2[i],new Integer[]{num1Number,++num2Number});
        }

        int i = 0;
        int[] ans = new int[nums1.length + nums2.length];

        for(int number : map.keySet()){
            int times = Math.min(map.get(number)[0],map.get(number)[1]);
            for(; times > 0 ; times--){
                ans[i] = number;
                i++;
            }

        }
        int[] ans2 = new int[i];
        for(int j = 0; j < i;j++){
            ans2[j] = ans[j];
        }
        return ans2;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
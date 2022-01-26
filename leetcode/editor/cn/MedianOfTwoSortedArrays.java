package editor.cn;//给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
//
// 算法的时间复杂度应该为 O(log (m+n)) 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums1 = [1,3], nums2 = [2]
//输出：2.00000
//解释：合并数组 = [1,2,3] ，中位数 2
// 
//
// 示例 2： 
//
// 
//输入：nums1 = [1,2], nums2 = [3,4]
//输出：2.50000
//解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
// 
//
// 示例 3： 
//
// 
//输入：nums1 = [0,0], nums2 = [0,0]
//输出：0.00000
// 
//
// 示例 4： 
//
// 
//输入：nums1 = [], nums2 = [1]
//输出：1.00000
// 
//
// 示例 5： 
//
// 
//输入：nums1 = [2], nums2 = []
//输出：2.00000
// 
//
// 
//
// 提示： 
//
// 
// nums1.length == m 
// nums2.length == n 
// 0 <= m <= 1000 
// 0 <= n <= 1000 
// 1 <= m + n <= 2000 
// -10⁶ <= nums1[i], nums2[i] <= 10⁶ 
// 
// Related Topics 数组 二分查找 分治 👍 4911 👎 0

//Java：4.寻找两个正序数组的中位数
public class MedianOfTwoSortedArrays{
    public static void main(String[] args) {
        Solution solution = new MedianOfTwoSortedArrays().new Solution();
        // TO TEST
        int[] a1 = {1,2};
        int[] a2 = {3,4};
        System.out.println(solution.findMedianSortedArrays(a1,a2));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            int n1 = nums1.length;
            int n2 = nums2.length;

            if (n1==0){
                int i = (n2-1)/2;
                if (n2%2==0){
                    double ans = (nums2[i]+nums2[i+1])/2.0;
                    return ans;
                }
                else {
                    double ans = nums2[i];
                    return ans;
                }
            }
            else if (n2==0){
                int i = (n1-1)/2;
                if (n1%2==0){
                    double ans = (nums1[i]+nums1[i+1])/2.0;
                    return ans;
                }
                else {
                    double ans = nums1[i];
                    return ans;
                }
            }
            else {
                int i = (n1+n2-1)/2;
                double ans = 0;
                int count = 0;
                if ((n1+n2)%2==0){
                    int left = 0;
                    int right = 0;
                    while (count<=i){
                        if (left<n1&&right<n2){
                            if (nums1[left]<nums2[right]){
                                ans = nums1[left];
                                left++;
                            }
                            else {
                                ans = nums2[right];
                                right++;
                            }
                        }
                        else if (left==n1){
                            ans = nums2[right];
                            right++;
                        }
                        else if (right==n2){
                            ans = nums1[left];
                            left++;
                        }
                        count++;
                    }
                    if (left==n1){
                        ans = (ans+nums2[right])/2.0;
                    }
                    else if (right==n2){
                        ans = (ans+nums1[left])/2.0;
                    }
                    else {
                        if (nums1[left]<nums2[right]){
                            ans = (ans+nums1[left])/2.0;
                        }
                        else {
                            ans = (ans+nums2[right])/2.0;
                        }
                    }
                    return ans;
                }
                else {
                    int left = 0;
                    int right = 0;
                    while (count<=i){
                        if (left<n1&&right<n2){
                            if (nums1[left]<nums2[right]){
                                ans = nums1[left];
                                left++;
                            }
                            else {
                                ans = nums2[right];
                                right++;
                            }
                        }
                        else if (left==n1){
                            ans = nums2[right];
                            right++;
                        }
                        else if (right==n2){
                            ans = nums1[left];
                            left++;
                        }
                        count++;
                    }
                    return ans;
                }
            }
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

}
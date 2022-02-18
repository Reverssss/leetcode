package editor.cn;//给你一个整数数组 arr ，请使用 煎饼翻转 完成对数组的排序。
//
// 一次煎饼翻转的执行过程如下： 
//
// 
// 选择一个整数 k ，1 <= k <= arr.length 
// 反转子数组 arr[0...k-1]（下标从 0 开始） 
// 
//
// 例如，arr = [3,2,1,4] ，选择 k = 3 进行一次煎饼翻转，反转子数组 [3,2,1] ，得到 arr = [1,2,3,4] 。 
//
// 以数组形式返回能使 arr 有序的煎饼翻转操作所对应的 k 值序列。任何将数组排序且翻转次数在 10 * arr.length 范围内的有效答案都将被判断
//为正确。 
//
// 
//
// 示例 1： 
//
// 
//输入：[3,2,4,1]
//输出：[4,2,4,3]
//解释：
//我们执行 4 次煎饼翻转，k 值分别为 4，2，4，和 3。
//初始状态 arr = [3, 2, 4, 1]
//第一次翻转后（k = 4）：arr = [1, 4, 2, 3]
//第二次翻转后（k = 2）：arr = [4, 1, 2, 3]
//第三次翻转后（k = 4）：arr = [3, 2, 1, 4]
//第四次翻转后（k = 3）：arr = [1, 2, 3, 4]，此时已完成排序。 
// 
//
// 示例 2： 
//
// 
//输入：[1,2,3]
//输出：[]
//解释：
//输入已经排序，因此不需要翻转任何内容。
//请注意，其他可能的答案，如 [3，3] ，也将被判断为正确。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= arr.length <= 100 
// 1 <= arr[i] <= arr.length 
// arr 中的所有整数互不相同（即，arr 是从 1 到 arr.length 整数的一个排列） 
// 
// Related Topics 贪心 数组 双指针 排序 👍 135 👎 0

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

//Java：|969|煎饼排序|PancakeSorting|
public class PancakeSorting{
    public static void main(String[] args) {
        Solution solution = new PancakeSorting().new Solution();
        // TO TEST
        for(Integer temp : solution.pancakeSort(new int[]{3,2,4,1})){
            System.out.print(temp + " ");
        }
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        int[] num;
    public List<Integer> pancakeSort(int[] arr) {
        ArrayList<Integer> ans = new ArrayList<>();
        num = new int[arr.length+1];
        for(int i = 0 ; i < arr.length ; i++){
            num[arr[i]] = i+1;
        }

        for(int i = num.length; i >1 ;i--){
            ans.add(num[i-1]);
            ans.add(i-1);
            reverse(num[i-1]);
            reverse(i-1);
        }

        return ans;
    }

    public void reverse(int k){
        for(int i = 1 ; i < num.length ; i++){
            if(num[i] <= k ) {
                num[i] = 1+k-num[i];
            }
        }
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}
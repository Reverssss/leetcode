package editor.cn;//输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
//
// 
//
// 示例 1： 
//
// 输入：arr = [3,2,1], k = 2
//输出：[1,2] 或者 [2,1]
// 
//
// 示例 2： 
//
// 输入：arr = [0,1,2,1], k = 1
//输出：[0] 
//
// 
//
// 限制： 
//
// 
// 0 <= k <= arr.length <= 10000 
// 0 <= arr[i] <= 10000 
// 
//
// Related Topics 数组 分治 快速选择 排序 堆（优先队列） 👍 519 👎 0

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

//Java：|剑指 Offer 40|最小的k个数|ZuiXiaoDeKgeShuLcof|
public class ZuiXiaoDeKgeShuLcof{
    public static void main(String[] args) {
        Solution solution = new ZuiXiaoDeKgeShuLcof().new Solution();
        // TO TEST
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] getLeastNumbers(int[] arr, int k) {
        PriorityQueue priorityQueue = new PriorityQueue();
        for(int i : arr)
            priorityQueue.add(i);
        int[] res = new int[k];
        for(int i = 0 ; i < k ; i++){
            res[i] = (int)priorityQueue.poll();
        }
        return res;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
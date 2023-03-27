package editor.cn;//返回所有长度为 n 且满足其每两个连续位上的数字之间的差的绝对值为 k 的 非负整数 。
//
// 请注意，除了 数字 0 本身之外，答案中的每个数字都 不能 有前导零。例如，01 有一个前导零，所以是无效的；但 0 是有效的。 
//
// 你可以按 任何顺序 返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3, k = 7
//输出：[181,292,707,818,929]
//解释：注意，070 不是一个有效的数字，因为它有前导零。
// 
//
// 示例 2： 
//
// 
//输入：n = 2, k = 1
//输出：[10,12,21,23,32,34,43,45,54,56,65,67,76,78,87,89,98] 
//
// 示例 3： 
//
// 
//输入：n = 2, k = 0
//输出：[11,22,33,44,55,66,77,88,99]
// 
//
// 示例 4： 
//
// 
//输入：n = 2, k = 2
//输出：[13,20,24,31,35,42,46,53,57,64,68,75,79,86,97]
// 
//
// 
//
// 提示： 
//
// 
// 2 <= n <= 9 
// 0 <= k <= 9 
// 
//
// Related Topics 广度优先搜索 回溯 👍 90 👎 0

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;

//Java：|967|连续差相同的数字|NumbersWithSameConsecutiveDifferences|
public class NumbersWithSameConsecutiveDifferences{
    public static void main(String[] args) {
        Solution solution = new NumbersWithSameConsecutiveDifferences().new Solution();
        // TO TEST
        for(int num : solution.numsSameConsecDiff(3,7)){
            System.out.print(num + ",");
        }
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] numsSameConsecDiff(int n, int k) {
        ArrayList<Integer> ans = new ArrayList();

        for(int i = 1 ; i <= 9 ; i++){
            LinkedList<Integer> linkedList = new LinkedList<>();
            linkedList.add(i);

            for(int j = 1 ; j < n ; j++) {
                if(linkedList.size()==0)
                    break;
                int pow = Double.valueOf(Math.pow(10, j)).intValue();
                while ( linkedList.getFirst()/ pow == 0) {
                    int num = linkedList.getFirst();
                    linkedList.removeFirst();

                    if(k == 0){
                        linkedList.add(num * 10 + num % 10);
                    }else {
                        if (num % 10 - k >= 0) {
                            linkedList.add(num * 10 + num % 10 - k);
                        }
                        if (num % 10 + k < 10) {
                            linkedList.add(num * 10 + num % 10 + k);
                        }
                    }

                    if(linkedList.isEmpty())
                        break;
                }
            }

            for(Integer num : linkedList){
                ans.add(num);
            }
        }

        int[] a = new int[ans.size()];
        for(int i = 0 ; i<ans.size();i++){
            a[i] = ans.get(i);
        }
        return a;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
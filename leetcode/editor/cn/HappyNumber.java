package editor.cn;//编写一个算法来判断一个数 n 是不是快乐数。
//
// 「快乐数」 定义为： 
//
// 
// 对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和。 
// 然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。 
// 如果这个过程 结果为 1，那么这个数就是快乐数。 
// 
//
// 如果 n 是 快乐数 就返回 true ；不是，则返回 false 。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 19
//输出：true
//解释：
//1² + 9² = 82
//8² + 2² = 68
//6² + 8² = 100
//1² + 0² + 0² = 1
// 
//
// 示例 2： 
//
// 
//输入：n = 2
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 2³¹ - 1 
// 
//
// Related Topics 哈希表 数学 双指针 👍 1185 👎 0

import java.util.HashMap;

//Java：|202|快乐数|HappyNumber|
public class HappyNumber{
    public static void main(String[] args) {
        Solution solution = new HappyNumber().new Solution();
        // TO TEST
        System.out.println(solution.isHappy(2));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isHappy(int n) {
        HashMap<Integer,Integer> map = new HashMap<>(){{
            put(1,1);
            put(2,4);
            put(3,9);
            put(4,16);
            put(5,25);
            put(6,36);
            put(7,49);
            put(8,64);
            put(9,81);
            put(0,0);
        }};

        int times = 0;
        int sum = -1;
        while (sum != 1){

            if(times > 8){
                return false;
            }
            if(sum != -1){
                n = sum;
                sum = 0;
            }else {
                sum = 0;
            }

            while (n != 0) {
                sum += map.get(n % 10);
                n /= 10;
            }
            times++;
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
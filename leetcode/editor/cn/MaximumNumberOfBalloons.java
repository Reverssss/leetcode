package editor.cn;//给你一个字符串 text，你需要使用 text 中的字母来拼凑尽可能多的单词 "balloon"（气球）。
//
// 字符串 text 中的每个字母最多只能被使用一次。请你返回最多可以拼凑出多少个单词 "balloon"。 
//
// 
//
// 示例 1： 
//
// 
//
// 输入：text = "nlaebolko"
//输出：1
// 
//
// 示例 2： 
//
// 
//
// 输入：text = "loonbalxballpoon"
//输出：2
// 
//
// 示例 3： 
//
// 输入：text = "leetcode"
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= text.length <= 10^4 
// text 全部由小写英文字母组成 
// 
// Related Topics 哈希表 字符串 计数 👍 59 👎 0

//Java：|1189|“气球” 的最大数量|MaximumNumberOfBalloons|
public class MaximumNumberOfBalloons{
    public static void main(String[] args) {
        Solution solution = new MaximumNumberOfBalloons().new Solution();
        // TO TEST
        System.out.println(solution.maxNumberOfBalloons("balon"));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxNumberOfBalloons(String text) {
        int[] num = new int[5];// 0b 1a 2l 3o 4n
        for(char i : text.toCharArray()){
            if(i == 'b')
                num[0]++;
            if(i == 'a')
                num[1]++;
            if(i == 'l')
                num[2]++;
            if(i == 'o')
                num[3]++;
            if(i == 'n')
                num[4]++;
        }
        int ans = Math.min(Math.min(num[0],num[1]),Math.min(Math.min(num[2]/2,num[3]/2),num[4]));
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
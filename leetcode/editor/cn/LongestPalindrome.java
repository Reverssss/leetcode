package editor.cn;//给定一个包含大写字母和小写字母的字符串
// s ，返回 通过这些字母构造成的 最长的回文串 。 
//
// 在构造过程中，请注意 区分大小写 。比如 "Aa" 不能当做一个回文字符串。 
//
// 
//
// 示例 1: 
//
// 
//输入:s = "abccccdd"
//输出:7
//解释:
//我们可以构造的最长的回文串是"dccaccd", 它的长度是 7。
// 
//
// 示例 2: 
//
// 
//输入:s = "a"
//输出:1
// 
//
// 示例 3： 
//
// 
//输入:s = "aaaaaccc"
//输出:7 
//
// 
//
// 提示: 
//
// 
// 1 <= s.length <= 2000 
// s 只由小写 和/或 大写英文字母组成 
// 
//
// Related Topics 贪心 哈希表 字符串 👍 503 👎 0

import java.util.HashMap;

//Java：|409|最长回文串|LongestPalindrome|
public class LongestPalindrome{
    public static void main(String[] args) {
        Solution solution = new LongestPalindrome().new Solution();
        // TO TEST
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int longestPalindrome(String s) {

        HashMap<Character,Integer> map = new HashMap<>();

        for(int i = 0 ; i < s.length() ; i++){
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
        }

        int res = 0;
        boolean single = false;
        for(char i : map.keySet()){
            int times = map.get(i);
            if(times % 2 == 1)
                single = true;
            res += times/2;
        }
        if(single){
            return 2*res+1;
        }else {
            return 2*res;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
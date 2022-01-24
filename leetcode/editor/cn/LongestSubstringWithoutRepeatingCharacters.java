package editor.cn;//给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
//
// 
//
// 示例 1: 
//
// 
//输入: s = "abcabcbb"
//输出: 3 
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
// 
//
// 示例 2: 
//
// 
//输入: s = "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
// 
//
// 示例 3: 
//
// 
//输入: s = "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
// 
//
// 示例 4: 
//
// 
//输入: s = ""
//输出: 0
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 5 * 10⁴ 
// s 由英文字母、数字、符号和空格组成 
// 
// Related Topics 哈希表 字符串 滑动窗口 👍 6807 👎 0

import java.util.Scanner;

//Java：无重复字符的最长子串
public class LongestSubstringWithoutRepeatingCharacters{
    public static void main(String[] args) {
        System.out.println("Java：无重复字符的最长子串");
        Solution solution = new LongestSubstringWithoutRepeatingCharacters().new Solution();
        Scanner sc = new Scanner(System.in);
        String n = sc.nextLine();
        int s = solution.lengthOfLongestSubstring(n);
        System.out.println(s);
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if("".equals(s)){
            return 0;
        }
        int length = s.length();

        int[] len = new int[length];
        for(int i = 0 ; i < length ; i++){
            len[i] = 99999;
            for(int j = 1; i+j < length ; j++) {
                if (s.charAt(i) == s.charAt(i+j)) {
                    len[i] = j;
                    break;
                }
            }
        }

        boolean flags;
        for(int i = length ; i > 0; i--){//i子串长度
            for(int j = 0; i+j <= length ; j++){//j子串位置
                flags = false;
                for(int k = 0; k < i ; k++){//子串中字符距开头位置
                    if(len[j + k] + k < i){
                        flags = true;
                        break;
                    }
                }
                if(flags == false){
                    return i;
                }
            }
        }
        return length;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
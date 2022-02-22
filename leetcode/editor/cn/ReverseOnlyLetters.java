package editor.cn;//给你一个字符串 s ，根据下述规则反转字符串：
//
// 
// 所有非英文字母保留在原有位置。 
// 所有英文字母（小写或大写）位置反转。 
// 
//
// 返回反转后的 s 。 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 
//输入：s = "ab-cd"
//输出："dc-ba"
// 
//
// 
// 
//
// 示例 2： 
//
// 
//输入：s = "a-bC-dEf-ghIj"
//输出："j-Ih-gfE-dCba"
// 
//
// 
// 
//
// 示例 3： 
//
// 
//输入：s = "Test1ng-Leet=code-Q!"
//输出："Qedo1ct-eeLg=ntse-T!"
// 
//
// 
//
// 提示 
//
// 
// 1 <= s.length <= 100 
// s 仅由 ASCII 值在范围 [33, 122] 的字符组成 
// s 不含 '\"' 或 '\\' 
// 
// Related Topics 双指针 字符串 👍 103 👎 0

//Java：|917|仅仅反转字母|ReverseOnlyLetters|
public class ReverseOnlyLetters{
    public static void main(String[] args) {
        Solution solution = new ReverseOnlyLetters().new Solution();
        // TO TEST
        System.out.println(solution.reverseOnlyLetters("7_28]"));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String reverseOnlyLetters(String s) {
        char[] ans = new char[s.length()];
        int left = 0 ;
        int right = s.length()-1;
        loop:
        while (left <= right){
            while (s.charAt(left) > 'z'  || s.charAt(left) < 'A' || (s.charAt(left) > 'Z' && s.charAt(left) < 'a')){
                ans[left] = s.charAt(left);
                if(left + 1 < s.length()) {
                    left++;
                }else{
                    break loop;
                }
            }
            while (s.charAt(right) > 'z'  || s.charAt(right) < 'A' || (s.charAt(right) > 'Z' && s.charAt(right) < 'a')){
                ans[right] = s.charAt(right);
                if(right - 1 >= 0) {
                    right--;
                }else {
                    break;
                }
            }
            ans[left] = s.charAt(right);
            ans[right] = s.charAt(left);
            left++;
            right--;
        }

        return new String(ans);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
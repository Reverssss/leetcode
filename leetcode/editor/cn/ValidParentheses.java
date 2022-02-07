package editor.cn;//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
//
// 有效字符串需满足： 
//
// 
// 左括号必须用相同类型的右括号闭合。 
// 左括号必须以正确的顺序闭合。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "()"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：s = "()[]{}"
//输出：true
// 
//
// 示例 3： 
//
// 
//输入：s = "(]"
//输出：false
// 
//
// 示例 4： 
//
// 
//输入：s = "([)]"
//输出：false
// 
//
// 示例 5： 
//
// 
//输入：s = "{[]}"
//输出：true 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 10⁴ 
// s 仅由括号 '()[]{}' 组成 
// 
// Related Topics 栈 字符串 👍 2948 👎 0

import java.util.ArrayList;
import java.util.Stack;

//Java：|20|有效的括号|ValidParentheses|
public class ValidParentheses{
    public static void main(String[] args) {
        Solution solution = new ValidParentheses().new Solution();
        // TO TEST
        System.out.println(solution.isValid("]"));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        try {
            for (char temp : s.toCharArray()) {
                if (temp == '(' || temp == '{' || temp == '[') {
                    stack.add(temp);
                } else if (temp == ')' && stack.pop() == '(') {

                } else if (temp == ']' && stack.pop() == '[') {

                } else if (temp == '}' && stack.pop() == '{') {

                } else {
                    return false;
                }
            }
        }catch (Exception e){
            return false;
        }
        if(stack.size() != 0)
            return false;
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
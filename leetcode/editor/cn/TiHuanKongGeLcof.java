package editor.cn;//请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
//
// 
//
// 示例 1： 
//
// 输入：s = "We are happy."
//输出："We%20are%20happy." 
//
// 
//
// 限制： 
//
// 0 <= s 的长度 <= 10000 
//
// Related Topics 字符串 👍 398 👎 0

//Java：|剑指 Offer 05|替换空格|TiHuanKongGeLcof|
public class TiHuanKongGeLcof{
    public static void main(String[] args) {
        Solution solution = new TiHuanKongGeLcof().new Solution();
        // TO TEST
        System.out.println(solution.replaceSpace("We are happy."));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String replaceSpace(String s) {
        s = s.replaceAll(" ","%20");
        return s;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
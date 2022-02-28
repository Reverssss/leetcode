package editor.cn;//将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
//
// 比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下： 
//
// 
//P   A   H   N
//A P L S I I G
//Y   I   R 
//
// 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。 
//
// 请你实现这个将字符串进行指定行数变换的函数： 
//
// 
//string convert(string s, int numRows); 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "PAYPALISHIRING", numRows = 3
//输出："PAHNAPLSIIGYIR"
// 
//示例 2：
//
// 
//输入：s = "PAYPALISHIRING", numRows = 4
//输出："PINALSIGYAHRPI"
//解释：
//P     I    N
//A   L S  I G
//Y A   H R
//P     I
// 
//
// 示例 3： 
//
// 
//输入：s = "A", numRows = 1
//输出："A"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 由英文字母（小写和大写）、',' 和 '.' 组成 
// 1 <= numRows <= 1000 
// 
// Related Topics 字符串 👍 1500 👎 0

//Java：|6|Z 字形变换|ZigzagConversion|
public class ZigzagConversion{
    public static void main(String[] args) {
        Solution solution = new ZigzagConversion().new Solution();
        // TO TEST
        System.out.println(solution.convert("A",1));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        private StringBuilder ans;
        int len;
        String s;

        public String convert(String s, int numRows) {
            if(numRows == 1)
                return s;
            this.s = s;
            len = s.length();
            int times = len / (numRows * 2 - 2) + 1;
            ans = new StringBuilder();
            for (int i = 0; i < numRows; i++) {
                for (int j = 0; j < times; j++) {
                    if (i == 0) {
                        include((numRows * 2 - 2) * j);
                    } else if (i == numRows - 1) {
                        include((numRows * 2 - 2) * j + numRows - 1);
                    } else {
                        include((numRows * 2 - 2) * j + i);
                        include((numRows * 2 - 2) * (j + 1) - i);
                    }
                }
            }
            return ans.toString();
        }

        private void include(int num){
            if(num < len){
                ans.append(s.charAt(num));
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
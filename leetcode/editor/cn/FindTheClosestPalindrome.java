package editor.cn;//给定一个表示整数的字符串 n ，返回与它最近的回文整数（不包括自身）。如果不止一个，返回较小的那个。
//
// “最近的”定义为两个整数差的绝对值最小。 
//
// 
//
// 示例 1: 
//
// 
//输入: n = "123"
//输出: "121"
// 
//
// 示例 2: 
//
// 
//输入: n = "1"
//输出: "0"
//解释: 0 和 2是最近的回文，但我们返回最小的，也就是 0。
// 
//
// 
//
// 提示: 
//
// 
// 1 <= n.length <= 18 
// n 只由数字组成 
// n 不含前导 0 
// n 代表在 [1, 10¹⁸ - 1] 范围内的整数 
// 
// Related Topics 数学 字符串 👍 113 👎 0

//Java：|564|寻找最近的回文数|FindTheClosestPalindrome|
public class FindTheClosestPalindrome {
    public static void main(String[] args) {
        Solution solution = new FindTheClosestPalindrome().new Solution();
        // TO TEST
        System.out.println(solution.nearestPalindromic("88"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String nearestPalindromic(String n) {
            if (n == null)
                return null;
            if (n.length() == 1)
                return n.charAt(0) > '0' ? String.valueOf(Integer.parseInt(n) - 1) : "0";

            int len = n.length();
            Double[] maybeAnsList = new Double[5];
            Double number = Double.parseDouble(n);


            if (len % 2 == 1) {
                StringBuilder str1 = new StringBuilder(n.substring(0, len / 2 + 1));
                maybeAnsList[0] = (Double.parseDouble(new String(str1))) * (int) Math.pow(10, len / 2) + Integer.parseInt(String.valueOf(str1.reverse().substring(1,str1.length())));
                str1.reverse();
                str1 = new StringBuilder(String.valueOf(Integer.valueOf(String.valueOf(str1)) + 1));
                maybeAnsList[1] = (Double.parseDouble(new String(str1))) * (int) Math.pow(10, len / 2) + Integer.parseInt(String.valueOf(str1.reverse().substring(1,str1.length())));
                str1.reverse();
                str1 = new StringBuilder(String.valueOf(Integer.valueOf(String.valueOf(str1)) - 2));
                if(str1.length() > len/2){
                    maybeAnsList[2] = (Double.parseDouble(new String(str1))) * (int) Math.pow(10, len / 2) + Integer.parseInt(String.valueOf(str1.reverse().substring(1,str1.length())));
                }else {
                    maybeAnsList[2] = Double.MAX_VALUE;
                }
            } else {
                StringBuilder str1 = new StringBuilder(n.substring(0, len / 2));
                maybeAnsList[0] = Double.parseDouble(new String(str1)) * Math.pow(10, len / 2) + Integer.parseInt(String.valueOf(str1.reverse()));
                str1.reverse();
                str1 = new StringBuilder(String.valueOf(Integer.valueOf(String.valueOf(str1)) + 1));
                maybeAnsList[1] = Double.parseDouble(new String(str1)) * Math.pow(10, len / 2) + Integer.parseInt(String.valueOf(str1.reverse()));
                str1.reverse();
                str1 = new StringBuilder(String.valueOf(Integer.valueOf(String.valueOf(str1)) - 2));
                if(str1.length() >= len/2){
                    maybeAnsList[2] = Double.parseDouble(new String(str1)) * Math.pow(10, len / 2) + Integer.parseInt(String.valueOf(str1.reverse()));
                }else {
                    maybeAnsList[2] = Double.MAX_VALUE;
                }
            }
            maybeAnsList[3] = 9.0;
            for (int i = 0; i < len - 2; i++) {
                maybeAnsList[3] = maybeAnsList[3] * 10 + 9;
            }
            maybeAnsList[4] = 1.0;
            for (int i = 0; i < len; i++) {
                maybeAnsList[4] = maybeAnsList[4] * 10;
            }
            maybeAnsList[4] += 1;

            double min = Double.MAX_VALUE;
            Double ans = 0.0;
            for (int i = 0; i < 5; i++) {
                if (Math.abs(maybeAnsList[i] - number) < min && Math.abs(maybeAnsList[i] - number) > 0 && maybeAnsList[i] != number) {
                    min = Math.abs(maybeAnsList[i] - number);
                    ans = maybeAnsList[i];
                }else if(Math.abs(maybeAnsList[i] - number) == min && maybeAnsList[i] != number &&maybeAnsList[i] < ans){
                    min = Math.abs(maybeAnsList[i] - number);
                    ans = maybeAnsList[i];
                }
            }

            return String.valueOf(ans.intValue());
        }


    }


//leetcode submit region end(Prohibit modification and deletion)
}
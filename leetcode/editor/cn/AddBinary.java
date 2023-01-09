package editor.cn;//给你两个二进制字符串 a 和 b ，以二进制字符串的形式返回它们的和。
//
//
//
// 示例 1：
//
//
//输入:a = "11", b = "1"
//输出："100"
//
// 示例 2：
//
//
//输入：a = "1010", b = "1011"
//输出："10101"
//
//
//
// 提示：
//
//
// 1 <= a.length, b.length <= 10⁴
// a 和 b 仅由字符 '0' 或 '1' 组成
// 字符串如果不是 "0" ，就不含前导零
//
//
// Related Topics 位运算 数学 字符串 模拟 👍 935 👎 0

import java.util.ArrayList;

//Java：|67|二进制求和|AddBinary|
public class AddBinary {
    public static void main(String[] args) {
        Solution solution = new AddBinary().new Solution();
        // TO TEST
        String a = "101111";
        String b = "10";
        System.out.println(solution.addBinary(a,b));
        //110111101100010011000101110110100000011101000101011001000011011000001100011110011010010011000000000
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String addBinary(String a, String b) {
            if(a.length() < b.length()){
                String temp = b;
                b = a;
                a = temp;
            }

            String a1;
            String a2;
            if(a.length() == b.length()) {
                a1 = "";
                a2 = a.substring(0, b.length());
            }else {
                a1 = a.substring(0, a.length()-b.length());
                a2 = a.substring(a.length()-b.length(), a.length());
            }
            int a1Length = a1.length();

            char[] sum = new char[a.length()+1];
            sum[a.length()] = '0';
            for(int i= b.length()-1;i>=0;i-- ){
                int bit = Character.getNumericValue(sum[a1Length+i+1]);
                if(a2.charAt(i) == '1')
                    bit++;
                if(b.charAt(i) == '1')
                    bit++;
                if(bit == 3){
                    sum[a1Length+i] = '1';
                    sum[a1Length+i+1] = '1';
                }else if(bit == 2){
                    sum[a1Length+i] = '1';
                    sum[a1Length+i+1] = '0';
                }else if (bit == 1){
                    sum[a1Length+i] = '0';
                    sum[a1Length+i+1] = '1';
                }else {
                    sum[a1Length+i] = '0';
                    sum[a1Length+i+1] = '0';
                }
            }

            for(int i = a1.length()-1;i>=0;i--){
                int bit = 0;
                if(sum[i+1] == '1')
                    bit++;
                if(a1.charAt(i) == '1')
                    bit++;
                if(bit==2){
                    sum[i+1] = '0';
                    sum[i] = '1';
                }else if (bit==1){
                    sum[i+1] = '1';
                    sum[i] = '0';
                }else {
                    sum[i+1] = '0';
                    sum[i] = '0';
                }
            }
            int split;
            for(split = 0 ; split < sum.length ; split++){
                if(sum[split] == '1'){
                    break;
                }
            }
            if(split == 0)
                return String.valueOf(sum);
            if(split == sum.length)
                return "0";

            String sumSub = String.valueOf(sum).substring(split,sum.length);
            if(sumSub == null){
                return "0";
            }else {
                return sumSub;
            }


        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
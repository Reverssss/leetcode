package editor.cn;//给你一个非负整数 x ，计算并返回 x 的 算术平方根 。
//
// 由于返回类型是整数，结果只保留 整数部分 ，小数部分将被 舍去 。 
//
// 注意：不允许使用任何内置指数函数和算符，例如 pow(x, 0.5) 或者 x ** 0.5 。 
//
// 
//
// 示例 1： 
//
// 
//输入：x = 4
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：x = 8
//输出：2
//解释：8 的算术平方根是 2.82842..., 由于返回类型是整数，小数部分将被舍去。
// 
//
// 
//
// 提示： 
//
// 
// 0 <= x <= 2³¹ - 1 
// 
// Related Topics 数学 二分查找 👍 871 👎 0

import java.util.Scanner;

//Java：Sqrt(x)
public class Sqrtx{
    public static void main(String[] args) {
        System.out.println("Java：Sqrt(x)");
        Solution solution = new Sqrtx().new Solution();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int s = solution.mySqrt(n);
        System.out.println(s);
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int mySqrt(int x) {
        long i;
        if(x == 1)
            return 1;
        for(i = x/2 ;i > 1 ; i = i/2){
            if(i*i<= x)
                break;
        }
        while(i*i <= x){
            if((i+1)*(i+1) > x) {
                return (int)i;
            }else{
                i++;
            }
        }
        return 0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
}
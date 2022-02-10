package editor.cn;//给你一个整数 n ，请你返回所有 0 到 1 之间（不包括 0 和 1）满足分母小于等于 n 的 最简 分数 。分数可以以 任意 顺序返回。
//
// 
//
// 示例 1： 
//
// 输入：n = 2
//输出：["1/2"]
//解释："1/2" 是唯一一个分母小于等于 2 的最简分数。 
//
// 示例 2： 
//
// 输入：n = 3
//输出：["1/2","1/3","2/3"]
// 
//
// 示例 3： 
//
// 输入：n = 4
//输出：["1/2","1/3","1/4","2/3","3/4"]
//解释："2/4" 不是最简分数，因为它可以化简为 "1/2" 。 
//
// 示例 4： 
//
// 输入：n = 1
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 100 
// 
// Related Topics 数学 字符串 数论 👍 65 👎 0

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

//Java：|1447|最简分数|SimplifiedFractions|
public class SimplifiedFractions{
    public static void main(String[] args) {
        Solution solution = new SimplifiedFractions().new Solution();
        // TO TEST
        for(String temp :  solution.simplifiedFractions(6)){
            System.out.println(temp);
        }
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> simplifiedFractions(int n) {
        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();
        List<String> ans = new ArrayList<>();

        for(int i = 1; i <= n ; i++){//分母
            int temp = i;
            for(int j = i/2 ; j > 1 ; j--){
                if(temp%j == 0){
                    temp /= j;
                    HashSet<Integer> tempSet = map.getOrDefault(i, new HashSet<>());
                    tempSet.add(j);
                    tempSet.addAll(map.getOrDefault(j,new HashSet<>()));
                    map.put(i,map.getOrDefault(i,tempSet));
                }
            }

            for(int j = 1 ; j < i ; j ++){
                Boolean flag = true;
                for(Integer k :map.getOrDefault(i,new HashSet<>())){
                    if(j%k == 0)
                        flag = false;
                }
                if(flag) {
                    ans.add(j + "/" + i);
                }
            }

        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
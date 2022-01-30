package editor.cn;//句子 是一串由空格分隔的单词。每个 单词 仅由小写字母组成。
//
// 如果某个单词在其中一个句子中恰好出现一次，在另一个句子中却 没有出现 ，那么这个单词就是 不常见的 。 
//
// 给你两个 句子 s1 和 s2 ，返回所有 不常用单词 的列表。返回列表中单词可以按 任意顺序 组织。 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 
//输入：s1 = "this apple is sweet", s2 = "this apple is sour"
//输出：["sweet","sour"]
// 
//
// 示例 2： 
//
// 
//输入：s1 = "apple apple", s2 = "banana"
//输出：["banana"]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s1.length, s2.length <= 200 
// s1 和 s2 由小写英文字母和空格组成 
// s1 和 s2 都不含前导或尾随空格 
// s1 和 s2 中的所有单词间均由单个空格分隔 
// 
// Related Topics 哈希表 字符串 👍 132 👎 0

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

//Java：|884|两句话中的不常见单词|UncommonWordsFromTwoSentences|
public class UncommonWordsFromTwoSentences{
    public static void main(String[] args) {
        Solution solution = new UncommonWordsFromTwoSentences().new Solution();
        // TO TEST

        String s1 = "this apple is sweet";
        String s2 = "this apple is sour";
        for(String temp : solution.uncommonFromSentences(s1,s2)){
            System.out.println(temp);
        }
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        HashMap<String,Integer> map1 = new HashMap<>();
        HashMap<String,Integer> map2 = new HashMap<>();
        ArrayList<String> list = new ArrayList<>();

        for(String temp : s1.split(" ")){
            map1.put(temp,map1.getOrDefault(temp,0) + 1);
        }
        for(String temp : s2.split(" ")){
            map2.put(temp,map2.getOrDefault(temp,0) + 1);
        }
        for(String temp : map1.keySet()){
            if(map1.get(temp) == 1){
                if(map2.getOrDefault(temp,0) == 0){
                    list.add(temp);
                }else {
                    map2.remove(temp);
                }
            }
        }

        for(String temp : map2.keySet()){
            if(map2.get(temp) == 1){
                if(map1.getOrDefault(temp,0) == 0){
                    list.add(temp);
                }
            }
        }

        return list.toArray(String[]::new);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
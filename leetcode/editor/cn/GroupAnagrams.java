package editor.cn;//给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
//
// 字母异位词 是由重新排列源单词的字母得到的一个新单词，所有源单词中的字母通常恰好只用一次。 
//
// 
//
// 示例 1: 
//
// 
//输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
//输出: [["bat"],["nat","tan"],["ate","eat","tea"]] 
//
// 示例 2: 
//
// 
//输入: strs = [""]
//输出: [[""]]
// 
//
// 示例 3: 
//
// 
//输入: strs = ["a"]
//输出: [["a"]] 
//
// 
//
// 提示： 
//
// 
// 1 <= strs.length <= 10⁴ 
// 0 <= strs[i].length <= 100 
// strs[i] 仅包含小写字母 
// 
//
// Related Topics 数组 哈希表 字符串 排序 👍 1352 👎 0

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//Java：|49|字母异位词分组|GroupAnagrams|
public class GroupAnagrams{
    public static void main(String[] args) {
        Solution solution = new GroupAnagrams().new Solution();
        // TO TEST
        String[] strs = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(solution.groupAnagrams(strs));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            HashMap<String,Integer> map = new HashMap(){
                {
                    put('a',2);put('b',3);put('c',5);put('d',7);put('e',11);put('f',13);put('g',17);put('h',19);
                    put('i',23);put('j',29);put('k',31);put('l',37);put('m',41);put('n',43);put('o',47);put('p',53);
                    put('q',59);put('r',61);put('s',61);put('t',71);put('u',73);put('v',79);put('w',83);put('x',89);
                    put('y',91);put('z',97);
                }
            };

            ArrayList<ArrayList<String>> ans = new ArrayList();

            for(String string : strs){
                Double sum = 0d;
                for(int i = 0 ; i < string.length() ; i++){
                    sum*=map.get(string.charAt(i));
                }
            }



            return null;
        }
    public List<List<String>> groupAnagrams2(String[] strs) {

        java.util.HashMap<String,Integer> hashMap = new HashMap();
        List<List<String>> ans = new ArrayList<List<String>>();

        for(String string : strs){
            int[] strIntArray = new int[26];
            for(int i = 0 ; i < string.length() ; i++){
                strIntArray[string.charAt(i)-'a']++;
            }
            StringBuilder flag = new StringBuilder();
            for(int i = 0 ; i < 10 ; i++){
                flag.append("0" + i);
                flag.append(strIntArray[i]);
            }
            for(int i = 10 ; i < 26 ; i++){
                flag.append(i);
                flag.append(strIntArray[i]);
            }

            if (hashMap.containsKey(flag.toString())){
                ans.get(hashMap.get(flag.toString())).add(string);
            }else {
                List<String> list = new ArrayList<>();
                list.add(string);
                ans.add(hashMap.size(),list);
                hashMap.put(flag.toString(),hashMap.size());
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
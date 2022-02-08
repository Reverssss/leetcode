package editor.cn;//给你两个字符串：ransomNote 和 magazine ，判断 ransomNote 能不能由 magazine 里面的字符构成。
//
// 如果可以，返回 true ；否则返回 false 。 
//
// magazine 中的每个字符只能在 ransomNote 中使用一次。 
//
// 
//
// 示例 1： 
//
// 
//输入：ransomNote = "a", magazine = "b"
//输出：false
// 
//
// 示例 2： 
//
// 
//输入：ransomNote = "aa", magazine = "ab"
//输出：false
// 
//
// 示例 3： 
//
// 
//输入：ransomNote = "aa", magazine = "aab"
//输出：true
// 
//
// 
//
// 提示： 
//
// 
// 1 <= ransomNote.length, magazine.length <= 10⁵ 
// ransomNote 和 magazine 由小写英文字母组成 
// 
// Related Topics 哈希表 字符串 计数 👍 273 👎 0

import java.util.HashMap;
import java.util.HashSet;

//Java：|383|赎金信|RansomNote|
public class RansomNote{
    public static void main(String[] args) {
        Solution solution = new RansomNote().new Solution();
        // TO TEST
        System.out.println(solution.canConstruct("aa","aab"));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character,Integer> map = new HashMap<>();
        for(char temp : magazine.toCharArray()){
            map.put(temp,map.getOrDefault(temp,0)+1);
        }
        for(char temp : ransomNote.toCharArray()){
            if(map.getOrDefault(temp,0) != 0){
                map.put(temp,map.getOrDefault(temp,0)-1);
            }else {
                return false;
            }
        }

        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
package editor.cn;//给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
//
// 
//
// 示例： 
//
// s = "leetcode"
//返回 0
//
//s = "loveleetcode"
//返回 2
// 
//
// 
//
// 提示：你可以假定该字符串只包含小写字母。 
// Related Topics 队列 哈希表 字符串 计数 👍 501 👎 0

import java.util.HashMap;

//Java：|387|字符串中的第一个唯一字符|FirstUniqueCharacterInAString|
public class FirstUniqueCharacterInAString{
    public static void main(String[] args) {
        Solution solution = new FirstUniqueCharacterInAString().new Solution();
        // TO TEST
        System.out.println(solution.firstUniqChar("loveleetcode"));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int firstUniqChar(String s) {
        HashMap<Character,Integer[]> map = new HashMap();//(char,[int 次数,int 位置])
        for(int i = 0 ; i < s.length() ; i++){
            Integer[] number = map.getOrDefault(s.charAt(i),new Integer[]{0,0});
            if(number[0] ==0){
                map.put(s.charAt(i),new Integer[]{1,i});
            }else{
                map.put(s.charAt(i),new Integer[]{number[0]+1,number[1]});
            }
        }

        int min = 99999;
        for(Character temp : map.keySet()){
            Integer[] number = map.getOrDefault(temp,new Integer[]{0,0});
            int frequence = number[0];
            int position = number[1];
            if(frequence == 1 ){
                min = Math.min(min , position);
            }
        }
        return min != 99999 ? min : -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
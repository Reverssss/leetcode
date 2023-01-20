package editor.cn;//给你一个字符串 s，找到 s 中最长的回文子串。
//
// 如果字符串的反序与原始字符串相同，则该字符串称为回文字符串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "babad"
//输出："bab"
//解释："aba" 同样是符合题意的答案。
// 
//
// 示例 2： 
//
// 
//输入：s = "cbbd"
//输出："bb"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 仅由数字和英文字母组成 
// 
//
// Related Topics 字符串 动态规划 👍 6034 👎 0

//Java：|5|最长回文子串|LongestPalindromicSubstring|
public class LongestPalindromicSubstring{
    public static void main(String[] args) {
        Solution solution = new LongestPalindromicSubstring().new Solution();
        // TO TEST
        String s = "babad";
        String s2 = "chbouigbhbytcgiyuygiuhnoijoikjegoikdshngokjhineorsdfoaishdfoiasujdhfsfasojfhbnwbytcgiyuygiuhnoijoikjegoikdshngokjhineorsdfoaishdfoiasujdhfsfasojfhsefwsefgkijhnaoerkjighergsougbyuzhynqvopdbnkvuxizirzjsslptlhmvyfqhqvqffmqldkrrdwapbdcxqbchvxqixmvbbtalrgzvkobyxlkonkfknabjwzeoazankqzuhexhcwkbvwtioubrcujqqeqoedhploqklhgeilwwnndbnzeadzefbytcgiyuygiuhnoijoikjegoikdshngokjhineorsdfoaishdfoiasujdhfsfasojfhkcbytcgiyuygiuhnoijbytcgiyuygiuhnoijoikjegoikdshngokjhineorsdfoaishdfoiasujdhfsfasojfhoikjegoikdshngokjhineorsdfoaishdfoiasujdhfsfasojfhaxdhgnmocadvvzjocoweyoidhleuwhmavpdiizbwkukpstyorlwwyiwwyyyzqqgipzzlxsgcdjscdfvrrrqmllbdjkkuisxeqaprfblvjuixajhucmcvffmevaztvadrujbthlnsdrxzvbldwxbazxmilpkbccigkihcgjbtpvignmrgzdqnufaacxtihfgwrllrwgfhitxcaafunqdzgrmngivptbjgchikgiccbkplimxzabxwdlbvzxrdsnlhtbjurdavtzavemffvcmcuhjaxiujvlbfrpaqexsiukkjdbllmqrrrvfdcsjdcgsxlzzpigqqzyyywwiywwlroytspkukwbziidpvamhwuelhdioyewocojzvvdacomnghdxavckfezdaeznbdnnwwlieghlkqolphdeoqeqqjucrbuoitwvbkwchxehuzqknazaoezwjbankfknoklxybokvzgrlatbbvmxiqxvhcbqxcdbpawdrrkdlqmffqvqhqfyvmhltplssjzrizixuvknbdpovqnyhzu";

        String answer = solution.longestPalindrome(s2);

        long time0 = System.currentTimeMillis();
        for(int i = 0 ; i < 10000 ; i++){
            String answer1 = solution.longestPalindrome(s2);
            if(!answer1.equals(answer)){
                System.out.println("error1");
            }
        }
        long time1 = System.currentTimeMillis();

        long time2 = System.currentTimeMillis();
        for(int i = 0 ; i < 10000 ; i++){
            String answer2 = solution.longestPalindrome2(s2);
            if(!answer2.equals(answer)){
                System.out.println("error2");
            }
        }
        long time3 = System.currentTimeMillis();






        System.out.println(time1-time0);
        System.out.println(time3-time2);
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String longestPalindrome(String s) {
        int[][] word = new int[36][1001];//a-z 0-25; 0-9;26-35;A-Z 36-61;0存放个数
        int answerLength = 0;
        String answer = "";

        for (int i = 0 ; i <s.length() ; i++) {
            char c = s.charAt(i);
            if ('a' <= c && c <= 'z') {
                word[c - 'a'][0]++;
                word[c - 'a'][word[c - 'a'][0]] = i;
            } else if ('0' <= c && c <= '9') {
                word[c - '0' ][0]++;
                word[c - '0' ][word[c - '0' ][0]] = i;
            } else if ('A' <= c && c <= 'Z') {
                word[c - 'A'][0]++;
                word[c - 'A'][word[c - 'A'][0]] = i;
            }
        }

        for(int i = 0 ; i < 36 ; i++){
            if(word[i][0] > 1){
                for(int j = 1 ; j <= word[i][0]; j++){
                    for(int k = word[i][0]; k >=j+1; k--){
                        if(word[i][k]-word[i][j] <= answerLength){
                            continue;
                        }
                        boolean flag =true;
                        for(int len = 1; len <= (word[i][k]-word[i][j])/2;len++){
                            if(s.charAt(word[i][j]+len) != s.charAt(word[i][k]-len)){
                                flag=false;
                                //xaabacxcabaaxcabaax
                            }
                        }
                        if(flag == true){
                            if(word[i][k]-word[i][j] > answerLength){
                                answerLength = word[i][k]-word[i][j];
                                answer = s.substring(word[i][j],word[i][k]+1);
                                break;
                            }
                        }
                    }
                }
            }
        }
        if(answer == "")
            return String.valueOf(s.charAt(0));

        return answer;
    }

        public String longestPalindrome2(String s) {
            int len = s.length();
            if (len < 2) {
                return s;
            }

            int maxLen = 1;
            int begin = 0;
            // dp[i][j] 表示 s[i..j] 是否是回文串
            boolean[][] dp = new boolean[len][len];
            // 初始化：所有长度为 1 的子串都是回文串
            for (int i = 0; i < len; i++) {
                dp[i][i] = true;
            }

            char[] charArray = s.toCharArray();
            // 递推开始
            // 先枚举子串长度
            for (int L = 2; L <= len; L++) {
                // 枚举左边界，左边界的上限设置可以宽松一些
                for (int i = 0; i < len; i++) {
                    // 由 L 和 i 可以确定右边界，即 j - i + 1 = L 得
                    int j = L + i - 1;
                    // 如果右边界越界，就可以退出当前循环
                    if (j >= len) {
                        break;
                    }

                    if (charArray[i] != charArray[j]) {
                        dp[i][j] = false;
                    } else {
                        if (j - i < 3) {
                            dp[i][j] = true;
                        } else {
                            dp[i][j] = dp[i + 1][j - 1];
                        }
                    }

                    // 只要 dp[i][L] == true 成立，就表示子串 s[i..L] 是回文，此时记录回文长度和起始位置
                    if (dp[i][j] && j - i + 1 > maxLen) {
                        maxLen = j - i + 1;
                        begin = i;
                    }
                }
            }
            return s.substring(begin, begin + maxLen);
        }

}
//leetcode submit region end(Prohibit modification and deletion)

}
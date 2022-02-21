package editor.cn;//一行中有 N 张多米诺骨牌，我们将每张多米诺骨牌垂直竖立。
//
// 在开始时，我们同时把一些多米诺骨牌向左或向右推。 
//
// 
//
// 每过一秒，倒向左边的多米诺骨牌会推动其左侧相邻的多米诺骨牌。 
//
// 同样地，倒向右边的多米诺骨牌也会推动竖立在其右侧的相邻多米诺骨牌。 
//
// 如果同时有多米诺骨牌落在一张垂直竖立的多米诺骨牌的两边，由于受力平衡， 该骨牌仍然保持不变。 
//
// 就这个问题而言，我们会认为正在下降的多米诺骨牌不会对其它正在下降或已经下降的多米诺骨牌施加额外的力。 
//
// 给定表示初始状态的字符串 "S" 。如果第 i 张多米诺骨牌被推向左边，则 S[i] = 'L'；如果第 i 张多米诺骨牌被推向右边，则 S[i] = 
//'R'；如果第 i 张多米诺骨牌没有被推动，则 S[i] = '.'。 
//
// 返回表示最终状态的字符串。 
//
// 示例 1： 
//
// 输入：".L.R...LR..L.."
//输出："LL.RR.LLRRLL.." 
//
// 示例 2： 
//
// 输入："RR.L"
//输出："RR.L"
//说明：第一张多米诺骨牌没有给第二张施加额外的力。 
//
// 提示： 
//
// 
// 0 <= N <= 10^5 
// 表示多米诺骨牌状态的字符串只含有 'L'，'R'; 以及 '.'; 
// 
// Related Topics 双指针 字符串 动态规划 👍 127 👎 0

import java.util.ArrayList;
import java.util.LinkedList;

//Java：|838|推多米诺|PushDominoes|
public class PushDominoes {
    public static void main(String[] args) {
        Solution solution = new PushDominoes().new Solution();
        // TO TEST
        System.out.println(solution.pushDominoes("...RL....R.L.L........RR......L....R.L.....R.L..RL....R....R......R.......................LR.R..L.R."));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String pushDominoes(String dominoes) {
            if(!dominoes.contains("L") && !dominoes.contains("R"))
                return dominoes;
            int left = -1;
            int right = -1;
            char[] ans = new char[dominoes.length()];
            for (left = 0; left < dominoes.length(); left++) {
                ans[left] = dominoes.charAt(left);
                if (dominoes.charAt(left) == 'L') {
                    for (int i = 0; i < left; i++) {
                        ans[i] = 'L';
                    }
                    break;
                }
                if (dominoes.charAt(left) == 'R') {
                    break;
                }
            }

            for (right = dominoes.length() - 1; right > 0; right--) {
                ans[right] = dominoes.charAt(right);
                if (dominoes.charAt(right) == 'L') {
                    break;
                }
                if (dominoes.charAt(right) == 'R') {
                    for (int i = dominoes.length() - 1; i >  right; i--) {
                        ans[i] = 'R';
                    }
                    break;
                }
            }

            if(left == right){
                if(ans[left] == 'R'){
                    for(int i = left ; i < dominoes.length() ; i++){
                        ans[i] = 'R';
                    }
                }else {
                    for(int i = 0 ; i < left ; i++){
                        ans[i] = 'L';
                    }
                }
            }

            char flag = dominoes.charAt(left);
                for (int i = left + 1; i <= right; i++) {
                    ans[i] = dominoes.charAt(i);
                    if (dominoes.charAt(i) == 'R') {
                        if (flag == dominoes.charAt(i)) {
                            for (int j = left; j < i; j++) {
                                ans[j] = 'R';
                            }
                        }
                        left = i;
                        flag = 'R';
                    } else if (dominoes.charAt(i) == 'L') {
                        if (flag == dominoes.charAt(i)) {
                            for (int j = left; j < i; j++) {
                                ans[j] = 'L';
                            }
                        } else {
                            for (int j = 1; j < (left + i + 1) / 2 - left; j++) {
                                ans[left + j] = 'R';
                                ans[i - j] = 'L';
                            }
                        }
                        left = i;
                        flag = 'L';
                    }
                }

            return new String(ans);

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
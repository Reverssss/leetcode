package editor.cn;//给定两个排序后的数组 A 和 B，其中 A 的末端有足够的缓冲空间容纳 B。 编写一个方法，将 B 合并入 A 并排序。
//
// 初始化 A 和 B 的元素数量分别为 m 和 n。 
//
// 示例: 
//
// 输入:
//A = [1,2,3,0,0,0], m = 3
//B = [2,5,6],       n = 3
//
//输出: [1,2,2,3,5,6] 
//
// 说明: 
//
// 
// A.length == n + m 
// 
//
// Related Topics 数组 双指针 排序 👍 166 👎 0

//Java：|面试题 10.01|合并排序的数组|SortedMergeLcci|
public class SortedMergeLcci{
    public static void main(String[] args) {
        Solution solution = new SortedMergeLcci().new Solution();
        // TO TEST
        int[] A = new int[]{1,2,3,0,0,0};
        int[] B = new int[]{2,5,6};
        solution.merge(A,3,B,3);
        for(int i : A){
            System.out.print(i +" ");
        }
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void merge(int[] A, int m, int[] B, int n) {
        int[] res = new int[A.length];

        int a = 0;
        int b = 0;
        while (a+b < m+n){
            if(a<m&&b<n) {
                if (A[a] <= B[b]) {
                    res[a + b] = A[a];
                    a++;
                } else {
                    res[a + b] = B[b];
                    b++;
                }
            }else if(a<m){
                res[a + b] = A[a];
                a++;
            }else {
                res[a + b] = B[b];
                b++;
            }
        }
        for (int i = 0; i != m + n; ++i) {
            A[i] = res[i];
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
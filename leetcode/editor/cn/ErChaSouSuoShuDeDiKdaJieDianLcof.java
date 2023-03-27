package editor.cn;//给定一棵二叉搜索树，请找出其中第 k 大的节点的值。
//
// 
//
// 示例 1: 
//
// 
//输入: root = [3,1,4,null,2], k = 1
//   3
//  / \
// 1   4
//  \
//   2
//输出: 4 
//
// 示例 2: 
//
// 
//输入: root = [5,3,6,2,4,null,null,1], k = 3
//       5
//      / \
//     3   6
//    / \
//   2   4
//  /
// 1
//输出: 4 
//
// 
//
// 限制： 
//
// 
// 1 ≤ k ≤ 二叉搜索树元素个数 
// 
//
// Related Topics 树 深度优先搜索 二叉搜索树 二叉树 👍 361 👎 0

import java.util.Collections;
import java.util.Map;
import java.util.PriorityQueue;

//Java：|剑指 Offer 54|二叉搜索树的第k大节点|ErChaSouSuoShuDeDiKdaJieDianLcof|
public class ErChaSouSuoShuDeDiKdaJieDianLcof{
    public static void main(String[] args) {
        Solution solution = new ErChaSouSuoShuDeDiKdaJieDianLcof().new Solution();
        // TO TEST
        TreeNode treeNode = new TreeNode(3);
        treeNode.left = new TreeNode(1);
        treeNode.right = new TreeNode(4);
        treeNode.left.right = new TreeNode(2);
        System.out.println(solution.kthLargest(treeNode,1));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    int times = 0;
    public int kthLargest(TreeNode root, int k) {
        times = k;
        return look(root);
    }
    public int look(TreeNode treeNode){
        if(treeNode == null){
            return -1;
        }

        int right = look(treeNode.right);
        if(right > 0)
            return right;
        times--;
        if(times == 0)
            return treeNode.val;
        int left = look(treeNode.left);
        if(left > 0)
            return left;

        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
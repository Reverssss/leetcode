package editor.cn;//给定二叉树的根节点 root，找出存在于 不同 节点 A 和 B 之间的最大值 V，其中 V = |A.val - B.val|，且 A 是 B 的祖先。
//
//
// （如果 A 的任何子节点之一为 B，或者 A 的任何子节点是 B 的祖先，那么我们认为 A 是 B 的祖先） 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：root = [8,3,10,1,6,null,14,null,null,4,7,13]
//输出：7
//解释： 
//我们有大量的节点与其祖先的差值，其中一些如下：
//|8 - 3| = 5
//|3 - 7| = 4
//|8 - 1| = 7
//|10 - 13| = 3
//在所有可能的差值中，最大值 7 由 |8 - 1| = 7 得出。
// 
//
// 示例 2： 
// 
// 
//输入：root = [1,null,2,null,0,3]
//输出：3
// 
//
// 
//
// 提示： 
//
// 
// 树中的节点数在 2 到 5000 之间。 
// 0 <= Node.val <= 10⁵ 
// 
//
// Related Topics 树 深度优先搜索 二叉树 👍 142 👎 0

//Java：|1026|节点与其祖先之间的最大差值|MaximumDifferenceBetweenNodeAndAncestor|
public class MaximumDifferenceBetweenNodeAndAncestor{
    public static void main(String[] args) {
        Solution solution = new MaximumDifferenceBetweenNodeAndAncestor().new Solution();
        // TO TEST
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int maxAncestorDiff(TreeNode root) {
        return maxAncestorDiffHelp(root,root.val,root.val,0);
    }

    public int maxAncestorDiffHelp(TreeNode root,int big,int small,int max) {
        if(root == null) {
            return max;
        }else {
            big = Math.max(big,root.val);
            small = Math.min(small,root.val);
            max = Math.max(max,big-small);

            int left = maxAncestorDiffHelp(root.left,big,small,max);
            int right = maxAncestorDiffHelp(root.right,big,small,max);
            max = Math.max(max,Math.max(left,right));
        }
        return max;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
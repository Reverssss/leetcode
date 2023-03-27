package editor.cn;//给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
//
// 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（
//一个节点也可以是它自己的祖先）。” 
//
// 例如，给定如下二叉树: root = [3,5,1,6,2,0,8,null,null,7,4] 
//
// 
//
// 
//
// 示例 1: 
//
// 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
//输出: 3
//解释: 节点 5 和节点 1 的最近公共祖先是节点 3。
// 
//
// 示例 2: 
//
// 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
//输出: 5
//解释: 节点 5 和节点 4 的最近公共祖先是节点 5。因为根据定义最近公共祖先节点可以为节点本身。
// 
//
// 
//
// 说明: 
//
// 
// 所有节点的值都是唯一的。 
// p、q 为不同节点且均存在于给定的二叉树中。 
// 
//
// 注意：本题与主站 236 题相同：https://leetcode-cn.com/problems/lowest-common-ancestor-of-
//a-binary-tree/ 
//
// Related Topics 树 深度优先搜索 二叉树 👍 516 👎 0

//Java：|剑指 Offer 68 - II|二叉树的最近公共祖先|ErChaShuDeZuiJinGongGongZuXianLcof|
public class ErChaShuDeZuiJinGongGongZuXianLcof{
    public static void main(String[] args) {
        Solution solution = new ErChaShuDeZuiJinGongGongZuXianLcof().new Solution();
        // TO TEST
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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return pre(root,p,q).treeNode;
    }
    public Message pre(TreeNode root, TreeNode p, TreeNode q) {
        Message message = new Message();

        if(root.val == p.val) message.has1 = true;
        if(root.val == q.val) message.has2 = true;

        if(root.left != null){
            Message messageLeft = pre(root.left,p,q);
            message.has1 = messageLeft.has1| message.has1;
            message.has2 = messageLeft.has2| message.has2;
            if(messageLeft.treeNode!=null)
                message.treeNode = messageLeft.treeNode;
        }
        if(root.right != null){
            Message messageright = pre(root.right,p,q);
            message.has1 = messageright.has1| message.has1;
            message.has2 = messageright.has2| message.has2;
            if(messageright.treeNode!=null)
                message.treeNode = messageright.treeNode;
        }
        if(message.treeNode == null) {
            if (message.has1 && message.has2) {
                message.treeNode = root;
            }
        }
        return message;
    }
}
class Message{
    boolean has1;
    boolean has2;
    TreeNode treeNode;
}
//leetcode submit region end(Prohibit modification and deletion)

}
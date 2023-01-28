package editor.cn;//给你一个二叉树的根节点 root ， 检查它是否轴对称。
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [1,2,2,3,4,4,3]
//输出：true
// 
//
// 示例 2： 
// 
// 
//输入：root = [1,2,2,null,3,null,3]
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [1, 1000] 内 
// -100 <= Node.val <= 100 
// 
//
// 
//
// 进阶：你可以运用递归和迭代两种方法解决这个问题吗？ 
//
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 2241 👎 0

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;

//Java：|101|对称二叉树|SymmetricTree|
public class SymmetricTree{
    public static void main(String[] args) {
        Solution solution = new SymmetricTree().new Solution();
        // TO TEST
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(2);
        //treeNode.left.left = new TreeNode(3);
        treeNode.left.right = new TreeNode(3);

        //treeNode.right.left = new TreeNode(4);
        treeNode.right.right = new TreeNode(3);
        solution.isSymmetric(treeNode);
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
    public boolean isSymmetric(TreeNode root) {
        LinkedList<Integer> preList = new LinkedList<>();
        LinkedList<Integer> lateList = new LinkedList<>();

        pre(root,preList);
        late(root,lateList);

        while (preList.size() > 0 && lateList.size()>0){
            if(preList.getFirst() == lateList.getFirst()){
                preList.removeFirst();
                lateList.removeFirst();
            }else {return false;}
        }
        if(preList.size() == 0 && lateList.size() == 0){
            return true;
        }else {
            return false;
        }
    }

    private void pre(TreeNode root,LinkedList preList){
        if(root.left!= null){pre(root.left,preList);}
        else preList.add(-1);
        if(root.right!=null){pre(root.right,preList);}
        else preList.add(-1);
        preList.add(root.val);
    }

    private void late(TreeNode root, LinkedList lateList){
        if(root.left!= null){pre(root.left,lateList);}
        else lateList.add(-1);
        if(root.right!=null){pre(root.right,lateList);}
        else lateList.add(-1);

        lateList.add(root.val);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
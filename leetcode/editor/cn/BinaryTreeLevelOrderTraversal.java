package editor.cn;//给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。
//
// 
//
// 示例 1： 
//
// 
//输入：root = [3,9,20,null,null,15,7]
//输出：[[3],[9,20],[15,7]]
// 
//
// 示例 2： 
//
// 
//输入：root = [1]
//输出：[[1]]
// 
//
// 示例 3： 
//
// 
//输入：root = []
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [0, 2000] 内 
// -1000 <= Node.val <= 1000 
// 
// Related Topics 树 广度优先搜索 二叉树 👍 1170 👎 0

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedTransferQueue;
import java.util.zip.InflaterInputStream;

import static java.lang.Math.log;

//Java：|102|二叉树的层序遍历|BinaryTreeLevelOrderTraversal|
public class BinaryTreeLevelOrderTraversal{
    public static void main(String[] args) {
        Solution solution = new BinaryTreeLevelOrderTraversal().new Solution();
        // TO TEST
        TreeNode root = new TreeNode(3);
        TreeNode root_static = root;
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root = root.right;
        root.left = new TreeNode(15);
        root.right = new TreeNode(7);
        for(List<Integer> i : solution.levelOrder(root_static)){
            for(Integer j : i){
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }
      public static class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;

          TreeNode() {
          }

          TreeNode(int val) {
              this.val = val;
          }

          TreeNode(int val, TreeNode left, TreeNode right) {
              this.val = val;
              this.left = left;
              this.right = right;
          }
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


    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root ==  null)
            return new ArrayList<List<Integer>>();
        List<List<Integer>> lists = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode remove = queue.poll();
                if(remove.left != null)
                    queue.add(remove.left);
                if(remove.right != null)
                    queue.add(remove.right);

                list.add(remove.val);
            }
            lists.add(list);
        }
        return lists;
    }



}

//leetcode submit region end(Prohibit modification and deletion)

}
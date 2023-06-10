package editor.cn;//给你一个链表的头节点 head，请你编写代码，反复删去链表中由 总和 值为 0 的连续节点组成的序列，直到不存在这样的序列为止。
//
// 删除完毕后，请你返回最终结果链表的头节点。 
//
// 
//
// 你可以返回任何满足题目要求的答案。 
//
// （注意，下面示例中的所有序列，都是对 ListNode 对象序列化的表示。） 
//
// 示例 1： 
//
// 输入：head = [1,2,-3,3,1]
//输出：[3,1]
//提示：答案 [1,2,1] 也是正确的。
// 
//
// 示例 2： 
//
// 输入：head = [1,2,3,-3,4]
//输出：[1,2,4]
// 
//
// 示例 3： 
//
// 输入：head = [1,2,3,-3,-2]
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 给你的链表中可能有 1 到 1000 个节点。 
// 对于链表中的每个节点，节点的值：-1000 <= node.val <= 1000. 
// 
//
// Related Topics 哈希表 链表 👍 196 👎 0

import java.util.HashMap;
import java.util.Hashtable;

//Java：|1171|从链表中删去总和值为零的连续节点|RemoveZeroSumConsecutiveNodesFromLinkedList|
public class RemoveZeroSumConsecutiveNodesFromLinkedList{
    public static void main(String[] args) {
        Solution solution = new RemoveZeroSumConsecutiveNodesFromLinkedList().new Solution();
        // TO TEST
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeZeroSumSublists(ListNode head) {
        ListNode first = new ListNode(0);
        first.next = head;
        int prefix = 0;
        HashMap<Integer,ListNode> hashtable = new HashMap<>();

        for(ListNode node = first; node != null ; node = node.next){
            prefix += node.val;
            hashtable.put(prefix,node);
        }

        prefix = 0;
        for(ListNode node = first; node != null ; node = node.next){
            prefix += node.val;
            node.next = hashtable.get(prefix).next;
        }
        return first.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
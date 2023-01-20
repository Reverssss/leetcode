package editor.cn;//给定一个已排序的链表的头 head ， 删除所有重复的元素，使每个元素只出现一次 。返回 已排序的链表 。
//
// 
//
// 示例 1： 
//
// 
//输入：head = [1,1,2]
//输出：[1,2]
// 
//
// 示例 2： 
//
// 
//输入：head = [1,1,2,3,3]
//输出：[1,2,3]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点数目在范围 [0, 300] 内 
// -100 <= Node.val <= 100 
// 题目数据保证链表已经按升序 排列 
// 
// Related Topics 链表 👍 723 👎 0

import java.util.HashMap;
import java.util.HashSet;

//Java：|83|删除排序链表中的重复元素|RemoveDuplicatesFromSortedList|
public class RemoveDuplicatesFromSortedList{
    public static void main(String[] args) {
        Solution solution = new RemoveDuplicatesFromSortedList().new Solution();
        // TO TEST
        ListNode head = new ListNode(1);
        ListNode head2 = head;

        head.next = new ListNode(1);
        head = head.next;
        head.next = new ListNode(2);
        head = head.next;
        head.next = new ListNode(3);
        head = head.next;
        head.next = new ListNode(3);
        head = head.next;

        ListNode ans = solution.deleteDuplicates(head2);
        while (ans.next != null){
            System.out.println(ans.val);
            ans = ans.next;
        }
        System.out.println(ans.val);

    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class editor.cn.ListNode {
 *     int val;
 *     editor.cn.ListNode next;
 *     editor.cn.ListNode() {}
 *     editor.cn.ListNode(int val) { this.val = val; }
 *     editor.cn.ListNode(int val, editor.cn.ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        HashSet<Integer> set = new HashSet<>();
        if(head == null || head.next == null)
            return head;

        ListNode head2 = head;
        set.add(head.val);
        while (head.next.next != null){
            if(set.contains(head.next.val)){
                head.next = head.next.next;
            }else {
                set.add(head.next.val);
                head = head.next;
            }
        }
        if(set.contains(head.next.val)){
            head.next = null;
            return head2;
        }else {
            return head2;
        }

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
package editor.cn;//给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。
//
// 
//
// 示例 1： 
// 
// 
//输入：head = [1,2,2,1]
//输出：true
// 
//
// 示例 2： 
// 
// 
//输入：head = [1,2]
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点数目在范围[1, 10⁵] 内 
// 0 <= Node.val <= 9 
// 
//
// 
//
// 进阶：你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？ 
//
// Related Topics 栈 递归 链表 双指针 👍 1668 👎 0

import java.util.ArrayDeque;
import java.util.List;

//Java：|234|回文链表|PalindromeLinkedList|
public class PalindromeLinkedList{
    public static void main(String[] args) {
        Solution solution = new PalindromeLinkedList().new Solution();
        // TO TEST
        ListNode listNode = new ListNode(1);
//        listNode.next = new ListNode(2);
//        listNode.next.next = new ListNode(2);
//        listNode.next.next.next = new ListNode(1);
        System.out.println(solution.isPalindrome(listNode));
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
    public boolean isPalindrome(ListNode head) {
        ArrayDeque<Integer> stack1 = new ArrayDeque<>();
        ArrayDeque<Integer> stack2 = new ArrayDeque<>();
        boolean res = true;

        while (head != null){
            stack1.push(head.val);
            head = head.next;
        }
        int len = stack1.size();
        for(int i = 0 ; i < len/2 ; i++){
            stack2.push(stack1.pop());
        }
        if(len %2 ==1)
            stack1.pop();
        for(int i = 0 ; i < len/2 ; i++){
            if(stack1.pop() != stack2.pop()){
                res = false;
                break;
            }
        }
        return res ;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
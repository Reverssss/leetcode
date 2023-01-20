package editor.cn;//编写一个函数，检查输入的链表是否是回文的。
//
// 
//
// 示例 1： 
//
// 输入： 1->2
//输出： false 
// 
//
// 示例 2： 
//
// 输入： 1->2->2->1
//输出： true 
// 
//
// 
//
// 进阶： 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？ 
//
// Related Topics 栈 递归 链表 双指针 👍 126 👎 0

import java.util.ArrayList;

//Java：|面试题 02.06|回文链表|PalindromeLinkedListLcci|
public class PalindromeLinkedListLcci{
    public static void main(String[] args) {
        Solution solution = new PalindromeLinkedListLcci().new Solution();
        // TO TEST
        ListNode node = new ListNode(-129);
        node.next = new ListNode(-129);
        System.out.println(solution.isPalindrome(node));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        ArrayList<Integer> list = new ArrayList();
        if(head == null)
            return true;
        while (head.next!=null){
            list.add(head.val);
            head = head.next;
        }
        list.add(head.val);

        for(int i = 0 ; i < list.size()/2 ; i++){
            if(list.get(i).compareTo(list.get(list.size()-1-i))!=0)
                return false;
        }

        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
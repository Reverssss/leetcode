package editor.cn;//给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
//
// 请你将两个数相加，并以相同形式返回一个表示和的链表。
//
// 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
//
//
//
// 示例 1：
//
//
//输入：l1 = [2,4,3], l2 = [5,6,4]
//输出：[7,0,8]
//解释：342 + 465 = 807.
//
//
// 示例 2：
//
//
//输入：l1 = [0], l2 = [0]
//输出：[0]
//
//
// 示例 3：
//
//
//输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
//输出：[8,9,9,9,0,0,0,1]
//
//
//
//
// 提示：
//
//
// 每个链表中的节点数在范围 [1, 100] 内
// 0 <= Node.val <= 9
// 题目数据保证列表表示的数字不含前导零
//
// Related Topics 递归 链表 数学 👍 7754 👎 0


import java.math.BigInteger;

//Java：|2|两数相加|AddTwoNumbers|
public class AddTwoNumbers{
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public static void main(String[] args) {
        Solution solution = new AddTwoNumbers().new Solution();
        // TO TEST
        ListNode l1 = new ListNode(3);

        l1 = new ListNode(4,l1);
        l1 = new ListNode(2,l1);
        ListNode l2 = new ListNode(4);
        l2 = new ListNode(6,l2);
        l2 = new ListNode(5,l2);

        ListNode ans = solution.addTwoNumbers(l1,l2);
        while (ans.next != null){
            System.out.print(ans.val + " ");
            ans = ans.next;
        }
        System.out.println(ans.val);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.

 */

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();

        while (l1!=null && l2!=null){

        }

        return null;
    }
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        StringBuilder int1 = new StringBuilder();
        StringBuilder int2 = new StringBuilder();

        while (l1.next!=null){
            int1.insert(0,l1.val);
            l1 = l1.next;
        }
        int1.insert(0,l1.val);

        while (l2.next!=null){
            int2.insert(0,l2.val);
            l2 = l2.next;
        }
        int2.insert(0,l2.val);

        java.math.BigInteger sum = new java.math.BigInteger(int1.toString()).add(new java.math.BigInteger(int2.toString()));
        String sumString = new StringBuilder().append(sum).toString();
        ListNode ans = null;

        for(int i = 0 ; i < sumString.length();i++){
            ans = new ListNode(Integer.valueOf(Character.toString(sumString.charAt(i))),ans);
        }

        if(ans == null){
            return new ListNode(0);
        }else {
            return ans;
        }

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
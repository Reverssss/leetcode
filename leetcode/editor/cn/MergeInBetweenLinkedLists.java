package editor.cn;//给你两个链表 list1 和 list2 ，它们包含的元素分别为 n 个和 m 个。
//
// 请你将 list1 中下标从 a 到 b 的全部节点都删除，并将list2 接在被删除节点的位置。 
//
// 下图中蓝色边和节点展示了操作后的结果： 
// 
// 请你返回结果链表的头指针。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：list1 = [0,1,2,3,4,5], a = 3, b = 4, list2 = [1000000,1000001,1000002]
//输出：[0,1,2,1000000,1000001,1000002,5]
//解释：我们删除 list1 中下标为 3 和 4 的两个节点，并将 list2 接在该位置。上图中蓝色的边和节点为答案链表。
// 
//
// 示例 2： 
// 
// 
//输入：list1 = [0,1,2,3,4,5,6], a = 2, b = 5, list2 = [1000000,1000001,1000002,100
//0003,1000004]
//输出：[0,1,1000000,1000001,1000002,1000003,1000004,6]
//解释：上图中蓝色的边和节点为答案链表。
// 
//
// 
//
// 提示： 
//
// 
// 3 <= list1.length <= 10⁴ 
// 1 <= a <= b < list1.length - 1 
// 1 <= list2.length <= 10⁴ 
// 
//
// Related Topics 链表 👍 59 👎 0

//Java：|1669|合并两个链表|MergeInBetweenLinkedLists|
public class MergeInBetweenLinkedLists{
    public static void main(String[] args) {
        Solution solution = new MergeInBetweenLinkedLists().new Solution();
        // TO TEST
        ListNode listNode = new ListNode(0);
        ListNode start1 = listNode;
        listNode.next = new ListNode(1);
        listNode = listNode.next;
        listNode.next = new ListNode(2);
        listNode = listNode.next;
        listNode.next = new ListNode(3);
        listNode = listNode.next;
        listNode.next = new ListNode(4);
        listNode = listNode.next;
        listNode.next = new ListNode(5);
        listNode = listNode.next;

        ListNode listNode2 = new ListNode(10000);
        ListNode start2 = listNode2;
        listNode2.next = new ListNode(10001);
        listNode2 = listNode2.next;
        listNode2.next = new ListNode(10002);

        ListNode listNode1 = solution.mergeInBetween(start1, 3, 4, start2);
        while (listNode1.next!=null){
            System.out.print(listNode1.val);
            listNode1 = listNode1.next;
        }
        System.out.print(listNode1.val);
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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode res = list1;
        for(int i = 0 ; i < a-1 ; i++){
            list1 = list1.next;
        }
        ListNode start = list1;
        ListNode temp1 = list1;
        for(int i = a ; i <= b ; i++){
            start = start.next;
        }
        start = start.next;


        ListNode temp2 = list2;
        while (list2.next!=null)
            list2 = list2.next;
        list2.next = start;
        temp1.next = temp2;
        return res;

        
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
//将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
//
// 
//
// 示例： 
//
// 输入：1->2->4, 1->3->4
//输出：1->1->2->3->4->4
// 
// Related Topics 链表 
// 👍 1458 👎 0


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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode prehead = new ListNode(-1);
        ListNode prev = prehead;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }
        if (l1 == null) {
            prev.next = l2;
        } else {
            prev.next = l1;
        }
        return prehead.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

// 1. 递归
//if (l1 == null) {
//    return l2;
//} else if (l2 == null) {
//    return l1;
//} else if (l1.val < l2.val) {
//    l1.next = mergeTwoLists(l1.next, l2);
//    return l1;
//} else {
//    l2.next = mergeTwoLists(l1, l2.next);
//    return l2;
//}

// 2. 迭代
// 设置一个prehead， 以便于之后返回合并的链表；
// 维护一个prev指针，需要做的是调整它的next指针。
// iteration直到l1或者l2指向了null：
//      如果l1当前节点的值小于等于l2，
//          我们就把l1当前的节点接在prev节点的后面同时将l1指针往后移一位。
//      否则，
//          我们对l2做同样的操作。
// 拼接剩下的链表的

//输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。 
//
// 
//
// 示例 1： 
//
// 输入：head = [1,3,2]
//输出：[2,3,1] 
//
// 
//
// 限制： 
//
// 0 <= 链表长度 <= 10000 
// Related Topics 链表 
// 👍 83 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    ArrayList<Integer> tmp = new ArrayList<Integer>();
    public int[] reversePrint(ListNode head) {
        recur(head);
        int[] res = new int[tmp.size()];
        for(int i = 0; i < res.length; i++) {
            res[i] = tmp.get(i);
        }
        return res;
    }
    public void recur(ListNode head){
        if (head == null) return;
        recur(head.next);
        tmp.add(head.val);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
// 1. stack
//    Stack<ListNode> stack = new Stack<ListNode>();
//    ListNode temp = head;
//    while(temp != null) {
//            stack.push(temp);
//            temp = temp.next;
//            }
//            int size = stack.size();
//            int[] res = new int[size];
//            for (int i = 0; i < size; i++) {
//    res[i] = stack.pop().val;
//    }
//    return res;

// 2. recusive

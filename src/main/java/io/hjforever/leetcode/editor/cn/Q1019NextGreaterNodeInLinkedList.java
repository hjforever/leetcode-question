//You are given the head of a linked list with n nodes.
//
// For each node in the list, find the value of the next greater node. That is, 
//for each node, find the value of the first node that is next to it and has a 
//strictly larger value than it. 
//
// Return an integer array answer where answer[i] is the value of the next 
//greater node of the iᵗʰ node (1-indexed). If the iᵗʰ node does not have a next 
//greater node, set answer[i] = 0. 
//
// 
// Example 1: 
//
// 
//Input: head = [2,1,5]
//Output: [5,5,0]
// 
//
// Example 2: 
//
// 
//Input: head = [2,7,4,3,5]
//Output: [7,0,5,5,0]
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the list is n. 
// 1 <= n <= 10⁴ 
// 1 <= Node.val <= 10⁹ 
// 
// Related Topics 栈 数组 链表 单调栈 👍 201 👎 0


package io.hjforever.leetcode.editor.cn;

import io.hjforever.leetcode.editor.cn.common.ListNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class Q1019NextGreaterNodeInLinkedList {
    public static void main(String[] args) {
        Solution solution = new Q1019NextGreaterNodeInLinkedList().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public int[] nextLargerNodes(ListNode head) {
            if (head == null) return new int[0];
            if (head.next == null) return new int[]{0};
            //单调栈
            //conver node
            ListNode tail = reverse(head);
            List<Integer> ans = new ArrayList<>();
            ans.add(0);
            Stack<Integer> stack = new Stack<>();
            stack.push(tail.val);
            ListNode temp = tail.next;
            while (temp != null) {
                int val = temp.val;
                while (!stack.isEmpty() && stack.peek() <= val) stack.pop();
                if (stack.isEmpty()) {
                    ans.add(0);
                } else {
                    ans.add(stack.peek());
                }
                stack.push(val);
                temp = temp.next;
            }
            Collections.reverse(ans);
            return ans.stream().mapToInt(value -> value).toArray();
        }

        ListNode reverse(ListNode head) {
            ListNode cur = head;
            ListNode pre = null;
            while (cur != null) {
                ListNode next = cur.next;
                cur.next = pre;
                pre = cur;
                cur = next;
            }
            return pre;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
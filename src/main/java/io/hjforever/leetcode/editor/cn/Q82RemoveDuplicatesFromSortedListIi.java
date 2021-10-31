//存在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除链表中所有存在数字重复情况的节点，只保留原始链表中 没有重复出现 的数字。
//
// 返回同样按升序排列的结果链表。 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,3,4,4,5]
//输出：[1,2,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [1,1,1,2,3]
//输出：[2,3]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点数目在范围 [0, 300] 内 
// -100 <= Node.val <= 100 
// 题目数据保证链表已经按升序排列 
// 
// Related Topics 链表 双指针 👍 737 👎 0


package io.hjforever.leetcode.editor.cn;

import io.hjforever.leetcode.editor.cn.common.ListNode;

public class Q82RemoveDuplicatesFromSortedListIi {
    public static void main(String[] args) {
        Solution solution = new Q82RemoveDuplicatesFromSortedListIi().new Solution();
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
        public ListNode deleteDuplicates(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            ListNode result = new ListNode(-1, head);
            ListNode cur = result;
            while (cur.next != null && cur.next.next != null) {
                if (cur.next.val == cur.next.next.val) {
                    //查找val然后删除
                    int val = cur.next.val;
                    while (cur.next != null && cur.next.val == val) {
                        cur.next = cur.next.next;
                    }
                } else {
                    cur = cur.next;
                }
            }
            return result.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
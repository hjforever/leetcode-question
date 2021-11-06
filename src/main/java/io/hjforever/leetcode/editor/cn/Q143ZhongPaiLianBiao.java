//给定一个单链表 L 的头节点 head ，单链表 L 表示为：
//
// L0 → L1 → … → Ln-1 → Ln 
//请将其重新排列后变为： 
//
// L0 → Ln → L1 → Ln-1 → L2 → Ln-2 → … 
//
// 不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。 
//
// 
//
// 示例 1: 
//
// 
//
// 
//输入: head = [1,2,3,4]
//输出: [1,4,2,3] 
//
// 示例 2: 
//
// 
//
// 
//输入: head = [1,2,3,4,5]
//输出: [1,5,2,4,3] 
//
// 
//
// 提示： 
//
// 
// 链表的长度范围为 [1, 5 * 10⁴] 
// 1 <= node.val <= 1000 
// 
// Related Topics 栈 递归 链表 双指针 👍 696 👎 0


package io.hjforever.leetcode.editor.cn;

import io.hjforever.leetcode.editor.cn.common.ListNode;

public class Q143ZhongPaiLianBiao {
    public static void main(String[] args) {
        Solution solution = new Q143ZhongPaiLianBiao().new Solution();
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
        public void reorderList(ListNode head) {
            //先找到中间节点
            if (head == null || head.next == null || head.next.next == null) {
                return;
            }

            ListNode midNode = midNode(head);
            ListNode listNode1 = head;
            ListNode listNode2 = midNode.next;
            //断开
            midNode.next = null;
            //反转
            listNode2 = reverseList(listNode2);
            mergeList(listNode1, listNode2);
        }

        private ListNode reverseList(ListNode head) {
            ListNode pre = null;
            ListNode cur = head;
            while (cur != null) {
                ListNode next = cur.next;
                cur.next = pre;
                pre = cur;
                cur = next;
            }
            return pre;
        }

        private void mergeList(ListNode listNode1, ListNode listNode2) {
            ListNode tmp1;
            ListNode tmp2;
            while (listNode1 != null && listNode2 != null) {
                tmp1 = listNode1.next;
                tmp2 = listNode2.next;

                listNode1.next = listNode2;
                listNode1 = tmp1;

                listNode2.next = listNode1;
                listNode2 = tmp2;
            }
        }

        ListNode midNode(ListNode head) {
            ListNode fast = head, slow = head;
            while (fast.next != null && fast.next.next != null) {
                fast = fast.next.next;
                slow = slow.next;
            }
            return slow;
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

}
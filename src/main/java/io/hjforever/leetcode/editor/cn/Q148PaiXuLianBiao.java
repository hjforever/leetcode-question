//给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
//
// 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [4,2,1,3]
//输出：[1,2,3,4]
// 
//
// 示例 2： 
//
// 
//输入：head = [-1,5,3,4,0]
//输出：[-1,0,3,4,5]
// 
//
// 示例 3： 
//
// 
//输入：head = []
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目在范围 [0, 5 * 10⁴] 内 
// -10⁵ <= Node.val <= 10⁵ 
// 
//
// 
//
// 进阶：你可以在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？ 
// Related Topics 链表 双指针 分治 排序 归并排序 👍 1510 👎 0


package io.hjforever.leetcode.editor.cn;

import io.hjforever.leetcode.editor.cn.common.ListNode;

public class Q148PaiXuLianBiao {
    public static void main(String[] args) {
        Solution solution = new Q148PaiXuLianBiao().new Solution();
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
        public ListNode sortList(ListNode head) {
            //归并排序
            //1.先用 fast-slow寻找中点，在合并排序
            //2.合并排序
            if (head == null || head.next == null) return head;

            //1.寻找中点，并cut
            ListNode fast = head.next.next, slow = head, left, right;
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            right = sortList(slow.next);
            // 链表判断结束的标志：末尾节点.next==null
            slow.next = null;
            left = sortList(head);
            //合并列表
            return mergeList(left, right);
        }

        private ListNode mergeList(ListNode l, ListNode r) {
            ListNode temp = new ListNode(-1);
            ListNode pre = temp;
            while (l != null && r != null) {
                if (l.val < r.val) {
                    pre.next = l;
                    l = l.next;
                } else {
                    pre.next = r;
                    r = r.next;
                }
                pre = pre.next;
            }
            pre.next = (l == null ? r : l);
            return temp.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
//输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
//
// 示例1： 
//
// 输入：1->2->4, 1->3->4
//输出：1->1->2->3->4->4 
//
// 限制： 
//
// 0 <= 链表长度 <= 1000 
//
// 注意：本题与主站 21 题相同：https://leetcode-cn.com/problems/merge-two-sorted-lists/ 
// Related Topics 递归 链表 👍 182 👎 0


package io.hjforever.leetcode.editor.cn;

import io.hjforever.leetcode.editor.cn.common.ListNode;

public class QJianZhiOffer25HeBingLiangGePaiXuDeLianBiao {
    public static void main(String[] args) {
        Solution solution = new QJianZhiOffer25HeBingLiangGePaiXuDeLianBiao().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */
    class Solution {
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            if (l1 == null && l2 == null) {
                return null;
            }
            ListNode tmp = new ListNode(-1);
            ListNode pre = tmp;
            while (l1 != null && l2 != null) {
                int l1Val = l1.val;
                int l2Val = l2.val;

                if (l1Val < l2Val) {
                    pre.next = l1;
                    l1 = l1.next;
                } else {
                    pre.next = l2;
                    l2 = l2.next;
                }
                pre = pre.next;
            }
            pre.next = l1 == null ? l2 : l1;
            return tmp.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
//给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。
//
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,4,5], k = 2
//输出：[4,5,1,2,3]
// 
//
// 示例 2： 
//
// 
//输入：head = [0,1,2], k = 4
//输出：[2,0,1]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目在范围 [0, 500] 内 
// -100 <= Node.val <= 100 
// 0 <= k <= 2 * 10⁹ 
// 
// Related Topics 链表 双指针 👍 647 👎 0


package io.hjforever.leetcode.editor.cn;

import io.hjforever.leetcode.editor.cn.common.ListNode;

public class Q61RotateList {
    public static void main(String[] args) {
        Solution solution = new Q61RotateList().new Solution();
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
        public ListNode rotateRight(ListNode head, int k) {
            if (head == null || head.next == null) {
                return head;
            }
            int length = 1;
            //计算长度然后取余
            ListNode iter = head;
            while (iter.next != null) {
                iter = iter.next;
                length++;
            }
            //通过k获取断开链表的位置
            int add = length - k % length;
            if (add == length) {
                return head;
            }
            //将链表置为为循环链表
            iter.next = head;
            while (add-- > 0) {
                iter = iter.next;
            }
            //断开链表
            ListNode ret = iter.next;
            iter.next = null;
            return ret;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
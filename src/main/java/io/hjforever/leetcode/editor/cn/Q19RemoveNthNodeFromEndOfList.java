//给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
//
// 进阶：你能尝试使用一趟扫描实现吗？ 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,4,5], n = 2
//输出：[1,2,3,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [1], n = 1
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：head = [1,2], n = 1
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 链表中结点的数目为 sz 
// 1 <= sz <= 30 
// 0 <= Node.val <= 100 
// 1 <= n <= sz 
// 
// Related Topics 链表 双指针 👍 1626 👎 0


package io.hjforever.leetcode.editor.cn;

import io.hjforever.leetcode.editor.cn.common.ListNode;

import java.util.ArrayList;
import java.util.List;

public class Q19RemoveNthNodeFromEndOfList {
    public static void main(String[] args) {
        Solution solution = new Q19RemoveNthNodeFromEndOfList().new Solution();
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


        public ListNode removeNthFromEnd(ListNode head, int n) {
            //return removeNthFromEndByArray(head, n);
            return removeNthFromEndByTwo(head, n);
        }

        //双指针（快慢指针）
        ListNode removeNthFromEndByTwo(ListNode head, int n) {
            //双指针找倒数第n个节点
            ListNode slow = head, fast = head, pre = head;
            //先让快指针走n步
            while (n > 0) {
                fast = fast.next;
                n--;
            }

            //快慢指针同时走，当快指针为空则表示已遍历完
            while (fast != null) {
                fast = fast.next;
                pre = slow;
                slow = slow.next;
            }
            if (slow == head) {
                return head.next;
            }
            pre.next = slow.next;
            return head;
        }


        //暴力解法，空间换时间
        ListNode removeNthFromEndByArray(ListNode head, int n) {
            List<ListNode> list = new ArrayList<>();
            ListNode node = head;
            while (node != null) {
                list.add(node);
                node = node.next;
            }
            if (n == 1 && list.size() == 1) {
                head = null;
                return head;
            }
            //取倒数n前
            int preIndex = list.size() - 1 - (n - 1) - 1;
            //取倒数n后
            int afterIndex = list.size() - 1 - (n - 1) + 1;
            if (preIndex < 0) {
                //说明为第一个元素
                list.get(0).next = null;
                head = list.get(1);
            } else if (afterIndex >= list.size()) {
                list.get(list.size() - 2).next = null;
            } else {
                list.get(preIndex).next = list.get(afterIndex);
            }
            return head;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
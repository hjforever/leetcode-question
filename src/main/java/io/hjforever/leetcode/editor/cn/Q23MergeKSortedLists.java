//给你一个链表数组，每个链表都已经按升序排列。
//
// 请你将所有链表合并到一个升序链表中，返回合并后的链表。 
//
// 
//
// 示例 1： 
//
// 输入：lists = [[1,4,5],[1,3,4],[2,6]]
//输出：[1,1,2,3,4,4,5,6]
//解释：链表数组如下：
//[
//  1->4->5,
//  1->3->4,
//  2->6
//]
//将它们合并到一个有序链表中得到。
//1->1->2->3->4->4->5->6
// 
//
// 示例 2： 
//
// 输入：lists = []
//输出：[]
// 
//
// 示例 3： 
//
// 输入：lists = [[]]
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// k == lists.length 
// 0 <= k <= 10^4 
// 0 <= lists[i].length <= 500 
// -10^4 <= lists[i][j] <= 10^4 
// lists[i] 按 升序 排列 
// lists[i].length 的总和不超过 10^4 
// 
// Related Topics 链表 分治 堆（优先队列） 归并排序 👍 1577 👎 0


package io.hjforever.leetcode.editor.cn;

import io.hjforever.leetcode.editor.cn.common.ListNode;

import java.util.Arrays;

public class Q23MergeKSortedLists {
    public static void main(String[] args) {
        Solution solution = new Q23MergeKSortedLists().new Solution();
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

        //分治合并
        public ListNode mergeKLists(ListNode[] lists) {
            //临界条件都要考虑,第一次提交遗漏导致参数为空时死循环
            if (lists.length == 0) {
                return null;
            }
            if (lists.length == 1) {
                return lists[0];
            }
            if (lists.length == 2) {
                return mergeTwoLists(lists[0], lists[1]);
            }
            //分治合并
            int left = 0;
            int mid = lists.length / 2;
            return mergeTwoLists(
                    mergeKLists(Arrays.copyOfRange(lists, left, mid)),
                    mergeKLists(Arrays.copyOfRange(lists, mid, lists.length))
            );
        }


        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            //预处理值
            ListNode result = new ListNode(-1);
            ListNode pre = result;
            while (l1 != null && l2 != null) {
                int l1Val = l1.val;
                int l2Val = l2.val;
                if (l1Val <= l2Val) {
                    pre.next = l1;
                    l1 = l1.next;
                } else {
                    pre.next = l2;
                    l2 = l2.next;
                }
                pre = pre.next;
            }
            // 合并后 l1 和 l2 最多只有一个还未被合并完，我们直接将链表末尾指向未合并完的链表即可
            pre.next = l1 == null ? l2 : l1;
            return result.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
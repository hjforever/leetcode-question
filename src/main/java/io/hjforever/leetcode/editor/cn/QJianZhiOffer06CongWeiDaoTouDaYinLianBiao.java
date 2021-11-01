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
// Related Topics 栈 递归 链表 双指针 👍 197 👎 0


package io.hjforever.leetcode.editor.cn;

import io.hjforever.leetcode.editor.cn.common.ListNode;

import java.util.Stack;

public class QJianZhiOffer06CongWeiDaoTouDaYinLianBiao {
    public static void main(String[] args) {
        Solution solution = new QJianZhiOffer06CongWeiDaoTouDaYinLianBiao().new Solution();
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
        public int[] reversePrint(ListNode head) {
            //栈解决或者递归
            //先进后出
            if (head == null) {
                return new int[0];
            }
            Stack<Integer> stack = new Stack<>();
            while (head != null) {
                stack.push(head.val);
                head = head.next;
            }
            int[] result = new int[stack.size()];
            for (int i = 0; i < result.length; i++) {
                result[i] = stack.peek();
                stack.pop();
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
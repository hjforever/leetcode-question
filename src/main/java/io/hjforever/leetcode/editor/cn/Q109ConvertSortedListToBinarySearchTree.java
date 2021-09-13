//给定一个单链表，其中的元素按升序排序，将其转换为高度平衡的二叉搜索树。
//
// 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。 
//
// 示例: 
//
// 给定的有序链表： [-10, -3, 0, 5, 9],
//
//一个可能的答案是：[0, -3, 9, -10, null, 5], 它可以表示下面这个高度平衡二叉搜索树：
//
//      0
//     / \
//   -3   9
//   /   /
// -10  5
// 
// Related Topics 树 二叉搜索树 链表 分治 二叉树 👍 584 👎 0


package io.hjforever.leetcode.editor.cn;

import io.hjforever.leetcode.editor.cn.common.ListNode;
import io.hjforever.leetcode.editor.cn.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Q109ConvertSortedListToBinarySearchTree {
    public static void main(String[] args) {
        Solution solution = new Q109ConvertSortedListToBinarySearchTree().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    class Solution {
        /**
         * 1.思路一 ： 此处参考 108 ， 先将链表转为为数组，然后在二分处理。此处会增加空间复杂度
         * 2.思路二： 依旧采用二分处理，但是需要每次找到链表的中间节点
         */
        public TreeNode sortedListToBST(ListNode head) {
            //return sortedListToBSTByArrayList(head);
            return sortedListToBSTByLinkedList(head);
        }


        /**
         * 思路一
         */
        private TreeNode sortedListToBSTByArrayList(ListNode head) {
            // list to array
            List<Integer> list = new ArrayList<>();
            while (head != null) {
                list.add(head.val);
                head = head.next;
            }
            return buildBstByArrayList(0, list.size() - 1, list);
        }

        private TreeNode buildBstByArrayList(int start, int end, List<Integer> nums) {
            //临界条件
            if (start > end) {
                return null;
            }
            //取中间值为顶点
            int mid = (start + end) / 2;
            TreeNode treeNode = new TreeNode();
            treeNode.val = nums.get(mid);
            treeNode.left = buildBstByArrayList(start, mid - 1, nums);
            treeNode.right = buildBstByArrayList(mid + 1, end, nums);
            return treeNode;
        }


        /**
         * 思路二 , 核心点是找中间节点，
         * <p>
         * 可以用两个指针， 快指针， 慢指针 ， 快指针每次走两步， 慢指针走一步 当快指针走到链表尾部则慢指针此时在中点
         * <p>
         * (一步两步，一步两步，似魔鬼的步伐.....)
         */
        private TreeNode sortedListToBSTByLinkedList(ListNode head) {
            //临界条件
            //为空
            if (head == null) {
                return null;
            }
            //当只有一个值
            if (head.next == null) {
                return new TreeNode(head.val);
            }
            ListNode fastNode = head;
            ListNode slowNode = head;
            ListNode preNode = null;

            while (fastNode != null && fastNode.next != null) {
                fastNode = fastNode.next.next;
                preNode = slowNode;
                slowNode = slowNode.next;
            }

            // 分割出左链表，用于构造本结点的左子树 , 此处会改变链表结构
            preNode.next = null;
            // 分割出右链表，用于构造本结点的右子树
            ListNode rightList = slowNode.next;
            // 用中间结点构造根结点
            TreeNode root = new TreeNode(slowNode.val);
            // 构造左子树
            root.left = sortedListToBSTByLinkedList(head);
            root.right = sortedListToBSTByLinkedList(rightList);
            return root;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
//给定一棵二叉树，设计一个算法，创建含有某一深度上所有节点的链表（比如，若一棵树的深度为 D，则会创建出 D 个链表）。返回一个包含所有深度的链表的数组。
//
// 
//
// 示例： 
//
// 输入：[1,2,3,4,5,null,7,8]
//
//        1
//       /  \ 
//      2    3
//     / \    \ 
//    4   5    7
//   /
//  8
//
//输出：[[1],[2,3],[4,5,7],[8]]
// 
// Related Topics 树 广度优先搜索 链表 二叉树 👍 58 👎 0


package io.hjforever.leetcode.editor.cn;

import io.hjforever.leetcode.editor.cn.common.ListNode;
import io.hjforever.leetcode.editor.cn.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class QMianShiTi0403TeDingShenDuJieDianLianBiao {
    public static void main(String[] args) {
        Solution solution = new QMianShiTi0403TeDingShenDuJieDianLianBiao().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */
    class Solution {
        public ListNode[] listOfDepth(TreeNode tree) {
            if (tree == null) {
                return null;
            }
            List<ListNode> list = new ArrayList<>();
            //bfs ,层级遍历
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(tree);
            while (!queue.isEmpty()) {
                int length = queue.size();
                ListNode listNode = new ListNode(-1);
                ListNode preNode = listNode;
                for (int i = 0; i < length; i++) {
                    TreeNode treeNode = queue.poll();
                    preNode.next = new ListNode(treeNode.val);
                    preNode = preNode.next;
                    //添加子节点
                    if (treeNode.left != null) {
                        queue.offer(treeNode.left);
                    }
                    if (treeNode.right != null) {
                        queue.offer(treeNode.right);
                    }
                }
                list.add(listNode.next);
            }
            return list.toArray(new ListNode[list.size()]);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
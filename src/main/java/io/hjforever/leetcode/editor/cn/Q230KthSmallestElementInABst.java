//给定一个二叉搜索树的根节点 root ，和一个整数 k ，请你设计一个算法查找其中第 k 个最小元素（从 1 开始计数）。
//
// 
//
// 示例 1： 
//
// 
//输入：root = [3,1,4,null,2], k = 1
//输出：1
// 
//
// 示例 2： 
//
// 
//输入：root = [5,3,6,2,4,null,null,1], k = 3
//输出：3
// 
//
// 
//
// 
//
// 提示： 
//
// 
// 树中的节点数为 n 。 
// 1 <= k <= n <= 10⁴ 
// 0 <= Node.val <= 10⁴ 
// 
//
// 
//
// 进阶：如果二叉搜索树经常被修改（插入/删除操作）并且你需要频繁地查找第 k 小的值，你将如何优化算法？ 
// Related Topics 树 深度优先搜索 二叉搜索树 二叉树 👍 447 👎 0


package io.hjforever.leetcode.editor.cn;

import io.hjforever.leetcode.editor.cn.common.TreeNode;
import sun.reflect.generics.tree.Tree;

public class Q230KthSmallestElementInABst {
    public static void main(String[] args) {
        Solution solution = new Q230KthSmallestElementInABst().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

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
         * 此题和二分查找没多大关系，因为中序遍历是有序的。
         * 中序遍历，递归到第k个元素
         */

        private int count = 1;
        private int result = 0;

        public int kthSmallest(TreeNode root, int k) {
            inOrder(root, k);
            return result;
        }

        private void inOrder(TreeNode root, int k) {
            if (root != null) {
                inOrder(root.left, k);
                if (count == k) {
                    result = root.val;
                } else if (count > k) {
                    //终止
                    return;
                }
                count++;
                inOrder(root.right, k);
            }
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
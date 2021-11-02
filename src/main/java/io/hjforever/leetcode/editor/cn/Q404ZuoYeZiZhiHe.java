//计算给定二叉树的所有左叶子之和。
//
// 示例： 
//
// 
//    3
//   / \
//  9  20
//    /  \
//   15   7
//
//在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24 
//
// 
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 357 👎 0


package io.hjforever.leetcode.editor.cn;

import io.hjforever.leetcode.editor.cn.common.TreeNode;

public class Q404ZuoYeZiZhiHe {
    public static void main(String[] args) {
        Solution solution = new Q404ZuoYeZiZhiHe().new Solution();
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

        int sum = 0;

        public int sumOfLeftLeaves(TreeNode root) {
            sumOfLeft(root);
            return sum;
        }

        public void sumOfLeft(TreeNode root) {
            if (root == null) {
                return;
            }
            //必须是左节点，且是叶子节点
            if (root.left != null && (root.left.left == null && root.left.right == null)) {
                sum = sum + root.left.val;
            }
            sumOfLeft(root.left);
            sumOfLeft(root.right);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
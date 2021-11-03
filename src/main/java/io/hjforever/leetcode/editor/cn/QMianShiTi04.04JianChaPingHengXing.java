//实现一个函数，检查二叉树是否平衡。在这个问题中，平衡树的定义如下：任意一个节点，其两棵子树的高度差不超过 1。 示例 1: 给定二叉树 [3,9,20,
//null,null,15,7]     3    / \   9  20     /  \    15   7 返回 true 。示例 2: 给定二叉树 [1,2,
//2,3,3,null,null,4,4]       1      / \     2   2    / \   3   3  / \ 4   4 返回 
//false 。 Related Topics 树 深度优先搜索 二叉树 👍 70 👎 0


package io.hjforever.leetcode.editor.cn;

import io.hjforever.leetcode.editor.cn.common.TreeNode;

 class QMianShiTi0404JianChaPingHengXing {
    public static void main(String[] args) {
        Solution solution = new QMianShiTi0404JianChaPingHengXing().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    class Solution {
        public boolean isBalanced(TreeNode root) {
            if (root == null) {
                return true;
            }
            return isBalancedTree(root);
        }

        private boolean isBalancedTree(TreeNode root) {
            int leftDepth = maxTreeDepth(root.left);
            int rightDepth = maxTreeDepth(root.right);
            int depth = Math.abs(leftDepth - rightDepth);
            return depth <= 1 && isBalanced(root.left) && isBalanced(root.right);
        }

        int maxTreeDepth(TreeNode treeNode) {
            if (treeNode == null) {
                return 0;
            }
            return Math.max(maxTreeDepth(treeNode.left), maxTreeDepth(treeNode.right)) + 1;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
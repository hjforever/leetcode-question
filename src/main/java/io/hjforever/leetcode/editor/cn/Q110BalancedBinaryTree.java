//给定一个二叉树，判断它是否是高度平衡的二叉树。
//
// 本题中，一棵高度平衡二叉树定义为： 
//
// 
// 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1 。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [3,9,20,null,null,15,7]
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：root = [1,2,2,3,3,null,null,4,4]
//输出：false
// 
//
// 示例 3： 
//
// 
//输入：root = []
//输出：true
// 
//
// 
//
// 提示： 
//
// 
// 树中的节点数在范围 [0, 5000] 内 
// -10⁴ <= Node.val <= 10⁴ 
// 
// Related Topics 树 深度优先搜索 二叉树 👍 768 👎 0


package io.hjforever.leetcode.editor.cn;

import io.hjforever.leetcode.editor.cn.common.TreeNode;

public class Q110BalancedBinaryTree {
    public static void main(String[] args) {
        Solution solution = new Q110BalancedBinaryTree().new Solution();
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
         * 比较左子树和右子树的深度 不大于1, 还需要加上 左子树的孩子和右子树的孩子
         */
        public boolean isBalanced(TreeNode root) {
            if (root == null) {
                return true;
            }
            int leftDepth = treeMaxDepth(root.left);
            int rightDepth = treeMaxDepth(root.right);
            return Math.abs(leftDepth - rightDepth) <= 1 && isBalanced(root.left) && isBalanced(root.right);
        }


        //获取树最大深度
        private int treeMaxDepth(TreeNode root) {
            if (root == null) {
                return 0;
            }
            return Math.max(treeMaxDepth(root.left), treeMaxDepth(root.right)) + 1;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
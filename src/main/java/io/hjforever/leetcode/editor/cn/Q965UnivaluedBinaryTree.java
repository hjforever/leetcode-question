//A binary tree is uni-valued if every node in the tree has the same value.
//
// Given the root of a binary tree, return true if the given tree is uni-valued,
// or false otherwise. 
//
// 
// Example 1: 
//
// 
//Input: root = [1,1,1,1,1,null,1]
//Output: true
// 
//
// Example 2: 
//
// 
//Input: root = [2,2,2,5,2]
//Output: false
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree is in the range [1, 100]. 
// 0 <= Node.val < 100 
// 
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 110 👎 0


package io.hjforever.leetcode.editor.cn;

import io.hjforever.leetcode.editor.cn.common.TreeNode;

public class Q965UnivaluedBinaryTree {
    public static void main(String[] args) {
        Solution solution = new Q965UnivaluedBinaryTree().new Solution();
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

        boolean ans = true;

        public boolean isUnivalTree(TreeNode root) {
            dfs(root,root.val);
            return  ans;
        }

        void dfs(TreeNode root, int val) {
            if (root == null) return;
            dfs(root.left, val);
            if (val != root.val) {
                ans = false;
                return;
            }
            dfs(root.right, val);
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
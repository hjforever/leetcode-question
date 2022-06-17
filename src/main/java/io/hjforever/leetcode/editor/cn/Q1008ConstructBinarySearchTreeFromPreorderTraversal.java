//Given an array of integers preorder, which represents the preorder traversal
//of a BST (i.e., binary search tree), construct the tree and return its root. 
//
// It is guaranteed that there is always possible to find a binary search tree 
//with the given requirements for the given test cases. 
//
// A binary search tree is a binary tree where for every node, any descendant 
//of Node.left has a value strictly less than Node.val, and any descendant of Node.
//right has a value strictly greater than Node.val. 
//
// A preorder traversal of a binary tree displays the value of the node first, 
//then traverses Node.left, then traverses Node.right. 
//
// 
// Example 1: 
//
// 
//Input: preorder = [8,5,1,7,10,12]
//Output: [8,5,10,1,7,null,12]
// 
//
// Example 2: 
//
// 
//Input: preorder = [1,3]
//Output: [1,null,3]
// 
//
// 
// Constraints: 
//
// 
// 1 <= preorder.length <= 100 
// 1 <= preorder[i] <= 1000 
// All the values of preorder are unique. 
// 
// Related Topics 栈 树 二叉搜索树 数组 二叉树 单调栈 👍 220 👎 0


package io.hjforever.leetcode.editor.cn;

import io.hjforever.leetcode.editor.cn.common.TreeNode;

public class Q1008ConstructBinarySearchTreeFromPreorderTraversal {
    public static void main(String[] args) {
        Solution solution = new Q1008ConstructBinarySearchTreeFromPreorderTraversal().new Solution();
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
        public TreeNode bstFromPreorder(int[] preorder) {
            return build(preorder, 0, preorder.length - 1);
        }

        TreeNode build(int[] preorder, int i, int j) {
            if (i > j) {
                return null;
            }
            TreeNode root = new TreeNode(preorder[i]);
            if (i == j) {
                return root;
            }
            int val = preorder[i];
            int k = i + 1;
            while (k <= j && preorder[k] < val) {
                k++;
            }
            root.left = build(preorder, i + 1, k - 1);
            root.right = build(preorder, k, j);
            return root;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
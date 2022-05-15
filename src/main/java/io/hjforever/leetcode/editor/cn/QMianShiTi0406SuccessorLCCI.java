//Write an algorithm to find the "next" node (i.e., in-order successor) of a
//given node in a binary search tree. 
//
// Return null if there's no "next" node for the given node. 
//
// Example 1: 
//
// 
//Input: root = [2,1,3], p = 1
//
//  2
// / \
//1   3
//
//Output: 2 
//
// Example 2: 
//
// 
//Input: root = [5,3,6,2,4,null,null,1], p = 6
//
//      5
//     / \
//    3   6
//   / \
//  2   4
// /   
//1
//
//Output: null 
// Related Topics 树 深度优先搜索 二叉搜索树 二叉树 👍 98 👎 0


package io.hjforever.leetcode.editor.cn;

import io.hjforever.leetcode.editor.cn.common.TreeNode;

public class QMianShiTi0406SuccessorLCCI {
    public static void main(String[] args) {
        // Solution solution = new QMianShiTi04.06SuccessorLCCI().new Solution();
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
        TreeNode t = null;
        TreeNode res = null;

        public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
            // inorder
            inorder(root, p);
            return res;
        }

        void inorder(TreeNode root, TreeNode p) {
            if(root==null) return;
            inorder(root.left,p);
            if(t!=null && res ==null){
                res = root ;
                return;
            }
            if(t==null && root== p){
                t = p ;
            }
            inorder(root.right,p);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
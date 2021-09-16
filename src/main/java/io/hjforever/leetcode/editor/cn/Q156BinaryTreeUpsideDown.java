//给你一个二叉树的根节点 root ，请你将此二叉树上下翻转，并返回新的根节点。
//
// 你可以按下面的步骤翻转一棵二叉树： 
//
// 
// 原来的左子节点变成新的根节点 
// 原来的根节点变成新的右子节点 
// 原来的右子节点变成新的左子节点 
// 
//
// 上面的步骤逐层进行。题目数据保证每个右节点都有一个同级节点（即共享同一父节点的左节点）且不存在子节点。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [1,2,3,4,5]
//输出：[4,5,2,null,null,3,1]
// 
//
// 示例 2： 
//
// 
//输入：root = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：root = [1]
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [0, 10] 内 
// 1 <= Node.val <= 10 
// 树中的每个右节点都有一个同级节点（即共享同一父节点的左节点） 
// 树中的每个右节点都没有子节点 
// 
// Related Topics 树 深度优先搜索 二叉树 👍 80 👎 0


package io.hjforever.leetcode.editor.cn;

import io.hjforever.leetcode.editor.cn.common.TreeNode;

public class Q156BinaryTreeUpsideDown {
    public static void main(String[] args) {
        Solution solution = new Q156BinaryTreeUpsideDown().new Solution();
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
         * dfs
         */

        //记录反转后的头节点
        TreeNode head = null;

        public TreeNode upsideDownBinaryTree(TreeNode root) {
            //对于root来说，父节点为null
            dfs(root, null);
            return head;
        }

        public void dfs(TreeNode root, TreeNode pre) {
            if (root == null) return;
            //前序遍历，先往左走
            dfs(root.left, root);
            if (head == null) {
                //head置为最左边的节点
                head = root;
            }
            //记录当前节点的右节点，因为当前节点的右节点要置为其父节点，为了能正常遍历，需要先进行记录
            TreeNode r = root.right;
            if (pre != null) {
                //父节点的left置为null，不会对遍历过程造成影响，因为左边已经全部遍历完成了
                pre.left = null;
                //当前节点左节点置为父节点的右节点
                root.left = pre.right;
                //父节点的right置为null，不会对遍历过程造成影响，因为右节点已经在上层进行了记录
                pre.right = null;
                //当前节点右节点置为父节点
                root.right = pre;
            }
            //向右进行遍历
            dfs(r, root);
        }

        //递归
        private TreeNode upsideDownBinaryTreeByRecusion(TreeNode root) {
            if (root == null || root.left == null) {
                return root;
            }
            TreeNode left = root.left ;
            TreeNode right = root.right ;
            TreeNode result = upsideDownBinaryTreeByRecusion(root.left);
            root.left = null ;
            root.right = null ;
            left.right = root ;
            left.left = right ;
            return  result ;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
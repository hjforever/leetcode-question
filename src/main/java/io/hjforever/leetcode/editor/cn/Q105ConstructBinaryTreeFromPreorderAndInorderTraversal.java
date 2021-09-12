//给定一棵树的前序遍历 preorder 与中序遍历 inorder。请构造二叉树并返回其根节点。
//
// 
//
// 示例 1: 
//
// 
//Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
//Output: [3,9,20,null,null,15,7]
// 
//
// 示例 2: 
//
// 
//Input: preorder = [-1], inorder = [-1]
//Output: [-1]
// 
//
// 
//
// 提示: 
//
// 
// 1 <= preorder.length <= 3000 
// inorder.length == preorder.length 
// -3000 <= preorder[i], inorder[i] <= 3000 
// preorder 和 inorder 均无重复元素 
// inorder 均出现在 preorder 
// preorder 保证为二叉树的前序遍历序列 
// inorder 保证为二叉树的中序遍历序列 
// 
// Related Topics 树 数组 哈希表 分治 二叉树 👍 1203 👎 0


package io.hjforever.leetcode.editor.cn;

import io.hjforever.leetcode.editor.cn.common.TreeNode;

import java.util.Arrays;

public class Q105ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public static void main(String[] args) {
        Solution solution = new Q105ConstructBinaryTreeFromPreorderAndInorderTraversal().new Solution();
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
         * 1.根据前序遍历确定根节点
         * 2.根据根节点值确定 左子树 和 右子树
         * 3.递归左子树 和 右子树
         * <p>
         * 终止条件 ： 左右子树均为空
         */
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            //临界
            if (preorder == null || inorder == null || preorder.length == 0 || inorder.length == 0) {
                return null;
            }
            //根据前序遍历获取根节点
            int rootNode = preorder[0];
            //获取中序遍历中根节点的位置
            int rootInorderIndex = 0;
            for (int i = 0; i < inorder.length; i++) {
                if (rootNode == inorder[i]) {
                    rootInorderIndex = i;
                }
            }
            //  3, 9,20,15,7    9, 3 ,15,20,7

            //分离左子树
            int leftTreeLength = rootInorderIndex;
            int[] leftInorder = Arrays.copyOfRange(inorder, 0, rootInorderIndex);
            // 从根节点后开始的长度为 leftTreeLength 为 左子树的前序
            int[] leftPreOrder = Arrays.copyOfRange(preorder, 1, leftTreeLength + 1);

            //分离右子树
            int[] rightInorder = Arrays.copyOfRange(inorder, rootInorderIndex + 1, inorder.length);
            int[] rightPreOrder = Arrays.copyOfRange(preorder, leftTreeLength + 1, preorder.length);

            TreeNode treeNode = new TreeNode();
            treeNode.val = rootNode;
            treeNode.left = buildTree(leftPreOrder, leftInorder);
            treeNode.right = buildTree(rightPreOrder, rightInorder);
            return treeNode;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
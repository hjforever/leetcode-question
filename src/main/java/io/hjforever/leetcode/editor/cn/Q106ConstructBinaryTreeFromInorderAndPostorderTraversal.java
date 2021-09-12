//根据一棵树的中序遍历与后序遍历构造二叉树。
//
// 注意: 
//你可以假设树中没有重复的元素。 
//
// 例如，给出 
//
// 中序遍历 inorder = [9,3,15,20,7]
//后序遍历 postorder = [9,15,7,20,3] 
//
// 返回如下的二叉树： 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// 
// Related Topics 树 数组 哈希表 分治 二叉树 👍 573 👎 0


package io.hjforever.leetcode.editor.cn;

import io.hjforever.leetcode.editor.cn.common.TreeNode;

import java.util.Arrays;

public class Q106ConstructBinaryTreeFromInorderAndPostorderTraversal {
    public static void main(String[] args) {
        Solution solution = new Q106ConstructBinaryTreeFromInorderAndPostorderTraversal().new Solution();
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
         * 思路参考前序遍历，后序遍历只需要每次取根节点从最后一位取
         */
        /**
         * 1.根据前序遍历确定根节点
         * 2.根据根节点值确定 左子树 和 右子树
         * 3.递归左子树 和 右子树
         * <p>
         * 终止条件 ： 左右子树均为空
         */
        public TreeNode buildTree(int[] inorder, int[] postorder) {
            //临界
            if (postorder == null || inorder == null || postorder.length == 0 || inorder.length == 0) {
                return null;
            }
            //根据前序遍历获取根节点
            int rootNode = postorder[postorder.length - 1];
            //获取中序遍历中根节点的位置
            int rootInorderIndex = 0;
            for (int i = 0; i < inorder.length; i++) {
                if (rootNode == inorder[i]) {
                    rootInorderIndex = i;
                }
            }
            //  3, 9,20,15,7    [9,15,7,20, 3]

            //分离左子树
            int leftTreeLength = rootInorderIndex;
            int[] leftInorder = Arrays.copyOfRange(inorder, 0, rootInorderIndex);
            // 从根节点后开始的长度为 leftTreeLength 为 左子树的前序
            int[] leftPostOrder = Arrays.copyOfRange(postorder, 0, leftTreeLength);

            //分离右子树
            int[] rightInorder = Arrays.copyOfRange(inorder, rootInorderIndex + 1, inorder.length);
            int[] rightPostOrder = Arrays.copyOfRange(postorder, leftTreeLength, postorder.length-1);

            TreeNode treeNode = new TreeNode();
            treeNode.val = rootNode;
            treeNode.left = buildTree(leftInorder,leftPostOrder);
            treeNode.right = buildTree(rightInorder,rightPostOrder);
            return treeNode;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
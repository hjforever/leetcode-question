//输入某二叉树的前序遍历和中序遍历的结果，请构建该二叉树并返回其根节点。
//
// 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。 
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
// 限制： 
//
// 0 <= 节点个数 <= 5000 
//
// 
//
// 注意：本题与主站 105 题重复：https://leetcode-cn.com/problems/construct-binary-tree-from-
//preorder-and-inorder-traversal/ 
// Related Topics 树 数组 哈希表 分治 二叉树 👍 609 👎 0


package io.hjforever.leetcode.editor.cn;

import io.hjforever.leetcode.editor.cn.common.TreeNode;

import java.util.Arrays;

public class QJianZhiOffer07ZhongJianErChaShu {
    public static void main(String[] args) {
        Solution solution = new QJianZhiOffer07ZhongJianErChaShu().new Solution();
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
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            //preorder = [3, 9,20,15,7], inorder = [9, 3, 15,20,7]
            if (preorder == null || inorder == null || preorder.length == 0 || inorder.length == 0) {
                return null;
            }
            int rootVal = preorder[0];

            //寻找 inorder root索引
            int rootIndex = 0;
            for (int i = 0; i < inorder.length; i++) {
                if (rootVal == inorder[i]) {
                    rootIndex = i;
                    break;
                }
            }

            int leftTreeLength = rootIndex;

            //分离左子树
            int[] leftInorder = Arrays.copyOfRange(inorder, 0, leftTreeLength);
            int[] leftPreOrder = Arrays.copyOfRange(preorder, 1, leftTreeLength + 1);


            //分离右子树
            int[] rightInorder = Arrays.copyOfRange(inorder, leftTreeLength + 1, inorder.length);
            int[] rightPreOrder = Arrays.copyOfRange(preorder, leftTreeLength + 1, preorder.length);

            TreeNode treeNode = new TreeNode(rootVal);
            treeNode.left = buildTree(leftPreOrder, leftInorder);
            treeNode.right = buildTree(rightPreOrder, rightInorder);
            return treeNode;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
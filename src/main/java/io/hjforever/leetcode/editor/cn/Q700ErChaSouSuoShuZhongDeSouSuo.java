//给定二叉搜索树（BST）的根节点和一个值。 你需要在BST中找到节点值等于给定值的节点。 返回以该节点为根的子树。 如果节点不存在，则返回 NULL。
//
// 例如， 
//
// 
//给定二叉搜索树:
//
//        4
//       / \
//      2   7
//     / \
//    1   3
//
//和值: 2
// 
//
// 你应该返回如下子树: 
//
// 
//      2     
//     / \   
//    1   3
// 
//
// 在上述示例中，如果要找的值是 5，但因为没有节点值为 5，我们应该返回 NULL。 
// Related Topics 树 二叉搜索树 二叉树 👍 217 👎 0


package io.hjforever.leetcode.editor.cn;

import io.hjforever.leetcode.editor.cn.common.TreeNode;

public class Q700ErChaSouSuoShuZhongDeSouSuo {
    public static void main(String[] args) {
        Solution solution = new Q700ErChaSouSuoShuZhongDeSouSuo().new Solution();
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
        TreeNode res;

        public TreeNode searchBST(TreeNode root, int val) {
            seach(root, val);
            return res;
        }

        //二分搜索
        void seach(TreeNode root, int val) {
            if (root == null) {
                return;
            }
            if (root.val == val) {
                res = root;
                return;
            } else if (root.val > val) {
                seach(root.left, val);
            } else {
                seach(root.right, val);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
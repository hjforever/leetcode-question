//实现一个函数，检查一棵二叉树是否为二叉搜索树。示例 1: 输入:     2    / \   1   3 输出: true 示例 2: 输入:     5
//    / \   1   4      / \     3   6 输出: false 解释: 输入为: [5,1,4,null,null,3,6]。    
//  根节点的值为 5 ，但是其右子节点值为 4 。 Related Topics 树 深度优先搜索 二叉搜索树 二叉树 👍 61 👎 0


package io.hjforever.leetcode.editor.cn;

import io.hjforever.leetcode.editor.cn.common.TreeNode;

class QMianShiTi0405HeFaErChaSouSuoShu {
    public static void main(String[] args) {
        Solution solution = new QMianShiTi0405HeFaErChaSouSuoShu().new Solution();
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
        public boolean isValidBST(TreeNode root) {
            if (root == null || (root.left == null && root.right == null)) {
                return true;
            }
            //二叉搜索树特性
            return isValid(root, Long.MIN_VALUE, Long.MAX_VALUE);
        }

        boolean isValid(TreeNode root, long left, long right) {
            if (root == null) {
                return true;
            }
            int val = root.val;
            return (left < val) && (right > val) && isValid(root.left, left, val) && isValid(root.right, val, right);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
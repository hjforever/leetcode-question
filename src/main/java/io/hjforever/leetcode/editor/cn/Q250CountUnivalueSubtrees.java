//给定一个二叉树，统计该二叉树数值相同的子树个数。
//
// 同值子树是指该子树的所有节点都拥有相同的数值。 
//
// 示例： 
//
// 输入: root = [5,1,5,5,5,null,5]
//
//              5
//             / \
//            1   5
//           / \   \
//          5   5   5
//
//输出: 4
// 
// Related Topics 树 深度优先搜索 二叉树 👍 83 👎 0


package io.hjforever.leetcode.editor.cn;

import io.hjforever.leetcode.editor.cn.common.TreeNode;

public class Q250CountUnivalueSubtrees {
    public static void main(String[] args) {
        Solution solution = new Q250CountUnivalueSubtrees().new Solution();
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

        //统计计数
        int count = 0;

        //给定树中的一个结点，若其满足下面条件中的一个，则子树同值:
        //
        //该节点没有子结点 （基本情况）
        //该节点的所有子结点都为同值子树，且结点与其子结点值相同。

        public int countUnivalSubtrees(TreeNode root) {
            if (root == null) {
                return 0;
            }
            isUnivalSubTree(root);
            return count;
        }

        boolean isUnivalSubTree(TreeNode root) {
            //当为叶子节点
            if (root.left == null && root.right == null) {
                count++;
                return true;
            }
            //非叶子节点
            boolean isUnivalSubTree = true;

            //判断左节点
            if (root.left != null) {
                //先要判断子树在判断值，即先要让递归跑完
                isUnivalSubTree = isUnivalSubTree(root.left) && isUnivalSubTree && (root.left.val == root.val);
            }

            //判断右节点
            if (root.right != null) {
                isUnivalSubTree = isUnivalSubTree(root.right) && isUnivalSubTree && (root.right.val == root.val);
            }

            if (!isUnivalSubTree) {
                return false;
            }
            count++;
            return true;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
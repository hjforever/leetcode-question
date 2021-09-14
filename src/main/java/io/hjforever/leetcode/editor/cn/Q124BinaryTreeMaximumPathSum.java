//路径 被定义为一条从树中任意节点出发，沿父节点-子节点连接，达到任意节点的序列。同一个节点在一条路径序列中 至多出现一次 。该路径 至少包含一个 节点，且不
//一定经过根节点。 
//
// 路径和 是路径中各节点值的总和。 
//
// 给你一个二叉树的根节点 root ，返回其 最大路径和 。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [1,2,3]
//输出：6
//解释：最优路径是 2 -> 1 -> 3 ，路径和为 2 + 1 + 3 = 6 
//
// 示例 2： 
//
// 
//输入：root = [-10,9,20,null,null,15,7]
//输出：42
//解释：最优路径是 15 -> 20 -> 7 ，路径和为 15 + 20 + 7 = 42
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目范围是 [1, 3 * 10⁴] 
// -1000 <= Node.val <= 1000 
// 
// Related Topics 树 深度优先搜索 动态规划 二叉树 👍 1219 👎 0


package io.hjforever.leetcode.editor.cn;

import io.hjforever.leetcode.editor.cn.common.TreeNode;

import java.util.List;

public class Q124BinaryTreeMaximumPathSum {
    public static void main(String[] args) {
        Solution solution = new Q124BinaryTreeMaximumPathSum().new Solution();
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

        int maxSum = Integer.MIN_VALUE;


        public int maxPathSum(TreeNode root) {
            maxGain(root);
            return maxSum;
        }

        public int maxGain(TreeNode root) {
            if (root == null) {
                return 0;
            }
            // 递归计算左右子节点的最大贡献值
            // 只有在最大贡献值大于 0 时，才会选取对应子节点
            int leftGain = Math.max(maxGain(root.left), 0);
            int rightGain = Math.max(maxGain(root.right), 0);
            int priceNewPath = root.val + leftGain + rightGain;
            maxSum = Math.max(maxSum, priceNewPath);
            // 返回节点的最大贡献值
            return root.val + Math.max(leftGain, rightGain);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
//给定一个不为空的二叉搜索树和一个目标值 target，请在该二叉搜索树中找到最接近目标值 target 的数值。
//
// 注意： 
//
// 
// 给定的目标值 target 是一个浮点数 
// 题目保证在该二叉搜索树中只会存在一个最接近目标值的数 
// 
//
// 示例： 
//
// 输入: root = [4,2,5,1,3]，目标值 target = 3.714286
//
//    4
//   / \
//  2   5
// / \
//1   3
//
//输出: 4
// 
// Related Topics 树 深度优先搜索 二叉搜索树 二分查找 二叉树 👍 97 👎 0


package io.hjforever.leetcode.editor.cn;

import io.hjforever.leetcode.editor.cn.common.TreeNode;

public class Q270ClosestBinarySearchTreeValue {
    public static void main(String[] args) {
        Solution solution = new Q270ClosestBinarySearchTreeValue().new Solution();
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

        //最接近的节点值
        int closetNodeValue = Integer.MAX_VALUE;

        //最接近的差值
        double closetValue = Double.MAX_VALUE;

        //深度遍历
        public int closestValue(TreeNode root, double target) {
            dfs(root, target);
            return closetNodeValue;
        }

        void dfs(TreeNode root, double target) {
            if (root == null) {
                return;
            }
            int val = root.val;
            double closetV = Math.abs(target - val);
            if (closetV < closetValue) {
                closetValue = closetV;
                closetNodeValue = val;
            }
            dfs(root.left, target);
            dfs(root.right, target);
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
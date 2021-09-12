//给定一个非空二叉树, 返回一个由每层节点平均值组成的数组。
//
// 
//
// 示例 1： 
//
// 输入：
//    3
//   / \
//  9  20
//    /  \
//   15   7
//输出：[3, 14.5, 11]
//解释：
//第 0 层的平均值是 3 ,  第1层是 14.5 , 第2层是 11 。因此返回 [3, 14.5, 11] 。
// 
//
// 
//
// 提示： 
//
// 
// 节点值的范围在32位有符号整数范围内。 
// 
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 285 👎 0


package io.hjforever.leetcode.editor.cn;

import io.hjforever.leetcode.editor.cn.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Q637AverageOfLevelsInBinaryTree {
    public static void main(String[] args) {
        Solution solution = new Q637AverageOfLevelsInBinaryTree().new Solution();
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
         * 思路参考层序遍历
         */

        public List<Double> averageOfLevels(TreeNode root) {
            return averageOfLevelTree(root);
        }

        //层级遍历
        private List<Double> averageOfLevelTree(TreeNode treeNode) {
            List<Double> levelOrderList = new ArrayList<>();
            if (treeNode == null) {
                return levelOrderList;
            }
            Queue<TreeNode> treeNodeQueue = new LinkedList<>();
            //添加根节点
            treeNodeQueue.offer(treeNode);
            while (!treeNodeQueue.isEmpty()) {
                //添加子节点
                Double averageValue = 0.0;
                int size = treeNodeQueue.size();
                for (int i = 1; i <= size; i++) {
                    TreeNode node = treeNodeQueue.poll();
                    averageValue = averageValue + node.val;
                    //加入子节点
                    if (node.left != null) {
                        treeNodeQueue.offer(node.left);
                    }
                    if (node.right != null) {
                        treeNodeQueue.offer(node.right);
                    }
                }
                averageValue = averageValue / size;
                levelOrderList.add(averageValue);
            }
            return levelOrderList;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
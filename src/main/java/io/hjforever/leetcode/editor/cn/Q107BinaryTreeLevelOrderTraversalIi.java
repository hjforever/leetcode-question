//给定一个二叉树，返回其节点值自底向上的层序遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
//
// 例如： 
//给定二叉树 [3,9,20,null,null,15,7], 
//
// 
//    3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回其自底向上的层序遍历为： 
//
// 
//[
//  [15,7],
//  [9,20],
//  [3]
//]
// 
// Related Topics 树 广度优先搜索 二叉树 👍 481 👎 0


package io.hjforever.leetcode.editor.cn;

import io.hjforever.leetcode.editor.cn.common.TreeNode;

import java.util.*;

public class Q107BinaryTreeLevelOrderTraversalIi {
    public static void main(String[] args) {
        Solution solution = new Q107BinaryTreeLevelOrderTraversalIi().new Solution();
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
         * 二叉树层级遍历
         * <p>
         * 每次将子节点加入队列中，输出后移除 ， 当队列为空则 表示已经处理完成
         * <p>
         * 此处输出需要反转，自底向上
         */
        public List<List<Integer>> levelOrderBottom(TreeNode root) {
            List<List<Integer>> levelOrderList = levelOrder(root);
            //反转
            Collections.reverse(levelOrderList);
            return levelOrderList;
        }

        //层级遍历
        private List<List<Integer>> levelOrder(TreeNode treeNode) {
            List<List<Integer>> levelOrderList = new ArrayList<>();
            if (treeNode == null) {
                return levelOrderList;
            }
            Queue<TreeNode> treeNodeQueue = new LinkedList<>();
            //添加根节点
            treeNodeQueue.offer(treeNode);
            while (!treeNodeQueue.isEmpty()) {
                //添加子节点
                int size = treeNodeQueue.size();
                List<Integer> childLevelList = new ArrayList<>();
                for (int i = 1; i <= size; i++) {
                    TreeNode node = treeNodeQueue.poll();
                    childLevelList.add(node.val);
                    //加入子节点
                    if (node.left != null) {
                        treeNodeQueue.offer(node.left);
                    }
                    if (node.right != null) {
                        treeNodeQueue.offer(node.right);
                    }
                }
                levelOrderList.add(childLevelList);
            }
            return levelOrderList;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
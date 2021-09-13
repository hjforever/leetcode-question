//给定一个二叉树的 根节点 root，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
//
// 
//
// 示例 1: 
//
// 
//
// 
//输入: [1,2,3,null,5,null,4]
//输出: [1,3,4]
// 
//
// 示例 2: 
//
// 
//输入: [1,null,3]
//输出: [1,3]
// 
//
// 示例 3: 
//
// 
//输入: []
//输出: []
// 
//
// 
//
// 提示: 
//
// 
// 二叉树的节点个数的范围是 [0,100] 
// -100 <= Node.val <= 100 
// 
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 535 👎 0


package io.hjforever.leetcode.editor.cn;

import io.hjforever.leetcode.editor.cn.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Q199BinaryTreeRightSideView {
    public static void main(String[] args) {
        Solution solution = new Q199BinaryTreeRightSideView().new Solution();
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
         * 广度优先搜索，去每层的最右边节点即可
         * 参考 Q102 层级遍历
         */
        public List<Integer> rightSideView(TreeNode root) {
            return levelOrderRightVal(root);
        }
        /**
         * 二叉树层级遍历
         * <p>
         * 每次将子节点加入队列中，输出后移除 ， 当队列为空则 表示已经处理完成
         */
        public List<Integer> levelOrderRightVal(TreeNode root) {
            List<Integer> levelOrderList = new ArrayList<>();
            if (root == null) {
                return levelOrderList;
            }
            Queue<TreeNode> treeNodeQueue = new LinkedList<>();
            //添加根节点
            treeNodeQueue.offer(root);
            while (!treeNodeQueue.isEmpty()) {
                //添加子节点
                int size = treeNodeQueue.size();
                Integer rightVal = null;
                for (int i = 1; i <= size; i++) {
                    TreeNode node = treeNodeQueue.poll();
                    rightVal = node.val;
                    //加入子节点
                    if (node.left != null) {
                        treeNodeQueue.offer(node.left);
                    }
                    if (node.right != null) {
                        treeNodeQueue.offer(node.right);
                    }
                }
                levelOrderList.add(rightVal);
            }
            return levelOrderList;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
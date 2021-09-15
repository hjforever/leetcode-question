//给你一棵 完全二叉树 的根节点 root ，求出该树的节点个数。
//
// 完全二叉树 的定义如下：在完全二叉树中，除了最底层节点可能没填满外，其余每层节点数都达到最大值，并且最下面一层的节点都集中在该层最左边的若干位置。若最底层
//为第 h 层，则该层包含 1~ 2ʰ 个节点。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [1,2,3,4,5,6]
//输出：6
// 
//
// 示例 2： 
//
// 
//输入：root = []
//输出：0
// 
//
// 示例 3： 
//
// 
//输入：root = [1]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 树中节点的数目范围是[0, 5 * 10⁴] 
// 0 <= Node.val <= 5 * 10⁴ 
// 题目数据保证输入的树是 完全二叉树 
// 
//
// 
//
// 进阶：遍历树来统计节点是一种时间复杂度为 O(n) 的简单解决方案。你可以设计一个更快的算法吗？ 
// Related Topics 树 深度优先搜索 二分查找 二叉树 👍 532 👎 0


package io.hjforever.leetcode.editor.cn;

import io.hjforever.leetcode.editor.cn.common.TreeNode;
import sun.reflect.generics.tree.Tree;

public class Q222CountCompleteTreeNodes {
    public static void main(String[] args) {
        Solution solution = new Q222CountCompleteTreeNodes().new Solution();
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
         * 思路1 ： 简单用二叉树遍历，但是时间复杂度 不符合
         * <p>
         * 思路2 ： 利用满二叉树的原理， 先求树的深度， 在用二分法查找底层节点
         * <p>
         * 思路3 ： 递归根据满二叉树的原理 ， 当子树为满二叉树 则直接用 1<<level 移位即可
         */

        public int countNodes(TreeNode root) {
            //思路二 return binarySearchTree(root);
            // 思路三
            return countNodesByRecursion(root);
        }

        /**
         * 针对完全二叉树的解法
         * <p>
         * 满二叉树的结点数为：2^depth - 1
         */
        public int countNodesByRecursion(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int leftDepth = getDepth(root.left);
            int rightDepth = getDepth(root.right);
            if (leftDepth == rightDepth) {// 左子树是满二叉树
                // 2^leftDepth其实是 （2^leftDepth - 1） + 1 ，左子树 + 根结点
                return (1 << leftDepth) + countNodesByRecursion(root.right);
            } else {// 右子树是满二叉树
                return (1 << rightDepth) + countNodesByRecursion(root.left);
            }
        }

        //获取深度
        private int getDepth(TreeNode root) {
            int depth = 0;
            while (root != null) {
                root = root.left;
                depth++;
            }
            return depth;
        }

        //二分搜索数值法
        private int binarySearchTree(TreeNode root) {
            //先求树的层级
            if (root == null) {
                return 0;
            }
            int level = 0;
            TreeNode node = root;
            while (node.left != null) {
                level++;
                node = node.left;
            }

            //二分搜索
            int low = 1 << level;
            int high = 1 << (level + 1);
            while (low < high) {
                //取中位数推荐此方式，1.防止溢出
                int mid = (high - low + 1) / 2 + low;
                //关键是怎么判定 值是否在二叉树中
                if (exist(root, level, mid)) {
                    low = mid;
                } else {
                    high = mid - 1;
                }
            }
            return low;
        }


        //判定是否在二叉树中
        //根据路径查找
        //大于则取右节点，小于则取左节点
        private boolean exist(TreeNode root, int level, int value) {
            int bits = 1 << (level - 1);
            TreeNode node = root;
            while (node != null && bits > 0) {
                if ((bits & value) == 0) {
                    node = node.left;
                } else {
                    node = node.right;
                }
                bits >>= 1;
            }
            return node != null;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
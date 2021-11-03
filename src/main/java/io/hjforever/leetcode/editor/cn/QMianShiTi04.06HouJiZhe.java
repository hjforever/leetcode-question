//设计一个算法，找出二叉搜索树中指定节点的“下一个”节点（也即中序后继）。
//
// 如果指定节点没有对应的“下一个”节点，则返回null。 
//
// 示例 1: 
//
// 输入: root = [2,1,3], p = 1
//
//  2
// / \
//1   3
//
//输出: 2 
//
// 示例 2: 
//
// 输入: root = [5,3,6,2,4,null,null,1], p = 6
//
//      5
//     / \
//    3   6
//   / \
//  2   4
// /   
//1
//
//输出: null 
// Related Topics 树 深度优先搜索 二叉搜索树 二叉树 👍 79 👎 0


package io.hjforever.leetcode.editor.cn;

import io.hjforever.leetcode.editor.cn.common.TreeNode;

 class QMianShiTi0406HouJiZhe {
    public static void main(String[] args) {
        Solution solution = new QMianShiTi0406HouJiZhe().new Solution();
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
        TreeNode after = null;
        boolean flag = false;

        public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
            //中序遍历o(n)
            //二分搜索olog(n)
            inOrder(root, p);
            return after;
        }

        void inOrder(TreeNode root, TreeNode p) {
            if (root == null) {
                return;
            }
            inOrder(root.left, p);
            if (flag && after == null) {
                after = root;
                return;
            }
            if (root == p) {
                //找到当前p节点
                flag = true;
            }
            inOrder(root.right, p);
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
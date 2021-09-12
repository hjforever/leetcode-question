//给你两棵二叉树的根节点 p 和 q ，编写一个函数来检验这两棵树是否相同。
//
// 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。 
//
// 
//
// 示例 1： 
//
// 
//输入：p = [1,2,3], q = [1,2,3]
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：p = [1,2], q = [1,null,2]
//输出：false
// 
//
// 示例 3： 
//
// 
//输入：p = [1,2,1], q = [1,1,2]
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 两棵树上的节点数目都在范围 [0, 100] 内 
// -10⁴ <= Node.val <= 10⁴ 
// 
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 680 👎 0


package io.hjforever.leetcode.editor.cn;

import io.hjforever.leetcode.editor.cn.common.TreeNode;

public class Q100SameTree {
    public static void main(String[] args) {
        Solution solution = new Q100SameTree().new Solution();
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
         * 中序遍历 判定是否相同
         */
        public boolean isSameTree(TreeNode p, TreeNode q) {
            return isSame(p, q);
        }

        public boolean isSame(TreeNode p, TreeNode q) {
            //都为空
            if (p == null && q == null) {
                return true;
            }
            //一个为空，一个不为空
            if ((p == null && q != null) || (q == null && p != null)) {
                return false;
            }
            //判定值是否相同
            if (p.val != q.val) {
                return false;
            }
            //判定左节点和右节点是否分别相同
            return isSame(p.left, q.left) && isSame(p.right, q.right);
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
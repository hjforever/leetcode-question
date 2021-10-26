//给你一个二叉树的根节点 root ，按 任意顺序 ，返回所有从根节点到叶子节点的路径。
//
// 叶子节点 是指没有子节点的节点。 
// 
//
// 示例 1： 
//
// 
//输入：root = [1,2,3,null,5]
//输出：["1->2->5","1->3"]
// 
//
// 示例 2： 
//
// 
//输入：root = [1]
//输出：["1"]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点的数目在范围 [1, 100] 内 
// -100 <= Node.val <= 100 
// 
// Related Topics 树 深度优先搜索 字符串 二叉树 👍 593 👎 0


package io.hjforever.leetcode.editor.cn;

import io.hjforever.leetcode.editor.cn.common.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Q257BinaryTreePaths {
    public static void main(String[] args) {
        Solution solution = new Q257BinaryTreePaths().new Solution();
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

        List<String> allTreePath = new ArrayList<>();

        public List<String> binaryTreePaths(TreeNode root) {
            if (root == null) {
                return Collections.emptyList();
            }
            allTreePath("", root);
            return allTreePath;
        }

        void allTreePath(String treePath, TreeNode root) {
            //表示没有到叶子节点，继续遍历
            //当没有叶子节点则直接返回
            if (root.left == null && root.right == null) {
                treePath = treePath + root.val;
                allTreePath.add(treePath);
                return;
            }
            treePath = treePath + root.val + "->";
            //左节点不为空
            if (root.left != null) {
                allTreePath(treePath, root.left);
            }
            //右节点
            if (root.right != null) {
                allTreePath(treePath, root.right);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
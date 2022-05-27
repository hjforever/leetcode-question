//Given the root of a binary search tree, return a balanced binary search tree
//with the same node values. If there is more than one answer, return any of them. 
//
//
// A binary search tree is balanced if the depth of the two subtrees of every 
//node never differs by more than 1. 
//
// 
// Example 1: 
//
// 
//Input: root = [1,null,2,null,3,null,4,null,null]
//Output: [2,1,3,null,null,null,4]
//Explanation: This is not the only correct answer, [3,1,4,null,2] is also 
//correct.
// 
//
// Example 2: 
//
// 
//Input: root = [2,1,3]
//Output: [2,1,3]
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree is in the range [1, 10⁴]. 
// 1 <= Node.val <= 10⁵ 
// 
// Related Topics 贪心 树 深度优先搜索 二叉搜索树 分治 二叉树 👍 116 👎 0


package io.hjforever.leetcode.editor.cn;

import io.hjforever.leetcode.editor.cn.common.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Q1382BalanceABinarySearchTree {
    public static void main(String[] args) {
        Solution solution = new Q1382BalanceABinarySearchTree().new Solution();
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
        public TreeNode balanceBST(TreeNode root) {
            if (root == null) return null;
            List<Integer> list = new ArrayList<>();
            dfs(root, list);
            Collections.sort(list);
            //rebuild
            return build(list, 0, list.size() - 1);
        }

        void dfs(TreeNode root, List<Integer> list) {
            if (root == null) return;
            dfs(root.left, list);
            list.add(root.val);
            dfs(root.right, list);
        }

        TreeNode build(List<Integer> list, int i, int j) {
            if (i > j) return null;
            if (i == j) return new TreeNode(list.get(i));
            int mid = (i + j) / 2;
            TreeNode treeNode = new TreeNode(list.get(mid));
            //left
            treeNode.left = build(list, i, mid - 1);
            treeNode.right = build(list, mid + 1, j);
            //right
            return treeNode;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
//Given the root of a binary tree, each node in the tree has a distinct value.
//
// After deleting all nodes with a value in to_delete, we are left with a 
//forest (a disjoint union of trees). 
//
// Return the roots of the trees in the remaining forest. You may return the 
//result in any order. 
//
// 
// Example 1: 
//
// 
//Input: root = [1,2,3,4,5,6,7], to_delete = [3,5]
//Output: [[1,2,null,4],[6],[7]]
// 
//
// Example 2: 
//
// 
//Input: root = [1,2,4,null,3], to_delete = [3]
//Output: [[1,2,4]]
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the given tree is at most 1000. 
// Each node has a distinct value between 1 and 1000. 
// to_delete.length <= 1000 
// to_delete contains distinct values between 1 and 1000. 
// 
// Related Topics 树 深度优先搜索 二叉树 👍 181 👎 0


package io.hjforever.leetcode.editor.cn;

import io.hjforever.leetcode.editor.cn.common.TreeNode;

import java.util.*;
import java.util.stream.Collectors;

public class Q1110DeleteNodesAndReturnForest {
    public static void main(String[] args) {
        Solution solution = new Q1110DeleteNodesAndReturnForest().new Solution();
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
        List<TreeNode> ans = new ArrayList<>();

        public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
            //dfs
            if (root == null) return ans;
            Set<Integer> set = new HashSet<>();
            for (int i = 0; i < to_delete.length; i++) {
                set.add(to_delete[i]);
            }
            if (!set.contains(root.val)) {
                ans.add(root);
            }
            dfs(root, set);
            return ans;
        }

        TreeNode dfs(TreeNode root, Set<Integer> delete) {
            if (root == null) return null;
            root.left = dfs(root.left, delete);
            root.right = dfs(root.right, delete);
            if (delete.contains(root.val)) {
                if (root.left != null) {
                    ans.add(root.left);
                }
                if (root.right != null) {
                    ans.add(root.right);
                }
                root = null;
            }
            return root;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
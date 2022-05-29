//You are given the root of a binary tree where each node has a value 0 or 1.
//Each root-to-leaf path represents a binary number starting with the most 
//significant bit. 
//
// 
// For example, if the path is 0 -> 1 -> 1 -> 0 -> 1, then this could represent 
//01101 in binary, which is 13. 
// 
//
// For all leaves in the tree, consider the numbers represented by the path 
//from the root to that leaf. Return the sum of these numbers. 
//
// The test cases are generated so that the answer fits in a 32-bits integer. 
//
// 
// Example 1: 
//
// 
//Input: root = [1,0,1,0,1,0,1]
//Output: 22
//Explanation: (100) + (101) + (110) + (111) = 4 + 5 + 6 + 7 = 22
// 
//
// Example 2: 
//
// 
//Input: root = [0]
//Output: 0
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree is in the range [1, 1000]. 
// Node.val is 0 or 1. 
// 
// Related Topics 树 深度优先搜索 二叉树 👍 147 👎 0


package io.hjforever.leetcode.editor.cn;

import io.hjforever.leetcode.editor.cn.common.TreeNode;

public class Q1022SumOfRootToLeafBinaryNumbers {
    public static void main(String[] args) {
        Solution solution = new Q1022SumOfRootToLeafBinaryNumbers().new Solution();
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
        int ans = 0;

        public int sumRootToLeaf(TreeNode root) {
            dfs(root, 0);
            return ans;
        }

        void dfs(TreeNode root, int sum) {
            if (root == null) return;

            int val = root.val;
            sum = sum * 2 + val;
            if(root.left==null && root.right==null){
                ans += sum ;
                return;
            }
            dfs(root.left, sum);
            dfs(root.right,sum);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
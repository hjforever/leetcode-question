//Given the root of a binary tree, return the most frequent subtree sum. If
//there is a tie, return all the values with the highest frequency in any order. 
//
// The subtree sum of a node is defined as the sum of all the node values 
//formed by the subtree rooted at that node (including the node itself). 
//
// 
// Example 1: 
//
// 
//Input: root = [5,2,-3]
//Output: [2,-3,4]
// 
//
// Example 2: 
//
// 
//Input: root = [5,2,-5]
//Output: [2]
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree is in the range [1, 10⁴]. 
// -10⁵ <= Node.val <= 10⁵ 
// 
// Related Topics 树 深度优先搜索 哈希表 二叉树 👍 153 👎 0


package io.hjforever.leetcode.editor.cn;

import io.hjforever.leetcode.editor.cn.common.TreeNode;

import java.util.*;
import java.util.function.ToIntFunction;

public class Q508MostFrequentSubtreeSum {
    public static void main(String[] args) {
        Solution solution = new Q508MostFrequentSubtreeSum().new Solution();
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
        Map<Integer, Integer> cnt = new HashMap<>();
        int max = 0;

        public int[] findFrequentTreeSum(TreeNode root) {
            if (root == null) return new int[0];
            if (root.left == null && root.right == null) return new int[]{root.val};
            dfs(root);
            List<Integer> ans = new ArrayList<>();
            for (Integer key : cnt.keySet()) {
                if (cnt.get(key) == max) {
                    ans.add(key);
                }
            }
            return ans.stream().mapToInt(value -> value).toArray();
        }

        int dfs(TreeNode root) {
            if (root == null) return 0;
            int left = dfs(root.left);
            int right = dfs(root.right);
            int sum = left + right + root.val;
            int count = cnt.getOrDefault(sum, 0) + 1;
            cnt.put(sum, count);
            max = Math.max(count, max);
            return sum;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
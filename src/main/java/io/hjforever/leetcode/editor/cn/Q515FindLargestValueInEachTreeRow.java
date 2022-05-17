//Given the root of a binary tree, return an array of the largest value in each
//row of the tree (0-indexed). 
//
// 
// Example 1: 
//
// 
//Input: root = [1,3,2,5,3,null,9]
//Output: [1,3,9]
// 
//
// Example 2: 
//
// 
//Input: root = [1,2,3]
//Output: [1,3]
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree will be in the range [0, 10⁴]. 
// -2³¹ <= Node.val <= 2³¹ - 1 
// 
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 191 👎 0


package io.hjforever.leetcode.editor.cn;

import io.hjforever.leetcode.editor.cn.common.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q515FindLargestValueInEachTreeRow {
    public static void main(String[] args) {
        Solution solution = new Q515FindLargestValueInEachTreeRow().new Solution();
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
        Map<Integer, Integer> largetValueMap = new HashMap<>();


        //dfs

        public List<Integer> largestValues(TreeNode root) {
            dfs(root, 0);
            int size = largetValueMap.keySet().size();
            List<Integer> ans = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                ans.add(largetValueMap.get(i));
            }
            return ans;
        }

        void dfs(TreeNode root, int level) {
            if (root == null) return;
            dfs(root.left, level + 1);
            Integer levelMaxVal = largetValueMap.get(level);
            if (levelMaxVal == null) {
                largetValueMap.put(level, root.val);
            } else {
                largetValueMap.put(level, Math.max(levelMaxVal, root.val));
            }
            dfs(root.right, level + 1);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
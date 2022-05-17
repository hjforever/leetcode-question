//Given the root of a binary tree, return the leftmost value in the last row of
//the tree. 
//
// 
// Example 1: 
//
// 
//Input: root = [2,1,3]
//Output: 1
// 
//
// Example 2: 
//
// 
//Input: root = [1,2,3,4,null,5,6,null,null,7]
//Output: 7
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree is in the range [1, 10⁴]. 
// -2³¹ <= Node.val <= 2³¹ - 1 
// 
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 276 👎 0


package io.hjforever.leetcode.editor.cn;

import io.hjforever.leetcode.editor.cn.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Q513FindBottomLeftTreeValue {
    public static void main(String[] args) {
        Solution solution = new Q513FindBottomLeftTreeValue().new Solution();
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
        int ans ;
        int maxLevel;
        int maxLeft ;

        //dfs
        public int findBottomLeftValue(TreeNode root) {
            if(root==null) return 0 ;
            ans  = root.val ;
            maxLeft = 0 ;
            maxLevel = 0 ;
            dfs(root, 0, 0);
            return ans;
        }

        void dfs(TreeNode root, int level, int leftBottom) {
            if (root == null) return;
            dfs(root.left, level + 1, leftBottom + 1);
            if (level > maxLevel) {
                ans = root.val;
                maxLevel = level;
            } else if (level == maxLevel) {
                if (leftBottom > maxLeft) {
                    maxLeft = leftBottom;
                    ans = root.val;
                }
            }
            dfs(root.right, level + 1, leftBottom - 1);
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
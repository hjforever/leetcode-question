//You need to construct a binary tree from a string consisting of parenthesis
//and integers. 
//
// The whole input represents a binary tree. It contains an integer followed by
//zero, one or two pairs of parenthesis. The integer represents the root's value 
//and a pair of parenthesis contains a child binary tree with the same structure.
//
// You always start to construct the left child node of the parent first if it 
//exists. 
//
// 
// Example 1: 
//
// 
//Input: s = "4(2(3)(1))(6(5))"
//Output: [4,2,6,3,1,5]
// 
//
// Example 2: 
//
// 
//Input: s = "4(2(3)(1))(6(5)(7))"
//Output: [4,2,6,3,1,5,7]
// 
//
// Example 3: 
//
// 
//Input: s = "-4(2(3)(1))(6(5)(7))"
//Output: [-4,2,6,3,1,5,7]
// 
//
// 
// Constraints: 
//
// 
// 0 <= s.length <= 3 * 10⁴ 
// s consists of digits, '(', ')', and '-' only. 
// 
// Related Topics 树 深度优先搜索 字符串 二叉树 👍 83 👎 0


package io.hjforever.leetcode.editor.cn;

import io.hjforever.leetcode.editor.cn.common.TreeNode;

public class Q536ConstructBinaryTreeFromString {
    public static void main(String[] args) {
        Solution solution = new Q536ConstructBinaryTreeFromString().new Solution();
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
        int index = 0;
        int val = 0;
        int sign = 1;

        public TreeNode str2tree(String s) {
            if (s == null || s.length() == 0) return null;
            return dfs(s.toCharArray());
        }


        //  dfs
        TreeNode dfs(char[] ch) {
            int n = ch.length;
            //已处理完
            if (index == n) return null;
            sign = 1;
            val = 0;
            if (ch[index] == '-') {
                sign = -1;
                index++;
            }
            while (index < n && ch[index] <= '9' && ch[index] >= '0') {
                val = val * 10 + (ch[index] - '0');
                index++;
            }
            TreeNode root = new TreeNode(sign * val);

            if (index < n) {
                // left
                if (ch[index] == '(') {
                    index++;
                    root.left = dfs(ch);
                }
            }
            if (index < n) {
                // right
                if (ch[index] == '(') {
                    index++;
                    root.right = dfs(ch);
                }
            }
            if (index < n) {
                //skip
                if (ch[index] == ')') {
                    index++;
                }
            }
            return root;
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}
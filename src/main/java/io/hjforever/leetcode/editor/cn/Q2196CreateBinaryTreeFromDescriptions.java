//You are given a 2D integer array descriptions where descriptions[i] = [
//parenti, childi, isLefti] indicates that parenti is the parent of childi in a binary 
//tree of unique values. Furthermore, 
//
// 
// If isLefti == 1, then childi is the left child of parenti. 
// If isLefti == 0, then childi is the right child of parenti. 
// 
//
// Construct the binary tree described by descriptions and return its root. 
//
// The test cases will be generated such that the binary tree is valid. 
//
// 
// Example 1: 
//
// 
//Input: descriptions = [[20,15,1],[20,17,0],[50,20,1],[50,80,0],[80,19,1]]
//Output: [50,20,80,15,17,19]
//Explanation: The root node is the node with value 50 since it has no parent.
//The resulting binary tree is shown in the diagram.
// 
//
// Example 2: 
//
// 
//Input: descriptions = [[1,2,1],[2,3,0],[3,4,1]]
//Output: [1,2,null,null,3,4]
//Explanation: The root node is the node with value 1 since it has no parent.
//The resulting binary tree is shown in the diagram.
// 
//
// 
// Constraints: 
//
// 
// 1 <= descriptions.length <= 10⁴ 
// descriptions[i].length == 3 
// 1 <= parenti, childi <= 10⁵ 
// 0 <= isLefti <= 1 
// The binary tree described by descriptions is valid. 
// 
// Related Topics 树 深度优先搜索 广度优先搜索 数组 哈希表 二叉树 👍 25 👎 0


package io.hjforever.leetcode.editor.cn;

import io.hjforever.leetcode.editor.cn.common.TreeNode;

import java.util.*;

public class Q2196CreateBinaryTreeFromDescriptions {
    public static void main(String[] args) {
        Solution solution = new Q2196CreateBinaryTreeFromDescriptions().new Solution();
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
        public TreeNode createBinaryTree(int[][] descriptions) {
            TreeNode[] treeNodes = new TreeNode[100001];
            for (int[] is : descriptions) treeNodes[is[1]] = new TreeNode(is[1]);
            int root = 0;
            for (int[] is : descriptions) {
                if (treeNodes[is[0]] == null) treeNodes[is[0]] = new TreeNode(root = is[0]);
                if (is[2] == 1) {
                    treeNodes[is[0]].left = treeNodes[is[1]];
                } else {
                    treeNodes[is[0]].right = treeNodes[is[1]];
                }
            }
            return treeNodes[root];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}
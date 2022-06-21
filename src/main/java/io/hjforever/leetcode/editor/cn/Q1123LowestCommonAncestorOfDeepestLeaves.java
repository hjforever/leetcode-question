//Given the root of a binary tree, return the lowest common ancestor of its
//deepest leaves. 
//
// Recall that: 
//
// 
// The node of a binary tree is a leaf if and only if it has no children 
// The depth of the root of the tree is 0. if the depth of a node is d, the 
//depth of each of its children is d + 1. 
// The lowest common ancestor of a set S of nodes, is the node A with the 
//largest depth such that every node in S is in the subtree with root A. 
// 
//
// 
// Example 1: 
//
// 
//Input: root = [3,5,1,6,2,0,8,null,null,7,4]
//Output: [2,7,4]
//Explanation: We return the node with value 2, colored in yellow in the 
//diagram.
//The nodes coloured in blue are the deepest leaf-nodes of the tree.
//Note that nodes 6, 0, and 8 are also leaf nodes, but the depth of them is 2, 
//but the depth of nodes 7 and 4 is 3. 
//
// Example 2: 
//
// 
//Input: root = [1]
//Output: [1]
//Explanation: The root is the deepest node in the tree, and it's the lca of 
//itself.
// 
//
// Example 3: 
//
// 
//Input: root = [0,1,3,null,2]
//Output: [2]
//Explanation: The deepest leaf node in the tree is 2, the lca of one node is 
//itself.
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree will be in the range [1, 1000]. 
// 0 <= Node.val <= 1000 
// The values of the nodes in the tree are unique. 
// 
//
// 
// Note: This question is the same as 865: https://leetcode.com/problems/
//smallest-subtree-with-all-the-deepest-nodes/ 
// Related Topics 树 深度优先搜索 广度优先搜索 哈希表 二叉树 👍 115 👎 0


package io.hjforever.leetcode.editor.cn;

import io.hjforever.leetcode.editor.cn.common.TreeNode;

public class Q1123LowestCommonAncestorOfDeepestLeaves {
    public static void main(String[] args) {
        Solution solution = new Q1123LowestCommonAncestorOfDeepestLeaves().new Solution();
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
        public TreeNode lcaDeepestLeaves(TreeNode root) {
            //1.判断左右两边的深度，如果相同则返回跟节点
            //2.左>右，则肯定在左，反之亦然。
            return dfs(root).node;
        }

        Node dfs(TreeNode root) {
            if (root == null) return new Node(null, 0);
            Node left = dfs(root.left);
            Node right = dfs(root.right);
            if (left.depth > right.depth) {
                return new Node(left.node, left.depth + 1);
            }
            if (right.depth > left.depth) {
                return new Node(right.node, right.depth + 1);
            }
            return new Node(root, left.depth + 1);
        }

        class Node {
            int depth;
            TreeNode node;

            public Node(TreeNode node, int depth) {
                this.depth = depth;
                this.node = node;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
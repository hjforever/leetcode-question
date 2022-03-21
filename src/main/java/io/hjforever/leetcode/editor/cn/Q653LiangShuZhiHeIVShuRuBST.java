//给定一个二叉搜索树 root 和一个目标结果 k，如果 BST 中存在两个元素且它们的和等于给定的目标结果，则返回 true。
//
// 
//
// 示例 1： 
//
// 
//输入: root = [5,3,6,2,4,null,7], k = 9
//输出: true
// 
//
// 示例 2： 
//
// 
//输入: root = [5,3,6,2,4,null,7], k = 28
//输出: false
// 
//
// 
//
// 提示: 
//
// 
// 二叉树的节点个数的范围是 [1, 10⁴]. 
// -10⁴ <= Node.val <= 10⁴ 
// root 为二叉搜索树 
// -10⁵ <= k <= 10⁵ 
// 
// Related Topics 树 深度优先搜索 广度优先搜索 二叉搜索树 哈希表 双指针 二叉树 👍 307 👎 0


package io.hjforever.leetcode.editor.cn;

import io.hjforever.leetcode.editor.cn.common.TreeNode;

import java.util.*;

public class Q653LiangShuZhiHeIVShuRuBST {
    public static void main(String[] args) {
        Solution solution = new Q653LiangShuZhiHeIVShuRuBST().new Solution();
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

        Set<Integer> map = new HashSet<>();
        boolean res;

        public boolean findTarget(TreeNode root, int k) {
            if (root == null || (root.left == null && root.right == null)) return false;
            dfs(root, k);
            return res;
        }

        void dfs(TreeNode root, int k) {
            if (root == null) return;
            dfs(root.left, k);
            int val = root.val;
            if (map.contains(k - val)) {
                res = true;
                return;
            }
            map.add(val);
            dfs(root.right, k);
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
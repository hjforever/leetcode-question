//Given the root of a binary tree, return all duplicate subtrees.
//
// For each kind of duplicate subtrees, you only need to return the root node 
//of any one of them. 
//
// Two trees are duplicate if they have the same structure with the same node 
//values. 
//
// 
// Example 1: 
//
// 
//Input: root = [1,2,3,4,null,2,4,null,null,4]
//Output: [[2,4],[4]]
// 
//
// Example 2: 
//
// 
//Input: root = [2,1,1]
//Output: [[1]]
// 
//
// Example 3: 
//
// 
//Input: root = [2,2,2,3,null,3,null]
//Output: [[2,3],[3]]
// 
//
// 
// Constraints: 
//
// 
// The number of the nodes in the tree will be in the range [1, 10^4] 
// -200 <= Node.val <= 200 
// 
// Related Topics 树 深度优先搜索 哈希表 二叉树 👍 415 👎 0


package io.hjforever.leetcode.editor.cn;

import io.hjforever.leetcode.editor.cn.common.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q652FindDuplicateSubtrees {
    public static void main(String[] args) {
        Solution solution = new Q652FindDuplicateSubtrees().new Solution();
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

        //sub tree hash
        Map<String, Integer> trees;
        Map<Integer, Integer> cnt;
        List<TreeNode> res = new ArrayList<>();
        int flag;


        public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
            flag = 1;
            cnt = new HashMap<>();
            trees = new HashMap<>();
            dfs(root);
            return res;
        }


        public int dfs(TreeNode root) {
            if (root == null) return 0;
            String tree = root.val + "," + dfs(root.left) + "," + dfs(root.right);
            //当子树不存在则创建新的标记
            int hash = trees.computeIfAbsent(tree, v -> flag++);
            cnt.put(hash, cnt.getOrDefault(hash, 0) + 1);
            //重复出现
            if (cnt.get(hash) == 2) {
                res.add(root);
            }
            return hash;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
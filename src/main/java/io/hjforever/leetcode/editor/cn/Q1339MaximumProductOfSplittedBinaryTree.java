//Given the root of a binary tree, split the binary tree into two subtrees by
//removing one edge such that the product of the sums of the subtrees is maximized. 
//
//
// Return the maximum product of the sums of the two subtrees. Since the answer 
//may be too large, return it modulo 10⁹ + 7. 
//
// Note that you need to maximize the answer before taking the mod and not 
//after taking it. 
//
// 
// Example 1: 
//
// 
//Input: root = [1,2,3,4,5,6]
//Output: 110
//Explanation: Remove the red edge and get 2 binary trees with sum 11 and 10. 
//Their product is 110 (11*10)
// 
//
// Example 2: 
//
// 
//Input: root = [1,null,2,3,4,null,null,5,6]
//Output: 90
//Explanation: Remove the red edge and get 2 binary trees with sum 15 and 6.
//Their product is 90 (15*6)
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree is in the range [2, 5 * 10⁴]. 
// 1 <= Node.val <= 10⁴ 
// 
// Related Topics 树 深度优先搜索 二叉树 👍 74 👎 0


package io.hjforever.leetcode.editor.cn;

import io.hjforever.leetcode.editor.cn.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Q1339MaximumProductOfSplittedBinaryTree {
    public static void main(String[] args) {
        Solution solution = new Q1339MaximumProductOfSplittedBinaryTree().new Solution();
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

        List<Long> list = new ArrayList<>();

        public int maxProduct(TreeNode root) {
            //先寻找两个子树绝对值相对最小节点和
            dfs(root);
            long sum = list.get(list.size() - 1);
            long l1 = sum, r1 = 0;
            for (int i = 0; i < list.size() - 1; i++) {
                if (Math.abs(sum - 2 * list.get(i)) < Math.abs(l1 - r1)) {
                    l1 = sum - list.get(i);
                    r1 = list.get(i);
                }
            }
            long MOD = (long) (1e9 + 7);
            return (int) mul(l1, r1, MOD);
        }

        //快速取模
        long mul(long a, long b, long mod) {
            long ans = 0;
            for (; b > 0; b >>= 1) {
                if ((b & 1) != 0) ans = (ans + a) % mod;
                a = a * 2 % mod;
            }
            return ans;
        }

        long dfs(TreeNode root) {
            if (root == null) return 0;
            long left = dfs(root.left);
            long right = dfs(root.right);
            long sum = root.val + left + right;
            list.add(sum);
            return sum;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
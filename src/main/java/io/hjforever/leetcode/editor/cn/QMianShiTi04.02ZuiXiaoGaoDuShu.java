//给定一个有序整数数组，元素各不相同且按升序排列，编写一个算法，创建一棵高度最小的二叉搜索树。示例: 给定有序数组: [-10,-3,0,5,9], 一个可能
//的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：           0          / \        -3 
//  9        /   /      -10  5 Related Topics 树 二叉搜索树 数组 分治 二叉树 👍 102 👎 0


package io.hjforever.leetcode.editor.cn;

import io.hjforever.leetcode.editor.cn.common.TreeNode;

public class QMianShiTi0402ZuiXiaoGaoDuShu {
    public static void main(String[] args) {
        Solution solution = new QMianShiTi0402ZuiXiaoGaoDuShu().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    class Solution {
        public TreeNode sortedArrayToBST(int[] nums) {
            //二分构造
            return buildBst(nums, 0, nums.length - 1);
        }

        TreeNode buildBst(int[] nums, int start, int end) {
            if (start > end) {
                return null;
            }
            int mid = start + (end - start) / 2;
            TreeNode root = new TreeNode(nums[mid]);
            root.left = buildBst(nums, start, mid - 1);
            root.right = buildBst(nums, mid + 1, end);
            return root;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
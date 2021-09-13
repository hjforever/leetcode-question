//给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。
//
// 叶子节点 是指没有子节点的节点。 
//
// 
// 
// 
//
// 示例 1： 
//
// 
//输入：root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
//输出：[[5,4,11,2],[5,8,4,5]]
// 
//
// 示例 2： 
//
// 
//输入：root = [1,2,3], targetSum = 5
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：root = [1,2], targetSum = 0
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点总数在范围 [0, 5000] 内 
// -1000 <= Node.val <= 1000 
// -1000 <= targetSum <= 1000 
// 
// 
// 
// Related Topics 树 深度优先搜索 回溯 二叉树 👍 574 👎 0


package io.hjforever.leetcode.editor.cn;

import io.hjforever.leetcode.editor.cn.common.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Q113PathSumIi {
    public static void main(String[] args) {
        Solution solution = new Q113PathSumIi().new Solution();
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

        /**
         * dfs
         */
        private List<List<Integer>> result = new LinkedList<>();
        //存储path路径
        private Deque<Integer> pathList = new LinkedList<>();

        public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
            if (root == null) {
                return result;
            }
            dfs(root, targetSum);
            return result;
        }

        private void dfs(TreeNode root, Integer target) {
            if (root == null) {
                return;
            }
            //添加节点到路径
            pathList.offerLast(root.val);
            //判断是否是叶子结点,且符合target条件
            target -= root.val;
            if (root.left == null && root.right == null && target == 0) {
                result.add(new LinkedList<>(pathList));
            }
            //dfs 左节点
            dfs(root.left, target);
            dfs(root.right, target);
            //关键点
            //当节点判定完之后，需要移除节点，防止污染其他分支
            pathList.pollLast();
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}
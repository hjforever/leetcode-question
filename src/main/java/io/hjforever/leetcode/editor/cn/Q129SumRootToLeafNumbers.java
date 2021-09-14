//给你一个二叉树的根节点 root ，树中每个节点都存放有一个 0 到 9 之间的数字。
// 
// 
// 每条从根节点到叶节点的路径都代表一个数字： 
//
// 
// 例如，从根节点到叶节点的路径 1 -> 2 -> 3 表示数字 123 。 
// 
//
// 计算从根节点到叶节点生成的 所有数字之和 。 
//
// 叶节点 是指没有子节点的节点。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [1,2,3]
//输出：25
//解释：
//从根到叶子节点路径 1->2 代表数字 12
//从根到叶子节点路径 1->3 代表数字 13
//因此，数字总和 = 12 + 13 = 25 
//
// 示例 2： 
//
// 
//输入：root = [4,9,0,5,1]
//输出：1026
//解释：
//从根到叶子节点路径 4->9->5 代表数字 495
//从根到叶子节点路径 4->9->1 代表数字 491
//从根到叶子节点路径 4->0 代表数字 40
//因此，数字总和 = 495 + 491 + 40 = 1026
// 
//
// 
//
// 提示： 
//
// 
// 树中节点的数目在范围 [1, 1000] 内 
// 0 <= Node.val <= 9 
// 树的深度不超过 10 
// 
// 
// 
// Related Topics 树 深度优先搜索 二叉树 👍 417 👎 0


package io.hjforever.leetcode.editor.cn;

import io.hjforever.leetcode.editor.cn.common.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Q129SumRootToLeafNumbers {
    public static void main(String[] args) {
        Solution solution = new Q129SumRootToLeafNumbers().new Solution();
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
         * 思路一：dfs , 获取所有叶子节点到顶节点的列表，然后求和。此处浪费存储空间
         * 思路二：dfs,用单个值存储sum值
         *
         */

        /**
         * 思路二
         */
        public int sumNumbers(TreeNode root) {
            return dfs(root, 0);
        }

        private int dfs(TreeNode treeNode, int preNum) {
            if (treeNode == null) {
                return 0;
            }
            int sum = preNum * 10 + treeNode.val;
            if (treeNode.left == null && treeNode.right == null) {
                //叶子节点则返回
                return sum;
            } else {
                //非叶子节点，则左子树 加上 右子树
                return dfs(treeNode.left, sum) + dfs(treeNode.right, sum);
            }
        }

        /**
         * 思路一：
         */
//        private List<List<Integer>> allPathList = new ArrayList<>();
//        //存储path路径
//        private Deque<Integer> pathList = new LinkedList<>();
//
//        public int sumNumbers(TreeNode root) {
//            allPath(root);
//            //统计
//            System.out.println(allPathList);
//            int sum = 0;
//            for (List list : allPathList) {
//                sum = sum + listValue(list);
//            }
//            return sum;
//        }
//
//        //计算单个路径值
//        private int listValue(List<Integer> list) {
//            //倒叙计算
//            int sum = 0;
//            int size = list.size();
//            for (int i = 0; i < size; i++) {
//                sum = sum + (int) Math.pow(10, (size - i-1)) * list.get(i);
//            }
//            return sum;
//        }
//
//
//        //获取所有路径
//        private void allPath(TreeNode treeNode) {
//            if (treeNode != null) {
//                pathList.offerLast(treeNode.val);
//                //当为叶子节点时则添加
//                if (treeNode.left == null && treeNode.right == null) {
//                    allPathList.add(new ArrayList<>(pathList));
//                }
//                //左右节点处理
//                allPath(treeNode.left);
//                allPath(treeNode.right);
//                //从path移除该节点，防止污染其他节点
//                pathList.removeLast();
//            }
//        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
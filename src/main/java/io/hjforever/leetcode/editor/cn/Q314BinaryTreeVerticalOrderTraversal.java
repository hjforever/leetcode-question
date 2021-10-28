//给你一个二叉树的根结点，返回其结点按 垂直方向（从上到下，逐列）遍历的结果。
//
// 如果两个结点在同一行和列，那么顺序则为 从左到右。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [3,9,20,null,null,15,7]
//输出：[[9],[3,15],[20],[7]]
// 
//
// 示例 2： 
//
// 
//输入：root = [3,9,8,4,0,1,7]
//输出：[[4],[9],[3,0,1],[8],[7]]
// 
//
// 示例 3： 
//
// 
//输入：root = [3,9,8,4,0,1,7,null,null,null,2,5]
//输出：[[4],[9,5],[3,0,1],[8,2],[7]]
// 
//
// 示例 4： 
//
// 
//输入：root = []
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 树中结点的数目在范围 [0, 100] 内 
// -100 <= Node.val <= 100 
// 
// Related Topics 树 深度优先搜索 广度优先搜索 哈希表 二叉树 👍 126 👎 0


package io.hjforever.leetcode.editor.cn;

import io.hjforever.leetcode.editor.cn.common.TreeNode;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Q314BinaryTreeVerticalOrderTraversal {
    public static void main(String[] args) {
        Solution solution = new Q314BinaryTreeVerticalOrderTraversal().new Solution();
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

        //思路是以顶点为0点坐标，左节点-1右节点+1 ，此处需要注意同坐标时需要根据 层级顺序排列
        private Map<Integer, Set<int[]>> verticalMap;

        private int visitSequence = 0;

        public List<List<Integer>> verticalOrder(TreeNode root) {
            visitSequence = 0;
            verticalMap = new TreeMap<>();
            verticalOrder(root, 0, 0);
            return verticalMap.values()
                    .stream()
                    .map(set -> set.stream().map(val -> val[0]).collect(Collectors.toList()))
                    .collect(Collectors.toList());
        }

        private void verticalOrder(TreeNode root, int hor, int ver) {
            if (root == null) {
                return;
            }
            verticalMap.computeIfAbsent(hor, key -> new TreeSet<>((val1, val2) -> {
                if (val1[1] == val2[1]) {
                    return val1[2] - val2[2];
                }
                return val1[1] - val2[1];
            })).add(new int[]{root.val, ver, ++visitSequence});
            verticalOrder(root.left, hor - 1, ver + 1);
            verticalOrder(root.right, hor + 1, ver + 1);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
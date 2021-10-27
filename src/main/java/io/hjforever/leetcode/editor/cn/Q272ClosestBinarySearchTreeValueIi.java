//给定一个不为空的二叉搜索树和一个目标值 target，请在该二叉搜索树中找到最接近目标值 target 的 k 个值。
//
// 注意： 
//
// 
// 给定的目标值 target 是一个浮点数 
// 你可以默认 k 值永远是有效的，即 k ≤ 总结点数 
// 题目保证该二叉搜索树中只会存在一种 k 个值集合最接近目标值 
// 
//
// 示例： 
//
// 输入: root = [4,2,5,1,3]，目标值 = 3.714286，且 k = 2
//
//    4
//   / \
//  2   5
// / \
//1   3
//
//输出: [4,3] 
//
// 拓展： 
//假设该二叉搜索树是平衡的，请问您是否能在小于 O(n)（n 为总结点数）的时间复杂度内解决该问题呢？ 
// Related Topics 栈 树 深度优先搜索 二叉搜索树 双指针 二叉树 堆（优先队列） 👍 87 👎 0


package io.hjforever.leetcode.editor.cn;

import io.hjforever.leetcode.editor.cn.common.TreeNode;

import java.util.*;

public class Q272ClosestBinarySearchTreeValueIi {
    public static void main(String[] args) {
        Solution solution = new Q272ClosestBinarySearchTreeValueIi().new Solution();
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
        public List<Integer> closestKValues(TreeNode root, double target, int k) {
            //中序遍历。因为是BST，所以中序遍历可确保元素从小到大访问
            //普通队列。在保证遍历顺序的前提下，普通队列的队列头，即是离target最远的节点
            //剪枝。当队列长度已经到达k，且队列头q.peek()的相比当前元素root离target更近，则没必要再继续遍历了(继续就更远了)。
            //时间复杂度O(N), 空间复杂度O(k)
            Queue<Integer> queue = new LinkedList<>();
            inorder(root, target, k, queue);
            return (List<Integer>) queue;
        }

        void inorder(TreeNode root, double target, int k, Queue<Integer> queue) {
            if (root == null) {
                return;
            }
            inorder(root.left, target, k, queue);
            //队列已满，需要剔除最大值
            if (queue.size() == k) {
                if (Math.abs(root.val - target) < Math.abs(queue.peek() - target)) {
                    queue.poll();
                    queue.offer(root.val);
                }
            } else {
                queue.offer(root.val);
            }
            inorder(root.right, target, k, queue);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
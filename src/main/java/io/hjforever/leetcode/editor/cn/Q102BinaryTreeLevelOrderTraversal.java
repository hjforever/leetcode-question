  //给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。 
//
// 
//
// 示例： 
//二叉树：[3,9,20,null,null,15,7], 
//
// 
//    3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回其层序遍历结果： 
//
// 
//[
//  [3],
//  [9,20],
//  [15,7]
//]
// 
// Related Topics 树 广度优先搜索 二叉树 👍 1003 👎 0

  
  package io.hjforever.leetcode.editor.cn;

  import io.hjforever.leetcode.editor.cn.common.TreeNode;

  import java.util.ArrayList;
  import java.util.LinkedList;
  import java.util.List;
  import java.util.Queue;

  public class Q102BinaryTreeLevelOrderTraversal{
      public static void main(String[] args) {
           Solution solution = new Q102BinaryTreeLevelOrderTraversal().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    /**
     * 二叉树层级遍历
     * <p>
     * 每次将子节点加入队列中，输出后移除 ， 当队列为空则 表示已经处理完成
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> levelOrderList = new ArrayList<>();
        if (root == null) {
            return levelOrderList;
        }
        Queue<TreeNode> treeNodeQueue = new LinkedList<>();
        //添加根节点
        treeNodeQueue.offer(root);
        while (!treeNodeQueue.isEmpty()) {
            //添加子节点
            int size = treeNodeQueue.size();
            List<Integer> childLevelList = new ArrayList<>();
            for (int i = 1; i <= size; i++) {
                TreeNode node = treeNodeQueue.poll();
                childLevelList.add(node.val);
                //加入子节点
                if (node.left != null) {
                    treeNodeQueue.offer(node.left);
                }
                if (node.right != null) {
                    treeNodeQueue.offer(node.right);
                }
            }
            levelOrderList.add(childLevelList);
        }
        return levelOrderList;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }
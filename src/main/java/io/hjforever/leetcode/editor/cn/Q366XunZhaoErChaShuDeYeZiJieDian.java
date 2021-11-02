//给你一棵二叉树，请按以下要求的顺序收集它的全部节点：
//
// 
// 依次从左到右，每次收集并删除所有的叶子节点 
// 重复如上过程直到整棵树为空 
// 
//
// 
//
// 示例: 
//
// 输入: [1,2,3,4,5]
//  
//          1
//         / \
//        2   3
//       / \     
//      4   5    
//
//输出: [[4,5,3],[2],[1]]
// 
//
// 
//
// 解释: 
//
// 1. 删除叶子节点 [4,5,3] ，得到如下树结构： 
//
//           1
//         / 
//        2          
// 
//
// 
//
// 2. 现在删去叶子节点 [2] ，得到如下树结构： 
//
//           1          
// 
//
// 
//
// 3. 现在删去叶子节点 [1] ，得到空树： 
//
//           []         
// 
// Related Topics 树 深度优先搜索 二叉树 👍 137 👎 0


package io.hjforever.leetcode.editor.cn;

import io.hjforever.leetcode.editor.cn.common.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Q366XunZhaoErChaShuDeYeZiJieDian {
    public static void main(String[] args) {
        Solution solution = new Q366XunZhaoErChaShuDeYeZiJieDian().new Solution();
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

        public List<List<Integer>> findLeaves(TreeNode root) {
            List<List<Integer>> results = new ArrayList<>();
            //根据循环规则，最后的最后root会被设置成null，这也是停止的条件
            while (root != null) {
                List<Integer> temp = new ArrayList<>();
                root = findSubLeaves(root, temp);
                results.add(temp);
            }
            return results;
        }

        public TreeNode findSubLeaves(TreeNode tn, List<Integer> temp) {
            //退出条件
            if (tn == null) return null;
            //当左子树和右子树都为空的时候，就是我们要的情况
            if (tn.left == null && tn.right == null) {
                temp.add(tn.val);
                //return null是因为上一层的recursion会把父级中的自己那个节点设置为null
                return null;
            }
            //这里循环设置自己的左子树和右子树
            tn.left = findSubLeaves(tn.left, temp);
            tn.right = findSubLeaves(tn.right, temp);
            return tn;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
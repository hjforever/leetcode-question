//请完成一个函数，输入一个二叉树，该函数输出它的镜像。
//
// 例如输入： 
//
// 4 
// / \ 
// 2 7 
// / \ / \ 
//1 3 6 9 
//镜像输出： 
//
// 4 
// / \ 
// 7 2 
// / \ / \ 
//9 6 3 1 
//
// 
//
// 示例 1： 
//
// 输入：root = [4,2,7,1,3,6,9]
//输出：[4,7,2,9,6,3,1]
// 
//
// 
//
// 限制： 
//
// 0 <= 节点个数 <= 1000 
//
// 注意：本题与主站 226 题相同：https://leetcode-cn.com/problems/invert-binary-tree/ 
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 187 👎 0


package io.hjforever.leetcode.editor.cn;

import io.hjforever.leetcode.editor.cn.common.TreeNode;

public class QJianZhiOffer27ErChaShuDeJingXiang {
    public static void main(String[] args) {
        Solution solution = new QJianZhiOffer27ErChaShuDeJingXiang().new Solution();
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
    //dfs
    class Solution {
        public TreeNode mirrorTree(TreeNode root) {
            mirror(root);
            return root;
        }

        void mirror(TreeNode root) {
            if (root == null) {
                return;
            }
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;
            mirror(root.left);
            mirror(root.right);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
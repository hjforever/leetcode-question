//给你二叉搜索树的根节点 root ，该树中的两个节点被错误地交换。请在不改变其结构的情况下，恢复这棵树。
//
// 进阶：使用 O(n) 空间复杂度的解法很容易实现。你能想出一个只使用常数空间的解决方案吗？ 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [1,3,null,null,2]
//输出：[3,1,null,null,2]
//解释：3 不能是 1 左孩子，因为 3 > 1 。交换 1 和 3 使二叉搜索树有效。
// 
//
// 示例 2： 
//
// 
//输入：root = [3,1,4,null,null,2]
//输出：[2,1,4,null,null,3]
//解释：2 不能在 3 的右子树中，因为 2 < 3 。交换 2 和 3 使二叉搜索树有效。 
//
// 
//
// 提示： 
//
// 
// 树上节点的数目在范围 [2, 1000] 内 
// -2³¹ <= Node.val <= 2³¹ - 1 
// 
// Related Topics 树 深度优先搜索 二叉搜索树 二叉树 👍 552 👎 0


package io.hjforever.leetcode.editor.cn;

import io.hjforever.leetcode.editor.cn.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Q99RecoverBinarySearchTree {
    public static void main(String[] args) {
        Solution solution = new Q99RecoverBinarySearchTree().new Solution();
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
         * 1.二叉树中序遍历后为有序的数据，根据有序来调整数组，调整乱序的2处值即可，当如果只有一处则表示乱序的前后顺序需要调整
         * 2. Morris 中序遍历
         */

        public void recoverTree(TreeNode root) {
            List<Integer> nums = new ArrayList<>();
            inorder(root, nums);
            int[] swp = findTwoSwap(nums);
            recover(root, 2, swp[0], swp[1]);
        }

        //中序遍历
        private void inorder(TreeNode root, List<Integer> nums) {
            if (root == null) {
                return;
            }
            inorder(root.left, nums);
            nums.add(root.val);
            inorder(root.right, nums);
        }

        //获取两处需要调整的位置
        private int[] findTwoSwap(List<Integer> nums) {
            int first = -1;
            int two = -1;
            for (int i = 0; i < nums.size() - 1; i++) {
                if (nums.get(i + 1) < nums.get(i)) {
                    two = i + 1;
                    if (first == -1) {
                        first = i;
                    } else {
                        break;
                    }
                }
            }
            return new int[]{nums.get(first), nums.get(two)};
        }


        //遍历树节点通过对应的值判断，然后交换值
        private void recover(TreeNode root, int count, int first, int two) {
            if (root != null) {
                //当已经更新完后直接退出
                if (count == 0) {
                    return;
                }
                //先判定根节点
                if (root.val == first || root.val == two) {
                    if (root.val == first) {
                        root.val = two;
                    } else {
                        root.val = first;
                    }
                    count = count - 1;
                }
                recover(root.left, count, first, two);
                recover(root.right, count, first, two);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
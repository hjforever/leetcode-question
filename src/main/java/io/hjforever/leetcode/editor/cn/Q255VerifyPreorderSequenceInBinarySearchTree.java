//给定一个整数数组，你需要验证它是否是一个二叉搜索树正确的先序遍历序列。
//
// 你可以假定该序列中的数都是不相同的。 
//
// 参考以下这颗二叉搜索树： 
//
//      5
//    / \
//   2   6
//  / \
// 1   3 
//
// 示例 1： 
//
// 输入: [5,2,6,1,3]
//输出: false 
//
// 示例 2： 
//
// 输入: [5,2,1,3,6]
//输出: true 
//
// 进阶挑战： 
//
// 您能否使用恒定的空间复杂度来完成此题？ 
// Related Topics 栈 树 二叉搜索树 递归 二叉树 单调栈 👍 122 👎 0


package io.hjforever.leetcode.editor.cn;

import java.util.Stack;

public class Q255VerifyPreorderSequenceInBinarySearchTree {
    public static void main(String[] args) {
        Solution solution = new Q255VerifyPreorderSequenceInBinarySearchTree().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        //维护一个单调递减栈（从栈底到栈顶），如某一状态下栈元素为[5,4,3][5,4,3]。
        // 若碰到一个6的时候，说明从左子树（或者没有左子树）到达了右子树，
        // 此时将小于6的元素都pop掉，栈变成[6][6],并且记录一个最小值为5，
        // 由于6是右子树，因此6右侧的元素都必须大于5，否则不合法。

        public boolean verifyPreorder(int[] preorder) {
            //单调递减栈
            Stack<Integer> stack = new Stack<>();
            int min = Integer.MIN_VALUE;
            for (int i = 0; i < preorder.length; i++) {
                if (preorder[i] < min) {
                    return false;
                }
                while (!stack.isEmpty() && stack.peek() < preorder[i]) {
                    //移除小于的preorder[i]值
                    min = stack.pop();
                }
                stack.push(preorder[i]);
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
//输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。如果是则返回 true，否则返回 false。假设输入的数组的任意两个数字都互不相同。
//
// 
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
// 输入: [1,6,3,2,5]
//输出: false 
//
// 示例 2： 
//
// 输入: [1,3,2,6,5]
//输出: true 
//
// 
//
// 提示： 
//
// 
// 数组长度 <= 1000 
// 
// Related Topics 栈 树 二叉搜索树 递归 二叉树 单调栈 👍 376 👎 0


package io.hjforever.leetcode.editor.cn;


import java.util.Arrays;

public class QJianZhiOffer33ErChaSouSuoShuDeHouXuBianLiXuLie {
    public static void main(String[] args) {
        Solution solution = new QJianZhiOffer33ErChaSouSuoShuDeHouXuBianLiXuLie().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean verifyPostorder(int[] postorder) {
            return dfsVerifyPostorder(postorder);
        }


        //dfs [1,3,2, 6 ,5]
        boolean dfsVerifyPostorder(int[] postorder) {
            int length = postorder.length;
            if (postorder == null || length <= 0) {
                return true;
            }
//            if(postorder.length==1){
//                return true;
//            }
            //根节点
            int root = postorder[length - 1];

            int leftIndex;

            //左节点 < root,找到第一个比root大的则为第一个右节点
            for (leftIndex = 0; leftIndex < length - 1; leftIndex++) {
                if (postorder[leftIndex] > root) {
                    break;
                }
            }
            int rightIndex = leftIndex;
            for (int i = rightIndex; i < length - 1; i++) {
                if (postorder[i] < root) {
                    return false;
                }
            }

            //在判断左子树及右子树
            boolean left = true;
            if (leftIndex > 0) {
                //表示有左子树
                int[] leftpostorder = Arrays.copyOfRange(postorder, 0, leftIndex);
                left = dfsVerifyPostorder(leftpostorder);
            }
            boolean right = true;
            if (rightIndex < length - 1) {
                int[] rightpostorder = Arrays.copyOfRange(postorder, leftIndex, length - 1);
                right = dfsVerifyPostorder(rightpostorder);
            }
            return left && right;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
//从左向右遍历一个数组，通过不断将其中的元素插入树中可以逐步地生成一棵二叉搜索树。给定一个由不同节点组成的二叉搜索树，输出所有可能生成此树的数组。
//
// 
//
// 示例： 
//给定如下二叉树 
//
//         2
//       / \
//      1   3
// 
//
// 返回： 
//
// [
//   [2,1,3],
//   [2,3,1]
//]
// 
// Related Topics 树 二叉搜索树 动态规划 二叉树 👍 73 👎 0


package io.hjforever.leetcode.editor.cn;

import io.hjforever.leetcode.editor.cn.common.TreeNode;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

class QMianShiTi0409ErChaSouSuoShuXuLie {
    public static void main(String[] args) {
        Solution solution = new QMianShiTi0409ErChaSouSuoShuXuLie().new Solution();
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
    class Solution {

        //TODO
        public List<List<Integer>> BSTSequences(TreeNode root) {
            List<List<Integer>> list;
            if (root == null) {
                list = new ArrayList<>();
                list.add(new ArrayList<>());
                return list;
            }
            //前序遍历
            List<String> set = new ArrayList<>();
            set.add(root.val + ",");
            dfs(root, set);
            list = new ArrayList<>(set.size());
            for (String s : set) {
                List<Integer> subList = new ArrayList<>();
                String[] ss = s.split(",");
                for (String sss : ss) {
                    if (sss != null && sss.length() > 0) {
                        subList.add(Integer.valueOf(sss));
                    }
                }
                list.add(subList);
            }
            return list;
        }

        void dfs(TreeNode root, List<String> list) {
            if (root == null) {
                return;
            }
            if (root.left == null && root.right == null) {
                return;
            }
            if (root.left != null && root.right != null) {
                //先left后right
                List<String> newList = new ArrayList<>();
                for (String s : list) {
                    String lr = s + root.left.val + ',' + +root.right.val + ',';
                    String rl = s + root.right.val + ',' + root.left.val + ',';
                    newList.add(lr);
                    newList.add(rl);
                }
                list.clear();
                for (String s : newList) {
                    list.add(s);
                }
                //先right后left
            } else {
                //只有一个，无关顺序
                String val = String.valueOf(root.left == null ? root.right.val : root.left.val);
                List<String> newList = new ArrayList<>();
                for (String s : list) {
                    newList.add(s + val + ",");
                }
                list.clear();
                for (String s : newList) {
                    list.add(s);
                }
            }
            dfs(root.left, list);
            dfs(root.right, list);
            System.out.println("都不为空的值:" + Arrays.toString(list.toArray(new String[list.size()])));
            System.out.println("都不为空的值大小:" + list.size());
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
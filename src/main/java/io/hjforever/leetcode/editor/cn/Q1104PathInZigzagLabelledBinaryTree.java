//In an infinite binary tree where every node has two children, the nodes are
//labelled in row order. 
//
// In the odd numbered rows (ie., the first, third, fifth,...), the labelling 
//is left to right, while in the even numbered rows (second, fourth, sixth,...), 
//the labelling is right to left. 
//
// 
//
// Given the label of a node in this tree, return the labels in the path from 
//the root of the tree to the node with that label. 
//
// 
// Example 1: 
//
// 
//Input: label = 14
//Output: [1,3,4,14]
// 
//
// Example 2: 
//
// 
//Input: label = 26
//Output: [1,2,6,10,26]
// 
//
// 
// Constraints: 
//
// 
// 1 <= label <= 10^6 
// 
// Related Topics 树 数学 二叉树 👍 177 👎 0


package io.hjforever.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Q1104PathInZigzagLabelledBinaryTree {
    public static void main(String[] args) {
        Solution solution = new Q1104PathInZigzagLabelledBinaryTree().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> pathInZigZagTree(int label) {
            List<Integer> list = getInitPath(label);
            boolean flag = false;
            for(int l = list.size() - 1; l >= 0; l--){
                if(flag){
                    int num = reverse(l, list.get(l));
                    list.set(l, num);
                }
                flag = !flag;
            }
            return list;
        }
        // 获得正常树的路径
        List<Integer> getInitPath(int label){
            LinkedList<Integer> list = new LinkedList<>();
            while(label > 0){
                list.addFirst(label);
                label = label/2;
            }
            return list;
        }
        // 获取num的对称元素，继父
        int reverse(int level, int num){
            return (1 << level) + (1 << level + 1) - 1 - num;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
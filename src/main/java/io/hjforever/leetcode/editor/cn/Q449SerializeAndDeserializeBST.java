//Serialization is converting a data structure or object into a sequence of
//bits so that it can be stored in a file or memory buffer, or transmitted across a 
//network connection link to be reconstructed later in the same or another computer 
//environment. 
//
// Design an algorithm to serialize and deserialize a binary search tree. There 
//is no restriction on how your serialization/deserialization algorithm should 
//work. You need to ensure that a binary search tree can be serialized to a string, 
//and this string can be deserialized to the original tree structure. 
//
// The encoded string should be as compact as possible. 
//
// 
// Example 1: 
// Input: root = [2,1,3]
//Output: [2,1,3]
// Example 2: 
// Input: root = []
//Output: []
// 
// 
// Constraints: 
//
// 
// The number of nodes in the tree is in the range [0, 10⁴]. 
// 0 <= Node.val <= 10⁴ 
// The input tree is guaranteed to be a binary search tree. 
// 
// Related Topics 树 深度优先搜索 广度优先搜索 设计 二叉搜索树 字符串 二叉树 👍 335 👎 0


package io.hjforever.leetcode.editor.cn;

import io.hjforever.leetcode.editor.cn.common.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class Q449SerializeAndDeserializeBST {
    public static void main(String[] args) {
        //Solution solution = new Q449SerializeAndDeserializeBST().new Solution();
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
    public class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            if (root == null) return "NULL";
            return "" + root.val + "," + serialize(root.left) + "," + serialize(root.right);
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            String[] array = data.split(",");
            return deserialize0(new LinkedList<String>(new ArrayList<>(Arrays.asList(array))));
        }

        private TreeNode deserialize0(LinkedList<String> list) {
            String val = list.getFirst();
            if (val.equals("NULL")) {
                list.removeFirst();
                return null;
            }
            TreeNode node = new TreeNode(Integer.parseInt(val));
            list.removeFirst();
            node.left = deserialize0(list);
            node.right = deserialize0(list);
            return node;
        }
    }

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;
//leetcode submit region end(Prohibit modification and deletion)

}
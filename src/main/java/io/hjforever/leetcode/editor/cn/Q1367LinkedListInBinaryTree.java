//Given a binary tree root and a linked list with head as the first node.
//
// Return True if all the elements in the linked list starting from the head 
//correspond to some downward path connected in the binary tree otherwise return 
//False. 
//
// In this context downward path means a path that starts at some node and goes 
//downwards. 
//
// 
// Example 1: 
//
// 
//
// 
//Input: head = [4,2,8], root = [1,4,4,null,2,2,null,1,null,6,8,null,null,null,
//null,1,3]
//Output: true
//Explanation: Nodes in blue form a subpath in the binary Tree.  
// 
//
// Example 2: 
//
// 
//
// 
//Input: head = [1,4,2,6], root = [1,4,4,null,2,2,null,1,null,6,8,null,null,
//null,null,1,3]
//Output: true
// 
//
// Example 3: 
//
// 
//Input: head = [1,4,2,6,8], root = [1,4,4,null,2,2,null,1,null,6,8,null,null,
//null,null,1,3]
//Output: false
//Explanation: There is no path in the binary tree that contains all the 
//elements of the linked list from head.
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree will be in the range [1, 2500]. 
// The number of nodes in the list will be in the range [1, 100]. 
// 1 <= Node.val <= 100 for each node in the linked list and binary tree. 
// 
// Related Topics 树 深度优先搜索 广度优先搜索 链表 二叉树 👍 141 👎 0


package io.hjforever.leetcode.editor.cn;

import io.hjforever.leetcode.editor.cn.common.ListNode;
import io.hjforever.leetcode.editor.cn.common.TreeNode;

public class Q1367LinkedListInBinaryTree {
    public static void main(String[] args) {
        Solution solution = new Q1367LinkedListInBinaryTree().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
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

        boolean ans = false;


        public boolean isSubPath(ListNode head, TreeNode root) {
            //1.字符串比较， 逻辑简单，但是时间稍长
//            StringBuilder builder = new StringBuilder();
//            ListNode temp = head;
//            while (temp != null) {
//                builder.append(temp.val).append(":");
//                temp = temp.next;
//            }
//            builder.deleteCharAt(builder.length() - 1);
//            String pattern = builder.toString();
//            dfs(pattern, "", root);
//            return ans;

            //链表节点只有在3个地方开始，1，根节点，2.左，3.右
            //TODO, 递归还是要多练，多总结
            if (head == null) return true;
            if (root == null) return false;
            return isSubPathRoot(head, root) || isSubPath(head, root.left) || isSubPath(head, root.right);
        }

        private boolean isSubPathRoot(ListNode head, TreeNode root) {
            if (head == null) return true;
            if (root == null) return false;
            if (root.val == head.val) {
                return isSubPathRoot(head.next, root.left) || isSubPathRoot(head.next, root.right);
            }
            return false;
        }


        //1.字符串比较， 逻辑简单，但是时效不高
//        void dfs(String pattern, String path, TreeNode root) {
//            if (root == null) return;
//            int val = root.val;
//            String p = path + ":" + val;
//            //System.out.println(p);
//            if (p.contains(pattern)) {
//                ans = true;
//                return;
//            }
//            dfs(pattern, p, root.left);
//            dfs(pattern, p, root.right);
//        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
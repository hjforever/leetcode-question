//Given a Circular Linked List node, which is sorted in ascending order, write
//a function to insert a value insertVal into the list such that it remains a 
//sorted circular list. The given node can be a reference to any single node in the 
//list and may not necessarily be the smallest value in the circular list. 
//
// If there are multiple suitable places for insertion, you may choose any 
//place to insert the new value. After the insertion, the circular list should remain 
//sorted. 
//
// If the list is empty (i.e., the given node is null), you should create a new 
//single circular list and return the reference to that single node. Otherwise, 
//you should return the originally given node. 
//
// 
// Example 1: 
// 
// 
// 
//Input: head = [3,4,1], insertVal = 2
//Output: [3,4,1,2]
//Explanation: In the figure above, there is a sorted circular list of three 
//elements. You are given a reference to the node with value 3, and we need to 
//insert 2 into the list. The new node should be inserted between node 1 and node 3. 
//After the insertion, the list should look like this, and we should still return 
//node 3.
//
//
//
// 
//
// Example 2: 
//
// 
//Input: head = [], insertVal = 1
//Output: [1]
//Explanation: The list is empty (given head is null). We create a new single 
//circular list and return the reference to that single node.
// 
//
// Example 3: 
//
// 
//Input: head = [1], insertVal = 0
//Output: [1,0]
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the list is in the range [0, 5 * 10⁴]. 
// -10⁶ <= Node.val, insertVal <= 10⁶ 
// 
// Related Topics 链表 👍 64 👎 0


package io.hjforever.leetcode.editor.cn;

import io.hjforever.leetcode.editor.cn.common.Node;

public class Q708InsertIntoASortedCircularLinkedList {
    public static void main(String[] args) {
        Solution solution = new Q708InsertIntoASortedCircularLinkedList().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _next) {
        val = _val;
        next = _next;
    }
};
*/

    class Solution {
        public Node insert(Node head, int insertVal) {
            Node node = new Node(insertVal);
            if (head == null) {
                node.next = node;
                return node;
            }
            if (head.next == head) {
                head.next = node;
                node.next = head;
                return head;
            }
            Node cur = head;
            Node next = head.next;

            //遍历一圈
            while (next != head) {
                //是否是插入位置
                if (insertVal >= cur.val && insertVal <= next.val) {
                    break;
                }
                if (cur.val > next.val) {
                    //看是否是最大值或者是最小值
                    if (insertVal > cur.val || insertVal < next.val) {
                        break;
                    }
                }
                cur = cur.next;
                next = next.next;
            }
            //插入新节点
            cur.next = node;
            node.next = next;
            return head;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
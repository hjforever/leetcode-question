//English description is not available for the problem. Please switch to
//Chinese. 
// Related Topics 链表 👍 50 👎 0


package io.hjforever.leetcode.editor.cn;

import io.hjforever.leetcode.editor.cn.common.Node;

public class QJianZhiOfferII029PaiXuDeXunHuanLianBiao {
    public static void main(String[] args) {
        Solution solution = new QJianZhiOfferII029PaiXuDeXunHuanLianBiao().new Solution();
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
            Node curr = head, next = head.next;
            while (next != head) {
                if (insertVal >= curr.val && insertVal <= next.val) {
                    break;
                }
                if (curr.val > next.val) {
                    if (insertVal > curr.val || insertVal < next.val) {
                        break;
                    }
                }
                curr = curr.next;
                next = next.next;
            }
            curr.next = node;
            node.next = next;
            return head;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
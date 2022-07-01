//Design a queue that supports push and pop operations in the front, middle,
//and back. 
//
// Implement the FrontMiddleBack class: 
//
// 
// FrontMiddleBack() Initializes the queue. 
// void pushFront(int val) Adds val to the front of the queue. 
// void pushMiddle(int val) Adds val to the middle of the queue. 
// void pushBack(int val) Adds val to the back of the queue. 
// int popFront() Removes the front element of the queue and returns it. If the 
//queue is empty, return -1. 
// int popMiddle() Removes the middle element of the queue and returns it. If 
//the queue is empty, return -1. 
// int popBack() Removes the back element of the queue and returns it. If the 
//queue is empty, return -1. 
// 
//
// Notice that when there are two middle position choices, the operation is 
//performed on the frontmost middle position choice. For example: 
//
// 
// Pushing 6 into the middle of [1, 2, 3, 4, 5] results in [1, 2, 6, 3, 4, 5]. 
// Popping the middle from [1, 2, 3, 4, 5, 6] returns 3 and results in [1, 2, 4,
// 5, 6]. 
// 
//
// 
// Example 1: 
//
// 
//Input:
//["FrontMiddleBackQueue", "pushFront", "pushBack", "pushMiddle", "pushMiddle", 
//"popFront", "popMiddle", "popMiddle", "popBack", "popFront"]
//[[], [1], [2], [3], [4], [], [], [], [], []]
//Output:
//[null, null, null, null, null, 1, 3, 4, 2, -1]
//
//Explanation:
//FrontMiddleBackQueue q = new FrontMiddleBackQueue();
//q.pushFront(1);   // [1]
//q.pushBack(2);    // [1, 2]
//q.pushMiddle(3);  // [1, 3, 2]
//q.pushMiddle(4);  // [1, 4, 3, 2]
//q.popFront();     // return 1 -> [4, 3, 2]
//q.popMiddle();    // return 3 -> [4, 2]
//q.popMiddle();    // return 4 -> [2]
//q.popBack();      // return 2 -> []
//q.popFront();     // return -1 -> [] (The queue is empty)
// 
//
// 
// Constraints: 
//
// 
// 1 <= val <= 10⁹ 
// At most 1000 calls will be made to pushFront, pushMiddle, pushBack, popFront,
// popMiddle, and popBack. 
// 
// Related Topics 设计 队列 数组 链表 数据流 👍 23 👎 0


package io.hjforever.leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Deque;

public class Q1670DesignFrontMiddleBackQueue {
    public static void main(String[] args) {
        //Solution solution = new Q1670DesignFrontMiddleBackQueue().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class FrontMiddleBackQueue {

        Deque<Integer> left;
        Deque<Integer> right;

        public FrontMiddleBackQueue() {
            left = new ArrayDeque<>();
            right = new ArrayDeque<>();
        }

        public void pushFront(int val) {
            left.addFirst(val);
            reBalance();
        }

        public void pushMiddle(int val) {
            if (left.size() == right.size()) {
                right.addFirst(val);
            } else {
                left.addLast(val);
            }
        }

        public void pushBack(int val) {
            right.addLast(val);
            reBalance();
        }

        public int popFront() {
            Integer val = left.pollFirst();
            if (val == null) {
                val = right.pollFirst();
                return val == null ? -1 : val;
            } else {
                reBalance();
                return val;
            }
        }

        public int popMiddle() {
            if (left.size() == right.size()) {
                Integer val = left.pollLast();
                return val == null ? -1 : val;
            } else {
                return right.pollFirst();
            }
        }

        public int popBack() {
            Integer val = right.pollLast();
            reBalance();
            return val == null ? -1 : val;
        }

        public void reBalance() {
            if (left.size() > right.size()) {
                right.addFirst(left.pollLast());
            } else if (right.size() == left.size() + 2) {
                left.addLast(right.pollFirst());
            }
        }
    }
/**
 * Your FrontMiddleBackQueue object will be instantiated and called as such:
 * FrontMiddleBackQueue obj = new FrontMiddleBackQueue();
 * obj.pushFront(val);
 * obj.pushMiddle(val);
 * obj.pushBack(val);
 * int param_4 = obj.popFront();
 * int param_5 = obj.popMiddle();
 * int param_6 = obj.popBack();
 */
//leetcode submit region end(Prohibit modification and deletion)

}
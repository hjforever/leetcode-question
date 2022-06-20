//A Range Module is a module that tracks ranges of numbers. Design a data
//structure to track the ranges represented as half-open intervals and query about them.
// 
//
// A half-open interval [left, right) denotes all the real numbers x where left 
//<= x < right. 
//
// Implement the RangeModule class: 
//
// 
// RangeModule() Initializes the object of the data structure. 
// void addRange(int left, int right) Adds the half-open interval [left, right),
// tracking every real number in that interval. Adding an interval that partially 
//overlaps with currently tracked numbers should add any numbers in the interval [
//left, right) that are not already tracked. 
// boolean queryRange(int left, int right) Returns true if every real number in 
//the interval [left, right) is currently being tracked, and false otherwise. 
// void removeRange(int left, int right) Stops tracking every real number 
//currently being tracked in the half-open interval [left, right). 
// 
//
// 
// Example 1: 
//
// 
//Input
//["RangeModule", "addRange", "removeRange", "queryRange", "queryRange", 
//"queryRange"]
//[[], [10, 20], [14, 16], [10, 14], [13, 15], [16, 17]]
//Output
//[null, null, null, true, false, true]
//
//Explanation
//RangeModule rangeModule = new RangeModule();
//rangeModule.addRange(10, 20);
//rangeModule.removeRange(14, 16);
//rangeModule.queryRange(10, 14); // return True,(Every number in [10, 14) is 
//being tracked)
//rangeModule.queryRange(13, 15); // return False,(Numbers like 14, 14.03, 14.17
// in [13, 15) are not being tracked)
//rangeModule.queryRange(16, 17); // return True, (The number 16 in [16, 17) is 
//still being tracked, despite the remove operation)
// 
//
// 
// Constraints: 
//
// 
// 1 <= left < right <= 10⁹ 
// At most 10⁴ calls will be made to addRange, queryRange, and removeRange. 
// 
// Related Topics 设计 线段树 有序集合 👍 134 👎 0


package io.hjforever.leetcode.editor.cn;


public class Q715RangeModule {
    public static void main(String[] args) {
        RangeModule rangeModule = new Q715RangeModule().new RangeModule();

        rangeModule.addRange(10, 20);

    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class SegmentNode {
        SegmentNode left;
        SegmentNode right;
        //节点的值
        int sum;
        // 懒惰标记
        int add;
    }

    class RangeModule {

        SegmentNode root = new SegmentNode();
        //线段树 , segmentTree
        private int N = (int) 1e9 + 10;

        public RangeModule() {

        }

        public void update(SegmentNode node, int start, int end, int l, int r, int val) {
            int len = (end - start + 1);
            if (l <= start && end <= r) {
                node.sum = val == 1 ? len : 0;
                node.add = val;
                return;
            }
            pushdown(node, len);
            int mid = (start + end) >> 1;
            if (l <= mid) {
                update(node.left, start, mid, l, r, val);
            }
            if (r > mid) {
                update(node.right, mid + 1, end, l, r, val);
            }
            pushup(node);
        }

        void pushup(SegmentNode node) {
            node.sum = node.left.sum + node.right.sum;
        }

        public void pushdown(SegmentNode node, int len) {
            if (node.left == null) node.left = new SegmentNode();
            if (node.right == null) node.right = new SegmentNode();
            if (node.add == 0) return;
            int add = node.add;
            if (add == -1) {
                node.left.sum = node.right.sum = 0;
            } else {
                node.left.sum = len - len / 2;
                node.right.sum = len / 2;
            }
            node.left.add = node.right.add = add;
            node.add = 0;
        }

        int query(SegmentNode node, int start, int end, int l, int r) {
            if (l <= start && end <= r) return node.sum;
            pushdown(node, end - start + 1);
            int mid = start + end >> 1;
            int ans = 0;
            if (l <= mid) ans = query(node.left, start, mid, l, r);
            if (r > mid) ans += query(node.right, mid + 1, end, l, r);
            return ans;
        }

        public void addRange(int left, int right) {
            update(root, 1, N - 1, left, right - 1, 1);
        }

        public boolean queryRange(int left, int right) {
            return query(root, 1, N - 1, left, right - 1) == right - left;
        }

        public void removeRange(int left, int right) {
            update(root, 1, N - 1, left, right - 1, -1);
        }
    }

/**
 * Your RangeModule object will be instantiated and called as such:
 * RangeModule obj = new RangeModule();
 * obj.addRange(left,right);
 * boolean param_2 = obj.queryRange(left,right);
 * obj.removeRange(left,right);
 */
//leetcode submit region end(Prohibit modification and deletion)

}
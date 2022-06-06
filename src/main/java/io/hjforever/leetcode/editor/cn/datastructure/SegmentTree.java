package io.hjforever.leetcode.editor.cn.datastructure;

public class SegmentTree {

    int[] nums;
    SegmentNode root;

    public SegmentTree(int[] nums) {
        this.nums = nums;
        this.root = buildTree(nums, 0, nums.length - 1);
    }

    /**
     * build segment tree
     *
     * @param nums
     * @param start
     * @param end
     * @return
     */
    public SegmentNode buildTree(int[] nums, int start, int end) {
        if (start > end) return null;
        SegmentNode node = new SegmentNode(start, end);
        if (start == end) {
            node.sum = nums[start];
        } else {
            int mid = (start + end) / 2;
            SegmentNode left = buildTree(nums, start, mid);
            SegmentNode right = buildTree(nums, mid + 1, end);
            node.sum = left.sum + right.sum;
        }
        return node;
    }

    /**
     * single node value update
     *
     * @param node
     * @param index
     * @param val
     */
    public void update(SegmentNode node, int index, int val) {
        if (node.start == node.end) {
            node.sum = val;
            return;
        }
        int mid = node.start + (node.end - node.start) / 2;
        if (index <= mid) {
            update(node.left, index, val);
        } else if (index > mid) {
            update(node.right, index, val);
        }
        node.sum = node.left.sum + node.right.sum;
        return;
    }

    public int sumRange(SegmentNode node, int start, int end) {
        if (start > end) return 0;
        if (node.start == start && node.end == end) return node.sum;
        int mid = (node.end - node.start) / 2 + node.start;
        if (end <= mid) {
            return sumRange(node.left, start, end);
        } else if (start > mid) {
            return sumRange(node.right, start, end);
        }
        return sumRange(node.left, start, mid) + sumRange(node.right, mid + 1, end);
    }

}

class SegmentNode {
    int start;
    int end;
    int sum;
    SegmentNode left, right;

    SegmentNode(int s, int e) {
        this.start = s;
        this.end = e;
    }
}

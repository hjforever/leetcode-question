//The median is the middle value in an ordered integer list. If the size of the
//list is even, there is no middle value. So the median is the mean of the two 
//middle values. 
//
// 
// For examples, if arr = [2,3,4], the median is 3. 
// For examples, if arr = [1,2,3,4], the median is (2 + 3) / 2 = 2.5. 
// 
//
// You are given an integer array nums and an integer k. There is a sliding 
//window of size k which is moving from the very left of the array to the very right. 
//You can only see the k numbers in the window. Each time the sliding window 
//moves right by one position. 
//
// Return the median array for each window in the original array. Answers 
//within 10⁻⁵ of the actual value will be accepted. 
//
// 
// Example 1: 
//
// 
//Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
//Output: [1.00000,-1.00000,-1.00000,3.00000,5.00000,6.00000]
//Explanation: 
//Window position                Median
//---------------                -----
//[1  3  -1] -3  5  3  6  7        1
// 1 [3  -1  -3] 5  3  6  7       -1
// 1  3 [-1  -3  5] 3  6  7       -1
// 1  3  -1 [-3  5  3] 6  7        3
// 1  3  -1  -3 [5  3  6] 7        5
// 1  3  -1  -3  5 [3  6  7]       6
// 
//
// Example 2: 
//
// 
//Input: nums = [1,2,3,4,2,3,1,4,2], k = 3
//Output: [2.00000,3.00000,3.00000,3.00000,2.00000,3.00000,2.00000]
// 
//
// 
// Constraints: 
//
// 
// 1 <= k <= nums.length <= 10⁵ 
// -2³¹ <= nums[i] <= 2³¹ - 1 
// 
// Related Topics 数组 哈希表 滑动窗口 堆（优先队列） 👍 370 👎 0


package io.hjforever.leetcode.editor.cn;

import java.util.PriorityQueue;

public class Q480SlidingWindowMedian {
    public static void main(String[] args) {
        Solution solution = new Q480SlidingWindowMedian().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public double[] medianSlidingWindow(int[] nums, int k) {
            //通过构建两个优先队列构建对应的数据结构
            int n = nums.length;
            int cnt = n - k + 1;
            double[] ans = new double[cnt];
            // 如果是奇数滑动窗口，让 right 的数量比 left 多一个
            PriorityQueue<Integer> left = new PriorityQueue<>((a, b) -> Integer.compare(b, a)); // 滑动窗口的左半部分
            PriorityQueue<Integer> right = new PriorityQueue<>(Integer::compare); // 滑动窗口的右半部分
            for (int i = 0; i < k; i++) right.add(nums[i]);
            for (int i = 0; i < k / 2; i++) left.add(right.poll());
            ans[0] = getMid(left, right);
            for (int i = k; i < n; i++) {
                // 人为确保了 right 会比 left 多，因此，删除和添加都与 right 比较（left 可能为空）
                int add = nums[i], del = nums[i - k];
                if (add >= right.peek()) {
                    right.add(add);
                } else {
                    left.add(add);
                }
                if (del >= right.peek()) {
                    right.remove(del);
                } else {
                    left.remove(del);
                }
                adjust(left, right);
                ans[i - k + 1] = getMid(left, right);
            }
            return ans;
        }

        void adjust(PriorityQueue<Integer> left, PriorityQueue<Integer> right) {
            while (left.size() > right.size()) right.add(left.poll());
            while (right.size() - left.size() > 1) left.add(right.poll());
        }

        double getMid(PriorityQueue<Integer> left, PriorityQueue<Integer> right) {
            if (left.size() == right.size()) {
                return (left.peek() / 2.0) + (right.peek() / 2.0);
            } else {
                return right.peek() * 1.0;
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}
//返回 A 的最短的非空连续子数组的长度，该子数组的和至少为 K 。
//
// 如果没有和至少为 K 的非空子数组，返回 -1 。 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 输入：A = [1], K = 1
//输出：1
// 
//
// 示例 2： 
//
// 输入：A = [1,2], K = 4
//输出：-1
// 
//
// 示例 3： 
//
// 输入：A = [2,-1,2], K = 3
//输出：3
// 
//
// 
//
// 提示： 
//
// 
// 1 <= A.length <= 50000 
// -10 ^ 5 <= A[i] <= 10 ^ 5 
// 1 <= K <= 10 ^ 9 
// 
// Related Topics 队列 数组 二分查找 前缀和 滑动窗口 单调队列 堆（优先队列） 👍 320 👎 0


package io.hjforever.leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class Q862HeZhiShaoWeiKDeZuiDuanZiShuZu {
    public static void main(String[] args) {
        Solution solution = new Q862HeZhiShaoWeiKDeZuiDuanZiShuZu().new Solution();
        solution.shortestSubarray(new int[]{1, 2}, 4);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int shortestSubarray(int[] nums, int k) {
            return slidingWindow(nums, k);
        }

        //sliding window
        public int slidingWindow(int[] nums, int k) {
            //前缀和
            int n = nums.length;
            //此处要注意要用long，不然会溢出
            long[] sum = new long[n + 1];
            for (int i = 0; i < n; i++) {
                sum[i + 1] = nums[i] + sum[i];
            }
            int res = n + 1;
            Deque<Integer> deque = new LinkedList<>();
            for (int i = 0; i <= n; i++) {
                //判断当前sum是否小于前一个sum，如果小于则丢弃，保证递增队列
                while (!deque.isEmpty() && sum[deque.peekLast()] >= sum[i]) {
                    deque.pollLast();
                }
                //保证队列大于target
                while (!deque.isEmpty() && sum[i] - sum[deque.peekFirst()] >= k) {
                    res = Math.min(res, i - deque.pollFirst());
                }
                deque.offerLast(i);
            }
            return res <= n ? res : -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
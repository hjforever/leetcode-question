//给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
//
// 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。 
//
// 
//
// 示例 1: 
//
// 
//输入: [3,2,1,5,6,4] 和 k = 2
//输出: 5
// 
//
// 示例 2: 
//
// 
//输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
//输出: 4 
//
// 
//
// 提示： 
//
// 
// 1 <= k <= nums.length <= 10⁴ 
// -10⁴ <= nums[i] <= 10⁴ 
// 
// Related Topics 数组 分治 快速选择 排序 堆（优先队列） 👍 1542 👎 0


package io.hjforever.leetcode.editor.cn;

import java.util.PriorityQueue;

public class Q215ShuZuZhongDeDiKGeZuiDaYuanSu {
    public static void main(String[] args) {
        Solution solution = new Q215ShuZuZhongDeDiKGeZuiDaYuanSu().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findKthLargest(int[] nums, int k) {
            //优先堆
            //此处为最小堆
            PriorityQueue<Integer> queue = new PriorityQueue<>();
            for (int num : nums) {
                if (queue.size() < k) {
                    queue.add(num);
                } else {
                    queue.add(num);
                    queue.poll();
                }
            }
            return queue.poll();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
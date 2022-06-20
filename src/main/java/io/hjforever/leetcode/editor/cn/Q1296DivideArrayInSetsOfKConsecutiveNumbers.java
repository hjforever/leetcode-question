//Given an array of integers nums and a positive integer k, check whether it is
//possible to divide this array into sets of k consecutive numbers. 
//
// Return true if it is possible. Otherwise, return false. 
//
// 
// Example 1: 
//
// 
//Input: nums = [1,2,3,3,4,4,5,6], k = 4
//Output: true
//Explanation: Array can be divided into [1,2,3,4] and [3,4,5,6].
// 
//
// Example 2: 
//
// 
//Input: nums = [3,2,1,2,3,4,3,4,5,9,10,11], k = 3
//Output: true
//Explanation: Array can be divided into [1,2,3] , [2,3,4] , [3,4,5] and [9,10,1
//1].
// 
//
// Example 3: 
//
// 
//Input: nums = [1,2,3,4], k = 3
//Output: false
//Explanation: Each array should be divided in subarrays of size 3.
// 
//
// 
// Constraints: 
//
// 
// 1 <= k <= nums.length <= 10⁵ 
// 1 <= nums[i] <= 10⁹ 
// 
//
// 
//Note: This question is the same as 846: https://leetcode.com/problems/hand-of-
//straights/ Related Topics 贪心 数组 哈希表 排序 👍 77 👎 0


package io.hjforever.leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Q1296DivideArrayInSetsOfKConsecutiveNumbers {
    public static void main(String[] args) {
        Solution solution = new Q1296DivideArrayInSetsOfKConsecutiveNumbers().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isPossibleDivide(int[] hand, int groupSize) {
            // sort,  greedy
            int n = hand.length;
            if (n % groupSize != 0) return false;
            Arrays.sort(hand);
            Map<Integer, Integer> cnt = new HashMap<>();
            for (int x : hand) {
                cnt.put(x, cnt.getOrDefault(x, 0) + 1);
            }
            for (int i = 0; i < n; i++) {
                int num = hand[i];
                if (!cnt.containsKey(num) || cnt.getOrDefault(num, 0) <= 0) {
                    continue;
                }
                for (int j = 0; j < groupSize; j++) {
                    int data = num + j;
                    if (!cnt.containsKey(data) || cnt.getOrDefault(data, 0) <= 0) return false;
                    cnt.put(data, cnt.get(data) - 1);
                    if (cnt.get(data) == 0) cnt.remove(data);
                }

            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
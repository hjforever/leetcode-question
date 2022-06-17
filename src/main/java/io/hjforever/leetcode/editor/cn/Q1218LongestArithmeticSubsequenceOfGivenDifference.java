//Given an integer array arr and an integer difference, return the length of
//the longest subsequence in arr which is an arithmetic sequence such that the 
//difference between adjacent elements in the subsequence equals difference. 
//
// A subsequence is a sequence that can be derived from arr by deleting some or 
//no elements without changing the order of the remaining elements. 
//
// 
// Example 1: 
//
// 
//Input: arr = [1,2,3,4], difference = 1
//Output: 4
//Explanation: The longest arithmetic subsequence is [1,2,3,4]. 
//
// Example 2: 
//
// 
//Input: arr = [1,3,5,7], difference = 1
//Output: 1
//Explanation: The longest arithmetic subsequence is any single element.
// 
//
// Example 3: 
//
// 
//Input: arr = [1,5,7,8,5,3,4,2,1], difference = -2
//Output: 4
//Explanation: The longest arithmetic subsequence is [7,5,3,1].
// 
//
// 
// Constraints: 
//
// 
// 1 <= arr.length <= 10⁵ 
// -10⁴ <= arr[i], difference <= 10⁴ 
// 
// Related Topics 数组 哈希表 动态规划 👍 215 👎 0


package io.hjforever.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class Q1218LongestArithmeticSubsequenceOfGivenDifference {
    public static void main(String[] args) {
        Solution solution = new Q1218LongestArithmeticSubsequenceOfGivenDifference().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int longestSubsequence(int[] arr, int difference) {
            // dp(i) = dp(i-v) + 1 ;
            Map<Integer, Integer> map = new HashMap<>();
            int ans = 0;
            for (int i = 0; i < arr.length; i++) {
                int num = arr[i];
                int size = map.getOrDefault(num - difference, 0) + 1;
                map.put(num, size);
                ans = Math.max(ans, size);
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
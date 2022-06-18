//You are given an array of positive integers nums and want to erase a subarray
//containing unique elements. The score you get by erasing the subarray is equal 
//to the sum of its elements. 
//
// Return the maximum score you can get by erasing exactly one subarray. 
//
// An array b is called to be a subarray of a if it forms a contiguous 
//subsequence of a, that is, if it is equal to a[l],a[l+1],...,a[r] for some (l,r). 
//
// 
// Example 1: 
//
// 
//Input: nums = [4,2,4,5,6]
//Output: 17
//Explanation: The optimal subarray here is [2,4,5,6].
// 
//
// Example 2: 
//
// 
//Input: nums = [5,2,1,2,5,2,1,2,5]
//Output: 8
//Explanation: The optimal subarray here is [5,2,1] or [1,2,5].
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 10⁵ 
// 1 <= nums[i] <= 10⁴ 
// 
// Related Topics 数组 哈希表 滑动窗口 👍 52 👎 0


package io.hjforever.leetcode.editor.cn;

import org.omg.CORBA.INTERNAL;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Q1695MaximumErasureValue {
    public static void main(String[] args) {
        Solution solution = new Q1695MaximumErasureValue().new Solution();
        solution.maximumUniqueSubarray(new int[]{4, 2, 4, 5, 6});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maximumUniqueSubarray(int[] nums) {
            //sliding window
            int n = nums.length;
            int ans = 0;
            int left = 0;
            int right = 0;
            int sum = 0;
            Set<Integer> set = new HashSet<>();
            while (right < n) {
                int num = nums[right];
                while (left < n && set.contains(num)) {
                    sum -= nums[left];
                    set.remove(nums[left++]);
                }
                set.add(num);
                right++;
                sum += num;
                ans = Math.max(ans, sum);
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
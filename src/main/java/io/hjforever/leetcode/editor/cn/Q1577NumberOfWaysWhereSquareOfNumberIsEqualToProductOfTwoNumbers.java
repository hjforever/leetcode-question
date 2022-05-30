//Given two arrays of integers nums1 and nums2, return the number of triplets
//formed (type 1 and type 2) under the following rules: 
//
// 
// Type 1: Triplet (i, j, k) if nums1[i]² == nums2[j] * nums2[k] where 0 <= i < 
//nums1.length and 0 <= j < k < nums2.length. 
// Type 2: Triplet (i, j, k) if nums2[i]² == nums1[j] * nums1[k] where 0 <= i < 
//nums2.length and 0 <= j < k < nums1.length. 
// 
//
// 
// Example 1: 
//
// 
//Input: nums1 = [7,4], nums2 = [5,2,8,9]
//Output: 1
//Explanation: Type 1: (1, 1, 2), nums1[1]² = nums2[1] * nums2[2]. (4² = 2 * 8).
// 
// 
//
// Example 2: 
//
// 
//Input: nums1 = [1,1], nums2 = [1,1,1]
//Output: 9
//Explanation: All Triplets are valid, because 1² = 1 * 1.
//Type 1: (0,0,1), (0,0,2), (0,1,2), (1,0,1), (1,0,2), (1,1,2).  nums1[i]² = 
//nums2[j] * nums2[k].
//Type 2: (0,0,1), (1,0,1), (2,0,1). nums2[i]² = nums1[j] * nums1[k].
// 
//
// Example 3: 
//
// 
//Input: nums1 = [7,7,8,3], nums2 = [1,2,9,7]
//Output: 2
//Explanation: There are 2 valid triplets.
//Type 1: (3,0,2).  nums1[3]² = nums2[0] * nums2[2].
//Type 2: (3,0,1).  nums2[3]² = nums1[0] * nums1[1].
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums1.length, nums2.length <= 1000 
// 1 <= nums1[i], nums2[i] <= 10⁵ 
// 
// Related Topics 数组 哈希表 数学 双指针 👍 14 👎 0


package io.hjforever.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class Q1577NumberOfWaysWhereSquareOfNumberIsEqualToProductOfTwoNumbers {
    public static void main(String[] args) {
        Solution solution = new Q1577NumberOfWaysWhereSquareOfNumberIsEqualToProductOfTwoNumbers().new Solution();
        System.out.println(solution.numTriplets(new int[]{43024, 99908}, new int[]{1864}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        // map count
        public int numTriplets(int[] nums1, int[] nums2) {
            Map<Long, Integer> cnt1 = new HashMap<>();
            Map<Long, Integer> cnt2 = new HashMap<>();

            for (int i = 0; i < nums1.length; i++) {
                for (int j = i + 1; j < nums1.length; j++) {
                    long k = 1L * nums1[i] * nums1[j];
                    cnt1.put(k, cnt1.getOrDefault(k, 0) + 1);
                }
            }

            for (int i = 0; i < nums2.length; i++) {
                for (int j = i + 1; j < nums2.length; j++) {
                    long k = 1L * nums2[i] * nums2[j];
                    cnt2.put(k, cnt2.getOrDefault(k, 0) + 1);
                }
            }
            int ans = 0;
            for (int i = 0; i < nums1.length; i++) {
                long pow = 1L * nums1[i] * nums1[i];
                int count = cnt2.getOrDefault(pow, 0);
                ans += count;
            }
            for (int i = 0; i < nums2.length; i++) {
                long pow = 1L * nums2[i] * nums2[i];
                int count = cnt1.getOrDefault(pow, 0);
                ans += count;
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
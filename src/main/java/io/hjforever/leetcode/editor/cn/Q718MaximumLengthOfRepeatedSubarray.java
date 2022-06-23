//Given two integer arrays nums1 and nums2, return the maximum length of a
//subarray that appears in both arrays. 
//
// 
// Example 1: 
//
// 
//Input: nums1 = [1,2,3,2,1], nums2 = [3,2,1,4,7]
//Output: 3
//Explanation: The repeated subarray with maximum length is [3,2,1].
// 
//
// Example 2: 
//
// 
//Input: nums1 = [0,0,0,0,0], nums2 = [0,0,0,0,0]
//Output: 5
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums1.length, nums2.length <= 1000 
// 0 <= nums1[i], nums2[i] <= 100 
// 
// Related Topics 数组 二分查找 动态规划 滑动窗口 哈希函数 滚动哈希 👍 737 👎 0


package io.hjforever.leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

public class Q718MaximumLengthOfRepeatedSubarray {
    public static void main(String[] args) {
        Solution solution = new Q718MaximumLengthOfRepeatedSubarray().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int MOD = (int) (1e9 + 9);
        int P = 131;

        public int findLength(int[] nums1, int[] nums2) {
            //1.dp
            // dp(i,j) = dp(i+1) + nums1[i]==nums2[j]?1:0
           /* int m = nums1.length;
            int n = nums2.length;
            int[][] dp = new int[m + 1][n + 1];
            int max = 0;
            for (int i = m - 1; i >= 0; i--) {
                for (int j = n - 1; j >= 0; j--) {
                    dp[i][j] = nums1[i] == nums2[j] ? dp[i + 1][j + 1] + 1 : 0;
                    max = Math.max(max, dp[i][j]);
                }
            }
            return max;*/
            //2. hash
            return findLengthHash(nums1, nums2);
        }


        public int findLengthHash(int[] nums1, int[] nums2) {
            int m = nums1.length;
            //最大长度为 1-m
            int left = 0;
            int right = Math.min(nums1.length, nums2.length);
            int ans = 0;
            while (left < right) {
                int mid = (right + left + 1) >> 1;
                if (check(mid, nums1, nums2)) {
                    left = mid;
                    ans = Math.max(ans, mid);
                } else {
                    right = mid - 1;
                }
            }
            return ans;
        }

        // f(i+1)= P * f(i) + nums1[i]
        // f(r)-f(l) = F(r)-F(l-1)*P^(r-l+1)
        boolean check(int n, int[] A, int[] B) {
            Set<Long> bucketB = new HashSet<>();
            long hashB = 0;
            for (int i = 0; i < n; i++) {
                hashB = (hashB * P + B[i]) % MOD;
            }
            bucketB.add(hashB);
            long mult = quickPow(P, n - 1, MOD);

            for (int i = n; i < B.length; i++) {
                hashB = ((hashB - B[i - n] * mult % MOD + MOD) % MOD * P + B[i]) % MOD;
                bucketB.add(hashB);
            }

            long hashA = 0;
            for (int i = 0; i < n; i++) {
                hashA = (hashA * P + A[i]) % MOD;
            }
            if (bucketB.contains(hashA)) return true;
            for (int i = n; i < A.length; i++) {
                hashA = ((hashA - A[i - n] * mult % MOD + MOD) % MOD * P + A[i]) % MOD;
                if (bucketB.contains(hashA)) {
                    return true;
                }
            }
            return false;
        }

        long quickPow(long x, long n, long mod) {
            long ans = 1;
            while (n != 0) {
                if ((n & 1) == 1) {
                    ans = ans * x % mod;
                }
                x = x * x % mod;
                n >>= 1;
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
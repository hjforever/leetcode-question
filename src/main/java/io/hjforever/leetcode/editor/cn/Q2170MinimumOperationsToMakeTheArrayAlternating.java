//You are given a 0-indexed array nums consisting of n positive integers.
//
// The array nums is called alternating if: 
//
// 
// nums[i - 2] == nums[i], where 2 <= i <= n - 1. 
// nums[i - 1] != nums[i], where 1 <= i <= n - 1. 
// 
//
// In one operation, you can choose an index i and change nums[i] into any 
//positive integer. 
//
// Return the minimum number of operations required to make the array 
//alternating. 
//
// 
// Example 1: 
//
// 
//Input: nums = [3,1,3,2,4,3]
//Output: 3
//Explanation:
//One way to make the array alternating is by converting it to [3,1,3,1,3,1].
//The number of operations required in this case is 3.
//It can be proven that it is not possible to make the array alternating in 
//less than 3 operations. 
// 
//
// Example 2: 
//
// 
//Input: nums = [1,2,2,2,2]
//Output: 2
//Explanation:
//One way to make the array alternating is by converting it to [1,2,1,2,1].
//The number of operations required in this case is 2.
//Note that the array cannot be converted to [2,2,2,2,2] because in this case 
//nums[0] == nums[1] which violates the conditions of an alternating array.
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 10⁵ 
// 1 <= nums[i] <= 10⁵ 
// 
// Related Topics 贪心 数组 哈希表 计数 👍 31 👎 0


package io.hjforever.leetcode.editor.cn;

import java.util.Arrays;

public class Q2170MinimumOperationsToMakeTheArrayAlternating {
    public static void main(String[] args) {
        Solution solution = new Q2170MinimumOperationsToMakeTheArrayAlternating().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int N = 100010;
        int[] m1 = new int[N], m2 = new int[N];

        // greedy
        //用hash表记录奇数下标和偶数下标对应分别出现最多的第一第二名对应的值和次数，
        // 如果奇数第一名和偶数第一名对应的数组值不相等，直接返回结果,
        // 如果相等判断是用奇数第二名更改次数少还是偶数第二名更改次数少，返回较小值
        public int minimumOperations(int[] nums) {
            int n = nums.length;
            Arrays.fill(m1, 0);
            Arrays.fill(m2, 0);
            int a = 0, b = 0, c = 0, d = 0;
            for (int i = 0; i < n; i++) {
                int t = nums[i];
                if (i % 2 == 0) {
                    m1[t]++;
                    if (a == 0 || m1[t] > m1[a]) {
                        b = a;
                        a = t;
                    } else if (t != a && (b == 0 || m1[t] > m1[b])) {
                        b = t;
                    }
                } else {
                    m2[t]++;
                    if (c == 0 || m2[t] > m2[c]) {
                        d = c;
                        c = t;
                    } else if (t != c && (d == 0 || m2[t] > m2[d])) {
                        d = t;
                    }
                }
            }
            if (a != c) return n - m1[a] - m2[c];
            else return n - Math.max(m1[a] + m2[d], m1[b] + m2[c]);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
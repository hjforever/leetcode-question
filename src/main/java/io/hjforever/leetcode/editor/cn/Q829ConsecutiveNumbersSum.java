//Given an integer n, return the number of ways you can write n as the sum of
//consecutive positive integers. 
//
// 
// Example 1: 
//
// 
//Input: n = 5
//Output: 2
//Explanation: 5 = 2 + 3
// 
//
// Example 2: 
//
// 
//Input: n = 9
//Output: 3
//Explanation: 9 = 4 + 5 = 2 + 3 + 4
// 
//
// Example 3: 
//
// 
//Input: n = 15
//Output: 4
//Explanation: 15 = 8 + 7 = 4 + 5 + 6 = 1 + 2 + 3 + 4 + 5
// 
//
// 
// Constraints: 
//
// 
// 1 <= n <= 10⁹ 
// 
// Related Topics 数学 枚举 👍 233 👎 0


package io.hjforever.leetcode.editor.cn;

public class Q829ConsecutiveNumbersSum {
    public static void main(String[] args) {
        Solution solution = new Q829ConsecutiveNumbersSum().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 将 n 表示成 k 个连续的正整数之和。
        // 设第一个数为x，连续的k个数之和为x+(x+1)+ ... + (x+k-1) = k * x + (1+2+...+k-1) = k * x + k(k-1)/2。
        // 能表示的条件为n=k * x + k(k-1)/2 (x≥1,k≥1), 即 (n−sum) mod k = 0。
        public int consecutiveNumbersSum(int n) {
            int sum = 0, ans = 0;
            for (int i = 1; sum < n; i++) {
                if ((n - sum) % i == 0) ans++;
                sum += i;
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
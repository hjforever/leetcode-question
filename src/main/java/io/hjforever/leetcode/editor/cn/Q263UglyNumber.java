//An ugly number is a positive integer whose prime factors are limited to 2, 3,
//and 5. 
//
// Given an integer n, return true if n is an ugly number. 
//
// 
// Example 1: 
//
// 
//Input: n = 6
//Output: true
//Explanation: 6 = 2 × 3
// 
//
// Example 2: 
//
// 
//Input: n = 1
//Output: true
//Explanation: 1 has no prime factors, therefore all of its prime factors are 
//limited to 2, 3, and 5.
// 
//
// Example 3: 
//
// 
//Input: n = 14
//Output: false
//Explanation: 14 is not ugly since it includes the prime factor 7.
// 
//
// 
// Constraints: 
//
// 
// -2³¹ <= n <= 2³¹ - 1 
// 
// Related Topics 数学 👍 319 👎 0


package io.hjforever.leetcode.editor.cn;

public class Q263UglyNumber {
    public static void main(String[] args) {
        Solution solution = new Q263UglyNumber().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isUgly(int n) {
            if (n <= 0) return false;
            if (n == 1) return true;
            while (n % 5 == 0 || n % 3 == 0 || n % 2 == 0) {
                if (n % 5 == 0) n = n / 5;
                if (n % 3 == 0) n = n / 3;
                if (n % 2 == 0) n = n / 2;
            }
            return n == 1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
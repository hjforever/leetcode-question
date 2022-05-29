//You are given a 0-indexed string num of length n consisting of digits.
//
// Return true if for every index i in the range 0 <= i < n, the digit i occurs 
//num[i] times in num, otherwise return false. 
//
// 
// Example 1: 
//
// 
//Input: num = "1210"
//Output: true
//Explanation:
//num[0] = '1'. The digit 0 occurs once in num.
//num[1] = '2'. The digit 1 occurs twice in num.
//num[2] = '1'. The digit 2 occurs once in num.
//num[3] = '0'. The digit 3 occurs zero times in num.
//The condition holds true for every index in "1210", so return true.
// 
//
// Example 2: 
//
// 
//Input: num = "030"
//Output: false
//Explanation:
//num[0] = '0'. The digit 0 should occur zero times, but actually occurs twice 
//in num.
//num[1] = '3'. The digit 1 should occur three times, but actually occurs zero 
//times in num.
//num[2] = '0'. The digit 2 occurs zero times in num.
//The indices 0 and 1 both violate the condition, so return false.
// 
//
// 
// Constraints: 
//
// 
// n == num.length 
// 1 <= n <= 10 
// num consists of digits. 
// 
// 👍 2 👎 0


package io.hjforever.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class Q6083CheckIfNumberHasEqualDigitCountAndDigitValue {
    public static void main(String[] args) {
        Solution solution = new Q6083CheckIfNumberHasEqualDigitCountAndDigitValue().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean digitCount(String nums) {
            int n = nums.length();
            Map<Integer, Integer> cnt = new HashMap<>();
            for (int i = 0; i < n; i++) {
                int num = nums.charAt(i) - '0';
                cnt.put(num, cnt.getOrDefault(num, 0) + 1);
            }
            for (int i = 0; i < n; i++) {
                int num = nums.charAt(i) - '0';
                if (num != cnt.getOrDefault(i, 0)) {
                    return false;
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
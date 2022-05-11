//A good meal is a meal that contains exactly two different food items with a
//sum of deliciousness equal to a power of two. 
//
// You can pick any two different foods to make a good meal. 
//
// Given an array of integers deliciousness where deliciousness[i] is the 
//deliciousness of the ith item of food, return the number of different good meals you 
//can make from this list modulo 10⁹ + 7. 
//
// Note that items with different indices are considered different even if they 
//have the same deliciousness value. 
//
// 
// Example 1: 
//
// 
//Input: deliciousness = [1,3,5,7,9]
//Output: 4
//Explanation: The good meals are (1,3), (1,7), (3,5) and, (7,9).
//Their respective sums are 4, 8, 8, and 16, all of which are powers of 2.
// 
//
// Example 2: 
//
// 
//Input: deliciousness = [1,1,1,3,3,3,7]
//Output: 15
//Explanation: The good meals are (1,1) with 3 ways, (1,3) with 9 ways, and (1,7
//) with 3 ways. 
//
// 
// Constraints: 
//
// 
// 1 <= deliciousness.length <= 10⁵ 
// 0 <= deliciousness[i] <= 2²⁰ 
// 
// Related Topics 数组 哈希表 👍 129 👎 0


package io.hjforever.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class Q1711CountGoodMeals {
    public static void main(String[] args) {
        Solution solution = new Q1711CountGoodMeals().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countPairs(int[] deliciousness) {
            // map count
            int MOD = (int) (1e9 + 7);
            int n = deliciousness.length;
            Map<Integer, Integer> cnt = new HashMap<>();
            int max = (int) Math.pow(2, 21);
            int res = 0;
            for (int i = 0; i < n; i++) {
                int num = deliciousness[i];
                for (int j = 1; j <= max; j <<= 1) {
                    int count = cnt.getOrDefault(j - num, 0);
                    res = (res + count) % MOD;
                }
                cnt.put(num, cnt.getOrDefault(num, 0) + 1);
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
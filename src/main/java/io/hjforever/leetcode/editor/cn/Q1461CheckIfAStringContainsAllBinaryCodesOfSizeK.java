//Given a binary string s and an integer k, return true if every binary code of
//length k is a substring of s. Otherwise, return false. 
//
// 
// Example 1: 
//
// 
//Input: s = "00110110", k = 2
//Output: true
//Explanation: The binary codes of length 2 are "00", "01", "10" and "11". They 
//can be all found as substrings at indices 0, 1, 3 and 2 respectively.
// 
//
// Example 2: 
//
// 
//Input: s = "0110", k = 1
//Output: true
//Explanation: The binary codes of length 1 are "0" and "1", it is clear that 
//both exist as a substring. 
// 
//
// Example 3: 
//
// 
//Input: s = "0110", k = 2
//Output: false
//Explanation: The binary code "00" is of length 2 and does not exist in the 
//array.
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 5 * 10⁵ 
// s[i] is either '0' or '1'. 
// 1 <= k <= 20 
// 
// Related Topics 位运算 哈希表 字符串 哈希函数 滚动哈希 👍 44 👎 0


package io.hjforever.leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

public class Q1461CheckIfAStringContainsAllBinaryCodesOfSizeK {
    public static void main(String[] args) {
        Solution solution = new Q1461CheckIfAStringContainsAllBinaryCodesOfSizeK().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean hasAllCodes(String s, int k) {
            if (s.length() < (1 << k) + k - 1) {
                return false;
            }
            // f(k).length =  math.pow(2,k) ,判断子串的数量是否等于f(k).length
            //hash
            int n = s.length();
            Set<String> set = new HashSet<>();
            for (int i = 0; i <= n - k; i++) {
                set.add(s.substring(i, i + k));
            }
            return set.size() == (1 << k);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
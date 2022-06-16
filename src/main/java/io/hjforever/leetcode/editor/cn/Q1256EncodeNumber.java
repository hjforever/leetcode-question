//Given a non-negative integer num, Return its encoding string.
//
// The encoding is done by converting the integer to a string using a secret 
//function that you should deduce from the following table: 
//
// 
//
// 
// Example 1: 
//
// 
//Input: num = 23
//Output: "1000"
// 
//
// Example 2: 
//
// 
//Input: num = 107
//Output: "101100"
// 
//
// 
// Constraints: 
//
// 
// 0 <= num <= 10^9 
// Related Topics 位运算 数学 字符串 👍 19 👎 0


package io.hjforever.leetcode.editor.cn;

public class Q1256EncodeNumber {
    public static void main(String[] args) {
        Solution solution = new Q1256EncodeNumber().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String encode(int num) {
            //bitset
            //找规律
            return Integer.toBinaryString(num + 1).substring(1);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
//We build a table of n rows (1-indexed). We start by writing 0 in the 1ˢᵗ row.
//Now in every subsequent row, we look at the previous row and replace each 
//occurrence of 0 with 01, and each occurrence of 1 with 10. 
//
// 
// For example, for n = 3, the 1ˢᵗ row is 0, the 2ⁿᵈ row is 01, and the 3ʳᵈ row 
//is 0110. 
// 
//
// Given two integer n and k, return the kᵗʰ (1-indexed) symbol in the nᵗʰ row 
//of a table of n rows. 
//
// 
// Example 1: 
//
// 
//Input: n = 1, k = 1
//Output: 0
//Explanation: row 1: 0
// 
//
// Example 2: 
//
// 
//Input: n = 2, k = 1
//Output: 0
//Explanation: 
//row 1: 0
//row 2: 01
// 
//
// Example 3: 
//
// 
//Input: n = 2, k = 2
//Output: 1
//Explanation: 
//row 1: 0
//row 2: 01
// 
//
// 
// Constraints: 
//
// 
// 1 <= n <= 30 
// 1 <= k <= 2n - 1 
// 
// Related Topics 位运算 递归 数学 👍 155 👎 0


package io.hjforever.leetcode.editor.cn;

public class Q779KThSymbolInGrammar {
    public static void main(String[] args) {
        Solution solution = new Q779KThSymbolInGrammar().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int kthGrammar(int n, int k) {
            return Integer.bitCount(k - 1) % 2;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
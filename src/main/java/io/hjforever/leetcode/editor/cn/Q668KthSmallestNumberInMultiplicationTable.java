//Nearly everyone has used the Multiplication Table. The multiplication table
//of size m x n is an integer matrix mat where mat[i][j] == i * j (1-indexed). 
//
// Given three integers m, n, and k, return the kᵗʰ smallest element in the m x 
//n multiplication table. 
//
// 
// Example 1: 
//
// 
//Input: m = 3, n = 3, k = 5
//Output: 3
//Explanation: The 5ᵗʰ smallest number is 3.
// 
//
// Example 2: 
//
// 
//Input: m = 2, n = 3, k = 6
//Output: 6
//Explanation: The 6ᵗʰ smallest number is 6.
// 
//
// 
// Constraints: 
//
// 
// 1 <= m, n <= 3 * 10⁴ 
// 1 <= k <= m * n 
// 
// Related Topics 二分查找 👍 204 👎 0


package io.hjforever.leetcode.editor.cn;

public class Q668KthSmallestNumberInMultiplicationTable {
    public static void main(String[] args) {
        Solution solution = new Q668KthSmallestNumberInMultiplicationTable().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findKthNumber(int m, int n, int k) {
            // binnary search
            int left = 1;
            int right = m * n;

            //寻找是哪个数字符合条件的最左边界
            while (left < right) {
                int mid = (right - left) / 2 + left;
                if (check(m, n, mid, k)) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            return left;
        }

        boolean check(int m, int n, int target, int k) {
            int ans = 0;
            int r = m;
            for (int i = 1; i <= n; i++) {
                while (r >= 1 && i * r > target) {
                    r--;
                }
                ans += r;
            }
            return ans >= k;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
//Given an array of integers arr.
//
// We want to select three indices i, j and k where (0 <= i < j <= k < arr.
//length). 
//
// Let's define a and b as follows: 
//
// 
// a = arr[i] ^ arr[i + 1] ^ ... ^ arr[j - 1] 
// b = arr[j] ^ arr[j + 1] ^ ... ^ arr[k] 
// 
//
// Note that ^ denotes the bitwise-xor operation. 
//
// Return the number of triplets (i, j and k) Where a == b. 
//
// 
// Example 1: 
//
// 
//Input: arr = [2,3,1,6,7]
//Output: 4
//Explanation: The triplets are (0,1,2), (0,2,2), (2,3,4) and (2,4,4)
// 
//
// Example 2: 
//
// 
//Input: arr = [1,1,1,1,1]
//Output: 10
// 
//
// 
// Constraints: 
//
// 
// 1 <= arr.length <= 300 
// 1 <= arr[i] <= 10⁸ 
// 
// Related Topics 位运算 数组 哈希表 数学 前缀和 👍 206 👎 0


package io.hjforever.leetcode.editor.cn;

public class Q1442CountTripletsThatCanFormTwoArraysOfEqualXOR {
    public static void main(String[] args) {
        Solution solution = new Q1442CountTripletsThatCanFormTwoArraysOfEqualXOR().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countTriplets(int[] arr) {
            //xor prefix sum
            // xor[i,j] = xorSum[0,i-1] ^ xorSum[0,j]
            int n = arr.length;
            int[] xorSum = new int[n + 1];
            for (int i = 0; i < n; i++) {
                xorSum[i + 1] = xorSum[i] ^ arr[i];
            }
            //枚举两个端点
            int ans = 0;
            for (int i = 1; i <= n; i++) {
                for (int j = i + 1; j <= n; j++) {
                    for (int k = j; k <= n; k++) {
                        int a = xorSum[j - 1] ^ xorSum[i - 1];
                        int b = xorSum[k] ^ xorSum[j - 1];
                        ans += (a == b ? 1 : 0);
                    }
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
//There is a bookstore owner that has a store open for n minutes. Every minute,
//some number of customers enter the store. You are given an integer array 
//customers of length n where customers[i] is the number of the customer that enters the 
//store at the start of the iᵗʰ minute and all those customers leave after the 
//end of that minute. 
//
// On some minutes, the bookstore owner is grumpy. You are given a binary array 
//grumpy where grumpy[i] is 1 if the bookstore owner is grumpy during the iᵗʰ 
//minute, and is 0 otherwise. 
//
// When the bookstore owner is grumpy, the customers of that minute are not 
//satisfied, otherwise, they are satisfied. 
//
// The bookstore owner knows a secret technique to keep themselves not grumpy 
//for minutes consecutive minutes, but can only use it once. 
//
// Return the maximum number of customers that can be satisfied throughout the 
//day. 
//
// 
// Example 1: 
//
// 
//Input: customers = [1,0,1,2,1,1,7,5], grumpy = [0,1,0,1,0,1,0,1], minutes = 3
//Output: 16
//Explanation: The bookstore owner keeps themselves not grumpy for the last 3 
//minutes. 
//The maximum number of customers that can be satisfied = 1 + 1 + 1 + 1 + 7 + 5 
//= 16.
// 
//
// Example 2: 
//
// 
//Input: customers = [1], grumpy = [0], minutes = 1
//Output: 1
// 
//
// 
// Constraints: 
//
// 
// n == customers.length == grumpy.length 
// 1 <= minutes <= n <= 2 * 10⁴ 
// 0 <= customers[i] <= 1000 
// grumpy[i] is either 0 or 1. 
// 
// Related Topics 数组 滑动窗口 👍 227 👎 0


package io.hjforever.leetcode.editor.cn;

public class Q1052GrumpyBookstoreOwner {
    public static void main(String[] args) {
        Solution solution = new Q1052GrumpyBookstoreOwner().new Solution();
        long st = System.nanoTime();
        solution.maxSatisfied(new int[]{1, 0, 1, 2, 1, 1, 7, 5}, new int[]{0, 1, 0, 1, 0, 1, 0, 1}, 8);
        System.out.println(System.nanoTime() - st);

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
            int ans = 0;
            int n = customers.length;
            //两个前缀和搞定
            int[] csum = new int[n + 1];
            int[] stsum = new int[n + 1];
            for (int i = 0; i < n; i++) {
                csum[i + 1] = customers[i] + csum[i];
                stsum[i + 1] = stsum[i] + (grumpy[i] == 1 ? 0 : 1) * customers[i];
            }
            if (minutes >= n) return csum[n];
            if (minutes == 0) return stsum[n];
            for (int i = 0; i + minutes - 1 < n; i++) {
                int idx = Math.min(i + minutes, n);
                int left = csum[idx] - csum[i];
                int right = stsum[n] - stsum[idx] + stsum[i - 1 >= 0 ? i : 0];
                ans = Math.max(ans, left + right);
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
//The bitwise AND of an array nums is the bitwise AND of all integers in nums.
//
// 
// For example, for nums = [1, 5, 3], the bitwise AND is equal to 1 & 5 & 3 = 1.
// 
// Also, for nums = [7], the bitwise AND is 7. 
// 
//
// You are given an array of positive integers candidates. Evaluate the bitwise 
//AND of every combination of numbers of candidates. Each number in candidates 
//may only be used once in each combination. 
//
// Return the size of the largest combination of candidates with a bitwise AND 
//greater than 0. 
//
// 
// Example 1: 
//
// 
//Input: candidates = [16,17,71,62,12,24,14]
//Output: 4
//Explanation: The combination [16,17,62,24] has a bitwise AND of 16 & 17 & 62 &
// 24 = 16 > 0.
//The size of the combination is 4.
//It can be shown that no combination with a size greater than 4 has a bitwise 
//AND greater than 0.
//Note that more than one combination may have the largest size.
//For example, the combination [62,12,24,14] has a bitwise AND of 62 & 12 & 24 &
// 14 = 8 > 0.
// 
//
// Example 2: 
//
// 
//Input: candidates = [8,8]
//Output: 2
//Explanation: The largest combination [8,8] has a bitwise AND of 8 & 8 = 8 > 0.
//
//The size of the combination is 2, so we return 2.
// 
//
// 
// Constraints: 
//
// 
// 1 <= candidates.length <= 10⁵ 
// 1 <= candidates[i] <= 10⁷ 
// 
// Related Topics 位运算 数组 哈希表 计数 👍 27 👎 0


package io.hjforever.leetcode.editor.cn;

public class Q2275LargestCombinationWithBitwiseANDGreaterThanZero {
    public static void main(String[] args) {
        Solution solution = new Q2275LargestCombinationWithBitwiseANDGreaterThanZero().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int largestCombination(int[] candidates) {
            //bitset ，最终结果时确定的，则可遍历各个bit位，看最多的组合落在哪一位上
            int ans = 0;
            for (int i = 0; i <= 30; i++) {
                int cnt = 0;
                for (int num : candidates) {
                    if (((num >> i) & 1) == 1) {
                        cnt++;
                    }
                }
                ans = Math.max(ans, cnt);
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
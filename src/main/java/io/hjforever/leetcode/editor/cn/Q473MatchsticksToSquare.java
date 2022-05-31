//You are given an integer array matchsticks where matchsticks[i] is the length
//of the iᵗʰ matchstick. You want to use all the matchsticks to make one square. 
//You should not break any stick, but you can link them up, and each matchstick 
//must be used exactly one time. 
//
// Return true if you can make this square and false otherwise. 
//
// 
// Example 1: 
//
// 
//Input: matchsticks = [1,1,2,2,2]
//Output: true
//Explanation: You can form a square with length 2, one side of the square came 
//two sticks with length 1.
// 
//
// Example 2: 
//
// 
//Input: matchsticks = [3,3,3,3,4]
//Output: false
//Explanation: You cannot find a way to form a square with all the matchsticks.
// 
//
// 
// Constraints: 
//
// 
// 1 <= matchsticks.length <= 15 
// 1 <= matchsticks[i] <= 10⁸ 
// 
// Related Topics 位运算 数组 动态规划 回溯 状态压缩 👍 279 👎 0


package io.hjforever.leetcode.editor.cn;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.function.ToIntFunction;

public class Q473MatchsticksToSquare {
    public static void main(String[] args) {
        Solution solution = new Q473MatchsticksToSquare().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        //back trace

        public boolean makesquare(int[] matchsticks) {
            int n = matchsticks.length;
            long sum = 0;
            for (int i = 0; i < n; i++) {
                sum += matchsticks[i];
            }
            if (sum % 4 != 0) return false;
            long avg = sum / 4;
            int[] m = Arrays.stream(matchsticks).boxed().sorted(Comparator.reverseOrder()).mapToInt(value -> value).toArray();
            long[] sq = new long[4];
            return dfs(m, 0, avg, sq);
        }


        boolean dfs(int[] m, int k, long target, long[] sq) {
            if (k == m.length) {
                return true;
            }
            for (int i = 0; i < sq.length; i++) {
                sq[i] += m[k];
                if (sq[i] <= target && dfs(m, k + 1, target, sq)) {
                    return true;
                }
                sq[i] -= m[k];
            }
            return false;
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}
//The chess knight has a unique movement, it may move two squares vertically
//and one square horizontally, or two squares horizontally and one square vertically 
//(with both forming the shape of an L). The possible movements of chess knight 
//are shown in this diagaram: 
//
// A chess knight can move as indicated in the chess diagram below: 
//
// We have a chess knight and a phone pad as shown below, the knight can only 
//stand on a numeric cell (i.e. blue cell). 
//
// Given an integer n, return how many distinct phone numbers of length n we 
//can dial. 
//
// You are allowed to place the knight on any numeric cell initially and then 
//you should perform n - 1 jumps to dial a number of length n. All jumps should be 
//valid knight jumps. 
//
// As the answer may be very large, return the answer modulo 10⁹ + 7. 
//
// 
// Example 1: 
//
// 
//Input: n = 1
//Output: 10
//Explanation: We need to dial a number of length 1, so placing the knight over 
//any numeric cell of the 10 cells is sufficient.
// 
//
// Example 2: 
//
// 
//Input: n = 2
//Output: 20
//Explanation: All the valid number we can dial are [04, 06, 16, 18, 27, 29, 34,
// 38, 40, 43, 49, 60, 61, 67, 72, 76, 81, 83, 92, 94]
// 
//
// Example 3: 
//
// 
//Input: n = 3131
//Output: 136006598
//Explanation: Please take care of the mod.
// 
//
// 
// Constraints: 
//
// 
// 1 <= n <= 5000 
// 
// Related Topics 动态规划 👍 118 👎 0


package io.hjforever.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class Q935KnightDialer {
    public static void main(String[] args) {
        Solution solution = new Q935KnightDialer().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int MOD = (int) (1e9 + 7);
        Map<String, Integer> backup = new HashMap<>();
        int[][] map = new int[][]{{4, 6}, {6, 8}, {7, 9}, {4, 8}, {3, 9, 0}, {}, {0, 1, 7}, {2, 6}, {1, 3}, {2, 4}};

        public int knightDialer(int n) {
            //1.记忆化递归
            //2.dp
            int[][] dp = new int[n][10];
            for (int num = 0; num < 10; num++)
                dp[0][num] = 1; //第0次（跳到）num的不同号码个数为1

            for (int time = 1; time < n; time++) {
                for (int num = 0; num < 10; num++) {
                    for (int arrive : map[num])
                        dp[time][num] = (dp[time][num] + dp[time - 1][arrive]) % MOD;
                }
            }
            int res = 0;
            for (int num = 0; num < 10; num++)
                res = (res + dp[n - 1][num]) % MOD;
            return res;
        }

        //记忆化递归
        int dfs(int n) {
            if (n == 1) return 10;
            if (n == 2) return 20;
            int ans = 0;
            for (int i = 0; i < 10; i++) {
                if (i != 5) {
                    ans = (ans + f(n - 1, i)) % MOD;
                }
            }
            return ans;
        }

        int f(int n, int k) {
            int ans = 0;
            if (n == 0) return 1;
            String key = n + ":" + k;
            if (backup.containsKey(key)) return backup.get(key);
            int[] arr = map[k];
            for (int i = 0; i < arr.length; i++) {
                ans = (ans + f(n - 1, arr[i])) % MOD;
            }
            backup.put(key, ans);
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
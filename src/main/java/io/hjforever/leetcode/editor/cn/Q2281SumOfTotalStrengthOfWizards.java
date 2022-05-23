//As the ruler of a kingdom, you have an army of wizards at your command.
//
// You are given a 0-indexed integer array strength, where strength[i] denotes 
//the strength of the iᵗʰ wizard. For a contiguous group of wizards (i.e. the 
//wizards' strengths form a subarray of strength), the total strength is defined as 
//the product of the following two values: 
//
// 
// The strength of the weakest wizard in the group. 
// The total of all the individual strengths of the wizards in the group. 
// 
//
// Return the sum of the total strengths of all contiguous groups of wizards. 
//Since the answer may be very large, return it modulo 10⁹ + 7. 
//
// A subarray is a contiguous non-empty sequence of elements within an array. 
//
// 
// Example 1: 
//
// 
//Input: strength = [1,3,1,2]
//Output: 44
//Explanation: The following are all the contiguous groups of wizards:
//- [1] from [1,3,1,2] has a total strength of min([1]) * sum([1]) = 1 * 1 = 1
//- [3] from [1,3,1,2] has a total strength of min([3]) * sum([3]) = 3 * 3 = 9
//- [1] from [1,3,1,2] has a total strength of min([1]) * sum([1]) = 1 * 1 = 1
//- [2] from [1,3,1,2] has a total strength of min([2]) * sum([2]) = 2 * 2 = 4
//- [1,3] from [1,3,1,2] has a total strength of min([1,3]) * sum([1,3]) = 1 * 4
// = 4
//- [3,1] from [1,3,1,2] has a total strength of min([3,1]) * sum([3,1]) = 1 * 4
// = 4
//- [1,2] from [1,3,1,2] has a total strength of min([1,2]) * sum([1,2]) = 1 * 3
// = 3
//- [1,3,1] from [1,3,1,2] has a total strength of min([1,3,1]) * sum([1,3,1]) =
// 1 * 5 = 5
//- [3,1,2] from [1,3,1,2] has a total strength of min([3,1,2]) * sum([3,1,2]) =
// 1 * 6 = 6
//- [1,3,1,2] from [1,3,1,2] has a total strength of min([1,3,1,2]) * sum([1,3,1
//,2]) = 1 * 7 = 7
//The sum of all the total strengths is 1 + 9 + 1 + 4 + 4 + 4 + 3 + 5 + 6 + 7 = 
//44.
// 
//
// Example 2: 
//
// 
//Input: strength = [5,4,6]
//Output: 213
//Explanation: The following are all the contiguous groups of wizards: 
//- [5] from [5,4,6] has a total strength of min([5]) * sum([5]) = 5 * 5 = 25
//- [4] from [5,4,6] has a total strength of min([4]) * sum([4]) = 4 * 4 = 16
//- [6] from [5,4,6] has a total strength of min([6]) * sum([6]) = 6 * 6 = 36
//- [5,4] from [5,4,6] has a total strength of min([5,4]) * sum([5,4]) = 4 * 9 =
// 36
//- [4,6] from [5,4,6] has a total strength of min([4,6]) * sum([4,6]) = 4 * 10 
//= 40
//- [5,4,6] from [5,4,6] has a total strength of min([5,4,6]) * sum([5,4,6]) = 4
// * 15 = 60
//The sum of all the total strengths is 25 + 16 + 36 + 36 + 40 + 60 = 213.
// 
//
// 
// Constraints: 
//
// 
// 1 <= strength.length <= 10⁵ 
// 1 <= strength[i] <= 10⁹ 
// 
// 👍 35 👎 0


package io.hjforever.leetcode.editor.cn;

import java.util.Arrays;
import java.util.Stack;

public class Q2281SumOfTotalStrengthOfWizards {
    public static void main(String[] args) {
        Solution solution = new Q2281SumOfTotalStrengthOfWizards().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int totalStrength(int[] strength) {
            // prefix sum,
            int MOD = (int) (1e9 + 7);
            int n = strength.length;

            long ans = 0;

            //求前缀和
            int[] sum = new int[n + 1];
            int[] allSum = new int[n + 2];
            for (int i = 0; i < n; i++) {
                sum[i + 1] = (sum[i] + strength[i]) % MOD;
                allSum[i + 2] = (allSum[i + 1] + sum[i + 1]) % MOD;
            }
            //s(l,k) + s(k,r)

            //求左右单调栈
            int[] left = new int[n];
            int[] right = new int[n];
            Arrays.fill(right, n);
            Stack<Integer> stack = new Stack<>();
            for (int i = 0; i < n; i++) {
                int num = strength[i];
                //寻找右边第一个小于当前值的下标
                while (!stack.isEmpty() && strength[stack.peek()] > num) {
                    right[stack.pop()] = i;
                }
                left[i] = stack.isEmpty() ? -1 : stack.peek();
                stack.push(i);
            }


            for (int i = 0; i < n; i++) {
                int ll = left[i] + 1;
                int rr = right[i] - 1;
                long cTimes = (long) (i - ll + 1) * (allSum[rr + 2] - allSum[i + 1]) - (long) (rr - i + 1) * (allSum[i + 1] - allSum[ll]);
                cTimes %= MOD;
                ans += cTimes * strength[i];
                ans = ans % MOD;
            }
            return (int) (ans + MOD) % MOD;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
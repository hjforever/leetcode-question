//A company is planning to interview 2n people. Given the array costs where
//costs[i] = [aCosti, bCosti], the cost of flying the iᵗʰ person to city a is aCosti, 
//and the cost of flying the iᵗʰ person to city b is bCosti. 
//
// Return the minimum cost to fly every person to a city such that exactly n 
//people arrive in each city. 
//
// 
// Example 1: 
//
// 
//Input: costs = [[10,20],[30,200],[400,50],[30,20]]
//Output: 110
//Explanation: 
//The first person goes to city A for a cost of 10.
//The second person goes to city A for a cost of 30.
//The third person goes to city B for a cost of 50.
//The fourth person goes to city B for a cost of 20.
//
//The total minimum cost is 10 + 30 + 50 + 20 = 110 to have half the people 
//interviewing in each city.
// 
//
// Example 2: 
//
// 
//Input: costs = [[259,770],[448,54],[926,667],[184,139],[840,118],[577,469]]
//Output: 1859
// 
//
// Example 3: 
//
// 
//Input: costs = [[515,563],[451,713],[537,709],[343,819],[855,779],[457,60],[65
//0,359],[631,42]]
//Output: 3086
// 
//
// 
// Constraints: 
//
// 
// 2 * n == costs.length 
// 2 <= costs.length <= 100 
// costs.length is even. 
// 1 <= aCosti, bCosti <= 1000 
// 
// Related Topics 贪心 数组 排序 👍 252 👎 0


package io.hjforever.leetcode.editor.cn;

import java.util.Arrays;

public class Q1029TwoCityScheduling {
    public static void main(String[] args) {
        Solution solution = new Q1029TwoCityScheduling().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int twoCitySchedCost(int[][] costs) {
            //greedy
            //先假设都去B，在通过差值将一半的改成去A
            int n = costs.length;
            Arrays.sort(costs, (o1, o2) -> o1[0] - o1[1] - (o2[0] - o2[1]));
            int ans = 0;
            for (int i = 0; i < n; i++) {
                if (i < n / 2) {
                    //前面为A
                    ans += costs[i][0];
                } else {
                    //后面为B
                    ans += costs[i][1];
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
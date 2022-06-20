//You are given an array people where people[i] is the weight of the iᵗʰ person,
// and an infinite number of boats where each boat can carry a maximum weight of 
//limit. Each boat carries at most two people at the same time, provided the sum 
//of the weight of those people is at most limit. 
//
// Return the minimum number of boats to carry every given person. 
//
// 
// Example 1: 
//
// 
//Input: people = [1,2], limit = 3
//Output: 1
//Explanation: 1 boat (1, 2)
// 
//
// Example 2: 
//
// 
//Input: people = [3,2,2,1], limit = 3
//Output: 3
//Explanation: 3 boats (1, 2), (2) and (3)
// 
//
// Example 3: 
//
// 
//Input: people = [3,5,3,4], limit = 5
//Output: 4
//Explanation: 4 boats (3), (3), (4), (5)
// 
//
// 
// Constraints: 
//
// 
// 1 <= people.length <= 5 * 10⁴ 
// 1 <= people[i] <= limit <= 3 * 10⁴ 
// 
// Related Topics 贪心 数组 双指针 排序 👍 237 👎 0


package io.hjforever.leetcode.editor.cn;

import java.util.Arrays;

public class Q881BoatsToSavePeople {
    public static void main(String[] args) {
        Solution solution = new Q881BoatsToSavePeople().new Solution();
        solution.numRescueBoats(new int[]{3, 2, 2, 1}, 3);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numRescueBoats(int[] people, int limit) {
            //two pointers
            Arrays.sort(people);
            int n = people.length;
            int i = 0;
            int j = n - 1;
            int ans = 0;
            while (i <= j) {
                if (people[j] + people[i] <= limit) {
                    i++;
                    j--;
                    ans++;
                } else {
                    j--;
                    ans++;
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
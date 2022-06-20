//Alice has some number of cards and she wants to rearrange the cards into
//groups so that each group is of size groupSize, and consists of groupSize 
//consecutive cards. 
//
// Given an integer array hand where hand[i] is the value written on the iᵗʰ 
//card and an integer groupSize, return true if she can rearrange the cards, or 
//false otherwise. 
//
// 
// Example 1: 
//
// 
//Input: hand = [1,2,3,6,2,3,4,7,8], groupSize = 3
//Output: true
//Explanation: Alice's hand can be rearranged as [1,2,3],[2,3,4],[6,7,8]
// 
//
// Example 2: 
//
// 
//Input: hand = [1,2,3,4,5], groupSize = 4
//Output: false
//Explanation: Alice's hand can not be rearranged into groups of 4.
//
// 
//
// 
// Constraints: 
//
// 
// 1 <= hand.length <= 10⁴ 
// 0 <= hand[i] <= 10⁹ 
// 1 <= groupSize <= hand.length 
// 
//
// 
// Note: This question is the same as 1296: https://leetcode.com/problems/
//divide-array-in-sets-of-k-consecutive-numbers/ 
// Related Topics 贪心 数组 哈希表 排序 👍 208 👎 0


package io.hjforever.leetcode.editor.cn;

import java.util.*;

public class Q846HandOfStraights {
    public static void main(String[] args) {
        Solution solution = new Q846HandOfStraights().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isNStraightHand(int[] hand, int groupSize) {
            // sort,  greedy
            int n = hand.length;
            if (n % groupSize != 0) return false;
            Arrays.sort(hand);
            Map<Integer, Integer> cnt = new HashMap<>();
            for (int x : hand) {
                cnt.put(x, cnt.getOrDefault(x, 0) + 1);
            }
            for (int i = 0; i < n; i++) {
                int num = hand[i];
                if (!cnt.containsKey(num) || cnt.getOrDefault(num, 0) <= 0) {
                    continue;
                }
                for (int j = 0; j < groupSize; j++) {
                    int data = num + j;
                    if (!cnt.containsKey(data) || cnt.getOrDefault(data, 0) <= 0) return false;
                    cnt.put(data, cnt.get(data) - 1);
                    if (cnt.get(data) == 0) cnt.remove(data);
                }

            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
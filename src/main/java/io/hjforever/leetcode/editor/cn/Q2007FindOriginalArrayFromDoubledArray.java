//An integer array original is transformed into a doubled array changed by
//appending twice the value of every element in original, and then randomly shuffling 
//the resulting array. 
//
// Given an array changed, return original if changed is a doubled array. If 
//changed is not a doubled array, return an empty array. The elements in original 
//may be returned in any order. 
//
// 
// Example 1: 
//
// 
//Input: changed = [1,3,4,2,6,8]
//Output: [1,3,4]
//Explanation: One possible original array could be [1,3,4]:
//- Twice the value of 1 is 1 * 2 = 2.
//- Twice the value of 3 is 3 * 2 = 6.
//- Twice the value of 4 is 4 * 2 = 8.
//Other original arrays could be [4,3,1] or [3,1,4].
// 
//
// Example 2: 
//
// 
//Input: changed = [6,3,0,1]
//Output: []
//Explanation: changed is not a doubled array.
// 
//
// Example 3: 
//
// 
//Input: changed = [1]
//Output: []
//Explanation: changed is not a doubled array.
// 
//
// 
// Constraints: 
//
// 
// 1 <= changed.length <= 10⁵ 
// 0 <= changed[i] <= 10⁵ 
// 
// Related Topics 贪心 数组 哈希表 排序 👍 21 👎 0


package io.hjforever.leetcode.editor.cn;

import java.util.*;

public class Q2007FindOriginalArrayFromDoubledArray {
    public static void main(String[] args) {
        Solution solution = new Q2007FindOriginalArrayFromDoubledArray().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] findOriginalArray(int[] changed) {
            // sort , greedy
            if (changed == null || (changed.length & 1) == 1) return new int[0];
            Arrays.sort(changed);
            int n = changed.length;
            Map<Integer, Integer> cnt = new HashMap<>();
            for (int i = 0; i < n; i++) {
                cnt.put(changed[i], cnt.getOrDefault(changed[i], 0) + 1);
            }
            int[] ans = new int[n / 2];
            int j = 0;
            for (int i = 0; i < n; i++) {
                int num = changed[i];
                if (cnt.getOrDefault(num, 0) < 1) continue;
                if (!cnt.containsKey(2 * num) || cnt.getOrDefault(2 * num, 0) < 1) {
                    return new int[0];
                } else {
                    ans[j++] = num;
                    cnt.put(num, cnt.getOrDefault(num, 0) - 1);
                    cnt.put(2 * num, cnt.getOrDefault(2 * num, 0) - 1);
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
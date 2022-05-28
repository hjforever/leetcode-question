//Given an array nums of distinct positive integers, return the number of
//tuples (a, b, c, d) such that a * b = c * d where a, b, c, and d are elements of nums,
// and a != b != c != d. 
//
// 
// Example 1: 
//
// 
//Input: nums = [2,3,4,6]
//Output: 8
//Explanation: There are 8 valid tuples:
//(2,6,3,4) , (2,6,4,3) , (6,2,3,4) , (6,2,4,3)
//(3,4,2,6) , (4,3,2,6) , (3,4,6,2) , (4,3,6,2)
// 
//
// Example 2: 
//
// 
//Input: nums = [1,2,4,5,10]
//Output: 16
//Explanation: There are 16 valid tuples:
//(1,10,2,5) , (1,10,5,2) , (10,1,2,5) , (10,1,5,2)
//(2,5,1,10) , (2,5,10,1) , (5,2,1,10) , (5,2,10,1)
//(2,10,4,5) , (2,10,5,4) , (10,2,4,5) , (10,2,5,4)
//(4,5,2,10) , (4,5,10,2) , (5,4,2,10) , (5,4,10,2)
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 1000 
// 1 <= nums[i] <= 10⁴ 
// All elements in nums are distinct. 
// 
// Related Topics 数组 哈希表 👍 20 👎 0


package io.hjforever.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class Q1726TupleWithSameProduct {
    public static void main(String[] args) {
        Solution solution = new Q1726TupleWithSameProduct().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int tupleSameProduct(int[] nums) {
            //map
            int n = nums.length;
            Map<Integer, Integer> cnt = new HashMap<>();
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    int num = nums[i] * nums[j];
                    cnt.put(num, cnt.getOrDefault(num, 0) + 1);
                }
            }
            int ans = 0;
            for (Integer key : cnt.keySet()) {
                int count = cnt.get(key);
                if (count > 1) {
                    ans += count * (count - 1) * 4;
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
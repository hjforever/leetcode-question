//You are given a 0-indexed integer array nums. The array nums is beautiful if:
//
//
// 
// nums.length is even. 
// nums[i] != nums[i + 1] for all i % 2 == 0. 
// 
//
// Note that an empty array is considered beautiful. 
//
// You can delete any number of elements from nums. When you delete an element, 
//all the elements to the right of the deleted element will be shifted one unit 
//to the left to fill the gap created and all the elements to the left of the 
//deleted element will remain unchanged. 
//
// Return the minimum number of elements to delete from nums to make it 
//beautiful. 
//
// 
// Example 1: 
//
// 
//Input: nums = [1,1,2,3,5]
//Output: 1
//Explanation: You can delete either nums[0] or nums[1] to make nums = [1,2,3,5]
// which is beautiful. It can be proven you need at least 1 deletion to make nums 
//beautiful.
// 
//
// Example 2: 
//
// 
//Input: nums = [1,1,2,2,3,3]
//Output: 2
//Explanation: You can delete nums[0] and nums[5] to make nums = [1,2,2,3] 
//which is beautiful. It can be proven you need at least 2 deletions to make nums 
//beautiful.
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 10⁵ 
// 0 <= nums[i] <= 10⁵ 
// 
// Related Topics 栈 贪心 数组 👍 21 👎 0


package io.hjforever.leetcode.editor.cn;

public class Q2216MinimumDeletionsToMakeArrayBeautiful {
    public static void main(String[] args) {
        Solution solution = new Q2216MinimumDeletionsToMakeArrayBeautiful().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minDeletion(int[] nums) {
            //greedy
            //不满足条件就删除，删除后后续，后续索引奇偶性需要变更
            int n = nums.length;
            int ans = 0;
            for (int i = 0; i < n; i++) {
                if ((i - ans) % 2 == 0 && i < n - 1 && nums[i] == nums[i + 1]) {
                    ans++;
                }
            }
            //判断是否是偶数个
            if ((n - ans) % 2 == 1) ans++;
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
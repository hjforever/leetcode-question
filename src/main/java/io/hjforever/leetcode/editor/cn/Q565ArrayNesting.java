//You are given an integer array nums of length n where nums is a permutation
//of the numbers in the range [0, n - 1]. 
//
// You should build a set s[k] = {nums[k], nums[nums[k]], nums[nums[nums[k]]], .
//.. } subjected to the following rule: 
//
// 
// The first element in s[k] starts with the selection of the element nums[k] 
//of index = k. 
// The next element in s[k] should be nums[nums[k]], and then nums[nums[nums[k]]
//], and so on. 
// We stop adding right before a duplicate element occurs in s[k]. 
// 
//
// Return the longest length of a set s[k]. 
//
// 
// Example 1: 
//
// 
//Input: nums = [5,4,0,3,1,6,2]
//Output: 4
//Explanation: 
//nums[0] = 5, nums[1] = 4, nums[2] = 0, nums[3] = 3, nums[4] = 1, nums[5] = 6, 
//nums[6] = 2.
//One of the longest sets s[k]:
//s[0] = {nums[0], nums[5], nums[6], nums[2]} = {5, 6, 2, 0}
// 
//
// Example 2: 
//
// 
//Input: nums = [0,1,2]
//Output: 1
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 10⁵ 
// 0 <= nums[i] < nums.length 
// All the values of nums are unique. 
// 
// Related Topics 深度优先搜索 数组 👍 205 👎 0


package io.hjforever.leetcode.editor.cn;

public class Q565ArrayNesting {
    public static void main(String[] args) {
        Solution solution = new Q565ArrayNesting().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int arrayNesting(int[] nums) {


            int ans = 1;
            boolean[] vist = new boolean[nums.length];

            for (int i = 0; i < nums.length; i++) {
                if(ans > nums.length/2)
                    return ans;
                //当元素被访问过，则表示此元素时其中一个环的节点，从这个元素开头的环长度必然不是最大值
                if (vist[nums[i]]) continue;
                vist[nums[i]] = true;
                int cur = nums[nums[i]];
                int count = 1;
                while (nums[i] != cur) {
                    vist[cur] = true;
                    count++;
                    cur = nums[cur];
                }
                ans = Math.max(ans, count);
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
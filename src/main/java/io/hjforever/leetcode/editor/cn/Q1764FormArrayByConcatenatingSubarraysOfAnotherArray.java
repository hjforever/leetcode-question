//You are given a 2D integer array groups of length n. You are also given an
//integer array nums. 
//
// You are asked if you can choose n disjoint subarrays from the array nums 
//such that the iᵗʰ subarray is equal to groups[i] (0-indexed), and if i > 0, the (i-1
//)ᵗʰ subarray appears before the iᵗʰ subarray in nums (i.e. the subarrays must 
//be in the same order as groups). 
//
// Return true if you can do this task, and false otherwise. 
//
// Note that the subarrays are disjoint if and only if there is no index k such 
//that nums[k] belongs to more than one subarray. A subarray is a contiguous 
//sequence of elements within an array. 
//
// 
// Example 1: 
//
// 
//Input: groups = [[1,-1,-1],[3,-2,0]], nums = [1,-1,0,1,-1,-1,3,-2,0]
//Output: true
//Explanation: You can choose the 0ᵗʰ subarray as [1,-1,0,1,-1,-1,3,-2,0] and 
//the 1ˢᵗ one as [1,-1,0,1,-1,-1,3,-2,0].
//These subarrays are disjoint as they share no common nums[k] element.
// 
//
// Example 2: 
//
// 
//Input: groups = [[10,-2],[1,2,3,4]], nums = [1,2,3,4,10,-2]
//Output: false
//Explanation: Note that choosing the subarrays [1,2,3,4,10,-2] and [1,2,3,4,10,
//-2] is incorrect because they are not in the same order as in groups.
//[10,-2] must come before [1,2,3,4].
// 
//
// Example 3: 
//
// 
//Input: groups = [[1,2,3],[3,4]], nums = [7,7,1,2,3,4,7,7]
//Output: false
//Explanation: Note that choosing the subarrays [7,7,1,2,3,4,7,7] and [7,7,1,2,3
//,4,7,7] is invalid because they are not disjoint.
//They share a common elements nums[4] (0-indexed).
// 
//
// 
// Constraints: 
//
// 
// groups.length == n 
// 1 <= n <= 10³ 
// 1 <= groups[i].length, sum(groups[i].length) <= 103 
// 1 <= nums.length <= 10³ 
// -107 <= groups[i][j], nums[k] <= 107 
// 
// Related Topics 贪心 数组 字符串匹配 👍 10 👎 0


package io.hjforever.leetcode.editor.cn;

public class Q1764FormArrayByConcatenatingSubarraysOfAnotherArray {
    public static void main(String[] args) {
        Solution solution = new Q1764FormArrayByConcatenatingSubarraysOfAnotherArray().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //简直阅读理解题
        //双指针
        public boolean canChoose(int[][] gs, int[] nums) {
            int n = nums.length, m = gs.length;
            int cnt = 0;
            for (int i = 0, j = 0; i < n && j < m; ) {
                if (check(gs[j], nums, i)) {
                    i += gs[j++].length;
                    cnt++;
                } else {
                    i++;
                }
            }
            return cnt == m;
        }

        boolean check(int[] g, int[] nums, int i) {
            int j = 0;
            for (; j < g.length && i < nums.length; j++, i++) {
                if (g[j] != nums[i]) return false;
            }
            return j == g.length;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
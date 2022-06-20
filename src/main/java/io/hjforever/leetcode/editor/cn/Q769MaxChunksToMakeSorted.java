//You are given an integer array arr of length n that represents a permutation
//of the integers in the range [0, n - 1]. 
//
// We split arr into some number of chunks (i.e., partitions), and individually 
//sort each chunk. After concatenating them, the result should equal the sorted 
//array. 
//
// Return the largest number of chunks we can make to sort the array. 
//
// 
// Example 1: 
//
// 
//Input: arr = [4,3,2,1,0]
//Output: 1
//Explanation:
//Splitting into two or more chunks will not return the required result.
//For example, splitting into [4, 3], [2, 1, 0] will result in [3, 4, 0, 1, 2], 
//which isn't sorted.
// 
//
// Example 2: 
//
// 
//Input: arr = [1,0,2,3,4]
//Output: 4
//Explanation:
//We can split into two chunks, such as [1, 0], [2, 3, 4].
//However, splitting into [1, 0], [2], [3], [4] is the highest number of chunks 
//possible.
// 
//
// 
// Constraints: 
//
// 
// n == arr.length 
// 1 <= n <= 10 
// 0 <= arr[i] < n 
// All the elements of arr are unique. 
// 
// Related Topics 栈 贪心 数组 排序 单调栈 👍 196 👎 0


package io.hjforever.leetcode.editor.cn;

public class Q769MaxChunksToMakeSorted {
    public static void main(String[] args) {
        Solution solution = new Q769MaxChunksToMakeSorted().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxChunksToSorted(int[] arr) {
            //当遍历到第i个位置时，如果可以切分为块，那前i个位置的最大值一定等于i。
            //否则，一定有比i小的数划分到后面的块，那块排序后，一定不满足升序。
            int res = 0, max = 0;
            for (int i = 0; i < arr.length; i++) {
                max = Math.max(max, arr[i]);//统计前i个位置的最大元素
                if (max == i) res++;
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
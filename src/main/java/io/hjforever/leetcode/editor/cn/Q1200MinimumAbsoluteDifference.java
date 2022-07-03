//Given an array of distinct integers arr, find all pairs of elements with the
//minimum absolute difference of any two elements. 
//
// Return a list of pairs in ascending order(with respect to pairs), each pair [
//a, b] follows 
//
// 
// a, b are from arr 
// a < b 
// b - a equals to the minimum absolute difference of any two elements in arr 
// 
//
// 
// Example 1: 
//
// 
//Input: arr = [4,2,1,3]
//Output: [[1,2],[2,3],[3,4]]
//Explanation: The minimum absolute difference is 1. List all pairs with 
//difference equal to 1 in ascending order. 
//
// Example 2: 
//
// 
//Input: arr = [1,3,6,10,15]
//Output: [[1,3]]
// 
//
// Example 3: 
//
// 
//Input: arr = [3,8,-10,23,19,-4,-14,27]
//Output: [[-14,-10],[19,23],[23,27]]
// 
//
// 
// Constraints: 
//
// 
// 2 <= arr.length <= 10⁵ 
// -10⁶ <= arr[i] <= 10⁶ 
// 
// Related Topics 数组 排序 👍 68 👎 0


package io.hjforever.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q1200MinimumAbsoluteDifference {
    public static void main(String[] args) {
        Solution solution = new Q1200MinimumAbsoluteDifference().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> minimumAbsDifference(int[] arr) {
            //sort
            Arrays.sort(arr);
            List<List<Integer>> ans = new ArrayList<>();
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < arr.length - 1; i++) {
                int diff = Math.abs(arr[i] - arr[i + 1]);
                if (diff < min) {
                    ans.clear();
                    List<Integer> pair = new ArrayList<>();
                    pair.add(arr[i]);
                    pair.add(arr[i + 1]);
                    ans.add(pair);
                    min = diff;
                } else if (diff == min) {
                    List<Integer> pair = new ArrayList<>();
                    pair.add(arr[i]);
                    pair.add(arr[i + 1]);
                    ans.add(pair);
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
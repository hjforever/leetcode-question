//You are given an array of distinct integers arr and an array of integer
//arrays pieces, where the integers in pieces are distinct. Your goal is to form arr by 
//concatenating the arrays in pieces in any order. However, you are not allowed 
//to reorder the integers in each array pieces[i]. 
//
// Return true if it is possible to form the array arr from pieces. Otherwise, 
//return false. 
//
// 
// Example 1: 
//
// 
//Input: arr = [15,88], pieces = [[88],[15]]
//Output: true
//Explanation: Concatenate [15] then [88]
// 
//
// Example 2: 
//
// 
//Input: arr = [49,18,16], pieces = [[16,18,49]]
//Output: false
//Explanation: Even though the numbers match, we cannot reorder pieces[0].
// 
//
// Example 3: 
//
// 
//Input: arr = [91,4,64,78], pieces = [[78],[4,64],[91]]
//Output: true
//Explanation: Concatenate [91] then [4,64] then [78]
// 
//
// 
// Constraints: 
//
// 
// 1 <= pieces.length <= arr.length <= 100 
// sum(pieces[i].length) == arr.length 
// 1 <= pieces[i].length <= arr.length 
// 1 <= arr[i], pieces[i][j] <= 100 
// The integers in arr are distinct. 
// The integers in pieces are distinct (i.e., If we flatten pieces in a 1D 
//array, all the integers in this array are distinct). 
// 
// Related Topics 数组 哈希表 👍 41 👎 0


package io.hjforever.leetcode.editor.cn;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q1640CheckArrayFormationThroughConcatenation {
    public static void main(String[] args) {
        Solution solution = new Q1640CheckArrayFormationThroughConcatenation().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean canFormArray(int[] arr, int[][] pieces) {

            //two pionters
            int n = arr.length;
            int m = pieces.length;

            Map<Integer, int[]> map = new HashMap<>();
            for (int i = 0; i < m; i++) {
                map.put(pieces[i][0], pieces[i]);
            }
            int i = 0;
            while (i < n) {
                int num = arr[i];
                if (!map.containsKey(num)) {
                    return false;
                }
                int[] data = map.get(num);
                int j = 0;
                while (i < n && j < data.length) {
                    if (data[j++] != arr[i++]) {
                        return false;
                    }
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
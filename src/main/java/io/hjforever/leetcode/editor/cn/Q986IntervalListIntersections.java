//You are given two lists of closed intervals, firstList and secondList, where
//firstList[i] = [starti, endi] and secondList[j] = [startj, endj]. Each list of 
//intervals is pairwise disjoint and in sorted order. 
//
// Return the intersection of these two interval lists. 
//
// A closed interval [a, b] (with a <= b) denotes the set of real numbers x 
//with a <= x <= b. 
//
// The intersection of two closed intervals is a set of real numbers that are 
//either empty or represented as a closed interval. For example, the intersection 
//of [1, 3] and [2, 4] is [2, 3]. 
//
// 
// Example 1: 
//
// 
//Input: firstList = [[0,2],[5,10],[13,23],[24,25]], secondList = [[1,5],[8,12],
//[15,24],[25,26]]
//Output: [[1,2],[5,5],[8,10],[15,23],[24,24],[25,25]]
// 
//
// Example 2: 
//
// 
//Input: firstList = [[1,3],[5,9]], secondList = []
//Output: []
// 
//
// 
// Constraints: 
//
// 
// 0 <= firstList.length, secondList.length <= 1000 
// firstList.length + secondList.length >= 1 
// 0 <= starti < endi <= 10⁹ 
// endi < starti+1 
// 0 <= startj < endj <= 10⁹ 
// endj < startj+1 
// 
// Related Topics 数组 双指针 👍 297 👎 0


package io.hjforever.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class Q986IntervalListIntersections {
    public static void main(String[] args) {
        Solution solution = new Q986IntervalListIntersections().new Solution();
        solution.intervalIntersection(new int[][]{{0, 2}, {5, 10}, {13, 23}, {24, 25}}, new int[][]{{1, 5}, {8, 12}, {15, 24}, {25, 26}});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] intervalIntersection(int[][] f, int[][] s) {
//          Arrays.sort(firstList, ((o1, o2) -> o1[0] - o2[0]));
//          Arrays.sort(secondList, ((o1, o2) -> o1[0] - o2[0]));
            List<int[]> ans = new ArrayList();
            int i = 0, j = 0;
            while (i < f.length && j < s.length) {
                // lo - the startpoint of the intersection
                // hi - the endpoint of the intersection
                int lo = Math.max(f[i][0], s[j][0]);
                int hi = Math.min(f[i][1], s[j][1]);
                if (lo <= hi) ans.add(new int[]{lo, hi});
                if (f[i][1] < s[j][1]) {
                    i++;
                } else {
                    j++;
                }
            }
            return ans.toArray(new int[ans.size()][]);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
//You are given an array of intervals, where intervals[i] = [starti, endi] and
//each starti is unique. 
//
// The right interval for an interval i is an interval j such that startj >= 
//endi and startj is minimized. Note that i may equal j. 
//
// Return an array of right interval indices for each interval i. If no right 
//interval exists for interval i, then put -1 at index i. 
//
// 
// Example 1: 
//
// 
//Input: intervals = [[1,2]]
//Output: [-1]
//Explanation: There is only one interval in the collection, so it outputs -1.
// 
//
// Example 2: 
//
// 
//Input: intervals = [[3,4],[2,3],[1,2]]
//Output: [-1,0,1]
//Explanation: There is no right interval for [3,4].
//The right interval for [2,3] is [3,4] since start0 = 3 is the smallest start 
//that is >= end1 = 3.
//The right interval for [1,2] is [2,3] since start1 = 2 is the smallest start 
//that is >= end2 = 2.
// 
//
// Example 3: 
//
// 
//Input: intervals = [[1,4],[2,3],[3,4]]
//Output: [-1,2,-1]
//Explanation: There is no right interval for [1,4] and [3,4].
//The right interval for [2,3] is [3,4] since start2 = 3 is the smallest start 
//that is >= end1 = 3.
// 
//
// 
// Constraints: 
//
// 
// 1 <= intervals.length <= 2 * 10⁴ 
// intervals[i].length == 2 
// -10⁶ <= starti <= endi <= 10⁶ 
// The start point of each interval is unique. 
// 
// Related Topics 数组 二分查找 排序 👍 112 👎 0


package io.hjforever.leetcode.editor.cn;

import java.util.TreeMap;

public class Q436FindRightInterval {
    public static void main(String[] args) {
        Solution solution = new Q436FindRightInterval().new Solution();
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        treeMap.put(1, 2);
        treeMap.put(2, 2);
        treeMap.put(4, 2);
        treeMap.put(6, 2);
        System.out.println(treeMap.higherKey(4));
        System.out.println(treeMap.lowerKey(4));
        System.out.println(treeMap.ceilingKey(4));
        System.out.println(treeMap.floorKey(4));
        System.out.println(treeMap.ceilingKey(5));
        System.out.println(treeMap.floorKey(5));
        solution.findRightInterval(new int[][]{{1, 4}, {2, 3}, {3, 4}});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] findRightInterval(int[][] intervals) {
            //寻找右边界，即 start(i) > end(j) 的最小start值的下标
            //sort + treeMap
            int n = intervals.length;
            int[] ans = new int[n];
            TreeMap<Integer, Integer> treeMap = new TreeMap<>();
            for (int i = 0; i < n; i++) {
                treeMap.put(intervals[i][0], i);
            }
            for (int i = 0; i < n; i++) {
                int end = intervals[i][1];
                //找到大于end的最小值start
                Integer higher = treeMap.ceilingKey(end);
                if (higher == null) {
                    ans[i] = -1;
                } else {
                    ans[i] = treeMap.get(higher);
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
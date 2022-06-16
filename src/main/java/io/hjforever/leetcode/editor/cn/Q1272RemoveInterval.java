//A set of real numbers can be represented as the union of several disjoint
//intervals, where each interval is in the form [a, b). A real number x is in the set 
//if one of its intervals [a, b) contains x (i.e. a <= x < b). 
//
// You are given a sorted list of disjoint intervals intervals representing a 
//set of real numbers as described above, where intervals[i] = [ai, bi] represents 
//the interval [ai, bi). You are also given another interval toBeRemoved. 
//
// Return the set of real numbers with the interval toBeRemoved removed from 
//intervals. In other words, return the set of real numbers such that every x in the 
//set is in intervals but not in toBeRemoved. Your answer should be a sorted list 
//of disjoint intervals as described above. 
//
// 
// Example 1: 
//
// 
//Input: intervals = [[0,2],[3,4],[5,7]], toBeRemoved = [1,6]
//Output: [[0,1],[6,7]]
// 
//
// Example 2: 
//
// 
//Input: intervals = [[0,5]], toBeRemoved = [2,3]
//Output: [[0,2],[3,5]]
// 
//
// Example 3: 
//
// 
//Input: intervals = [[-5,-4],[-3,-2],[1,2],[3,5],[8,9]], toBeRemoved = [-1,4]
//Output: [[-5,-4],[-3,-2],[4,5],[8,9]]
// 
//
// 
// Constraints: 
//
// 
// 1 <= intervals.length <= 10⁴ 
// -10⁹ <= ai < bi <= 10⁹ 
// 
// Related Topics 数组 👍 31 👎 0


package io.hjforever.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Q1272RemoveInterval {
    public static void main(String[] args) {
        Solution solution = new Q1272RemoveInterval().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> removeInterval(int[][] intervals, int[] toBeRemoved) {
            List<List<Integer>> ans = new ArrayList<>();

            for (int[] cur : intervals) {
                //没重合的情况
                if (cur[0] > toBeRemoved[1] || cur[1] < toBeRemoved[0]) {
                    List<Integer> interval = new ArrayList<>();
                    interval.add(cur[0], cur[1]);
                    ans.add(interval);
                    continue;
                }
                //重合(1,3),(2,4)的情况
                if (cur[0] < toBeRemoved[0]) {
                    List<Integer> interval = new ArrayList<>();
                    interval.add(cur[0], toBeRemoved[0]);
                    ans.add(interval);
                }
                //重合(5,7),(4,6)的情况
                if (cur[1] > toBeRemoved[1]) {
                    List<Integer> interval = new ArrayList<>();
                    interval.add(toBeRemoved[1], cur[1]);
                    ans.add(interval);
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
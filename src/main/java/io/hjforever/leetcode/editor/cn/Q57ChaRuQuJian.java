//给你一个 无重叠的 ，按照区间起始端点排序的区间列表。
//
// 在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。 
//
// 
//
// 示例 1： 
//
// 
//输入：intervals = [[1,3],[6,9]], newInterval = [2,5]
//输出：[[1,5],[6,9]]
// 
//
// 示例 2： 
//
// 
//输入：intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
//输出：[[1,2],[3,10],[12,16]]
//解释：这是因为新的区间 [4,8] 与 [3,5],[6,7],[8,10] 重叠。 
//
// 示例 3： 
//
// 
//输入：intervals = [], newInterval = [5,7]
//输出：[[5,7]]
// 
//
// 示例 4： 
//
// 
//输入：intervals = [[1,5]], newInterval = [2,3]
//输出：[[1,5]]
// 
//
// 示例 5： 
//
// 
//输入：intervals = [[1,5]], newInterval = [2,7]
//输出：[[1,7]]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= intervals.length <= 10⁴ 
// intervals[i].length == 2 
// 0 <= intervals[i][0] <= intervals[i][1] <= 10⁵ 
// intervals 根据 intervals[i][0] 按 升序 排列 
// newInterval.length == 2 
// 0 <= newInterval[0] <= newInterval[1] <= 10⁵ 
// 
// Related Topics 数组 👍 565 👎 0


package io.hjforever.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Q57ChaRuQuJian {
    public static void main(String[] args) {
        Solution solution = new Q57ChaRuQuJian().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] insert(int[][] intervals, int[] newInterval) {
            if (intervals == null || intervals.length == 0) {
                return new int[][]{newInterval};
            }
            int m = intervals.length;
            int[][] res = new int[m + 1][2];
            res[0] = newInterval;
            int k = 1;
            for (int[] its : intervals) {
                res[k++] = its;
            }
            return merge(res);
        }

        public int[][] merge(int[][] intervals) {
            if (intervals == null || intervals.length == 0) return new int[0][0];
            if (intervals.length == 1) return new int[][]{intervals[0]};
            Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
            List<int[]> res = new ArrayList<>();
            int start = intervals[0][0];
            int end = intervals[0][1];
            for (int i = 1; i < intervals.length; i++) {
                int st = intervals[i][0];
                int ed = intervals[i][1];
                if (end < st) {
                    int[] ans = new int[]{start, end};
                    res.add(ans);
                    start = st;
                    end = ed;
                } else {
                    if (ed > end) {
                        end = ed;
                    }
                }
                if (i == intervals.length - 1) {
                    res.add(new int[]{start, end});
                }
            }
            return res.toArray(new int[res.size()][2]);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
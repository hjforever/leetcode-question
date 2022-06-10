//Given the availability time slots arrays slots1 and slots2 of two people and
//a meeting duration duration, return the earliest time slot that works for both 
//of them and is of duration duration. 
//
// If there is no common time slot that satisfies the requirements, return an 
//empty array. 
//
// The format of a time slot is an array of two elements [start, end] 
//representing an inclusive time range from start to end. 
//
// It is guaranteed that no two availability slots of the same person intersect 
//with each other. That is, for any two time slots [start1, end1] and [start2, 
//end2] of the same person, either start1 > end2 or start2 > end1. 
//
// 
// Example 1: 
//
// 
//Input: slots1 = [[10,50],[60,120],[140,210]], slots2 = [[0,15],[60,70]], 
//duration = 8
//Output: [60,68]
// 
//
// Example 2: 
//
// 
//Input: slots1 = [[10,50],[60,120],[140,210]], slots2 = [[0,15],[60,70]], 
//duration = 12
//Output: []
// 
//
// 
// Constraints: 
//
// 
// 1 <= slots1.length, slots2.length <= 10⁴ 
// slots1[i].length, slots2[i].length == 2 
// slots1[i][0] < slots1[i][1] 
// slots2[i][0] < slots2[i][1] 
// 0 <= slots1[i][j], slots2[i][j] <= 10⁹ 
// 1 <= duration <= 10⁶ 
// 
// Related Topics 数组 双指针 排序 👍 53 👎 0


package io.hjforever.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Q1229MeetingScheduler {
    public static void main(String[] args) {
        Solution solution = new Q1229MeetingScheduler().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> minAvailableDuration(int[][] slots1, int[][] slots2, int duration) {
            // sort, two pointer
            Arrays.sort(slots1, Comparator.comparingInt(o -> o[0]));
            Arrays.sort(slots2, Comparator.comparingInt(o -> o[0]));
            List<Integer> ans = new ArrayList<>();
            for (int i = 0, j = 0; i < slots1.length && j < slots2.length; ) {
                int start = Math.max(slots1[i][0], slots2[j][0]);//得到起点
                //找终点
                int end1 = slots1[i][1], end2 = slots2[j][1];
                if (end1 > end2) {
                    //此时终点应该是end2
                    if (end2 - start >= duration) {
                        ans.add(start);
                        ans.add(start + duration);
                        return ans;
                    }
                    j++;
                } else {
                    if (end1 - start >= duration) {
                        ans.add(start);
                        ans.add(start + duration);
                        return ans;
                    }
                    i++;
                }
            }
            return ans;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
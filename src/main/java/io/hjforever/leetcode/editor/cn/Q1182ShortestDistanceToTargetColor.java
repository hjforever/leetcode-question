//You are given an array colors, in which there are three colors: 1, 2 and 3.
//
// You are also given some queries. Each query consists of two integers i and c,
// return the shortest distance between the given index i and the target color c. 
//If there is no solution return -1. 
//
// 
// Example 1: 
//
// 
//Input: colors = [1,1,2,1,3,2,2,3,3], queries = [[1,3],[2,2],[6,1]]
//Output: [3,0,3]
//Explanation: 
//The nearest 3 from index 1 is at index 4 (3 steps away).
//The nearest 2 from index 2 is at index 2 itself (0 steps away).
//The nearest 1 from index 6 is at index 3 (3 steps away).
// 
//
// Example 2: 
//
// 
//Input: colors = [1,2], queries = [[0,3]]
//Output: [-1]
//Explanation: There is no 3 in the array.
// 
//
// 
// Constraints: 
//
// 
// 1 <= colors.length <= 5*10^4 
// 1 <= colors[i] <= 3 
// 1 <= queries.length <= 5*10^4 
// queries[i].length == 2 
// 0 <= queries[i][0] < colors.length 
// 1 <= queries[i][1] <= 3 
// 
// Related Topics 数组 二分查找 动态规划 👍 32 👎 0


package io.hjforever.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class Q1182ShortestDistanceToTargetColor {
    public static void main(String[] args) {
        Solution solution = new Q1182ShortestDistanceToTargetColor().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> shortestDistanceColor(int[] colors, int[][] queries) {

            //分别记录左右两边最近的color idx, 然后在判断即可
            int n = colors.length;
            int[][] leftIdx = new int[n][3];
            int[][] rightIdx = new int[n][3];


            for (int k = 1; k <= 3; k++) {
                if (k != colors[n - 1]) {
                    rightIdx[n - 1][k - 1] = -1;
                } else {
                    rightIdx[n - 1][k - 1] = n - 1;
                }
            }


            for (int k = 1; k <= 3; k++) {
                if (k != colors[0]) {
                    leftIdx[0][k - 1] = -1;
                } else {
                    leftIdx[0][k - 1] = 0;
                }
            }

            for (int i = 1; i < n; i++) {
                int color = colors[i];
                for (int k = 1; k <= 3; k++) {
                    if (k != color) {
                        leftIdx[i][k - 1] = leftIdx[i - 1][k - 1];
                    } else {
                        leftIdx[i][k - 1] = i;
                    }
                }
            }

            for (int i = n - 2; i >= 0; i--) {
                int color = colors[i];
                for (int k = 1; k <= 3; k++) {
                    if (k != color) {
                        rightIdx[i][k - 1] = rightIdx[i + 1][k - 1];
                    } else {
                        rightIdx[i][k - 1] = i;
                    }
                }
            }

            int m = queries.length;
            List<Integer> ans = new ArrayList<>();

            for (int i = 0; i < m; i++) {
                int idx = queries[i][0];
                int color = queries[i][1];
                if (leftIdx[idx][color - 1] == -1 && rightIdx[idx][color - 1] == -1) {
                    ans.add(-1);
                    continue;
                }
                int dis = -1;
                if (leftIdx[idx][color - 1] != -1) {
                    dis = Math.abs(leftIdx[idx][color - 1] - idx);
                }
                if (rightIdx[idx][color - 1] != -1) {
                    if (dis == -1) {
                        dis = Math.abs(rightIdx[idx][color - 1] - idx);
                    } else {
                        dis = Math.min(dis, Math.abs(rightIdx[idx][color - 1] - idx));
                    }
                }
                ans.add(dis);
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}
//Given n points on a 2D plane, find if there is such a line parallel to the y-
//axis that reflects the given points symmetrically. 
//
// In other words, answer whether or not if there exists a line that after 
//reflecting all points over the given line, the original points' set is the same as 
//the reflected ones. 
//
// Note that there can be repeated points. 
//
// 
// Example 1: 
//
// 
//Input: points = [[1,1],[-1,1]]
//Output: true
//Explanation: We can choose the line x = 0.
// 
//
// Example 2: 
//
// 
//Input: points = [[1,1],[-1,-1]]
//Output: false
//Explanation: We can't choose a line.
// 
//
// 
// Constraints: 
//
// 
// n == points.length 
// 1 <= n <= 10⁴ 
// -10⁸ <= points[i][j] <= 10⁸ 
// 
//
// 
// Follow up: Could you do better than O(n²)? 
// Related Topics 数组 哈希表 数学 👍 27 👎 0


package io.hjforever.leetcode.editor.cn;

import java.util.*;

public class Q356LineReflection {
    public static void main(String[] args) {
        Solution solution = new Q356LineReflection().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isReflected(int[][] points) {
            int minX = Integer.MAX_VALUE, maxX = Integer.MIN_VALUE;
            HashSet<String> set = new HashSet<>(); // 存储不重复的元素
            for (int[] point : points) {
                minX = Math.min(minX, point[0]);
                maxX = Math.max(maxX, point[0]);
                set.add(point[0] + "@" + point[1]);
            }
            double sum = minX + maxX;
            for (int[] point : points) {
                if (!set.contains((int) (sum - point[0]) + "@" + point[1])) return false;
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
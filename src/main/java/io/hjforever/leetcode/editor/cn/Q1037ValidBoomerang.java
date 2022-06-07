//Given an array points where points[i] = [xi, yi] represents a point on the X-
//Y plane, return true if these points are a boomerang. 
//
// A boomerang is a set of three points that are all distinct and not in a 
//straight line. 
//
// 
// Example 1: 
// Input: points = [[1,1],[2,3],[3,2]]
//Output: true
// Example 2: 
// Input: points = [[1,1],[2,2],[3,3]]
//Output: false
// 
// 
// Constraints: 
//
// 
// points.length == 3 
// points[i].length == 2 
// 0 <= xi, yi <= 100 
// 
// Related Topics 几何 数组 数学 👍 33 👎 0


package io.hjforever.leetcode.editor.cn;

public class Q1037ValidBoomerang {
    public static void main(String[] args) {
        Solution solution = new Q1037ValidBoomerang().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isBoomerang(int[][] points) {
            //三点共线问题
            //1.斜率，2.叉积

            //向量叉积
            int[] v1 = {points[1][0] - points[0][0], points[1][1] - points[0][1]};
            int[] v2 = {points[2][0] - points[0][0], points[2][1] - points[0][1]};
            return v1[0] * v2[1] - v1[1] * v2[0] != 0;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
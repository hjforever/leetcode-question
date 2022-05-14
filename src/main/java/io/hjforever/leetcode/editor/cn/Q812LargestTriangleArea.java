//Given an array of points on the X-Y plane points where points[i] = [xi, yi],
//return the area of the largest triangle that can be formed by any three 
//different points. Answers within 10⁻⁵ of the actual answer will be accepted. 
//
// 
// Example 1: 
//
// 
//Input: points = [[0,0],[0,1],[1,0],[0,2],[2,0]]
//Output: 2.00000
//Explanation: The five points are shown in the above figure. The red triangle 
//is the largest.
// 
//
// Example 2: 
//
// 
//Input: points = [[1,0],[0,0],[0,1]]
//Output: 0.50000
// 
//
// 
// Constraints: 
//
// 
// 3 <= points.length <= 50 
// -50 <= xi, yi <= 50 
// All the given points are unique. 
// 
// Related Topics 几何 数组 数学 👍 109 👎 0


package io.hjforever.leetcode.editor.cn;

public class Q812LargestTriangleArea {
    public static void main(String[] args) {
        Solution solution = new Q812LargestTriangleArea().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public double largestTriangleArea(int[][] points) {
            int n = points.length;
            double ret = 0.0;
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    for (int k = j + 1; k < n; k++) {
                        ret = Math.max(ret, triangleArea(points[i][0], points[i][1], points[j][0], points[j][1], points[k][0], points[k][1]));
                    }
                }
            }
            return ret;
        }

        //行列式
        public double triangleArea(int x1, int y1, int x2, int y2, int x3, int y3) {
            return 0.5 * Math.abs(x1 * y2 + x2   * y3 + x3 * y1 - x1 * y3 - x2 * y1 - x3 * y2);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
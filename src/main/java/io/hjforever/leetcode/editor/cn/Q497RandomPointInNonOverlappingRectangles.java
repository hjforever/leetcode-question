//You are given an array of non-overlapping axis-aligned rectangles rects where
//rects[i] = [ai, bi, xi, yi] indicates that (ai, bi) is the bottom-left corner 
//point of the iᵗʰ rectangle and (xi, yi) is the top-right corner point of the iᵗʰ 
//rectangle. Design an algorithm to pick a random integer point inside the space 
//covered by one of the given rectangles. A point on the perimeter of a rectangle 
//is included in the space covered by the rectangle. 
//
// Any integer point inside the space covered by one of the given rectangles 
//should be equally likely to be returned. 
//
// Note that an integer point is a point that has integer coordinates. 
//
// Implement the Solution class: 
//
// 
// Solution(int[][] rects) Initializes the object with the given rectangles 
//rects. 
// int[] pick() Returns a random integer point [u, v] inside the space covered 
//by one of the given rectangles. 
// 
//
// 
// Example 1: 
//
// 
//Input
//["Solution", "pick", "pick", "pick", "pick", "pick"]
//[[[[-2, -2, 1, 1], [2, 2, 4, 6]]], [], [], [], [], []]
//Output
//[null, [1, -2], [1, -1], [-1, -2], [-2, -2], [0, 0]]
//
//Explanation
//Solution solution = new Solution([[-2, -2, 1, 1], [2, 2, 4, 6]]);
//solution.pick(); // return [1, -2]
//solution.pick(); // return [1, -1]
//solution.pick(); // return [-1, -2]
//solution.pick(); // return [-2, -2]
//solution.pick(); // return [0, 0]
// 
//
// 
// Constraints: 
//
// 
// 1 <= rects.length <= 100 
// rects[i].length == 4 
// -10⁹ <= ai < xi <= 10⁹ 
// -10⁹ <= bi < yi <= 10⁹ 
// xi - ai <= 2000 
// yi - bi <= 2000 
// All the rectangles do not overlap. 
// At most 10⁴ calls will be made to pick. 
// 
// Related Topics 水塘抽样 数学 二分查找 有序集合 前缀和 随机化 👍 68 👎 0


package io.hjforever.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Q497RandomPointInNonOverlappingRectangles {
    public static void main(String[] args) {
        //Solution solution = new Q497RandomPointInNonOverlappingRectangles().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        Random random;
        List<Integer> list;
        int[][] rects;

        public Solution(int[][] rects) {
            random = new Random();
            list = new ArrayList<>();
            list.add(0);
            this.rects = rects;
            for (int[] rect : rects) {
                int a = rect[0], b = rect[1], x = rect[2], y = rect[3];
                // 获取所有点, 如果有2 个矩形, 那么第二个矩形应该包含第一个矩形中的所有点
                list.add(list.get(list.size() - 1) + (x - a + 1) * (y - b + 1));
            }
        }

        public int[] pick() {
            // 在最后一个矩形包含的 点 中随机取一个点
            int k = random.nextInt(list.get(list.size() - 1));
            // 找到矩形的编号
            int rectIndex = binarySearch(list, k + 1) - 1;
            // 找到随机值 k 在 对应矩形中的编号
            k -= list.get(rectIndex);
            // 获取左下角的值跟右上角的值
            int[] rect = rects[rectIndex];
            int a = rect[0], b = rect[1], y = rect[3];
            // 还原索引
            int col = y - b + 1;
            int da = k / col;
            int db = k - col * da;
            return new int[]{a + da, b + db};
        }

        private int binarySearch(List<Integer> arr, int target) {
            int low = 0, high = arr.size() - 1;
            while (low <= high) {
                int mid = (high - low) / 2 + low;
                int num = arr.get(mid);
                if (num == target) {
                    return mid;
                } else if (num > target) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            return low;
        }
    }

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(rects);
 * int[] param_1 = obj.pick();
 */
//leetcode submit region end(Prohibit modification and deletion)

}
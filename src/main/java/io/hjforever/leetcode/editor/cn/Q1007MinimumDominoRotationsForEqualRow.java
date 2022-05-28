//In a row of dominoes, tops[i] and bottoms[i] represent the top and bottom
//halves of the iᵗʰ domino. (A domino is a tile with two numbers from 1 to 6 - one on 
//each half of the tile.) 
//
// We may rotate the iᵗʰ domino, so that tops[i] and bottoms[i] swap values. 
//
// Return the minimum number of rotations so that all the values in tops are 
//the same, or all the values in bottoms are the same. 
//
// If it cannot be done, return -1. 
//
// 
// Example 1: 
//
// 
//Input: tops = [2,1,2,4,2,2], bottoms = [5,2,6,2,3,2]
//Output: 2
//Explanation: 
//The first figure represents the dominoes as given by tops and bottoms: before 
//we do any rotations.
//If we rotate the second and fourth dominoes, we can make every value in the 
//top row equal to 2, as indicated by the second figure.
// 
//
// Example 2: 
//
// 
//Input: tops = [3,5,1,2,3], bottoms = [3,6,3,3,4]
//Output: -1
//Explanation: 
//In this case, it is not possible to rotate the dominoes to make one row of 
//values equal.
// 
//
// 
// Constraints: 
//
// 
// 2 <= tops.length <= 2 * 10⁴ 
// bottoms.length == tops.length 
// 1 <= tops[i], bottoms[i] <= 6 
// 
// Related Topics 贪心 数组 👍 95 👎 0


package io.hjforever.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class Q1007MinimumDominoRotationsForEqualRow {
    public static void main(String[] args) {
        Solution solution = new Q1007MinimumDominoRotationsForEqualRow().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minDominoRotations(int[] tops, int[] bottoms) {
            int r = check(tops[0], tops, bottoms);
            if (r != -1 || tops[0] == bottoms[0]) return r;
            return check(bottoms[0], tops, bottoms);

            //先找num在判断，这样效率有点低，此处只存在两种情况，数字要么是 tops,要么是bottom故遍历2次即可
//
//            Map<Integer, Integer> cnt = new HashMap<>();
//            for (int i = 0; i < n; i++) {
//                if (tops[i] != bottoms[i]) {
//                    cnt.put(tops[i], cnt.getOrDefault(tops[i], 0) + 1);
//                    cnt.put(bottoms[i], cnt.getOrDefault(bottoms[i], 0) + 1);
//                } else {
//                    cnt.put(tops[i], cnt.getOrDefault(tops[i], 0) + 1);
//                }
//            }
//            Integer num = -1;
//            for (Integer key : cnt.keySet()) {
//                if (cnt.get(key) == n) {
//                    num = key;
//                }
//            }
//            if (num == -1) return -1;
//            int top = 0;
//            int bottom = 0;
//            for (int i = 0; i < n; i++) {
//                if (tops[i] != num) top++;
//                if (bottoms[i] != num) bottom++;
//            }
//            return Math.min(top, bottom);
        }

        int check(int x, int[] t, int[] b) {
            int tCnt = 0;
            int bCnt = 0;
            for (int i = 0; i < t.length; i++) {
                if (t[i] != x && b[i] != x) return -1;
                if (t[i] != x) tCnt++;
                if (b[i] != x) bCnt++;
            }
            return Math.min(tCnt, bCnt);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
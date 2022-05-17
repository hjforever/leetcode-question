//There is an m x n binary grid matrix with all the values set 0 initially.
//Design an algorithm to randomly pick an index (i, j) where matrix[i][j] == 0 and 
//flips it to 1. All the indices (i, j) where matrix[i][j] == 0 should be equally 
//likely to be returned. 
//
// Optimize your algorithm to minimize the number of calls made to the built-in 
//random function of your language and optimize the time and space complexity. 
//
// Implement the Solution class: 
//
// 
// Solution(int m, int n) Initializes the object with the size of the binary 
//matrix m and n. 
// int[] flip() Returns a random index [i, j] of the matrix where matrix[i][j] =
//= 0 and flips it to 1. 
// void reset() Resets all the values of the matrix to be 0. 
// 
//
// 
// Example 1: 
//
// 
//Input
//["Solution", "flip", "flip", "flip", "reset", "flip"]
//[[3, 1], [], [], [], [], []]
//Output
//[null, [1, 0], [2, 0], [0, 0], null, [2, 0]]
//
//Explanation
//Solution solution = new Solution(3, 1);
//solution.flip();  // return [1, 0], [0,0], [1,0], and [2,0] should be equally 
//likely to be returned.
//solution.flip();  // return [2, 0], Since [1,0] was returned, [2,0] and [0,0]
//solution.flip();  // return [0, 0], Based on the previously returned indices, 
//only [0,0] can be returned.
//solution.reset(); // All the values are reset to 0 and can be returned.
//solution.flip();  // return [2, 0], [0,0], [1,0], and [2,0] should be equally 
//likely to be returned.
// 
//
// 
// Constraints: 
//
// 
// 1 <= m, n <= 10⁴ 
// There will be at least one free cell for each call to flip. 
// At most 1000 calls will be made to flip and reset. 
// 
// Related Topics 水塘抽样 哈希表 数学 随机化 👍 138 👎 0


package io.hjforever.leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Q519RandomFlipMatrix {
    public static void main(String[] args) {
        //Solution solution = new Q519RandomFlipMatrix().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        // hash ,random
        int m, n, cnt;
        Random random = new Random(300);
        Map<Integer, Integer> map = new HashMap<>();


        public Solution(int m, int n) {
            this.m = m;
            this.n = n;
            cnt = m * n;
        }

        public int[] flip() {
            // random pick
            Integer x = random.nextInt(cnt);
            cnt--;
            int idx = map.getOrDefault(x, x);
            map.put(x, map.getOrDefault(cnt, cnt));
            return new int[]{idx / n, idx % n};

        }

        public void reset() {
            cnt = m * n;
            map.clear();
        }
    }

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(m, n);
 * int[] param_1 = obj.flip();
 * obj.reset();
 */
//leetcode submit region end(Prohibit modification and deletion)

}
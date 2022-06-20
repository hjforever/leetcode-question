//A stepping number is an integer such that all of its adjacent digits have an
//absolute difference of exactly 1. 
//
// 
// For example, 321 is a stepping number while 421 is not. 
// 
//
// Given two integers low and high, return a sorted list of all the stepping 
//numbers in the inclusive range [low, high]. 
//
// 
// Example 1: 
//
// 
//Input: low = 0, high = 21
//Output: [0,1,2,3,4,5,6,7,8,9,10,12,21]
// 
//
// Example 2: 
//
// 
//Input: low = 10, high = 15
//Output: [10,12]
// 
//
// 
// Constraints: 
//
// 
// 0 <= low <= high <= 2 * 10⁹ 
// 
// Related Topics 广度优先搜索 回溯 👍 33 👎 0


package io.hjforever.leetcode.editor.cn;

import java.util.*;

public class Q1215SteppingNumbers {
    public static void main(String[] args) {
        Solution solution = new Q1215SteppingNumbers().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        Set<Integer> set = new HashSet<>();

        public List<Integer> countSteppingNumbers(int low, int high) {
            //dfs ,下一层数据依赖上一层
            //从第一位数字开始模拟，后续的数字只有两种一个是-1，一个+1
            for (long i = 0; i <= 9; i++) {
                dfs(i, low, high);
            }
            List<Integer> ans = new ArrayList<>(set);
            Collections.sort(ans);
            return ans;
        }

        void dfs(long num, int low, int high) {
            if (num >= low && num <= high) set.add((int) num);
            if (num > high) return;
            long last = num % 10;
            if (last < 9) {
                dfs(num * 10 + last + 1, low, high);
            }
            if (last > 0) {
                dfs(num * 10 + last - 1, low, high);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
//给定一个正整数 n ，你可以做如下操作：
//
// 
// 如果 n 是偶数，则用 n / 2替换 n 。 
// 如果 n 是奇数，则可以用 n + 1或n - 1替换 n 。 
// 
//
// n 变为 1 所需的最小替换次数是多少？ 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 8
//输出：3
//解释：8 -> 4 -> 2 -> 1
// 
//
// 示例 2： 
//
// 
//输入：n = 7
//输出：4
//解释：7 -> 8 -> 4 -> 2 -> 1
//或 7 -> 6 -> 3 -> 2 -> 1
// 
//
// 示例 3： 
//
// 
//输入：n = 4
//输出：2
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 2³¹ - 1 
// 
// Related Topics 贪心 位运算 记忆化搜索 动态规划 👍 111 👎 0


package io.hjforever.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class Q397ZhengShuTiHuan {
    public static void main(String[] args) {
        Solution solution = new Q397ZhengShuTiHuan().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        Map<Long, Integer> backup = new HashMap<>();

        public int integerReplacement(int n) {
            //dp 一维数组会内存超出限制
            //dfs + 备忘录
            long num = n;
            return dfs(num);
        }

        int dfs(long n) {
            if (n == 1) {
                return 0;
            }
            if (n == 2) {
                return 1;
            }
            if (backup.containsKey(n)) {
                return backup.get(n);
            }
            int res;
            if (n % 2 == 0) {
                res = dfs(n / 2) + 1;
            } else {
                res = Math.min(dfs(n + 1), dfs(n - 1)) + 1;
            }
            backup.put(n, res);
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
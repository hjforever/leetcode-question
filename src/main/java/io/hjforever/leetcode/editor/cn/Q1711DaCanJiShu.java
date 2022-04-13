//大餐 是指 恰好包含两道不同餐品 的一餐，其美味程度之和等于 2 的幂。
//
// 你可以搭配 任意 两道餐品做一顿大餐。 
//
// 给你一个整数数组 deliciousness ，其中 deliciousness[i] 是第 i 道餐品的美味程度，返回你可以用数组中的餐品做出的不同 大
//餐 的数量。结果需要对 10⁹ + 7 取余。 
//
// 注意，只要餐品下标不同，就可以认为是不同的餐品，即便它们的美味程度相同。 
//
// 
//
// 示例 1： 
//
// 
//输入：deliciousness = [1,3,5,7,9]
//输出：4
//解释：大餐的美味程度组合为 (1,3) 、(1,7) 、(3,5) 和 (7,9) 。
//它们各自的美味程度之和分别为 4 、8 、8 和 16 ，都是 2 的幂。
// 
//
// 示例 2： 
//
// 
//输入：deliciousness = [1,1,1,3,3,3,7]
//输出：15
//解释：大餐的美味程度组合为 3 种 (1,1) ，9 种 (1,3) ，和 3 种 (1,7) 。 
//
// 
//
// 提示： 
//
// 
// 1 <= deliciousness.length <= 10⁵ 
// 0 <= deliciousness[i] <= 2²⁰ 
// 
// Related Topics 数组 哈希表 👍 122 👎 0


package io.hjforever.leetcode.editor.cn;

import java.util.*;

public class Q1711DaCanJiShu {
    public static void main(String[] args) {
        Solution solution = new Q1711DaCanJiShu().new Solution();
        System.out.println(solution.countPairs(new int[]{149, 107, 1, 63, 0, 1, 6867, 1325, 5611, 2581, 39, 89, 46, 18, 12, 20, 22, 234}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countPairs(int[] deliciousness) {
            if (deliciousness == null || deliciousness.length == 0 || deliciousness.length == 1) {
                return 0;
            }
            int MOD = 1000000007;
            //计算最大幂次 2^21
            Map<Integer, Integer> map = new HashMap<>();
            int max = (int) Math.pow(2, 21);
            int sum = 0;
            for (int i = 0; i < deliciousness.length; i++) {
                int num = deliciousness[i];
                for (int twoPow = 1; twoPow <= max; twoPow <<= 1) {
                    int count = map.getOrDefault(twoPow - num, 0);
                    sum = (sum + count) % MOD;
                }
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
            return sum;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
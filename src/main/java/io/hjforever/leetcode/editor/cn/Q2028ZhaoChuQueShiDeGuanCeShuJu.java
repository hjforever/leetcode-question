//现有一份 n + m 次投掷单个 六面 骰子的观测数据，骰子的每个面从 1 到 6 编号。观测数据中缺失了 n 份，你手上只拿到剩余 m 次投掷的数据。幸好
//你有之前计算过的这 n + m 次投掷数据的 平均值 。 
//
// 给你一个长度为 m 的整数数组 rolls ，其中 rolls[i] 是第 i 次观测的值。同时给你两个整数 mean 和 n 。 
//
// 返回一个长度为 n 的数组，包含所有缺失的观测数据，且满足这 n + m 次投掷的 平均值 是 mean 。如果存在多组符合要求的答案，只需要返回其中任意
//一组即可。如果不存在答案，返回一个空数组。 
//
// k 个数字的 平均值 为这些数字求和后再除以 k 。 
//
// 注意 mean 是一个整数，所以 n + m 次投掷的总和需要被 n + m 整除。 
//
// 
//
// 示例 1： 
//
// 
//输入：rolls = [3,2,4,3], mean = 4, n = 2
//输出：[6,6]
//解释：所有 n + m 次投掷的平均值是 (3 + 2 + 4 + 3 + 6 + 6) / 6 = 4 。
// 
//
// 示例 2： 
//
// 
//输入：rolls = [1,5,6], mean = 3, n = 4
//输出：[2,3,2,2]
//解释：所有 n + m 次投掷的平均值是 (1 + 5 + 6 + 2 + 3 + 2 + 2) / 7 = 3 。
// 
//
// 示例 3： 
//
// 
//输入：rolls = [1,2,3,4], mean = 6, n = 4
//输出：[]
//解释：无论丢失的 4 次数据是什么，平均值都不可能是 6 。
// 
//
// 示例 4： 
//
// 
//输入：rolls = [1], mean = 3, n = 1
//输出：[5]
//解释：所有 n + m 次投掷的平均值是 (1 + 5) / 2 = 3 。
// 
//
// 
//
// 提示： 
//
// 
// m == rolls.length 
// 1 <= n, m <= 10⁵ 
// 1 <= rolls[i], mean <= 6 
// 
// Related Topics 数组 数学 模拟 👍 4 👎 0


package io.hjforever.leetcode.editor.cn;

import java.util.Arrays;
import java.util.LinkedList;

public class Q2028ZhaoChuQueShiDeGuanCeShuJu {
    public static void main(String[] args) {
        Solution solution = new Q2028ZhaoChuQueShiDeGuanCeShuJu().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        LinkedList<Integer> res = new LinkedList<>();
        boolean search = false;

        public int[] missingRolls(int[] rolls, int mean, int n) {
            //本题本质上是求 n个数之和问题
            //1.dfs搜索
            //2.贪心，先将n个数都设置为1然后向每个数中++只要不超过6即可
            return missingRollsGredy(rolls, mean, n);
        }

        //贪心，桶算法,桶的个数是固定的，容量也是在区间1,6之间
        public int[] missingRollsGredy(int[] rolls, int mean, int n) {
            int m = rolls.length;
            int rollsum = Arrays.stream(rolls).sum();
            int sum = (m + n) * mean;
            int target = sum - rollsum;
            if (target < n || target > 6 * n) {
                return new int[]{};
            }
            int[] res = new int[n];
            Arrays.fill(res, target / n);
            target = target % n;
            if (target > 0) {
                for (int i = 0; i < res.length; i++) {
                    if (target > 0) {
                        res[i]++;
                        target--;
                    }
                }
            }
            return res;
        }


        //dfs
        public int[] missingRollsDfs(int[] rolls, int mean, int n) {
            int m = rolls.length;
            int len = m + n;
            long sum = (long) len * mean;
            long rollsum = Arrays.stream(rolls).sum();
            if (sum > rollsum) {
                dfs(new LinkedList(), n, 0, sum - rollsum);
            }
            return res.stream().mapToInt(value -> value).toArray();
        }


        //dfs搜索
        void dfs(LinkedList list, int k, long sum, long target) {
            if (search) {
                return;
            }
            if ((k - list.size()) * 6L + sum < target ||
                    (k - list.size()) > target) {
                return;
            }
            if (sum > target || list.size() > k) {
                return;
            }
            if (list.size() == k) {
                if (sum == target) {
                    search = true;
                    res = new LinkedList<>(list);
                    return;
                }
                return;
            }
            for (int i = 1; i <= 6; i++) {
                list.addLast(i);
                dfs(list, k, sum + i, target);
                list.removeLast();
            }
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
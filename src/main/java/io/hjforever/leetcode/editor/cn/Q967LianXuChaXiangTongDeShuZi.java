//返回所有长度为 n 且满足其每两个连续位上的数字之间的差的绝对值为 k 的 非负整数 。
//
// 请注意，除了 数字 0 本身之外，答案中的每个数字都 不能 有前导零。例如，01 有一个前导零，所以是无效的；但 0 是有效的。 
//
// 你可以按 任何顺序 返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3, k = 7
//输出：[181,292,707,818,929]
//解释：注意，070 不是一个有效的数字，因为它有前导零。
// 
//
// 示例 2： 
//
// 
//输入：n = 2, k = 1
//输出：[10,12,21,23,32,34,43,45,54,56,65,67,76,78,87,89,98] 
//
// 示例 3： 
//
// 
//输入：n = 2, k = 0
//输出：[11,22,33,44,55,66,77,88,99]
// 
//
// 示例 4： 
//
// 
//输入：n = 2, k = 2
//输出：[13,20,24,31,35,42,46,53,57,64,68,75,79,86,97]
// 
//
// 
//
// 提示： 
//
// 
// 2 <= n <= 9 
// 0 <= k <= 9 
// 
// Related Topics 广度优先搜索 回溯 👍 63 👎 0


package io.hjforever.leetcode.editor.cn;

import java.util.*;

public class Q967LianXuChaXiangTongDeShuZi {
    public static void main(String[] args) {
        Solution solution = new Q967LianXuChaXiangTongDeShuZi().new Solution();
        solution.numsSameConsecDiff(3, 7);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //简单循环思想
        Set<Integer> result = new HashSet<>();

        public int[] numsSameConsecDiff(int n, int k) {

            //第一位
            Set<String> set = new HashSet<>();
            for (int i = 1; i <= 9; i++) {
                set.add("" + i);
            }
            dfs(n, k, set);
            List<Integer> list = new ArrayList<>(result);
            Collections.sort(list);
            int[] res = new int[list.size()];
            int st = 0;
            for (Integer num : list) {
                res[st] = num;
                st++;
            }
            return res;
        }

        void dfs(int n, int k, Set<String> pathList) {
            int length = 1;
            while (length < n) {
                Set<String> set = new HashSet<>();
                for (String s : pathList) {
                    int st = Integer.parseInt("" + s.charAt(s.length() - 1));
                    int next1 = st + k;
                    int next2 = st - k;
                    if (next1 >= 0 && next1 < 10) {
                        set.add(s + next1);
                    }
                    if (next2 >= 0 && next2 < 10) {
                        //加入pathlist
                        set.add(s + next2);
                    }
                }
                pathList.clear();
                pathList.addAll(set);
                length++;
            }
            for (String s : pathList) {
                if (s.length() == n) {
                    result.add(Integer.valueOf(s));
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
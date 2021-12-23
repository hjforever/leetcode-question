//给你一个字符串 s ，考虑其所有 重复子串 ：即，s 的连续子串，在 s 中出现 2 次或更多次。这些出现之间可能存在重叠。
//
// 返回 任意一个 可能具有最长长度的重复子串。如果 s 不含重复子串，那么答案为 "" 。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "banana"
//输出："ana"
// 
//
// 示例 2： 
//
// 
//输入：s = "abcd"
//输出：""
// 
//
// 
//
// 提示： 
//
// 
// 2 <= s.length <= 3 * 10⁴ 
// s 由小写英文字母组成 
// 
// Related Topics 字符串 二分查找 后缀数组 滑动窗口 哈希函数 滚动哈希 👍 208 👎 0


package io.hjforever.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class Q1044ZuiZhangZhongFuZiChuan {
    public static void main(String[] args) {
        Solution solution = new Q1044ZuiZhangZhongFuZiChuan().new Solution();
        System.out.println(solution.longestDupSubstring("banana"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestDupSubstring(String s) {
            return longestDupSubstringByBianrySeachHash(s);
        }

        //二分（1，n） + 字符串hash
        public String longestDupSubstringByBianrySeachHash(String s) {
            String result = "";
            int P = 1313131;
            int length = s.length();
            long[] ha = new long[length + 1];
            long[] p = new long[length + 1];
            p[0] = 1;
            //bac -> a + ha * P , b + (a + ha * P)* P
            for (int i = 0; i < length; i++) {
                p[i + 1] = p[i] * P;
                ha[i + 1] = ha[i] * P + s.charAt(i);
            }

            //二分查找，当mid有值，则
            int left = 0;
            int right = length;

            while (left < right) {
                int mid = left + right + 1 >> 1;
                String res = check(s, mid, ha, p);
                //说明maxlenght > mid 则left= mid
                if (res.length() > 0) {
                    left = mid;
                } else {
                    right = mid - 1;
                }
                //记录每次结果值
                result = res.length() > result.length() ? res : result;
            }
            return result;
        }

        //hash前缀检测
        private String check(String s, int len, long[] ha, long[] p) {
            int n = s.length();
            Map<Long, Integer> map = new HashMap<>();
            for (int i = 1; i + len - 1 <= n; i++) {
                int j = i + len - 1;
                long hash = ha[j] - ha[i - 1] * p[j - i + 1];
                int cnt = map.getOrDefault(hash, 0);
                if (cnt == 1) {
                    return s.substring(i - 1, j);
                }
                map.put(hash, cnt + 1);
            }
            return "";
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
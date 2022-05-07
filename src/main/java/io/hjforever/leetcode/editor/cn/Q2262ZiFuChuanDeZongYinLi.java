//字符串的 引力 定义为：字符串中 不同 字符的数量。
//
// 
// 例如，"abbca" 的引力为 3 ，因为其中有 3 个不同字符 'a'、'b' 和 'c' 。 
// 
//
// 给你一个字符串 s ，返回 其所有子字符串的总引力 。 
//
// 子字符串 定义为：字符串中的一个连续字符序列。 
//
// 
//
// 示例 1： 
//
// 输入：s = "abbca"
//输出：28
//解释："abbca" 的子字符串有：
//- 长度为 1 的子字符串："a"、"b"、"b"、"c"、"a" 的引力分别为 1、1、1、1、1，总和为 5 。
//- 长度为 2 的子字符串："ab"、"bb"、"bc"、"ca" 的引力分别为 2、1、2、2 ，总和为 7 。
//- 长度为 3 的子字符串："abb"、"bbc"、"bca" 的引力分别为 2、2、3 ，总和为 7 。
//- 长度为 4 的子字符串："abbc"、"bbca" 的引力分别为 3、3 ，总和为 6 。
//- 长度为 5 的子字符串："abbca" 的引力为 3 ，总和为 3 。
//引力总和为 5 + 7 + 7 + 6 + 3 = 28 。
// 
//
// 示例 2： 
//
// 输入：s = "code"
//输出：20
//解释："code" 的子字符串有：
//- 长度为 1 的子字符串："c"、"o"、"d"、"e" 的引力分别为 1、1、1、1 ，总和为 4 。
//- 长度为 2 的子字符串："co"、"od"、"de" 的引力分别为 2、2、2 ，总和为 6 。
//- 长度为 3 的子字符串："cod"、"ode" 的引力分别为 3、3 ，总和为 6 。
//- 长度为 4 的子字符串："code" 的引力为 4 ，总和为 4 。
//引力总和为 4 + 6 + 6 + 4 = 20 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 10⁵ 
// s 由小写英文字母组成 
// 
// Related Topics 哈希表 字符串 动态规划 👍 49 👎 0


package io.hjforever.leetcode.editor.cn;

import java.util.Arrays;

public class Q2262ZiFuChuanDeZongYinLi {
    public static void main(String[] args) {
        Solution solution = new Q2262ZiFuChuanDeZongYinLi().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public long appealSum(String s) {
            long res = 1;
            // dp
            //1. 从左往右遍历 s，考虑将 s[i] 添加到以 s[i−1] 结尾的子串的末尾。添加后，这些子串的引力值会增加多少？
            // 2. 如果 s[i] 之前没有遇到过，那么每个子串的引力值都会增加 1，引力值之和会增加 i，再加上 1，即 s[i] 单独组成的子串的引力值
            // 3. 如果 s[i] 之前遇到过，设其上次出现的下标为 j，那么向子串 s[0..i-1], s[1..i-1], s[2..i-1],...,s[j..i-1]的末尾添加 s[i] 后，
            //    引力值是不会变化的，因为 s[i] 已经在 s[j] 处出现过了，
            //    因此只有 i−j−1 个子串的引力值会增加 1，引力值之和会增加 i−j−1，再加上1，即 s[i] 单独组成的子串的引力值
            int n = s.length();
            int[] dp = new int[n];
            int[] preIdx = new int[26];
            Arrays.fill(preIdx, -1);
            //记录前一个字符的出现的位置，如果没有出现则为-1
            dp[0] = 1;
            preIdx[s.charAt(0) - 'a'] = 0;

            for (int i = 1; i < n; i++) {
                int idx = s.charAt(i) - 'a';
                int len = i - preIdx[idx] - 1;
                dp[i] = dp[i - 1] + len + 1;
                //记录字符的前一个位置
                preIdx[idx] = i;
                res += dp[i];
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
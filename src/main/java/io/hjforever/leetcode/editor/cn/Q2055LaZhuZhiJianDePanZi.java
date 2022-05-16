//给你一个长桌子，桌子上盘子和蜡烛排成一列。给你一个下标从 0 开始的字符串 s ，它只包含字符 '*' 和 '|' ，其中 '*' 表示一个 盘子 ，'|
//' 表示一支 蜡烛 。 
//
// 同时给你一个下标从 0 开始的二维整数数组 queries ，其中 queries[i] = [lefti, righti] 表示 子字符串 s[
//lefti...righti] （包含左右端点的字符）。对于每个查询，你需要找到 子字符串中 在 两支蜡烛之间 的盘子的 数目 。如果一个盘子在 子字符串中 左边和右边
// 都 至少有一支蜡烛，那么这个盘子满足在 两支蜡烛之间 。 
//
// 
// 比方说，s = "||**||**|*" ，查询 [3, 8] ，表示的是子字符串 "*||**|" 。子字符串中在两支蜡烛之间的盘子数目为 2 ，子字符
//串中右边两个盘子在它们左边和右边 都 至少有一支蜡烛。 
// 
//
// 请你返回一个整数数组 answer ，其中 answer[i] 是第 i 个查询的答案。 
//
// 
//
// 示例 1: 
//
// 
//
// 输入：s = "**|**|***|", queries = [[2,5],[5,9]]
//输出：[2,3]
//解释：
//- queries[0] 有两个盘子在蜡烛之间。
//- queries[1] 有三个盘子在蜡烛之间。
// 
//
// 示例 2: 
//
// 
//
// 输入：s = "***|**|*****|**||**|*", queries = [[1,17],[4,5],[14,17],[5,11],[15,16
//]]
//输出：[9,0,0,0,0]
//解释：
//- queries[0] 有 9 个盘子在蜡烛之间。
//- 另一个查询没有盘子在蜡烛之间。
// 
//
// 
//
// 提示： 
//
// 
// 3 <= s.length <= 10⁵ 
// s 只包含字符 '*' 和 '|' 。 
// 1 <= queries.length <= 10⁵ 
// queries[i].length == 2 
// 0 <= lefti <= righti < s.length 
// 
// Related Topics 数组 字符串 二分查找 前缀和 👍 26 👎 0


package io.hjforever.leetcode.editor.cn;

public class Q2055LaZhuZhiJianDePanZi {
    public static void main(String[] args) {
        Solution solution = new Q2055LaZhuZhiJianDePanZi().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] platesBetweenCandles(String s, int[][] queries) {
            //预处理 + 前缀和
            int n = s.length();
            //盘子前缀和，快速求出区间内的盘子数量
            int[] preSum = new int[n];
            for (int i = 0, sum = 0; i < n; i++) {
                if (s.charAt(i) == '*') {
                    sum++;
                }
                preSum[i] = sum;
            }

            //预处理各个位置左右相邻蜡烛index
            int[] left = new int[n];
            for (int i = 0, leftVal = -1; i < n; i++) {
                if (s.charAt(i) == '|') {
                    //当自身为蜡烛时则为当前坐标
                    leftVal = i;
                }
                //否则为前一个蜡烛坐标
                left[i] = leftVal;
            }

            int[] right = new int[n];
            for (int i = n - 1, rightVal = -1; i >= 0; i--) {
                if (s.charAt(i) == '|') {
                    //当自身为蜡烛时则为当前坐标
                    rightVal = i;
                }
                //否则为前一个蜡烛坐标
                right[i] = rightVal;
            }
            int[] res = new int[queries.length];

            for (int i = 0; i < queries.length; i++) {
                int[] query = queries[i];
                //左边界求右侧最近的蜡烛坐标
                int leftIndex = right[query[0]];
                //右边界求最左侧最近的蜡烛坐标
                int rightIndex = left[query[1]];

                if (leftIndex == -1 || rightIndex == -1 || leftIndex >= rightIndex) {
                    res[i] = 0;
                } else {
                    res[i] = preSum[rightIndex] - preSum[leftIndex];
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
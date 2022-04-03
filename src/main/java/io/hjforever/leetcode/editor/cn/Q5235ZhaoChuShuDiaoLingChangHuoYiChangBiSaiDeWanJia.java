//给你一个整数数组 matches 其中 matches[i] = [winneri, loseri] 表示在一场比赛中 winneri 击败了
//loseri 。 
//
// 返回一个长度为 2 的列表 answer ： 
//
// 
// answer[0] 是所有 没有 输掉任何比赛的玩家列表。 
// answer[1] 是所有恰好输掉 一场 比赛的玩家列表。 
// 
//
// 两个列表中的值都应该按 递增 顺序返回。 
//
// 注意： 
//
// 
// 只考虑那些参与 至少一场 比赛的玩家。 
// 生成的测试用例保证 不存在 两场比赛结果 相同 。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：matches = [[1,3],[2,3],[3,6],[5,6],[5,7],[4,5],[4,8],[4,9],[10,4],[10,9]]
//输出：[[1,2,10],[4,5,7,8]]
//解释：
//玩家 1、2 和 10 都没有输掉任何比赛。
//玩家 4、5、7 和 8 每个都输掉一场比赛。
//玩家 3、6 和 9 每个都输掉两场比赛。
//因此，answer[0] = [1,2,10] 和 answer[1] = [4,5,7,8] 。
// 
//
// 示例 2： 
//
// 
//输入：matches = [[2,3],[1,3],[5,4],[6,4]]
//输出：[[1,2,5,6],[]]
//解释：
//玩家 1、2、5 和 6 都没有输掉任何比赛。
//玩家 3 和 4 每个都输掉两场比赛。
//因此，answer[0] = [1,2,5,6] 和 answer[1] = [] 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= matches.length <= 10⁵ 
// matches[i].length == 2 
// 1 <= winneri, loseri <= 10⁵ 
// winneri != loseri 
// 所有 matches[i] 互不相同 
// 
// Related Topics 图 👍 0 👎 0


package io.hjforever.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;

public class Q5235ZhaoChuShuDiaoLingChangHuoYiChangBiSaiDeWanJia {
    public static void main(String[] args) {
        Solution solution = new Q5235ZhaoChuShuDiaoLingChangHuoYiChangBiSaiDeWanJia().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> findWinners(int[][] matches) {
            //map统计
            LinkedHashMap<Integer, int[]> map = new LinkedHashMap<>();
            for (int i = 0; i < matches.length; i++) {
                int[] m = matches[i];
                int[] w = map.getOrDefault(m[0], new int[]{0, 0});
                int[] l = map.getOrDefault(m[1], new int[]{0, 0});
                w[0]++;
                l[1]++;
                map.put(m[0], w);
                map.put(m[1], l);
            }

            List<Integer> lose = new ArrayList<>();
            List<Integer> win = new ArrayList<>();

            List<List<Integer>> res = new ArrayList<>();

            for (Integer key : map.keySet()) {
                int[] m = map.get(key);
                if (m[1] == 0 && m[0] > 0) {
                    win.add(key);
                }
                if (m[1] == 1) {
                    lose.add(key);
                }
            }
            Collections.sort(win);
            Collections.sort(lose);
            res.add(win);
            res.add(lose);
            return  res ;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
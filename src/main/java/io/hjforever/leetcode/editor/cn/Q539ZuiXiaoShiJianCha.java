//给定一个 24 小时制（小时:分钟 "HH:MM"）的时间列表，找出列表中任意两个时间的最小时间差并以分钟数表示。
//
// 
//
// 示例 1： 
//
// 
//输入：timePoints = ["23:59","00:00"]
//输出：1
// 
//
// 示例 2： 
//
// 
//输入：timePoints = ["00:00","23:59","00:00"]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 2 <= timePoints <= 2 * 10⁴ 
// timePoints[i] 格式为 "HH:MM" 
// 
// Related Topics 数组 数学 字符串 排序 👍 121 👎 0


package io.hjforever.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Q539ZuiXiaoShiJianCha {
    public static void main(String[] args) {
        Solution solution = new Q539ZuiXiaoShiJianCha().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findMinDifference(List<String> timePoints) {
            int max = 24 * 60;
            if (timePoints.size() > max) {
                return 0;
            }
            List<Integer> minsList = new ArrayList();

            for (String time : timePoints) {
                minsList.add(convertToMinus(time));
            }
            Collections.sort(minsList);
            int res = Integer.MAX_VALUE;
            for (int i = 1; i < minsList.size(); i++) {
                int t = minsList.get(i) - minsList.get(i - 1);
                res = Math.min(t, res);
            }
            //比较第一个和最后一个
            int time = max - minsList.get(minsList.size() - 1) + minsList.get(0);
            res = Math.min(time, res);
            return res;
        }

        //转化成分钟数
        public int convertToMinus(String time) {
            return time.charAt(0) * 600 + time.charAt(1) * 60 + time.charAt(3) * 10 + time.charAt(4) * 1;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
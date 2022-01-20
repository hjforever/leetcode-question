//给你一个日期，请你设计一个算法来判断它是对应一周中的哪一天。
//
// 输入为三个整数：day、month 和 year，分别表示日、月、年。 
//
// 您返回的结果必须是这几个值中的一个 {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", 
//"Friday", "Saturday"}。 
//
// 
//
// 示例 1： 
//
// 输入：day = 31, month = 8, year = 2019
//输出："Saturday"
// 
//
// 示例 2： 
//
// 输入：day = 18, month = 7, year = 1999
//输出："Sunday"
// 
//
// 示例 3： 
//
// 输入：day = 15, month = 8, year = 1993
//输出："Sunday"
// 
//
// 
//
// 提示： 
//
// 
// 给出的日期一定是在 1971 到 2100 年之间的有效日期。 
// 
// Related Topics 数学 👍 108 👎 0


package io.hjforever.leetcode.editor.cn;

public class Q1185YiZhouZhongDeDiJiTian {
    public static void main(String[] args) {
        Solution solution = new Q1185YiZhouZhongDeDiJiTian().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String dayOfTheWeek(int d, int m, int y) {
            //基姆拉尔森计算公式
            //m 是月份。m 的取值范围是 3 至 14，因为某年的 1、2 月要看作上一年的 13、14月
            // 返回0到6 ，对应的星期需要加1
            //Week=(Day + 2*Month + 3*(Month+1）/5 + Year + Year/4 - Year/100 + Year/400) % 7
            String[] weeks = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
            if (m < 3) {
                m += 12;
                --y;
            }
            int D = y + y / 4 - y / 100 + y / 400 + 2 * m + 3 * (m + 1) / 5 + d + 1;
            return weeks[D % 7];

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
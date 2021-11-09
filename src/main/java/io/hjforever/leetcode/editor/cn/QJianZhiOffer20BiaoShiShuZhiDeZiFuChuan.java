//请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
//
// 数值（按顺序）可以分成以下几个部分： 
//
// 
// 若干空格 
// 一个 小数 或者 整数 
// （可选）一个 'e' 或 'E' ，后面跟着一个 整数 
// 若干空格 
// 
//
// 小数（按顺序）可以分成以下几个部分： 
//
// 
// （可选）一个符号字符（'+' 或 '-'） 
// 下述格式之一：
// 
// 至少一位数字，后面跟着一个点 '.' 
// 至少一位数字，后面跟着一个点 '.' ，后面再跟着至少一位数字 
// 一个点 '.' ，后面跟着至少一位数字 
// 
// 
// 
//
// 整数（按顺序）可以分成以下几个部分： 
//
// 
// （可选）一个符号字符（'+' 或 '-'） 
// 至少一位数字 
// 
//
// 部分数值列举如下： 
//
// 
// ["+100", "5e2", "-123", "3.1416", "-1E-16", "0123"] 
// 
//
// 部分非数值列举如下： 
//
// 
// ["12e", "1a3.14", "1.2.3", "+-5", "12e+5.4"] 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "0"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：s = "e"
//输出：false
// 
//
// 示例 3： 
//
// 
//输入：s = "."
//输出：false 
//
// 示例 4： 
//
// 
//输入：s = "    .1  "
//输出：true
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 20 
// s 仅含英文字母（大写和小写），数字（0-9），加号 '+' ，减号 '-' ，空格 ' ' 或者点 '.' 。 
// 
// Related Topics 字符串 👍 257 👎 0


package io.hjforever.leetcode.editor.cn;

public class QJianZhiOffer20BiaoShiShuZhiDeZiFuChuan {
    public static void main(String[] args) {
        Solution solution = new QJianZhiOffer20BiaoShiShuZhiDeZiFuChuan().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //模式匹配，寻找规律
        public boolean isNumber(String s) {
            if (s == null || s.length() == 0) return false;
            //去掉首位空格
            s = s.trim();
            boolean numFlag = false;
            boolean dotFlag = false;
            boolean eFlag = false;
            for (int i = 0; i < s.length(); i++) {
                //判定为数字，则标记numFlag
                if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                    numFlag = true;
                    //判定为.  需要没出现过.并且没出现过e
                } else if (s.charAt(i) == '.' && !dotFlag && !eFlag) {
                    dotFlag = true;
                    //判定为e，需要没出现过e，并且出过数字了
                } else if ((s.charAt(i) == 'e' || s.charAt(i) == 'E') && !eFlag && numFlag) {
                    eFlag = true;
                    numFlag = false;//为了避免123e这种请求，出现e之后就标志为false
                    //判定为+-符号，只能出现在第一位或者紧接e后面
                } else if ((s.charAt(i) == '+' || s.charAt(i) == '-') && (i == 0 || s.charAt(i - 1) == 'e' || s.charAt(i - 1) == 'E')) {

                    //其他情况，都是非法的
                } else {
                    return false;
                }
            }
            return numFlag;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
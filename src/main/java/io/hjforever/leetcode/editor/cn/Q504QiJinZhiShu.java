//给定一个整数 num，将其转化为 7 进制，并以字符串形式输出。
//
// 
//
// 示例 1: 
//
// 
//输入: num = 100
//输出: "202"
// 
//
// 示例 2: 
//
// 
//输入: num = -7
//输出: "-10"
// 
//
// 
//
// 提示： 
//
// 
// -10⁷ <= num <= 10⁷ 
// 
// Related Topics 数学 👍 124 👎 0


package io.hjforever.leetcode.editor.cn;

public class Q504QiJinZhiShu {
    public static void main(String[] args) {
        Solution solution = new Q504QiJinZhiShu().new Solution();
        System.out.println(solution.convertToBase7(-7));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String convertToBase7(int num) {
            return convertToBase(num, 7);
        }

        //转换任意进制模板
        public String convertToBase(int num, int base) {
            if (num == 0) return "0";
            boolean negative = false;
            StringBuilder sb = new StringBuilder();
            if (num < 0) {
                negative = true;
                num = -num;
            }
            int n = num;
            while (n > 0) {
                int mod = n % base;
                n = n / base;
                if (mod > 9) {
                    char ch = (char) ((mod - 10) + 'a');
                    sb.append(ch);
                } else {
                    sb.append(mod);
                }
            }
            String res = sb.reverse().toString();
            if (negative) {
                res = "-" + res;
            }
            return res;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
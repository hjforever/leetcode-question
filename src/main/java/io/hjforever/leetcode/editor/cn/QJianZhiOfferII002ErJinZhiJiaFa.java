//给定两个 01 字符串 a 和 b ，请计算它们的和，并以二进制字符串的形式输出。
//
// 输入为 非空 字符串且只包含数字 1 和 0。 
//
// 
//
// 示例 1: 
//
// 
//输入: a = "11", b = "10"
//输出: "101" 
//
// 示例 2: 
//
// 
//输入: a = "1010", b = "1011"
//输出: "10101" 
//
// 
//
// 提示： 
//
// 
// 每个字符串仅由字符 '0' 或 '1' 组成。 
// 1 <= a.length, b.length <= 10^4 
// 字符串如果不是 "0" ，就都不含前导零。 
// 
//
// 
//
// 注意：本题与主站 67 题相同：https://leetcode-cn.com/problems/add-binary/ 
// Related Topics 位运算 数学 字符串 模拟 👍 29 👎 0


package io.hjforever.leetcode.editor.cn;

public class QJianZhiOfferII002ErJinZhiJiaFa {
    public static void main(String[] args) {
        Solution solution = new QJianZhiOfferII002ErJinZhiJiaFa().new Solution();
        solution.addBinary("11", "10");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String addBinary(String a, String b) {
            if (a.equals("0") && b.equals("0")) return "0";
            if (a.equals("0") || b.equals("0")) return a.equals("0") ? b : a;
            int m = a.length() - 1;
            int n = b.length() - 1;
            int flag = 0;
            StringBuilder res = new StringBuilder();
            while (m >= 0 && n >= 0) {
                int mm = a.charAt(m) - '0';
                int nn = b.charAt(n) - '0';
                res.append((mm + nn + flag) % 2);
                flag = (mm + nn + flag) / 2;
                m--;
                n--;
            }
            while (m >= 0) {
                int mm = a.charAt(m) - '0';
                res.append((mm + flag) % 2);
                flag = (mm + flag) / 2;
                m--;
            }

            while (n >= 0) {
                int nn = b.charAt(n) - '0';
                res.append((nn + flag) % 2);
                flag = (nn + flag) / 2;
                n--;
            }

            if (flag == 1) {
                res.append("1");
            }
            return res.reverse().toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
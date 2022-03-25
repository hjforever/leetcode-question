//给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
//
// 注意：不能使用任何内置的 BigInteger 库或直接将输入转换为整数。 
//
// 
//
// 示例 1: 
//
// 
//输入: num1 = "2", num2 = "3"
//输出: "6" 
//
// 示例 2: 
//
// 
//输入: num1 = "123", num2 = "456"
//输出: "56088" 
//
// 
//
// 提示： 
//
// 
// 1 <= num1.length, num2.length <= 200 
// num1 和 num2 只能由数字组成。 
// num1 和 num2 都不包含任何前导零，除了数字0本身。 
// 
// Related Topics 数学 字符串 模拟 👍 878 👎 0


package io.hjforever.leetcode.editor.cn;

public class Q43ZiFuChuanXiangCheng {
    public static void main(String[] args) {
        Solution solution = new Q43ZiFuChuanXiangCheng().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String multiply(String num1, String num2) {
            //字符串模拟
            if (num1.equals("0") || num2.equals("0")) {
                return "0";
            }
            int m = num1.length();
            int n = num2.length();
            int[] res = new int[m + n];
            for (int i = m - 1; i >= 0; i--) {
                int n1 = num1.charAt(i) - '0';
                for (int j = n - 1; j >= 0; j--) {
                    int n2 = num2.charAt(j) - '0';
                    int sum = (res[i + j + 1] + n1 * n2);
                    res[i + j + 1] = sum % 10;
                    res[i + j] += sum / 10;
                }
            }
            StringBuilder resutl = new StringBuilder();
            for (int i = 0; i < res.length; i++) {
                if (i == 0 && res[i] == 0) {
                    continue;
                }
                resutl.append(res[i]);
            }
            return resutl.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
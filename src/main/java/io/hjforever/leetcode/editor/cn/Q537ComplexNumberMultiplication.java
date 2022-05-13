//A complex number can be represented as a string on the form "real+imaginaryi"
//where: 
//
// 
// real is the real part and is an integer in the range [-100, 100]. 
// imaginary is the imaginary part and is an integer in the range [-100, 100]. 
// i² == -1. 
// 
//
// Given two complex numbers num1 and num2 as strings, return a string of the 
//complex number that represents their multiplications. 
//
// 
// Example 1: 
//
// 
//Input: num1 = "1+1i", num2 = "1+1i"
//Output: "0+2i"
//Explanation: (1 + i) * (1 + i) = 1 + i2 + 2 * i = 2i, and you need convert it 
//to the form of 0+2i.
// 
//
// Example 2: 
//
// 
//Input: num1 = "1+-1i", num2 = "1+-1i"
//Output: "0+-2i"
//Explanation: (1 - i) * (1 - i) = 1 + i2 - 2 * i = -2i, and you need convert 
//it to the form of 0+-2i.
// 
//
// 
// Constraints: 
//
// 
// num1 and num2 are valid complex numbers. 
// 
// Related Topics 数学 字符串 模拟 👍 136 👎 0


package io.hjforever.leetcode.editor.cn;

public class Q537ComplexNumberMultiplication {
    public static void main(String[] args) {
        Solution solution = new Q537ComplexNumberMultiplication().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String complexNumberMultiply(String num1, String num2) {
            // math monitor
            String[] num1Array = num1.split("\\+");
            String[] num2Array = num2.split("\\+");
            int realNum1 = Integer.parseInt(num1Array[0]);
            int imagNum1 = Integer.parseInt(num1Array[1].substring(0, num1Array[1].length() - 1));

            int realNum2 = Integer.parseInt(num2Array[0]);
            int imagNum2 =  Integer.parseInt(num2Array[1].substring(0, num2Array[1].length() - 1));

            int realNum = realNum1 * realNum2 - (imagNum1 * imagNum2);
            int imagNum = realNum1 * imagNum2 + imagNum1 * realNum2;

            return "" + realNum + "+" + imagNum + "i";

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
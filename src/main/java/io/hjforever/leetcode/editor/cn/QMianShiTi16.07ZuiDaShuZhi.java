//编写一个方法，找出两个数字a和b中最大的那一个。不得使用if-else或其他比较运算符。
// 示例： 
// 输入： a = 1, b = 2
//输出： 2
// 
// Related Topics 位运算 脑筋急转弯 数学 👍 97 👎 0


package io.hjforever.leetcode.editor.cn;

class QMianShiTi1607ZuiDaShuZhi {
    public static void main(String[] args) {
        Solution solution = new QMianShiTi1607ZuiDaShuZhi().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maximum(int a, int b) {
            // return Math.max(a, b);
            //max(a,b) = (|a-b| + a + b)/2
            long c = a;
            long d = b;
            int res = (int) ((Math.abs(c - d) + c + d) / 2);
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
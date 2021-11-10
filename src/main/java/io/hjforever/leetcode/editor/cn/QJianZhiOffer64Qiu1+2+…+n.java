//求 1+2+...+n ，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
//
// 
//
// 示例 1： 
//
// 输入: n = 3
//输出: 6
// 
//
// 示例 2： 
//
// 输入: n = 9
//输出: 45
// 
//
// 
//
// 限制： 
//
// 
// 1 <= n <= 10000 
// 
// Related Topics 位运算 递归 脑筋急转弯 👍 396 👎 0


package io.hjforever.leetcode.editor.cn;

class QJianZhiOffer64Qiu1 {
    public static void main(String[] args) {
        Solution solution = new QJianZhiOffer64Qiu1().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int sumNums(int n) {
            //数学公式,但是题意不允许用乘法及循环语句
            // 1 + 2 + 3...+n = n(n-1)
            //语法特性
            //return IntStream.range(1,n+1).sum();
            //return n * (n + 1) / 2;

            //递归代替for
            boolean flag = n > 0 && (n += sumNums(n - 1)) > 0;
            return n;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
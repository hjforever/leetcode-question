//0,1,···,n-1这n个数字排成一个圆圈，从数字0开始，每次从这个圆圈里删除第m个数字（删除后从下一个数字开始计数）。求出这个圆圈里剩下的最后一个数字。
// 
//
// 例如，0、1、2、3、4这5个数字组成一个圆圈，从数字0开始每次删除第3个数字，则删除的前4个数字依次是2、0、4、1，因此最后剩下的数字是3。 
//
// 
//
// 示例 1： 
//
// 
//输入: n = 5, m = 3
//输出: 3
// 
//
// 示例 2： 
//
// 
//输入: n = 10, m = 17
//输出: 2
// 
//
// 
//
// 限制： 
//
// 
// 1 <= n <= 10^5 
// 1 <= m <= 10^6 
// 
// Related Topics 递归 数学 👍 474 👎 0


package io.hjforever.leetcode.editor.cn;

public class QJianZhiOffer62YuanQuanZhongZuiHouShengXiaDeShuZi {
    public static void main(String[] args) {
        Solution solution = new QJianZhiOffer62YuanQuanZhongZuiHouShengXiaDeShuZi().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int lastRemaining(int n, int m) {
            //数学取余
            // 上一个 index = (cur index + m)%n(剩余的个数)
            //最后剩下一个数字的坐标为0则 上一轮剩余个数为2 则 index = (0+m)%2
            int x = 0;
            for (int i = 2; i <= n; i++) {
                x = (x + m) % i;
            }
            return x;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
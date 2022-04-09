//给定四个整数 sx , sy ，tx 和 ty，如果通过一系列的转换可以从起点 (sx, sy) 到达终点 (tx, ty)，则返回 true，否则返回
//false。 
//
// 从点 (x, y) 可以转换到 (x, x+y) 或者 (x+y, y)。 
//
// 
//
// 示例 1: 
//
// 
//输入: sx = 1, sy = 1, tx = 3, ty = 5
//输出: true
//解释:
//可以通过以下一系列转换从起点转换到终点：
//(1, 1) -> (1, 2)
//(1, 2) -> (3, 2)
//(3, 2) -> (3, 5)
// 
//
// 示例 2: 
//
// 
//输入: sx = 1, sy = 1, tx = 2, ty = 2 
//输出: false
// 
//
// 示例 3: 
//
// 
//输入: sx = 1, sy = 1, tx = 1, ty = 1 
//输出: true
// 
//
// 
//
// 提示: 
//
// 
// 1 <= sx, sy, tx, ty <= 10⁹ 
// 
// Related Topics 数学 👍 215 👎 0


package io.hjforever.leetcode.editor.cn;

public class Q780DaoDaZhongDian {
    public static void main(String[] args) {
        Solution solution = new Q780DaoDaZhongDian().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean reachingPoints(int sx, int sy, int tx, int ty) {
            //逆向思维 ,  因x>0 , y>0 ,则可以从结果反推，总是大的减去小的
            while (tx > sx && ty > sy && tx != ty) {
                if (tx > ty) {
                    tx %= ty;
                } else {
                    ty %= tx;
                }
            }
            if (sx == tx && sy == ty) {
                return true;
            } else if (tx == sx) {
                return ty > sy && (ty - sy) % tx == 0;
            } else if (ty == sy) {
                return tx > sx && (tx - sx) % ty == 0;
            } else {
                return false;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
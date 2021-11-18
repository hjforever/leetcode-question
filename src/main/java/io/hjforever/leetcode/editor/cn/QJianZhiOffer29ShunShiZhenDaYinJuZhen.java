//输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
//
// 
//
// 示例 1： 
//
// 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
//输出：[1,2,3,6,9,8,7,4,5]
// 
//
// 示例 2： 
//
// 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
//输出：[1,2,3,4,8,12,11,10,9,5,6,7]
// 
//
// 
//
// 限制： 
//
// 
// 0 <= matrix.length <= 100 
// 0 <= matrix[i].length <= 100 
// 
//
// 注意：本题与主站 54 题相同：https://leetcode-cn.com/problems/spiral-matrix/ 
// Related Topics 数组 矩阵 模拟 👍 311 👎 0


package io.hjforever.leetcode.editor.cn;

import java.util.Arrays;

public class QJianZhiOffer29ShunShiZhenDaYinJuZhen {
    public static void main(String[] args) {
        Solution solution = new QJianZhiOffer29ShunShiZhenDaYinJuZhen().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] spiralOrder(int[][] matrix) {
            if (matrix == null || matrix.length == 0) {
                return new int[0];
            }
            //行
            int rl = 0, rh = matrix.length - 1;
            //列
            int cl = 0, ch = matrix[0].length - 1;
            int[] result = new int[(rh + 1) * (ch + 1)];
            int k = 0;
            while (true) {
                //从左往右 , 行不变，列变
                for (int i = cl; i <= ch; i++) {
                    result[k++] = matrix[rl][i];
                    //System.out.println(result[0]);
                }
                //从上往下，先判定是否行数超出限制
                if (++rl > rh) break;
                //从上往下, 行变，列不变
                for (int i = rl; i <= rh; i++) {
                    result[k++] = matrix[i][ch];
                }
                //后续要从右往左，需要判定列是否超出限制
                if (--ch < cl) break;

                //从右往左，行不变，列变
                for (int i = ch; i >= cl; i--) {
                    result[k++] = matrix[rh][i];
                }
                //后续要从下往上，需要判定行是否超出限制
                if (--rh < rl) break;
                //从下往上 列不变，行变
                for (int i = rh; i >= rl; i--) {
                    result[k++] = matrix[i][cl];
                }
                //后续是从右往左，故需要判定列是否超出限制
                if (++cl > ch) break;
            }

            return result;
//            int rl = 0, rh = matrix.size()-1; //记录待打印的矩阵上下边缘
//            int cl = 0, ch = matrix[0].size()-1; //记录待打印的矩阵左右边缘
//            while(1){
//                for(int i=cl; i<=ch; i++) res.push_back(matrix[rl][i]);//从左往右
//                if(++rl > rh) break; //若超出边界，退出
//                for(int i=rl; i<=rh; i++) res.push_back(matrix[i][ch]);//从上往下
//                if(--ch < cl) break;
//                for(int i=ch; i>=cl; i--) res.push_back(matrix[rh][i]);//从右往左
//                if(--rh < rl) break;
//                for(int i=rh; i>=rl; i--) res.push_back(matrix[i][cl]);//从下往上
//                if(++cl > ch) break;
//            }
//            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
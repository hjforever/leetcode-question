//输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。
//
// 示例 1: 
//
// 输入: n = 1
//输出: [1,2,3,4,5,6,7,8,9]
// 
//
// 
//
// 说明： 
//
// 
// 用返回一个整数列表来代替打印 
// n 为正整数 
// 
// Related Topics 数组 数学 👍 160 👎 0


package io.hjforever.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.function.ToIntFunction;

public class QJianZhiOffer17DaYinCong1DaoZuiDaDenWeiShu {
    public static void main(String[] args) {
        Solution solution = new QJianZhiOffer17DaYinCong1DaoZuiDaDenWeiShu().new Solution();

        solution.dfs(2, "");

        //System.out.println(Arrays.toString(res));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<String> res = new ArrayList<>();

        public int[] printNumbers(int n) {
            //此题与原题意不符，返回参数应该是string[]
            //1. 字符串相加，即大数相加
            //2.全排列
            for (int i = 1; i <= n; i++) {
                dfs(i, "");
            }
            return res.stream().mapToInt(value -> Integer.valueOf(value)).toArray();
        }

        //n位数全排列
        void dfs(int n, String path) {
            if (path.length() == n) {
                res.add(path);
                return;
            }
            if (path.length() == 0) {
                //消除前缀0
                for (char c = '1'; c <= '9'; c++) {
                    dfs(n, path + c);
                }
            } else {
                for (char c = '0'; c <= '9'; c++) {
                    dfs(n, path + c);
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
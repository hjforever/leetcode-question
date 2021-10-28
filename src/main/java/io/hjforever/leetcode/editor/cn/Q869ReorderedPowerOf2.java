//给定正整数 N ，我们按任何顺序（包括原始顺序）将数字重新排序，注意其前导数字不能为零。
//
// 如果我们可以通过上述方式得到 2 的幂，返回 true；否则，返回 false。 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 输入：1
//输出：true
// 
//
// 示例 2： 
//
// 输入：10
//输出：false
// 
//
// 示例 3： 
//
// 输入：16
//输出：true
// 
//
// 示例 4： 
//
// 输入：24
//输出：false
// 
//
// 示例 5： 
//
// 输入：46
//输出：true
// 
//
// 
//
// 提示： 
//
// 
// 1 <= N <= 10^9 
// 
// Related Topics 数学 计数 枚举 排序 👍 98 👎 0


package io.hjforever.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class Q869ReorderedPowerOf2 {
    public static void main(String[] args) {
        Solution solution = new Q869ReorderedPowerOf2().new Solution();
        solution.reorderedPowerOf2(16);
        //solution.isreOrder(16, solution.numLenght(16));
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        //根据有限的范围先求出符合条件的值，然后在和输入参数比较是否一致
        public boolean reorderedPowerOf2(int n) {
            if (n == 1 || n == 2 || n == 4) {
                return true;
            }
            List<String> list = numToStringList(n);
            //此处可以剪枝
            int maxValue = (int) Math.pow(10, list.size());
            //获取对应范围内所有的2次幂数然后和输入参数n判定
            for (int i = 1; i <= maxValue; i <<= 1) {
                //判断是否成立
                if (preOrderSame(i, list)) {
                    return true;
                }
            }
            return false;
        }

        List<String> numToStringList(int m) {
            int n = m;
            List<String> list = new ArrayList<>();
            while (n >= 10) {
                int mod = n % 10;
                list.add(String.valueOf(mod));
                n = n / 10;
            }
            list.add(String.valueOf(n));
            return list;
        }

        boolean preOrderSame(int n, List<String> list) {
            List<String> orderList = numToStringList(n);
            if (list.size() != orderList.size()) {
                return false;
            }
            for (String s : list) {
                orderList.remove(s);
            }
            return orderList.isEmpty();
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
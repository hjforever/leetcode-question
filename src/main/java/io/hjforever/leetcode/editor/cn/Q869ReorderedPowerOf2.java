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
            int max = (int) 1e9;
            String nStr = String.valueOf(n);
            int[] cnt = new int[10];
            for (int i = 0; i < nStr.length(); i++) {
                cnt[nStr.charAt(i) - '0']++;
            }
            for (int i = 1; i <= max; i = i << 1) {
                String s = String.valueOf(i);
                if (s.length() == nStr.length() && check(cnt, String.valueOf(i))) {
                    return true;
                }
            }
            return false;
        }

        boolean check(int[] cnt, String s2) {
            int[] ct2 = new int[10];
            for (int i = 0; i < s2.length(); i++) {
                ct2[s2.charAt(i) - '0']++;
            }
            for (int i = 0; i < 10; i++) {
                if (cnt[i] != ct2[i]) return false;
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
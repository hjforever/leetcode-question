//给定两个整数，分别表示分数的分子 numerator 和分母 denominator，以 字符串形式返回小数 。
//
// 如果小数部分为循环小数，则将循环的部分括在括号内。 
//
// 如果存在多个答案，只需返回 任意一个 。 
//
// 对于所有给定的输入，保证 答案字符串的长度小于 10⁴ 。 
//
// 
//
// 示例 1： 
//
// 
//输入：numerator = 1, denominator = 2
//输出："0.5"
// 
//
// 示例 2： 
//
// 
//输入：numerator = 2, denominator = 1
//输出："2"
// 
//
// 示例 3： 
//
// 
//输入：numerator = 4, denominator = 333
//输出："0.(012)"
// 
//
// 
//
// 提示： 
//
// 
// -2³¹ <= numerator, denominator <= 2³¹ - 1 
// denominator != 0 
// 
// Related Topics 哈希表 数学 字符串 👍 375 👎 0


package io.hjforever.leetcode.editor.cn;

import jdk.internal.org.objectweb.asm.Handle;

import java.util.HashMap;
import java.util.Map;

public class Q166FenShuDaoXiaoShu {
    public static void main(String[] args) {
        Solution solution = new Q166FenShuDaoXiaoShu().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String fractionToDecimal(int numerator, int denominator) {
            //当出现相同的余数时则表示有循环小数
            StringBuilder res = new StringBuilder();
            long nume = numerator;
            long denomi = denominator;
            if (nume % denomi == 0) return String.valueOf(nume / denomi);
            if (nume * denomi < 0) {
                res.append("-");
            }
            nume = Math.abs(nume);
            denomi = Math.abs(denomi);

            res.append((nume / denomi)).append(".");
            nume = nume % denomi;
            Map<Long, Integer> map = new HashMap<>();
            while (nume != 0) {
                map.put(nume, res.length());
                nume *= 10;
                res.append(nume / denomi);
                nume = nume % denomi;
                if (map.containsKey(nume)) {
                    int u = map.get(nume);
                    return String.format("%s(%s)", res.substring(0, u), res.substring(u));
                }
            }
            return res.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
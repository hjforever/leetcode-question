//给定两个字符串 a 和 b，寻找重复叠加字符串 a 的最小次数，使得字符串 b 成为叠加后的字符串 a 的子串，如果不存在则返回 -1。
//
// 注意：字符串 "abc" 重复叠加 0 次是 ""，重复叠加 1 次是 "abc"，重复叠加 2 次是 "abcabc"。 
//
// 
//
// 示例 1： 
//
// 输入：a = "abcd", b = "cdabcdab"
//输出：3
//解释：a 重复叠加三遍后为 "abcdabcdabcd", 此时 b 是其子串。
// 
//
// 示例 2： 
//
// 输入：a = "a", b = "aa"
//输出：2
// 
//
// 示例 3： 
//
// 输入：a = "a", b = "a"
//输出：1
// 
//
// 示例 4： 
//
// 输入：a = "abc", b = "wxyz"
//输出：-1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= a.length <= 10⁴ 
// 1 <= b.length <= 10⁴ 
// a 和 b 由小写英文字母组成 
// 
// Related Topics 字符串 字符串匹配 👍 166 👎 0


package io.hjforever.leetcode.editor.cn;

public class Q686ZhongFuDieJiaZiFuChuanPiPei {
    public static void main(String[] args) {
        Solution solution = new Q686ZhongFuDieJiaZiFuChuanPiPei().new Solution();
        System.out.println(solution.repeatedStringMatch("abcd", "cdabcdab"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int repeatedStringMatch(String a, String b) {
            if (a.equals("") && !b.equals("")) {
                return -1;
            }
            if (b.equals("") && !a.equals("")) {
                return 0;
            }
            if (a.equals(b)) {
                return 1;
            }
            //判断字符是否是子集
            StringBuilder aTemp = new StringBuilder(a);
            int maxSize = (b.length()) / (a.length()) + 1;
            int size = 1;
            int mathIndex = 0;
            boolean find = false;
            while (true) {
                if (aTemp.length() >= b.length()) {
                    char head = b.charAt(0);
                    for (int i = mathIndex; i < aTemp.length(); i++) {
                        if (aTemp.charAt(i) == head) {
                            mathIndex = i;
                            find = true;
                            //判断是否为子串  ab cabc , cabc ,
                            if (aTemp.length() - i >= b.length()) {
                                String sub = aTemp.substring(i, i + b.length());
                                if (b.equals(sub)) {
                                    return size;
                                }
                                mathIndex++;
                            } else {
                                break;
                            }
                        }
                    }
                    if (!find || size > maxSize) {
                        return -1;
                    }
                }
                aTemp = aTemp.append(a);
                size++;
            }
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
//给你一个字符串 S，返回只含 单一字母 的子串个数。
//
// 示例 1： 
//
// 输入： "aaaba"
//输出： 8
//解释： 
//只含单一字母的子串分别是 "aaa"， "aa"， "a"， "b"。
//"aaa" 出现 1 次。
//"aa" 出现 2 次。
//"a" 出现 4 次。
//"b" 出现 1 次。
//所以答案是 1 + 2 + 4 + 1 = 8。
// 
//
// 示例 2: 
//
// 输入： "aaaaaaaaaa"
//输出： 55
// 
//
// 
//
// 提示： 
//
// 
// 1 <= S.length <= 1000 
// S[i] 仅由小写英文字母组成。 
// 
// Related Topics 数学 字符串 👍 30 👎 0


package io.hjforever.leetcode.editor.cn;

public class Q1180TongJiZhiHanDanYiZiMuDeZiChuan {
    public static void main(String[] args) {
        Solution solution = new Q1180TongJiZhiHanDanYiZiMuDeZiChuan().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countLetters(String s) {
            if (s == null || s.length() == 0) return 0;
            if (s.length() == 1) return 1;
            int left = 0;
            int right = 1;
            int sum = 0;
            //加入一个末尾标识来判断最后一个元素，必须不存在字符串中
            s = s + "A";
            char[] ch = s.toCharArray();
            while (right < s.length()) {
                if (ch[right] != ch[left]) {
                    int k = right - left;
                    sum += k * (k + 1) / 2;
                    left = right;
                }
                right++;
            }
            return sum;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
//给定两个字符串 s 和 t ，如果它们的编辑距离为 1 ，则返回 true ，否则返回 false 。
//
// 字符串 s 和字符串 t 之间满足编辑距离等于 1 有三种可能的情形： 
//
// 
// 往 s 中插入 恰好一个 字符得到 t 
// 从 s 中删除 恰好一个 字符得到 t 
// 在 s 中用 一个不同的字符 替换 恰好一个 字符得到 t 
// 
//
// 
//
// 示例 1： 
//
// 
//输入: s = "ab", t = "acb"
//输出: true
//解释: 可以将 'c' 插入字符串 s 来得到 t。
// 
//
// 示例 2: 
//
// 
//输入: s = "cab", t = "ad"
//输出: false
//解释: 无法通过 1 步操作使 s 变为 t。 
//
// 
//
// 提示: 
//
// 
// 0 <= s.length, t.length <= 10⁴ 
// s 和 t 由小写字母，大写字母和数字组成 
// 
// Related Topics 双指针 字符串 👍 100 👎 0


package io.hjforever.leetcode.editor.cn;

public class Q161XiangGeWei1DeBianJiJuLi {
    public static void main(String[] args) {
        Solution solution = new Q161XiangGeWei1DeBianJiJuLi().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isOneEditDistance(String s, String t) {
            // 间隔为1 说明只有一位不相同
            if (s.equals(t)) return false;
            int sLen = s.length();
            int tLen = t.length();

            // if (sLen == 1 && tLen == 1) return !s.equals(t);
            //长度差大于1则肯定间隔大于1
            if (Math.abs(sLen - tLen) > 1) return false;

            if (sLen > tLen) {
                return isOneEditDistance(t, s);
            }
            for (int i = 0; i < sLen; i++) {
                if (s.charAt(i) != t.charAt(i)) {
                    if (sLen == tLen) {
                        //相同则后续必须全部相同
                        return s.substring(i + 1).equals(t.substring(i + 1));
                    } else {
                        //t - s ==1
                        return s.substring(i).equals(t.substring(i + 1));
                    }
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
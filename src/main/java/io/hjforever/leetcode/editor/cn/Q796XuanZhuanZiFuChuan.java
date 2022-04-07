//给定两个字符串, s 和 goal。如果在若干次旋转操作之后，s 能变成 goal ，那么返回 true 。
//
// s 的 旋转操作 就是将 s 最左边的字符移动到最右边。 
//
// 
// 例如, 若 s = 'abcde'，在旋转一次之后结果就是'bcdea' 。 
// 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "abcde", goal = "cdeab"
//输出: true
// 
//
// 示例 2: 
//
// 
//输入: s = "abcde", goal = "abced"
//输出: false
// 
//
// 
//
// 提示: 
//
// 
// 1 <= s.length, goal.length <= 100 
// s 和 goal 由小写英文字母组成 
// 
// Related Topics 字符串 字符串匹配 👍 208 👎 0


package io.hjforever.leetcode.editor.cn;

public class Q796XuanZhuanZiFuChuan {
    public static void main(String[] args) {
        Solution solution = new Q796XuanZhuanZiFuChuan().new Solution();
        System.out.println(solution.rotateString("gcmbf", "fgcmb"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean rotateString(String s, String goal) {
            //return rotateStringMonitor(s, goal);
            return rotatesubStringCompare(s, goal);
        }

        public boolean rotateStringMonitor(String s, String goal) {
            //1.常规模拟思维
            if (s.length() != goal.length()) {
                return false;
            }
            if (s.equals(goal)) return true;
            //寻找在哪出是否旋转
            for (int i = 1; i < s.length(); i++) {
                String right = s.substring(0, i);
                String left = s.substring(i);
                String str = left.concat(right);
                if (str.equals(goal)) {
                    return true;
                }
            }
            return false;
        }

        //2.子串比较
        public boolean rotatesubStringCompare(String s, String goal) {
            return s.length() == goal.length() && (s + s).contains(goal);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
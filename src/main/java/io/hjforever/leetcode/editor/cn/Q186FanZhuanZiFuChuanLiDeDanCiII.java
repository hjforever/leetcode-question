//给定一个字符串，逐个翻转字符串中的每个单词。
//
// 示例： 
//
// 输入: ["t","h","e"," ","s","k","y"," ","i","s"," ","b","l","u","e"]
//输出: ["b","l","u","e"," ","i","s"," ","s","k","y"," ","t","h","e"] 
//
// 注意： 
//
// 
// 单词的定义是不包含空格的一系列字符 
// 输入字符串中不会包含前置或尾随的空格 
// 单词与单词之间永远是以单个空格隔开的 
// 
//
// 进阶：使用 O(1) 额外空间复杂度的原地解法。 
// Related Topics 双指针 字符串 👍 77 👎 0


package io.hjforever.leetcode.editor.cn;

public class Q186FanZhuanZiFuChuanLiDeDanCiII {
    public static void main(String[] args) {
        Solution solution = new Q186FanZhuanZiFuChuanLiDeDanCiII().new Solution();
        solution.reverseWords(new char[]{'t', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e' });
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void reverseWords(char[] s) {
            // without allocating extra space
            // 不开辟任何空间，直接在原数组中操作
            // 1. reverse array
            // 2. reverse word
            reverse(s, 0, s.length - 1);
            int j = 0;
            for (int i = 0; i < s.length; i++) {
                if (i > 0 && s[i] == ' ') {
                    reverse(s, j, i - 1);
                    j = i + 1;
                }

            }
            reverse(s, j, s.length - 1);
        }

        void reverse(char[] s, int i, int j) {
            int l = i;
            int r = j;
            while (l < r) {
                char temp = s[r];
                s[r] = s[l];
                s[l] = temp;
                l++;
                r--;
            }
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
//我们定义，在以下情况时，单词的大写用法是正确的：
//
// 
// 全部字母都是大写，比如 "USA" 。 
// 单词中所有字母都不是大写，比如 "leetcode" 。 
// 如果单词不只含有一个字母，只有首字母大写， 比如 "Google" 。 
// 
//
// 给你一个字符串 word 。如果大写用法正确，返回 true ；否则，返回 false 。 
//
// 
//
// 示例 1： 
//
// 
//输入：word = "USA"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：word = "FlaG"
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= word.length <= 100 
// word 由小写和大写英文字母组成 
// 
// Related Topics 字符串 👍 188 👎 0


package io.hjforever.leetcode.editor.cn;

public class Q520JianCeDaXieZiMu {
    public static void main(String[] args) {
        Solution solution = new Q520JianCeDaXieZiMu().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean detectCapitalUse(String word) {
            if (word == null || word.length() == 0 || word.length() == 1) {
                return true;
            }
            //三种情况
            //1.全大写
            if (word.equals(word.toUpperCase())) {
                return true;
            }
            //2.全小写
            if (word.equals(word.toLowerCase())) {
                return true;
            }
            //第一个字母大写第二个小写
            if (Character.isUpperCase(word.charAt(0))) {
                //判断后续是否是小写
                for (int i = 1; i < word.length(); i++) {
                    if (Character.isUpperCase(word.charAt(i))) {
                        return false;
                    }
                }
                return true;
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
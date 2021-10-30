//给你一个字符串数组 words ，只返回可以使用在 美式键盘 同一行的字母打印出来的单词。键盘如下图所示。
//
// 美式键盘 中： 
//
// 
// 第一行由字符 "qwertyuiop" 组成。 
// 第二行由字符 "asdfghjkl" 组成。 
// 第三行由字符 "zxcvbnm" 组成。 
// 
//
// 
//
// 
//
// 示例 1： 
//
// 
//输入：words = ["Hello","Alaska","Dad","Peace"]
//输出：["Alaska","Dad"]
// 
//
// 示例 2： 
//
// 
//输入：words = ["omk"]
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：words = ["adsdf","sfd"]
//输出：["adsdf","sfd"]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= words.length <= 20 
// 1 <= words[i].length <= 100 
// words[i] 由英文字母（小写和大写字母）组成 
// 
// Related Topics 数组 哈希表 字符串 👍 141 👎 0


package io.hjforever.leetcode.editor.cn;

import java.util.*;

public class Q500KeyboardRow {
    public static void main(String[] args) {
        Solution solution = new Q500KeyboardRow().new Solution();
        solution.findWords(new String[]{"Hello", "Alaska", "Dad", "Peace"});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        List<Map<Character, Character>> dictList = new ArrayList<>();


        public String[] findWords(String[] words) {
            initDict();
            if (words == null || words.length == 0) {
                return new String[0];
            }
            List<String> result = new ArrayList<>();
            for (String world : words) {
                if (inOneLine(world)) {
                    result.add(world);
                }
            }
            return result.toArray(new String[result.size()]);
        }

        //初始化字典
        void initDict() {
            //初始化
            String[] dicts = {"qwertyuiop", "asdfghjkl", "zxcvbnm"};
            for (String s : dicts) {
                Map<Character, Character> map = new HashMap<>();
                for (int i = 0; i < s.length(); i++) {
                    map.put(s.charAt(i), s.charAt(i));
                }
                dictList.add(map);
            }
        }

        //Word in one line
        boolean inOneLine(String word) {
            word = word.toLowerCase();
            for (Map<Character, Character> map : dictList) {
                boolean flag = true;
                for (int i = 0; i < word.length(); i++) {
                    Character character = word.charAt(i);
                    if (!map.containsKey(character)) {
                        flag = false;
                        break;
                    }
                }
                if (flag == true) {
                    return true;
                }
            }
            return false;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
//给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
//
// 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。 
//
// 
//
// 
//
// 示例 1： 
//
// 
//输入：digits = "23"
//输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
// 
//
// 示例 2： 
//
// 
//输入：digits = ""
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：digits = "2"
//输出：["a","b","c"]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= digits.length <= 4 
// digits[i] 是范围 ['2', '9'] 的一个数字。 
// 
// Related Topics 哈希表 字符串 回溯 👍 1585 👎 0


package io.hjforever.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class Q17DianHuaHaoMaDeZiMuZuHe {
    public static void main(String[] args) {
        Solution solution = new Q17DianHuaHaoMaDeZiMuZuHe().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<String> res = new ArrayList<>();

        public List<String> letterCombinations(String digits) {
            if (digits == null || digits.length() == 0) {
                return res;
            }
            List<List<String>> list = toList(digits);
            //回溯解决
            backTrack(list, "", 0);
            return res;
        }

        void backTrack(List<List<String>> list, String sub, int length) {
            //确定退出条件
            if (list.size() == length) {
                res.add(sub);
                return;
            }
            String temp = sub;
            for (int i = 0; i < list.get(length).size(); i++) {
                String str = list.get(length).get(i);
                sub = temp + str;
                backTrack(list, sub, length + 1);
                //回退
                sub = temp;
            }
        }

        private List<List<String>> toList(String digits) {
            List<List<String>> result = new ArrayList<>();
            //选取
            for (int i = 0; i < digits.length(); i++) {
                List<String> list = new ArrayList<>();
                char c = digits.charAt(i);
                switch (c) {
                    case '2':
                        list.add("a");
                        list.add("b");
                        list.add("c");
                        break;
                    case '3':
                        list.add("d");
                        list.add("e");
                        list.add("f");
                        break;
                    case '4':
                        list.add("g");
                        list.add("h");
                        list.add("i");
                        break;
                    case '5':
                        list.add("j");
                        list.add("k");
                        list.add("l");
                        break;
                    case '6':
                        list.add("m");
                        list.add("n");
                        list.add("o");
                        break;
                    case '7':
                        list.add("p");
                        list.add("q");
                        list.add("r");
                        list.add("s");
                        break;
                    case '8':
                        list.add("t");
                        list.add("u");
                        list.add("v");
                        break;
                    case '9':
                        list.add("w");
                        list.add("x");
                        list.add("y");
                        list.add("z");
                        break;
                }
                result.add(list);
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
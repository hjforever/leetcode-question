//给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
//
// 
//
// 示例： 
//
// s = "leetcode"
//返回 0
//
//s = "loveleetcode"
//返回 2
// 
//
// 
//
// 提示：你可以假定该字符串只包含小写字母。 
// Related Topics 队列 哈希表 字符串 计数 👍 478 👎 0


package io.hjforever.leetcode.editor.cn;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

public class Q387ZiFuChuanZhongDeDiYiGeWeiYiZiFu {
    public static void main(String[] args) {
        Solution solution = new Q387ZiFuChuanZhongDeDiYiGeWeiYiZiFu().new Solution();
        System.out.println(solution.firstUniqChar("lettcode"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int firstUniqChar(String s) {
            if (s == null || s.length() == 0) {
                return -1;
            }
            Map<Character, Integer> coutMap = new LinkedHashMap<>();
            Map<Character, Integer> firstIndexMap = new HashMap<>();
            char[] array = s.toCharArray();
            for (int i = 0; i < array.length; i++) {
                char ch = array[i];
                coutMap.put(ch, coutMap.getOrDefault(ch, 0) + 1);
                if (!firstIndexMap.containsKey(ch)) {
                    firstIndexMap.put(ch, i);
                }
            }
            Character ch = null;
            for (Character character : coutMap.keySet()) {
                if (coutMap.get(character) == 1) {
                    ch = character;
                    break;
                }
            }
            if (ch!=null) {
                return firstIndexMap.get(ch);
            } else {
                return -1;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
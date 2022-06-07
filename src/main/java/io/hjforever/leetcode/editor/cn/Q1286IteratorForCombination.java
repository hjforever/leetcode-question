//Design the CombinationIterator class:
//
// 
// CombinationIterator(string characters, int combinationLength) Initializes 
//the object with a string characters of sorted distinct lowercase English letters 
//and a number combinationLength as arguments. 
// next() Returns the next combination of length combinationLength in 
//lexicographical order. 
// hasNext() Returns true if and only if there exists a next combination. 
// 
//
// 
// Example 1: 
//
// 
//Input
//["CombinationIterator", "next", "hasNext", "next", "hasNext", "next", 
//"hasNext"]
//[["abc", 2], [], [], [], [], [], []]
//Output
//[null, "ab", true, "ac", true, "bc", false]
//
//Explanation
//CombinationIterator itr = new CombinationIterator("abc", 2);
//itr.next();    // return "ab"
//itr.hasNext(); // return True
//itr.next();    // return "ac"
//itr.hasNext(); // return True
//itr.next();    // return "bc"
//itr.hasNext(); // return False
// 
//
// 
// Constraints: 
//
// 
// 1 <= combinationLength <= characters.length <= 15 
// All the characters of characters are unique. 
// At most 10⁴ calls will be made to next and hasNext. 
// It is guaranteed that all calls of the function next are valid. 
// 
// Related Topics 设计 字符串 回溯 迭代器 👍 55 👎 0


package io.hjforever.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class Q1286IteratorForCombination {
    public static void main(String[] args) {
        //Solution solution = new Q1286IteratorForCombination().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class CombinationIterator {

        int idx = 0;

        List<String> res = new ArrayList<>();

        StringBuilder sb = new StringBuilder();

        public CombinationIterator(String characters, int combinationLength) {
            dfs(characters, combinationLength, 0);
        }

        void dfs(String s, int len, int idx) {
            if (sb.length() == len) {
                res.add(sb.toString());
            }
            for (int i = idx; i < s.length(); i++) {
                sb.append(s.charAt(i));
                dfs(s, len, i + 1);
                sb.deleteCharAt(sb.length() - 1);
            }
        }

        public String next() {
            if (hasNext()) {
                return res.get(idx++);
            }
            return "";
        }

        public boolean hasNext() {
            if (idx >= res.size()) {
                return false;
            }
            return true;
        }
    }

/**
 * Your CombinationIterator object will be instantiated and called as such:
 * CombinationIterator obj = new CombinationIterator(characters, combinationLength);
 * String param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
//leetcode submit region end(Prohibit modification and deletion)

}
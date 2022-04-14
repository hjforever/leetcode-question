//请你设计一个数据结构，支持 添加新单词 和 查找字符串是否与任何先前添加的字符串匹配 。
//
// 实现词典类 WordDictionary ： 
//
// 
// WordDictionary() 初始化词典对象 
// void addWord(word) 将 word 添加到数据结构中，之后可以对它进行匹配 
// bool search(word) 如果数据结构中存在字符串与 word 匹配，则返回 true ；否则，返回 false 。word 中可能包含一些 
//'.' ，每个 . 都可以表示任何一个字母。 
// 
//
// 
//
// 示例： 
//
// 
//输入：
//["WordDictionary","addWord","addWord","addWord","search","search","search",
//"search"]
//[[],["bad"],["dad"],["mad"],["pad"],["bad"],[".ad"],["b.."]]
//输出：
//[null,null,null,null,false,true,true,true]
//
//解释：
//WordDictionary wordDictionary = new WordDictionary();
//wordDictionary.addWord("bad");
//wordDictionary.addWord("dad");
//wordDictionary.addWord("mad");
//wordDictionary.search("pad"); // 返回 False
//wordDictionary.search("bad"); // 返回 True
//wordDictionary.search(".ad"); // 返回 True
//wordDictionary.search("b.."); // 返回 True
// 
//
// 
//
// 提示： 
//
// 
// 1 <= word.length <= 25 
// addWord 中的 word 由小写英文字母组成 
// search 中的 word 由 '.' 或小写英文字母组成 
// 最多调用 10⁴ 次 addWord 和 search 
// 
// Related Topics 深度优先搜索 设计 字典树 字符串 👍 417 👎 0


package io.hjforever.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Q211TianJiaYuSouSuoDanCiShuJuJieGouSheJi {
    public static void main(String[] args) {
        //Solution solution = new Q211TianJiaYuSouSuoDanCiShuJuJieGouSheJi().new Solution();
        WordDictionary wordDictionary = new Q211TianJiaYuSouSuoDanCiShuJuJieGouSheJi().new WordDictionary();
        wordDictionary.addWord("at");
        wordDictionary.addWord("and");
        wordDictionary.addWord("an");
        wordDictionary.addWord("add");
        wordDictionary.search("a");
        wordDictionary.search(".at");
        wordDictionary.addWord("bat");
        wordDictionary.search(".at");
        wordDictionary.search("an.");
        wordDictionary.search("a.d");
        wordDictionary.search("b.");
        wordDictionary.search("a.d");
        wordDictionary.search(".");
        System.out.println(wordDictionary.search("b.."));

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class WordDictionary {

        // trie , dfs

        class Trie {
            TrieNode root;

            class TrieNode {
                public boolean end;
                public TrieNode[] child = new TrieNode[26];
            }

            public Trie() {
                this.root = new TrieNode();
            }

            public void add(String s) {
                TrieNode r = root;
                for (int i = 0; i < s.length(); i++) {
                    char ch = s.charAt(i);
                    int index = ch - 'a';
                    if (r.child[index] == null) {
                        r.child[index] = new TrieNode();
                    }
                    r = r.child[index];
                }
                r.end = true;
            }

            public boolean search(String s) {
                return dfs(s, root, 0);
            }

            boolean dfs(String s, TrieNode p, int sIdx) {
                int n = s.length();
                if (n == sIdx) return p.end;
                char c = s.charAt(sIdx);
                if (c == '.') {
                    for (int j = 0; j < 26; j++) {
                        if (p.child[j] != null && dfs(s, p.child[j], sIdx + 1)) return true;
                    }
                    return false;
                } else {
                    int u = c - 'a';
                    if (p.child[u] == null) return false;
                    return dfs(s, p.child[u], sIdx + 1);
                }
            }
        }

        Trie trie;

        public WordDictionary() {
            trie = new Trie();
        }

        public void addWord(String word) {
            trie.add(word);
        }

        public boolean search(String word) {
            return trie.search(word);
        }
    }

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
//leetcode submit region end(Prohibit modification and deletion)

}
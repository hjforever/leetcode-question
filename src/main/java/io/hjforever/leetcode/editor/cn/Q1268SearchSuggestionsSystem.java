//You are given an array of strings products and a string searchWord.
//
// Design a system that suggests at most three product names from products 
//after each character of searchWord is typed. Suggested products should have common 
//prefix with searchWord. If there are more than three products with a common 
//prefix return the three lexicographically minimums products. 
//
// Return a list of lists of the suggested products after each character of 
//searchWord is typed. 
//
// 
// Example 1: 
//
// 
//Input: products = ["mobile","mouse","moneypot","monitor","mousepad"], 
//searchWord = "mouse"
//Output: [
//["mobile","moneypot","monitor"],
//["mobile","moneypot","monitor"],
//["mouse","mousepad"],
//["mouse","mousepad"],
//["mouse","mousepad"]
//]
//Explanation: products sorted lexicographically = ["mobile","moneypot",
//"monitor","mouse","mousepad"]
//After typing m and mo all products match and we show user ["mobile",
//"moneypot","monitor"]
//After typing mou, mous and mouse the system suggests ["mouse","mousepad"]
// 
//
// Example 2: 
//
// 
//Input: products = ["havana"], searchWord = "havana"
//Output: [["havana"],["havana"],["havana"],["havana"],["havana"],["havana"]]
// 
//
// Example 3: 
//
// 
//Input: products = ["bags","baggage","banner","box","cloths"], searchWord = 
//"bags"
//Output: [["baggage","bags","banner"],["baggage","bags","banner"],["baggage",
//"bags"],["bags"]]
// 
//
// 
// Constraints: 
//
// 
// 1 <= products.length <= 1000 
// 1 <= products[i].length <= 3000 
// 1 <= sum(products[i].length) <= 2 * 10⁴ 
// All the strings of products are unique. 
// products[i] consists of lowercase English letters. 
// 1 <= searchWord.length <= 1000 
// searchWord consists of lowercase English letters. 
// 
// Related Topics 字典树 数组 字符串 👍 117 👎 0


package io.hjforever.leetcode.editor.cn;

import java.util.*;

public class Q1268SearchSuggestionsSystem {
    public static void main(String[] args) {
        Solution solution = new Q1268SearchSuggestionsSystem().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<String>> suggestedProducts(String[] products, String searchWord) {
            // trie
            Trie trie = new Trie();
            for (int i = 0; i < products.length; i++) {
                trie.insert(products[i]);
            }
            return trie.search(searchWord);
        }
    }

    class Trie {
        Node root;

        public Trie() {
            this.root = new Node();
        }

        public void insert(String word) {
            Node cur = root;
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                int idx = ch - 'a';
                if (cur.child[idx] == null) {
                    cur.child[idx] = new Node();
                }
                cur = cur.child[idx];
                cur.addWord(word);
            }
            cur.flag = true;
        }

        public List<List<String>> search(String world) {
            List<List<String>> res = new ArrayList<>();
            Node cur = root;
            for (int i = 0; i < world.length(); i++) {
                List<String> sub = new ArrayList<>();
                char ch = world.charAt(i);
                int idx = ch - 'a';
                if (cur != null) {
                    cur = cur.child[idx];
                    sub = cur == null ? new ArrayList<>() : new ArrayList<>(cur.products);
                }
                res.add(sub);
            }
            return res;
        }
    }

    class Node {
        boolean flag;
        Node[] child;
        TreeSet<String> products;

        public Node() {
            flag = false;
            child = new Node[26];
            products = new TreeSet<>();
        }

        public void addWord(String word) {
            products.add(word);
            if (products.size() > 3) {
                products.pollLast();
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
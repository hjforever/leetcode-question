package io.hjforever.leetcode.editor.cn.datastructure;


/**
 * trie，字典树
 */
public class Trie {


    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("app");
        trie.insert("apple");
        trie.insert("appl");
        trie.insert("apple");
        trie.insert("abc");
        trie.insert("abcd");
        trie.insert("bann");
        trie.insert("bannan");
        System.out.println(trie.search("apple"));
        System.out.println(trie.startWith("appl"));
        System.out.println(trie.startWith("apple"));
        System.out.println(trie.startWith("bann"));
        System.out.println(trie.search("bann"));
    }


    class TrieNode {
        protected boolean end;
        protected TrieNode[] child = new TrieNode[26];
    }

    //根节点
    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    /**
     * 插入
     */
    public void insert(String word) {
        TrieNode p = root;
        for (char c : word.toCharArray()) {
            int chIndex = c - 'a';
            //当不存在节点时需要初始化
            if (p.child[chIndex] == null) {
                p.child[chIndex] = new TrieNode();
            }
            //节点向后传递
            p = p.child[chIndex];
        }
        //结尾节点
        p.end = true;
    }

    /**
     * 查找
     */
    public boolean search(String s) {
        TrieNode p = root;
        for (char c : s.toCharArray()) {
            int chIndex = c - 'a';
            if (p.child[chIndex] == null) {
                return false;
            } else {
                p = p.child[chIndex];
            }
        }
        return p.end;
    }

    /**
     * 是否存在以开头的字符串
     */
    public boolean startWith(String s) {
        TrieNode p = root;
        for (char c : s.toCharArray()) {
            int chIndex = c - 'a';
            if (p.child[chIndex] == null) {
                return false;
            } else {
                p = p.child[chIndex];
            }
        }
        return true;
    }
}

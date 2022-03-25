//给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
//
// 字母异位词 是由重新排列源单词的字母得到的一个新单词，所有源单词中的字母通常恰好只用一次。 
//
// 
//
// 示例 1: 
//
// 
//输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
//输出: [["bat"],["nat","tan"],["ate","eat","tea"]] 
//
// 示例 2: 
//
// 
//输入: strs = [""]
//输出: [[""]]
// 
//
// 示例 3: 
//
// 
//输入: strs = ["a"]
//输出: [["a"]] 
//
// 
//
// 提示： 
//
// 
// 1 <= strs.length <= 10⁴ 
// 0 <= strs[i].length <= 100 
// strs[i] 仅包含小写字母 
// 
// Related Topics 哈希表 字符串 排序 👍 1067 👎 0


package io.hjforever.leetcode.editor.cn;

import java.util.*;

public class Q49ZiMuYiWeiCiFenZu {
    public static void main(String[] args) {
        Solution solution = new Q49ZiMuYiWeiCiFenZu().new Solution();
        //solution.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
        long hash1 = solution.hash("huh");
        long hash2 = solution.hash("tit");
        System.out.println(hash1 + ":" + hash2);

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public List<List<String>> groupAnagrams(String[] strs) {
            List<List<String>> res = new ArrayList<>();
            if (strs == null || strs.length == 0) {
                res.add(new ArrayList<>());
                return res;
            }
            if (strs.length == 1) {
                res.add(Collections.singletonList(strs[0]));
                return res;
            }

            //hashmap统计
            Map<Integer, List<String>> map = new HashMap<>();
            for (String str : strs) {
                int len = str.length();
                List<String> list = map.getOrDefault(len, new ArrayList<>());
                list.add(str);
                map.put(len, list);
            }
            for (Integer key : map.keySet()) {
                List<String> list = map.get(key);
                if (list.size() == 1) {
                    res.add(list);
                } else {
                    Map<Long, List<String>> hashMap = new HashMap<>();
                    //根据hash值统计
                    for (String str : list) {
                        long hash = hash(str);
                        List<String> ll = hashMap.getOrDefault(hash, new ArrayList<>());
                        ll.add(str);
                        hashMap.put(hash, ll);
                    }
                    for (long hash : hashMap.keySet()) {
                        res.add(hashMap.get(hash));
                    }
                }
            }
            return res;
        }


        //计算字符串hash值
        public long hash(String str) {

            if ("".equals(str)) {
                return 0;
            }
            long hash = 0;
            for (int i = 0; i < str.length(); i++) {
                int ch = str.charAt(i) - 'a';
                hash += Math.pow(2, ch) * (ch+1);
            }
            return hash;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
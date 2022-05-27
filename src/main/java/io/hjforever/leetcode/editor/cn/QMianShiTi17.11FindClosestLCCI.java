//You have a large text file containing words. Given any two different words,
//find the shortest distance (in terms of number of words) between them in the file.
// If the operation will be repeated many times for the same file (but different 
//pairs of words), can you optimize your solution? 
//
// Example: 
//
// 
//Input: words = ["I","am","a","student","from","a","university","in","a",
//"city"], word1 = "a", word2 = "student"
//Output: 1 
//
// Note: 
//
// 
// words.length <= 100000 
// Related Topics 数组 字符串 👍 45 👎 0


package io.hjforever.leetcode.editor.cn;

class QMianShiTi1711FindClosestLCCI {
    public static void main(String[] args) {
        Solution solution = new QMianShiTi1711FindClosestLCCI().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findClosest(String[] words, String word1, String word2) {


            //two pointer

            int idx1 = -1, idx2 = -1;
            int ans = Integer.MAX_VALUE;
            for (int i = 0; i < words.length; i++) {
                if (words[i].equals(word1)) {
                    idx1 = i;
                } else if (words[i].equals(word2)) {
                    idx2 = i;
                }
                if (idx1 != -1 && idx2 != -1) {
                    ans = Math.min(ans, Math.abs(idx2 - idx1));
                }
            }
            return ans;

            // map
//            Map<String, List<Integer>> dict = new HashMap<>();
//            for (int i = 0; i < words.length; i++) {
//                String word = words[i];
//                List<Integer> list = dict.getOrDefault(word, new ArrayList<>());
//                list.add(i);
//                dict.put(word, list);
//            }
//
//            List<Integer> word1List = dict.get(word1);
//            List<Integer> word2List = dict.get(word2);
//
//            int ans = Integer.MAX_VALUE;
//
//            for (int i = 0; i < word1List.size(); i++) {
//                for (int j = 0; j < word2List.size(); j++) {
//                    ans = Math.min(Math.abs(word1List.get(i) - word2List.get(j)), ans);
//                    if (ans == 1) return ans;
//                }
//            }
//            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
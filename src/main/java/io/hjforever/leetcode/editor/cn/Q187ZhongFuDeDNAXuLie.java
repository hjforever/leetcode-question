//所有 DNA 都由一系列缩写为 'A'，'C'，'G' 和 'T' 的核苷酸组成，例如："ACGAATTCCG"。在研究 DNA 时，识别 DNA 中的重复
//序列有时会对研究非常有帮助。 
//
// 编写一个函数来找出所有目标子串，目标子串的长度为 10，且在 DNA 字符串 s 中出现次数超过一次。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
//输出：["AAAAACCCCC","CCCCCAAAAA"]
// 
//
// 示例 2： 
//
// 
//输入：s = "AAAAAAAAAAAAA"
//输出：["AAAAAAAAAA"]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 10⁵ 
// s[i] 为 'A'、'C'、'G' 或 'T' 
// 
// Related Topics 位运算 哈希表 字符串 滑动窗口 哈希函数 滚动哈希 👍 312 👎 0


package io.hjforever.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q187ZhongFuDeDNAXuLie {
    public static void main(String[] args) {
        Solution solution = new Q187ZhongFuDeDNAXuLie().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> findRepeatedDnaSequences(String s) {
            //1.滑动窗口 + hash
            //return findRepeatedDnaSequencesByWindows(s);
            //2.前缀和 + hash
            return findRepateDnaSequencesByPrefix(s);
        }

        /**
         * 前缀和 + hash
         */
        int N = (int) (1e5 + 10);
        long hash[] = new long[N];
        long p[] = new long[N];
        int P = 131;

        public List<String> findRepateDnaSequencesByPrefix(String s) {
            //1. i<k<j 先求出 i,k,之间的和 则 i,k = sum(k)-sum(j) , i,j = sum(j)-sum(i)
            //2.因数字相加则可能会相同，则需要保证唯一，对每一位保持一个大的次方，防止哈希冲突 假设abc , 则 abc = a*10 +b*100 + c*1000,此处
            //通过10作为次方则大几率冲突，故因找一个大的质数
            //空间换时间
            int n = s.length();
            List<String> res = new ArrayList<>();
            //计算前缀和 数组从1开始计算
            p[0] = 1;
            for (int i = 1; i <= n; i++) {
                hash[i] = hash[i - 1] * P + s.charAt(i - 1);
                p[i] = p[i - 1] * P;
            }

            HashMap<Long, Integer> cnt = new HashMap<>();
            for (int i = 1; i + 10 - 1 <= n; i++) {
                int j = i + 10 - 1;
                long ha = hash[j] - hash[i - 1] * p[j - i + 1];
                int count = cnt.getOrDefault(ha, 0);
                if (count == 1) {
                    res.add(s.substring(i - 1, i + 9));
                }
                cnt.put(ha, count + 1);
            }
            return res;
        }


        /**
         * 滑动窗口 ，即朴素想法，依次遍历子串然后判断是否重复 时间复杂度为 O(n*C)
         *
         * @param s
         * @return
         */
        public List<String> findRepeatedDnaSequencesByWindows(String s) {
            List<String> res = new ArrayList<>();
            if (s.length() < 10) {
                return res;
            }
            Map<String, Integer> map = new HashMap<>();
            int length = s.length();
            for (int i = 0; i + 10 <= length; i++) {
                String sub = s.substring(i, i + 10);
                int cnt = map.getOrDefault(sub, 0);
                if (cnt == 1) {
                    res.add(sub);
                }
                map.put(sub, cnt + 1);
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
//给你一个整数数组 arr 和一个整数 k 。现需要从数组中恰好移除 k 个元素，请找出移除后数组中不同整数的最少数目。
//
// 
// 
//
// 
//
// 示例 1： 
//
// 输入：arr = [5,5,4], k = 1
//输出：1
//解释：移除 1 个 4 ，数组中只剩下 5 一种整数。
// 
//
// 示例 2： 
//
// 输入：arr = [4,3,1,1,3,3,2], k = 3
//输出：2
//解释：先移除 4、2 ，然后再移除两个 1 中的任意 1 个或者三个 3 中的任意 1 个，最后剩下 1 和 3 两种整数。 
//
// 
//
// 提示： 
//
// 
// 1 <= arr.length <= 10^5 
// 1 <= arr[i] <= 10^9 
// 0 <= k <= arr.length 
// 
// Related Topics 贪心 数组 哈希表 计数 排序 👍 44 👎 0


package io.hjforever.leetcode.editor.cn;

import java.util.*;

public class Q1481BuTongZhengShuDeZuiShaoShuMu {
    public static void main(String[] args) {
        Solution solution = new Q1481BuTongZhengShuDeZuiShaoShuMu().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findLeastNumOfUniqueInts(int[] arr, int k) {
            //排序加贪心，每次删除最小个数
            Map<Integer, Integer> cnt = new HashMap<>();
            for (int num : arr) {
                cnt.put(num, cnt.getOrDefault(num, 0) + 1);
            }
            int res = cnt.keySet().size();
            List<Integer> values = new ArrayList<>();
            for (Integer key : cnt.keySet()) {
                values.add(cnt.get(key));
            }
            Collections.sort(values);
            for (int i = 0; i < values.size(); i++) {
                if (k >= values.get(i)) {
                    res--;
                    k -= values.get(i);
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
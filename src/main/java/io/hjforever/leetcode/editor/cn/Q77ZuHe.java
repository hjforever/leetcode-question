//给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
//
// 你可以按 任何顺序 返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 4, k = 2
//输出：
//[
//  [2,4],
//  [3,4],
//  [2,3],
//  [1,2],
//  [1,3],
//  [1,4],
//] 
//
// 示例 2： 
//
// 
//输入：n = 1, k = 1
//输出：[[1]] 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 20 
// 1 <= k <= n 
// 
// Related Topics 数组 回溯 👍 749 👎 0


package io.hjforever.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Q77ZuHe {
    public static void main(String[] args) {
        Solution solution = new Q77ZuHe().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<List<Integer>> res = new ArrayList<>();

        public List<List<Integer>> combine(int n, int k) {
            if (k > n) {
                return res;
            }
            List<Integer> list = new ArrayList<>();
            for (int i = 1; i <= n; i++) {
                list.add(i);
            }
            if (n == k) {
                res.add(list);
                return res;
            } else {
                //回溯
                LinkedList<Integer> reList = new LinkedList<>();
                //start =0 , end n-k+1
                for (int i = 0; i < n - k + 1; i++) {
                    backTrack(list, k, i, reList);
                }
                return res.stream().distinct().collect(Collectors.toList());
            }
        }

        void backTrack(List<Integer> numsList, int k, int start, LinkedList<Integer> list) {
            if (list.size() == k) {
                //Collections.sort(list);
                res.add(new LinkedList<>(list));
                return;
            }
            for (int i = start; i < numsList.size(); i++) {
                if (list.contains(numsList.get(i))) {
                    continue;
                }
                list.addLast(numsList.get(i));
                backTrack(numsList, k, i, list);
                list.removeLast();
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
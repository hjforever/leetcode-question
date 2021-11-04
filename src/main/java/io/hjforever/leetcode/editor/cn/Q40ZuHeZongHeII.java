//给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
//
// candidates 中的每个数字在每个组合中只能使用一次。 
//
// 注意：解集不能包含重复的组合。 
//
// 
//
// 示例 1: 
//
// 
//输入: candidates = [10,1,2,7,6,1,5], target = 8,
//输出:
//[
//[1,1,6],
//[1,2,5],
//[1,7],
//[2,6]
//] 
//
// 示例 2: 
//
// 
//输入: candidates = [2,5,2,1,2], target = 5,
//输出:
//[
//[1,2,2],
//[5]
//] 
//
// 
//
// 提示: 
//
// 
// 1 <= candidates.length <= 100 
// 1 <= candidates[i] <= 50 
// 1 <= target <= 30 
// 
// Related Topics 数组 回溯 👍 723 👎 0


package io.hjforever.leetcode.editor.cn;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Q40ZuHeZongHeII {
    public static void main(String[] args) {
        Solution solution = new Q40ZuHeZongHeII().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        LinkedList<List<Integer>> res = new LinkedList<>();

        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            if (candidates == null || candidates.length == 0) {
                return res;
            }
            Arrays.sort(candidates);
            LinkedList<Integer> list = new LinkedList<>();
            backTrack(candidates, target, 0, 0, list);
            return res.stream().map(list1 -> {
                Collections.sort(list1);
                return list1;
            }).distinct().collect(Collectors.toList());
        }

        void backTrack(int[] candidates, int target, int sum, int left, LinkedList<Integer> list) {
            if (target == sum) {
                res.add(new LinkedList<>(list));
                return;
            }
            if (target < sum) {
                return;
            }
            if (left >= candidates.length) {
                return;
            }
            for (int i = left; i < candidates.length; i++) {
                //关键去重，剪枝，否则会超时
                //当上一个元素与当前的元素相同时则跳过
                if (i > left && candidates[i - 1] == candidates[i]) {
                    continue;
                }
                int num = candidates[i];
                if (sum + num > target) {
                    return;
                }
                list.add(num);
                backTrack(candidates, target, sum + num, i + 1, list);
                list.removeLast();
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
//给定一个无重复元素的正整数数组 candidates 和一个正整数 target ，找出 candidates 中所有可以使数字和为目标数 target 的
//唯一组合。 
//
// candidates 中的数字可以无限制重复被选取。如果至少一个所选数字数量不同，则两种组合是唯一的。 
//
// 对于给定的输入，保证和为 target 的唯一组合数少于 150 个。 
//
// 
//
// 示例 1： 
//
// 
//输入: candidates = [2,3,6,7], target = 7
//输出: [[7],[2,2,3]]
// 
//
// 示例 2： 
//
// 
//输入: candidates = [2,3,5], target = 8
//输出: [[2,2,2,2],[2,3,3],[3,5]] 
//
// 示例 3： 
//
// 
//输入: candidates = [2], target = 1
//输出: []
// 
//
// 示例 4： 
//
// 
//输入: candidates = [1], target = 1
//输出: [[1]]
// 
//
// 示例 5： 
//
// 
//输入: candidates = [1], target = 2
//输出: [[1,1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= candidates.length <= 30 
// 1 <= candidates[i] <= 200 
// candidate 中的每个元素都是独一无二的。 
// 1 <= target <= 500 
// 
// Related Topics 数组 回溯 👍 1609 👎 0


package io.hjforever.leetcode.editor.cn;

import java.util.*;
import java.util.stream.Collectors;

public class Q39ZuHeZongHe {
    public static void main(String[] args) {
        Solution solution = new Q39ZuHeZongHe().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<List<Integer>> res = new LinkedList<>();

        //回溯法解决
        //通过剪枝来优化，当sum > target 则应该跳出循环，走下一个节点，此时必须保持数组有序
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            if (candidates == null || candidates.length == 0) {
                return new ArrayList<>(res);
            }
            LinkedList list = new LinkedList();
            //排序
            Arrays.sort(candidates);
            backTrack(candidates, target, 0, list);
            return res.stream().map(list1 -> {
                Collections.sort(list1);
                return list1;
            }).distinct().collect(Collectors.toList());
        }

        void backTrack(int[] candidates, int target, int sum, LinkedList<Integer> list) {
            if (sum == target) {
                //需要去重
                res.add(new LinkedList<>(list));
                return;
            } else if (sum > target) {
                return;
            }
            for (int i = 0; i < candidates.length; i++) {
                int num = candidates[i];
                //剪枝优化,后续相加只会大于target
                if (sum + num > target) {
                    break;
                }
                list.add(num);
                backTrack(candidates, target, sum + num, list);
                list.removeLast();
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
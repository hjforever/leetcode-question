//给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,1]
//输出：[[0,1],[1,0]]
// 
//
// 示例 3： 
//
// 
//输入：nums = [1]
//输出：[[1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 6 
// -10 <= nums[i] <= 10 
// nums 中的所有整数 互不相同 
// 
// Related Topics 数组 回溯 👍 1616 👎 0


package io.hjforever.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Q46QuanPaiLie {
    public static void main(String[] args) {
        Solution solution = new Q46QuanPaiLie().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<List<Integer>> res = new LinkedList<>();

        public List<List<Integer>> permute(int[] nums) {
            //回溯算法
            LinkedList<Integer> premuteList = new LinkedList<>();
            backTrack(nums, premuteList);
            return res;
        }

        //回溯函数
        void backTrack(int nums[], LinkedList<Integer> track) {
            //1.触发条件
            if (track.size() == nums.length) {
                res.add(new LinkedList<>(track));
                return;
            }
            for (int i = 0; i < nums.length; i++) {
                //2做选择
                //2.1 排除已选择的列表
                if (track.contains(nums[i])) {
                    continue;
                }
                track.add(nums[i]);
                //进入下一层决策树
                backTrack(nums, track);
                //3.取消选择
                track.removeLast();
            }

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
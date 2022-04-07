//给你一个整数数组 arr，请你检查是否存在两个整数 N 和 M，满足 N 是 M 的两倍（即，N = 2 * M）。
//
// 更正式地，检查是否存在两个下标 i 和 j 满足： 
//
// 
// i != j 
// 0 <= i, j < arr.length 
// arr[i] == 2 * arr[j] 
// 
//
// 
//
// 示例 1： 
//
// 输入：arr = [10,2,5,3]
//输出：true
//解释：N = 10 是 M = 5 的两倍，即 10 = 2 * 5 。
// 
//
// 示例 2： 
//
// 输入：arr = [7,1,14,11]
//输出：true
//解释：N = 14 是 M = 7 的两倍，即 14 = 2 * 7 。
// 
//
// 示例 3： 
//
// 输入：arr = [3,1,7,11]
//输出：false
//解释：在该情况下不存在 N 和 M 满足 N = 2 * M 。
// 
//
// 
//
// 提示： 
//
// 
// 2 <= arr.length <= 500 
// -10^3 <= arr[i] <= 10^3 
// 
// Related Topics 数组 哈希表 双指针 二分查找 排序 👍 49 👎 0


package io.hjforever.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class Q1346JianChaZhengShuJiQiLiangBeiShuShiFouCunZai {
    public static void main(String[] args) {
        Solution solution = new Q1346JianChaZhengShuJiQiLiangBeiShuShiFouCunZai().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean checkIfExist(int[] arr) {
            //map
            Map<Integer, Integer> cnt = new HashMap<>();
            for (int num : arr) {
                if (cnt.containsKey(num * 2) || (cnt.containsKey(num / 2) && num % 2 == 0)) {
                    return true;
                }
                if (!cnt.containsKey(num)) {
                    cnt.put(num, 1);
                }
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
//给定一个长度为偶数的整数数组 arr，只有对 arr 进行重组后可以满足 “对于每个 0 <= i < len(arr) / 2，都有 arr[2 * i
//+ 1] = 2 * arr[2 * i]” 时，返回 true；否则，返回 false。 
//
// 
//
// 示例 1： 
//
// 
//输入：arr = [3,1,3,6]
//输出：false
// 
//
// 示例 2： 
//
// 
//输入：arr = [2,1,2,6]
//输出：false
// 
//
// 示例 3： 
//
// 
//输入：arr = [4,-2,2,-4]
//输出：true
//解释：可以用 [-2,-4] 和 [2,4] 这两组组成 [-2,-4,2,4] 或是 [2,4,-2,-4]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= arr.length <= 3 * 10⁴ 
// arr.length 是偶数 
// -10⁵ <= arr[i] <= 10⁵ 
// 
// Related Topics 贪心 数组 哈希表 排序 👍 67 👎 0


package io.hjforever.leetcode.editor.cn;

import java.util.*;

public class Q954ErBeiShuDuiShuZu {
    public static void main(String[] args) {
        Solution solution = new Q954ErBeiShuDuiShuZu().new Solution();
        System.out.println(solution.canReorderDoubled(new int[]{10, 20, 40, 80}));;
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean canReorderDoubled(int[] arr) {
            //hash 计数 排序
            if (arr == null || arr.length % 2 == 1) return false;
            Map<Integer, Integer> cnt = new HashMap<>();
            for (int i = 0; i < arr.length; i++) {
                cnt.put(arr[i], cnt.getOrDefault(arr[i], 0) + 1);
            }
            if (cnt.getOrDefault(0, 0) % 2 != 0) {
                return false;
            }
            List<Integer> vals = new ArrayList<>();
            for (int x : cnt.keySet()) {
                vals.add(x);
            }
            Collections.sort(vals, Comparator.comparingInt(Math::abs));
            for (int x : vals) {
                if (cnt.getOrDefault(2 * x, 0) < cnt.get(x)) { // 无法找到足够的 2x 与 x 配对
                    return false;
                }
                cnt.put(2 * x, cnt.getOrDefault(2 * x, 0) - cnt.get(x));
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
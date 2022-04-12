//给定一个 排序好 的数组 arr ，两个整数 k 和 x ，从数组中找到最靠近 x（两数之差最小）的 k 个数。返回的结果必须要是按升序排好的。
//
// 整数 a 比整数 b 更接近 x 需要满足： 
//
// 
// |a - x| < |b - x| 或者 
// |a - x| == |b - x| 且 a < b 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：arr = [1,2,3,4,5], k = 4, x = 3
//输出：[1,2,3,4]
// 
//
// 示例 2： 
//
// 
//输入：arr = [1,2,3,4,5], k = 4, x = -1
//输出：[1,2,3,4]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= k <= arr.length 
// 1 <= arr.length <= 10⁴ 
// arr 按 升序 排列 
// -10⁴ <= arr[i], x <= 10⁴ 
// 
// Related Topics 数组 双指针 二分查找 排序 堆（优先队列） 👍 309 👎 0


package io.hjforever.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class Q658ZhaoDaoKGeZuiJieJinDeYuanSu {
    public static void main(String[] args) {
        Solution solution = new Q658ZhaoDaoKGeZuiJieJinDeYuanSu().new Solution();
        solution.findClosestElements(new int[]{1, 2, 3, 4, 5}, 4, 3);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> findClosestElements(int[] arr, int k, int x) {
            //sliding window  > sort
            int left = 0, right = arr.length - 1;
            while (right - left >= k) {
                if (x - arr[left] > arr[right] - x) {
                    left++;
                } else if (x - arr[left] < arr[right] - x) {
                    right--;
                } else if (x - arr[left] == arr[right] - x) {
                    right--;
                }
            }
            List<Integer> ans = new ArrayList<>();
            for (; left < right + 1; left++) {
                ans.add(arr[left]);
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
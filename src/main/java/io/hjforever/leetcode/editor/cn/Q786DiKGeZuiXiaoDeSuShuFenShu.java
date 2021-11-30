//给你一个按递增顺序排序的数组 arr 和一个整数 k 。数组 arr 由 1 和若干 素数 组成，且其中所有整数互不相同。
//
// 对于每对满足 0 < i < j < arr.length 的 i 和 j ，可以得到分数 arr[i] / arr[j] 。 
//
// 那么第 k 个最小的分数是多少呢? 以长度为 2 的整数数组返回你的答案, 这里 answer[0] == arr[i] 且 answer[1] == 
//arr[j] 。 
// 
//
// 示例 1： 
//
// 
//输入：arr = [1,2,3,5], k = 3
//输出：[2,5]
//解释：已构造好的分数,排序后如下所示: 
//1/5, 1/3, 2/5, 1/2, 3/5, 2/3
//很明显第三个最小的分数是 2/5
// 
//
// 示例 2： 
//
// 
//输入：arr = [1,7], k = 1
//输出：[1,7]
// 
//
// 
//
// 提示： 
//
// 
// 2 <= arr.length <= 1000 
// 1 <= arr[i] <= 3 * 10⁴ 
// arr[0] == 1 
// arr[i] 是一个 素数 ，i > 0 
// arr 中的所有数字 互不相同 ，且按 严格递增 排序 
// 1 <= k <= arr.length * (arr.length - 1) / 2 
// 
// Related Topics 数组 二分查找 堆（优先队列） 👍 132 👎 0


package io.hjforever.leetcode.editor.cn;

public class Q786DiKGeZuiXiaoDeSuShuFenShu {
    public static void main(String[] args) {
        Solution solution = new Q786DiKGeZuiXiaoDeSuShuFenShu().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] kthSmallestPrimeFraction(int[] arr, int k) {
            // 1.最小堆
            // 2.二分查找
            if (arr == null || arr.length == 1) {
                return new int[0];
            }
            //二分查找
            int length = arr.length;
            //最小分数
            double left = 0;
            //最大分数
            double right = 1;
            //二分查找
            while (true) {
                double mid = (left + right) / 2;
                int x = 0;
                int y = 1;
                int i = -1;
                int count = 0;
                for (int j = 1; j < length; j++) {
                    //统计小于 的个数
                    while ((double) arr[i + 1] / arr[j] < mid) {
                        ++i;
                        //记录最大分数
                        if (arr[i] * y > arr[j] * x) {
                            x = arr[i];
                            y = arr[j];
                        }
                    }
                    count = count + i + 1;
                }

                if (count == k) {
                    return new int[]{x, y};
                } else if (count < k) {
                    left = mid;
                } else {
                    right = mid;
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
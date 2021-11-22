//在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。
//
// 
//
// 示例 1: 
//
// 输入: [7,5,6,4]
//输出: 5 
//
// 
//
// 限制： 
//
// 0 <= 数组长度 <= 50000 
// Related Topics 树状数组 线段树 数组 二分查找 分治 有序集合 归并排序 👍 556 👎 0


package io.hjforever.leetcode.editor.cn;

public class QJianZhiOffer51ShuZuZhongDeNiXuDui {
    public static void main(String[] args) {
        Solution solution = new QJianZhiOffer51ShuZuZhongDeNiXuDui().new Solution();
        int[] arr = {7, 5, 6, 4};
        solution.mergeSort(arr, 0, 3);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        int count = 0;

        public int reversePairs(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }
            //归并排序
            mergeSort(nums, 0, nums.length - 1);
            return count;
        }


        //归并排序
        void mergeSort(int[] arr, int start, int end) {
            if (arr == null || arr.length == 0 || start >= end) {
                return;
            }
            int mid = start + (end - start) / 2;
            mergeSort(arr, start, mid);
            mergeSort(arr, mid + 1, end);
            merge(arr, start, mid, end);
        }

        //合并两个有序数组
        void merge(int[] arr, int start, int mid, int end) {
            //temp
            int[] temp = new int[end - start + 1];

            int left = start;
            int right = mid + 1;
            int k = 0;

            while (left <= mid && right <= end) {
                if (arr[left] <= arr[right]) {
                    temp[k++] = arr[left++];
                } else {
                    //前面的元素大于后面的元素则加对应的距离的
                    count += mid - left + 1;
                    temp[k++] = arr[right++];
                }
            }

            while (left <= mid) {
                temp[k++] = arr[left++];
            }

            while (right <= end) {
                temp[k++] = arr[right++];
            }
            // 将排序后的元素，全部都整合到数组a中。
            for (int i = 0; i < k; i++) {
                arr[start + i] = temp[i];
            }
            temp = null;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
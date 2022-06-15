//Given an array of integers arr, sort the array by performing a series of
//pancake flips. 
//
// In one pancake flip we do the following steps: 
//
// 
// Choose an integer k where 1 <= k <= arr.length. 
// Reverse the sub-array arr[0...k-1] (0-indexed). 
// 
//
// For example, if arr = [3,2,1,4] and we performed a pancake flip choosing k = 
//3, we reverse the sub-array [3,2,1], so arr = [1,2,3,4] after the pancake flip 
//at k = 3. 
//
// Return an array of the k-values corresponding to a sequence of pancake flips 
//that sort arr. Any valid answer that sorts the array within 10 * arr.length 
//flips will be judged as correct. 
//
// 
// Example 1: 
//
// 
//Input: arr = [3,2,4,1]
//Output: [4,2,4,3]
//Explanation: 
//We perform 4 pancake flips, with k values 4, 2, 4, and 3.
//Starting state: arr = [3, 2, 4, 1]
//After 1st flip (k = 4): arr = [1, 4, 2, 3]
//After 2nd flip (k = 2): arr = [4, 1, 2, 3]
//After 3rd flip (k = 4): arr = [3, 2, 1, 4]
//After 4th flip (k = 3): arr = [1, 2, 3, 4], which is sorted.
// 
//
// Example 2: 
//
// 
//Input: arr = [1,2,3]
//Output: []
//Explanation: The input is already sorted, so there is no need to flip 
//anything.
//Note that other answers, such as [3, 3], would also be accepted.
// 
//
// 
// Constraints: 
//
// 
// 1 <= arr.length <= 100 
// 1 <= arr[i] <= arr.length 
// All integers in arr are unique (i.e. arr is a permutation of the integers 
//from 1 to arr.length). 
// 
// Related Topics 贪心 数组 双指针 排序 👍 263 👎 0


package io.hjforever.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class Q969PancakeSorting {
    public static void main(String[] args) {
        Solution solution = new Q969PancakeSorting().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> pancakeSort(int[] arr) {
            // sort , 每次将最大的放到后面
            List<Integer> ans = new ArrayList<>();
            int n = arr.length - 1;
            while (n > 0) {
                int idx = maxIndex(arr, n);
                if (idx != n) {
                    if (idx != 0) {
                        reverse(arr, idx);
                        ans.add(idx + 1);
                    }
                    reverse(arr, n);
                    ans.add(n + 1);
                }
                n--;
            }
            return ans;
        }

        public int maxIndex(int[] arr, int k) {
            int idx = 0;
            for (int i = 1; i <= k; i++) {
                if (arr[i] > arr[idx]) idx = i;
            }
            return idx;
        }


        public void reverse(int[] arr, int k) {
            int s = 0;
            int e = k;
            while (s < e) {
                int temp = arr[s];
                arr[s] = arr[e];
                arr[e] = temp;
                s++;
                e--;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
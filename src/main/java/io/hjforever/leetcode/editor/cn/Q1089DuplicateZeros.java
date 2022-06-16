//Given a fixed-length integer array arr, duplicate each occurrence of zero,
//shifting the remaining elements to the right. 
//
// Note that elements beyond the length of the original array are not written. 
//Do the above modifications to the input array in place and do not return 
//anything. 
//
// 
// Example 1: 
//
// 
//Input: arr = [1,0,2,3,0,4,5,0]
//Output: [1,0,0,2,3,0,0,4]
//Explanation: After calling your function, the input array is modified to: [1,0
//,0,2,3,0,0,4]
// 
//
// Example 2: 
//
// 
//Input: arr = [1,2,3]
//Output: [1,2,3]
//Explanation: After calling your function, the input array is modified to: [1,2
//,3]
// 
//
// 
// Constraints: 
//
// 
// 1 <= arr.length <= 10⁴ 
// 0 <= arr[i] <= 9 
// 
// Related Topics 数组 双指针 👍 122 👎 0


package io.hjforever.leetcode.editor.cn;

public class Q1089DuplicateZeros {
    public static void main(String[] args) {
        Solution solution = new Q1089DuplicateZeros().new Solution();
        solution.duplicateZeros(new int[]{0, 0, 0, 0, 0, 0, 0});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void duplicateZeros(int[] arr) {
            int n = arr.length;
            int[] temp = new int[n];
            for (int i = 0, j = 0; i < n && j < n; i++) {
                if (arr[i] == 0) {
                    temp[j++] = 0;
                    if (j < n) {
                        temp[j++] = 0;
                    }
                } else {
                    temp[j++] = arr[i];
                }
            }
            for (int i = 0; i < n; i++) {
                arr[i] = temp[i];
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
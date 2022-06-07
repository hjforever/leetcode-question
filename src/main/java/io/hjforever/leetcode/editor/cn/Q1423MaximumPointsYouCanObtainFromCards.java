//There are several cards arranged in a row, and each card has an associated
//number of points. The points are given in the integer array cardPoints. 
//
// In one step, you can take one card from the beginning or from the end of the 
//row. You have to take exactly k cards. 
//
// Your score is the sum of the points of the cards you have taken. 
//
// Given the integer array cardPoints and the integer k, return the maximum 
//score you can obtain. 
//
// 
// Example 1: 
//
// 
//Input: cardPoints = [1,2,3,4,5,6,1], k = 3
//Output: 12
//Explanation: After the first step, your score will always be 1. However, 
//choosing the rightmost card first will maximize your total score. The optimal 
//strategy is to take the three cards on the right, giving a final score of 1 + 6 + 5 = 1
//2.
// 
//
// Example 2: 
//
// 
//Input: cardPoints = [2,2,2], k = 2
//Output: 4
//Explanation: Regardless of which two cards you take, your score will always 
//be 4.
// 
//
// Example 3: 
//
// 
//Input: cardPoints = [9,7,7,9,7,7,9], k = 7
//Output: 55
//Explanation: You have to take all the cards. Your score is the sum of points 
//of all cards.
// 
//
// 
// Constraints: 
//
// 
// 1 <= cardPoints.length <= 10⁵ 
// 1 <= cardPoints[i] <= 10⁴ 
// 1 <= k <= cardPoints.length 
// 
// Related Topics 数组 前缀和 滑动窗口 👍 235 👎 0


package io.hjforever.leetcode.editor.cn;

public class Q1423MaximumPointsYouCanObtainFromCards {
    public static void main(String[] args) {
        Solution solution = new Q1423MaximumPointsYouCanObtainFromCards().new Solution();
        solution.maxScore(new int[]{1, 2, 3, 4, 5, 6, 1}, 3);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxScore(int[] cardPoints, int k) {
            // prefix sum
            int ans = 0;
            int n = cardPoints.length;
            int[] preSum = new int[n + 1];
            for (int i = 0; i < n; i++) {
                preSum[i + 1] = preSum[i] + cardPoints[i];
            }
            for (int i = 0; i <= k; i++) {
                int left = i;
                int right = k - left;
                int leftSum = 0;
                int rightSum = 0;
                if (left > 0) leftSum = preSum[left];
                if (right > 0) rightSum = preSum[n] - preSum[n - right];
                ans = Math.max(ans, leftSum + rightSum);
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
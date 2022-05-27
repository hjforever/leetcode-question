//There are n flights that are labeled from 1 to n.
//
// You are given an array of flight bookings bookings, where bookings[i] = [
//firsti, lasti, seatsi] represents a booking for flights firsti through lasti (
//inclusive) with seatsi seats reserved for each flight in the range. 
//
// Return an array answer of length n, where answer[i] is the total number of 
//seats reserved for flight i. 
//
// 
// Example 1: 
//
// 
//Input: bookings = [[1,2,10],[2,3,20],[2,5,25]], n = 5
//Output: [10,55,45,25,25]
//Explanation:
//Flight labels:        1   2   3   4   5
//Booking 1 reserved:  10  10
//Booking 2 reserved:      20  20
//Booking 3 reserved:      25  25  25  25
//Total seats:         10  55  45  25  25
//Hence, answer = [10,55,45,25,25]
// 
//
// Example 2: 
//
// 
//Input: bookings = [[1,2,10],[2,2,15]], n = 2
//Output: [10,25]
//Explanation:
//Flight labels:        1   2
//Booking 1 reserved:  10  10
//Booking 2 reserved:      15
//Total seats:         10  25
//Hence, answer = [10,25]
//
// 
//
// 
// Constraints: 
//
// 
// 1 <= n <= 2 * 10⁴ 
// 1 <= bookings.length <= 2 * 10⁴ 
// bookings[i].length == 3 
// 1 <= firsti <= lasti <= n 
// 1 <= seatsi <= 10⁴ 
// 
// Related Topics 数组 前缀和 👍 356 👎 0


package io.hjforever.leetcode.editor.cn;

public class Q1109CorporateFlightBookings {
    public static void main(String[] args) {
        Solution solution = new Q1109CorporateFlightBookings().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] corpFlightBookings(int[][] bookings, int n) {
            //差分
            int[] seat = new int[n];
            for (int i = 0; i < bookings.length; i++) {
                int s = bookings[i][0];
                int e = bookings[i][1];
                int num = bookings[i][2];
                seat[s - 1] += num;
                if (e-1 < n-1) {
                    seat[e-1+1] -= num;
                }

            }
            int[] ans = new int[n];
            ans[0] = seat[0];
            for (int i = 1; i < n; i++) {
                ans[i] = ans[i - 1] + seat[i];
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
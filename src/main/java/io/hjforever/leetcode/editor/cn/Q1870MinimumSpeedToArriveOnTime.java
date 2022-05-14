//You are given a floating-point number hour, representing the amount of time
//you have to reach the office. To commute to the office, you must take n trains in 
//sequential order. You are also given an integer array dist of length n, where 
//dist[i] describes the distance (in kilometers) of the iᵗʰ train ride. 
//
// Each train can only depart at an integer hour, so you may need to wait in 
//between each train ride. 
//
// 
// For example, if the 1ˢᵗ train ride takes 1.5 hours, you must wait for an 
//additional 0.5 hours before you can depart on the 2ⁿᵈ train ride at the 2 hour mark.
// 
// 
//
// Return the minimum positive integer speed (in kilometers per hour) that all 
//the trains must travel at for you to reach the office on time, or -1 if it is 
//impossible to be on time. 
//
// Tests are generated such that the answer will not exceed 10⁷ and hour will 
//have at most two digits after the decimal point. 
//
// 
// Example 1: 
//
// 
//Input: dist = [1,3,2], hour = 6
//Output: 1
//Explanation: At speed 1:
//- The first train ride takes 1/1 = 1 hour.
//- Since we are already at an integer hour, we depart immediately at the 1 
//hour mark. The second train takes 3/1 = 3 hours.
//- Since we are already at an integer hour, we depart immediately at the 4 
//hour mark. The third train takes 2/1 = 2 hours.
//- You will arrive at exactly the 6 hour mark.
// 
//
// Example 2: 
//
// 
//Input: dist = [1,3,2], hour = 2.7
//Output: 3
//Explanation: At speed 3:
//- The first train ride takes 1/3 = 0.33333 hours.
//- Since we are not at an integer hour, we wait until the 1 hour mark to 
//depart. The second train ride takes 3/3 = 1 hour.
//- Since we are already at an integer hour, we depart immediately at the 2 
//hour mark. The third train takes 2/3 = 0.66667 hours.
//- You will arrive at the 2.66667 hour mark.
// 
//
// Example 3: 
//
// 
//Input: dist = [1,3,2], hour = 1.9
//Output: -1
//Explanation: It is impossible because the earliest the third train can depart 
//is at the 2 hour mark.
// 
//
// 
// Constraints: 
//
// 
// n == dist.length 
// 1 <= n <= 10⁵ 
// 1 <= dist[i] <= 10⁵ 
// 1 <= hour <= 10⁹ 
// There will be at most two digits after the decimal point in hour. 
// 
// Related Topics 数组 二分查找 👍 25 👎 0


package io.hjforever.leetcode.editor.cn;

public class Q1870MinimumSpeedToArriveOnTime {
    public static void main(String[] args) {
        Solution solution = new Q1870MinimumSpeedToArriveOnTime().new Solution();
        boolean check = solution.check(new int[]{1, 1, 100000}, 2.01,
                10000000);

        System.out.println(check);

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minSpeedOnTime(int[] dist, double hour) {
            //binary search

            //这个题一看就是个二分就是细节有点多
            // 1.精度问题(搞得吐血) 2.右边界问题，最好在1e7 + 10

            int res = -1;
            int left = 1;
            int right = (int) 1e7 + 1;

            while (left < right) {
                int mid = left + (right - left) / 2;
                if (check(dist, hour, mid)) {
                    right = mid;
                    res = mid;
                } else {
                    left = mid + 1;
                }
            }
            return res;
        }

        boolean check(int[] dist, double hour, int speed) {
            double t = 0;
            for (int i = 0; i < dist.length - 1; i++) {
                t += Math.ceil(((double) dist[i]) / speed);
            }
            t += ((double) dist[dist.length - 1]) / speed;
            return t <= hour;
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

}
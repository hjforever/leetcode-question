//Given an integer n, return true if it is possible to represent n as the sum
//of distinct powers of three. Otherwise, return false. 
//
// An integer y is a power of three if there exists an integer x such that y == 
//3ˣ. 
//
// 
// Example 1: 
//
// 
//Input: n = 12
//Output: true
//Explanation: 12 = 3¹ + 3²
// 
//
// Example 2: 
//
// 
//Input: n = 91
//Output: true
//Explanation: 91 = 3⁰ + 3² + 3⁴
// 
//
// Example 3: 
//
// 
//Input: n = 21
//Output: false
// 
//
// 
// Constraints: 
//
// 
// 1 <= n <= 10⁷ 
// 
// Related Topics 数学 👍 30 👎 0


package io.hjforever.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class Q1780CheckIfNumberIsASumOfPowersOfThree {
    public static void main(String[] args) {
        Solution solution = new Q1780CheckIfNumberIsASumOfPowersOfThree().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        boolean ans = false;

        public boolean checkPowersOfThree(int n) {
            //1.暴力解法
//            if (n == 1) return true;
//            List<Integer> data = new ArrayList<>();
//            for (int i = 0; i <= n && Math.pow(3, i) <= n; i++) {
//                data.add((int) Math.pow(3, i));
//            }
//            dfs(data, 0, n, 0);
//            return ans;
            //2.数学解法，因为 n = 1 * 3^k +  0* 3^k1 .... + 1* 3^kn
            //相当于将n转换为3进制时则只存在0,1若存在2则失败
            while (n > 0) {
                if (n % 3 > 1) return false;
                n /= 3;
            }
            return true;
        }

        void dfs(List<Integer> data, int idx, int target, int sum) {
            if (sum == target) {
                ans = true;
                return;
            }
            if (sum > target || idx >= data.size()) {
                return;
            }
            dfs(data, idx + 1, target, sum + data.get(idx));
            dfs(data, idx + 1, target, sum);
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
//A binary watch has 4 LEDs on the top which represent the hours (0-11), and
//the 6 LEDs on the bottom represent the minutes (0-59). Each LED represents a zero 
//or one, with the least significant bit on the right. 
//
// 
// For example, the below binary watch reads "4:51". 
// 
//
// 
//
// Given an integer turnedOn which represents the number of LEDs that are 
//currently on, return all possible times the watch could represent. You may return the 
//answer in any order. 
//
// The hour must not contain a leading zero. 
//
// 
// For example, "01:00" is not valid. It should be "1:00". 
// 
//
// The minute must be consist of two digits and may contain a leading zero. 
//
// 
// For example, "10:2" is not valid. It should be "10:02". 
// 
//
// 
// Example 1: 
// Input: turnedOn = 1
//Output: ["0:01","0:02","0:04","0:08","0:16","0:32","1:00","2:00","4:00","8:00
//"]
// Example 2: 
// Input: turnedOn = 9
//Output: []
// 
// 
// Constraints: 
//
// 
// 0 <= turnedOn <= 10 
// 
// Related Topics 位运算 回溯 👍 360 👎 0


package io.hjforever.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class Q401BinaryWatch {
    public static void main(String[] args) {
        Solution solution = new Q401BinaryWatch().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> readBinaryWatch(int turnedOn) {
            //bit count
            //因为都是二进制表示，则时间是惟一的，只需要统计所有时间1的位数即可
            List<String> res = new ArrayList<>();
            for (int i = 0; i < 12; i++) {
                for (int j = 0; j < 60; j++) {
                    if (bitCount(i) + bitCount(j) == turnedOn) {
                        res.add(i + ":" + (j < 10 ? "0" + j : j));
                    }
                }
            }
            return res;
        }

        //统计二进制1的个数
        public int bitCount(int n) {
            return Integer.bitCount(n);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
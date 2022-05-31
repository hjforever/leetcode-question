//On an infinite plane, a robot initially stands at (0, 0) and faces north.
//Note that: 
//
// 
// The north direction is the positive direction of the y-axis. 
// The south direction is the negative direction of the y-axis. 
// The east direction is the positive direction of the x-axis. 
// The west direction is the negative direction of the x-axis. 
// 
//
// The robot can receive one of three instructions: 
//
// 
// "G": go straight 1 unit. 
// "L": turn 90 degrees to the left (i.e., anti-clockwise direction). 
// "R": turn 90 degrees to the right (i.e., clockwise direction). 
// 
//
// The robot performs the instructions given in order, and repeats them forever.
// 
//
// Return true if and only if there exists a circle in the plane such that the 
//robot never leaves the circle. 
//
// 
// Example 1: 
//
// 
//Input: instructions = "GGLLGG"
//Output: true
//Explanation: The robot is initially at (0, 0) facing the north direction.
//"G": move one step. Position: (0, 1). Direction: North.
//"G": move one step. Position: (0, 2). Direction: North.
//"L": turn 90 degrees anti-clockwise. Position: (0, 2). Direction: West.
//"L": turn 90 degrees anti-clockwise. Position: (0, 2). Direction: South.
//"G": move one step. Position: (0, 1). Direction: South.
//"G": move one step. Position: (0, 0). Direction: South.
//Repeating the instructions, the robot goes into the cycle: (0, 0) --> (0, 1) -
//-> (0, 2) --> (0, 1) --> (0, 0).
//Based on that, we return true.
// 
//
// Example 2: 
//
// 
//Input: instructions = "GG"
//Output: false
//Explanation: The robot is initially at (0, 0) facing the north direction.
//"G": move one step. Position: (0, 1). Direction: North.
//"G": move one step. Position: (0, 2). Direction: North.
//Repeating the instructions, keeps advancing in the north direction and does 
//not go into cycles.
//Based on that, we return false.
// 
//
// Example 3: 
//
// 
//Input: instructions = "GL"
//Output: true
//Explanation: The robot is initially at (0, 0) facing the north direction.
//"G": move one step. Position: (0, 1). Direction: North.
//"L": turn 90 degrees anti-clockwise. Position: (0, 1). Direction: West.
//"G": move one step. Position: (-1, 1). Direction: West.
//"L": turn 90 degrees anti-clockwise. Position: (-1, 1). Direction: South.
//"G": move one step. Position: (-1, 0). Direction: South.
//"L": turn 90 degrees anti-clockwise. Position: (-1, 0). Direction: East.
//"G": move one step. Position: (0, 0). Direction: East.
//"L": turn 90 degrees anti-clockwise. Position: (0, 0). Direction: North.
//Repeating the instructions, the robot goes into the cycle: (0, 0) --> (0, 1) -
//-> (-1, 1) --> (-1, 0) --> (0, 0).
//Based on that, we return true.
// 
//
// 
// Constraints: 
//
// 
// 1 <= instructions.length <= 100 
// instructions[i] is 'G', 'L' or, 'R'. 
// 
// Related Topics 数学 字符串 模拟 👍 116 👎 0


package io.hjforever.leetcode.editor.cn;

public class Q1041RobotBoundedInCircle {
    public static void main(String[] args) {
        Solution solution = new Q1041RobotBoundedInCircle().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isRobotBounded(String instructions) {
            //monitor
            //如果最终面朝方向与原始面朝方向垂直，那么机器人走四次instructions会回到原点形成闭环。（四个向量组成一个正方形）
            //如果最终面朝方向是原始面朝方向的反方向，则下一次instructions必定会到原点。（两个方向相反的向量）
            //如果面朝方向不变，向量不是零则发散，是零则一直在原点。

            int[][] vecs = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
            int x = 0;
            int y = 0;
            int dr = 0;
            for (char c : instructions.toCharArray()) {
                if (c == 'G') {
                    x += vecs[dr][0];
                    y += vecs[dr][1];
                } else if (c == 'L') {
                    dr = (dr + 3) % 4;
                } else {
                    dr = (dr + 1) % 4;
                }
            }
            if (dr == 0) return x == 0 && y == 0;
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
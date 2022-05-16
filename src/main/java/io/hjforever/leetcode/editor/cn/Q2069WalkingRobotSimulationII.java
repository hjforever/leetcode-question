//A width x height grid is on an XY-plane with the bottom-left cell at (0, 0)
//and the top-right cell at (width - 1, height - 1). The grid is aligned with the 
//four cardinal directions ("North", "East", "South", and "West"). A robot is 
//initially at cell (0, 0) facing direction "East". 
//
// The robot can be instructed to move for a specific number of steps. For each 
//step, it does the following. 
//
// 
// Attempts to move forward one cell in the direction it is facing. 
// If the cell the robot is moving to is out of bounds, the robot instead turns 
//90 degrees counterclockwise and retries the step. 
// 
//
// After the robot finishes moving the number of steps required, it stops and 
//awaits the next instruction. 
//
// Implement the Robot class: 
//
// 
// Robot(int width, int height) Initializes the width x height grid with the 
//robot at (0, 0) facing "East". 
// void step(int num) Instructs the robot to move forward num steps. 
// int[] getPos() Returns the current cell the robot is at, as an array of 
//length 2, [x, y]. 
// String getDir() Returns the current direction of the robot, "North", "East", 
//"South", or "West". 
// 
//
// 
// Example 1: 
//
// 
//Input
//["Robot", "step", "step", "getPos", "getDir", "step", "step", "step", 
//"getPos", "getDir"]
//[[6, 3], [2], [2], [], [], [2], [1], [4], [], []]
//Output
//[null, null, null, [4, 0], "East", null, null, null, [1, 2], "West"]
//
//Explanation
//Robot robot = new Robot(6, 3); // Initialize the grid and the robot at (0, 0) 
//facing East.
//robot.step(2);  // It moves two steps East to (2, 0), and faces East.
//robot.step(2);  // It moves two steps East to (4, 0), and faces East.
//robot.getPos(); // return [4, 0]
//robot.getDir(); // return "East"
//robot.step(2);  // It moves one step East to (5, 0), and faces East.
//                // Moving the next step East would be out of bounds, so it 
//turns and faces North.
//                // Then, it moves one step North to (5, 1), and faces North.
//robot.step(1);  // It moves one step North to (5, 2), and faces North (not 
//West).
//robot.step(4);  // Moving the next step North would be out of bounds, so it 
//turns and faces West.
//                // Then, it moves four steps West to (1, 2), and faces West.
//robot.getPos(); // return [1, 2]
//robot.getDir(); // return "West"
//
// 
//
// 
// Constraints: 
//
// 
// 2 <= width, height <= 100 
// 1 <= num <= 10⁵ 
// At most 10⁴ calls in total will be made to step, getPos, and getDir. 
// 
// Related Topics 设计 模拟 👍 16 👎 0


package io.hjforever.leetcode.editor.cn;

public class Q2069WalkingRobotSimulationII {
    public static void main(String[] args) {
        //Solution solution = new Q2069WalkingRobotSimulationII().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Robot {
        int m;
        int n;
        int[][] grid;
        int x = 0;
        int y = 0;
        int curIndex = 0;
        String[] directions = new String[]{"East", "North", "West", "South"};

        public Robot(int width, int height) {
            m = height;
            n = width;
            grid = new int[m][n];
        }

        public void step(int num) {
            if (num == 0) return;

            if (num > ((m + n - 2) * 2)) {
                //超过一圈取余
                num %= ((m + n - 2) * 2);
                //当回到0点时方向为south
                if (x == 0 && y == 0) {
                    curIndex = 3;
                }
            }
            while (num > 0) {
                if ((x == 0 && y == n - 1)) {
                    curIndex = 1;
                } else if ((x == 0 && y == 0)) {
                    curIndex = 0;
                } else if (x == m - 1 && y == n - 1) {
                    curIndex = 2;
                } else if (x == m - 1 && y == 0) {
                    curIndex = 3;
                }
                if (curIndex == 0) {
                    y++;
                } else if (curIndex == 1) {
                    x++;
                } else if (curIndex == 2) {
                    y--;
                } else {
                    x--;
                }
                num--;
            }
        }

        public int[] getPos() {
            return new int[]{y, x};
        }

        public String getDir() {
            return directions[curIndex % 4];
        }
    }

/**
 * Your Robot object will be instantiated and called as such:
 * Robot obj = new Robot(width, height);
 * obj.step(num);
 * int[] param_2 = obj.getPos();
 * String param_3 = obj.getDir();
 */
//leetcode submit region end(Prohibit modification and deletion)

}
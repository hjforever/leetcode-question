//Alice 和 Bob 交替进行一个游戏，由 Alice 先手。
//
// 在游戏中，共有 n 堆石头。在每个玩家的回合中，玩家需要 选择 任一非空石头堆，从中移除任意 非零 数量的石头。如果不能移除任意的石头，就输掉游戏，同时另
//一人获胜。 
//
// 给定一个整数数组 piles ，piles[i] 为 第 i 堆石头的数量，如果 Alice 能获胜返回 true ，反之返回 false 。 
//
// Alice 和 Bob 都会采取 最优策略 。 
//
// 
//
// 示例 1： 
//
// 
//输入：piles = [1]
//输出：true
//解释：只有一种可能的情况：
//- 第一回合，Alice 移除了第 1 堆中 1 块石头。piles = [0]。
//- 第二回合，Bob 没有任何石头可以移除。Alice 获胜。
// 
//
// 示例 2： 
//
// 
//输入：piles = [1,1]
//输出：false
//解释：可以证明，Bob一定能获胜。一种可能的情况：
//- 第一回合，Alice 移除了第 1 堆中 1 块石头。 piles = [0,1]。
//- 第二回合，Bob 移除了第 2 堆中 1 块石头。 piles = [0,0]。
//- 第三回合，Alice 没有任何石头可以移除。Bob 获胜。
// 
//
// 示例 3： 
//
// 
//输入：piles = [1,2,3]
//输出：false
//解释：可以证明，Bob一定能获胜。一种可能的情况：
//- 第一回合，Alice 移除了第 3 堆中 3 块石头。 piles = [1,2,0]。
//- 第二回合，Bob 移除了第 2 堆中 1 块石头。 piles = [1,1,0]。
//- 第三回合，Alice 移除了第 1 堆中 1 块石头。piles = [0,1,0]。
//- 第四回合，Bob 移除了第 2 堆中 1 块石头。 piles = [0,0,0]。
//- 第三回合，Alice 没有任何石头可以移除。Bob 获胜。 
//
// 
//
// 提示： 
//
// 
// n == piles.length 
// 1 <= n <= 7 
// 1 <= piles[i] <= 7 
// 
//
// 
//
// 进阶：你能想出一个 线性时间 的解决方案吗？虽然这一答案可能超出了面试所需的范围，但了解它可能会很有趣。 
// Related Topics 位运算 脑筋急转弯 数组 数学 动态规划 博弈 👍 3 👎 0


package io.hjforever.leetcode.editor.cn;

public class Q1908NimYouXiII {
    public static void main(String[] args) {
        Solution solution = new Q1908NimYouXiII().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean nimGame(int[] piles) {
            /**
             * 这个定理由Roland Sprague在1935和Patrick Michael Grundy在1939分别独立给出。
             * 定理描述了所谓“公正的”双人回合制游戏，即玩家是否胜利仅取决于当前的状态。
             * 此外我们假设这个游戏是：
             *
             * 在有限步骤内一定可以决出胜负（无平局）；
             * 游戏双方的信息是公开透明的。
             * 这类游戏可以用无圈有向图表示，每个状态表示一个点，状态A可以转换成状态B，则AB为一条有向边。
             * 若一个顶点没有出边，则该状态为losing。
             * 因为我们要求无平局，因此每个顶点都可以对应到losing状态 或者 winning 状态。
             * 一个losing状态的下一状态一定都是winning状态，否则就可以选择一个对手的losing状态，
             * 也就是自己的winning状态。
             *
             * 用SG(A)表示状态A的输赢。若一个状态x可以从若干相互独立的状态x_1,x_2...x_k得到，则
             * SG(A) = SG(x_1)^SG(x_2)^...SG(x_k)
             */
            //https://cp-algorithms.com/game_theory/sprague-grundy-nim.html
            int win = 0;
            for (int x : piles) {
                win = win ^ x;
            }
            return win != 0;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
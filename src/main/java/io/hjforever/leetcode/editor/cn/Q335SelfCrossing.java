//给你一个整数数组 distance 。
//
// 从 X-Y 平面上的点 (0,0) 开始，先向北移动 distance[0] 米，然后向西移动 distance[1] 米，向南移动 distance[2
//] 米，向东移动 distance[3] 米，持续移动。也就是说，每次移动后你的方位会发生逆时针变化。 
//
// 判断你所经过的路径是否相交。如果相交，返回 true ；否则，返回 false 。 
//
// 
//
// 示例 1： 
//
// 
//输入：distance = [2,1,1,2]
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：distance = [1,2,3,4]
//输出：false
// 
//
// 示例 3： 
//
// 
//输入：distance = [1,1,1,1]
//输出：true 
//
// 
//
// 提示： 
//
// 
// 1 <= distance.length <= 10⁵ 
// 1 <= distance[i] <= 10⁵ 
// 
// Related Topics 几何 数组 数学 👍 88 👎 0


package io.hjforever.leetcode.editor.cn;

public class Q335SelfCrossing {
    public static void main(String[] args) {
        Solution solution = new Q335SelfCrossing().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isSelfCrossing(int[] distance) {

            //找规律总结题
            //数学归纳法
            /**
             * 1.d[i] 与 d[i - 3]d[i−3] 发生相交：此时满足 d[i] >= d[i - 2]d[i]>=d[i−2]，同时 d[i - 1] <= d[i - 3]d[i−1]<=d[i−3]；
             * 2.d[i]d[i] 与 d[i - 4]d[i−4] 发生相交：此时满足 d[i - 1] = d[i - 3]d[i−1]=d[i−3]，同时 d[i] + d[i - 4] >= d[i - 2]d[i]+d[i−4]>=d[i−2]；
             * 3.d[i]d[i] 与 d[i - 5]d[i−5] 发生相交：此时满足d[i - 1] <= d[i - 3]d[i−1]<=d[i−3]，同时 d[i - 2] > d[i - 4]d[i−2]>d[i−4]，
             * 同时 d[i] + d[i - 4] >= d[i - 2]d[i]+d[i−4]>=d[i−2]，同时 d[i - 1] + d[i - 5] >= d[i - 3]d[i−1]+d[i−5]>=d[i−3]。
             *
             */
            int length = distance.length;
            if (length < 4) {
                return false;
            }
            for (int i = 3; i < length; i++) {
                if (distance[i] >= distance[i - 2] && distance[i - 1] <= distance[i - 3]) return true;
                if (i >= 4 && distance[i - 1] == distance[i - 3] && distance[i] + distance[i - 4] >= distance[i - 2])
                    return true;
                if (i >= 5 && distance[i - 1] <= distance[i - 3] && distance[i - 2] > distance[i - 4]
                        && distance[i] + distance[i - 4] >= distance[i - 2] && distance[i - 1] + distance[i - 5] >= distance[i - 3])
                    return true;
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
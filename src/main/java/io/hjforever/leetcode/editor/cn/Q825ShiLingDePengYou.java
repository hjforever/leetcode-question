//在社交媒体网站上有 n 个用户。给你一个整数数组 ages ，其中 ages[i] 是第 i 个用户的年龄。
//
// 如果下述任意一个条件为真，那么用户 x 将不会向用户 y（x != y）发送好友请求： 
//
// 
// age[y] <= 0.5 * age[x] + 7 
// age[y] > age[x] 
// age[y] > 100 && age[x] < 100 
// 
//
// 否则，x 将会向 y 发送一条好友请求。 
//
// 注意，如果 x 向 y 发送一条好友请求，y 不必也向 x 发送一条好友请求。另外，用户不会向自己发送好友请求。 
//
// 返回在该社交媒体网站上产生的好友请求总数。 
//
// 
//
// 示例 1： 
//
// 
//输入：ages = [16,16]
//输出：2
//解释：2 人互发好友请求。
// 
//
// 示例 2： 
//
// 
//输入：ages = [16,17,18]
//输出：2
//解释：产生的好友请求为 17 -> 16 ，18 -> 17 。
// 
//
// 示例 3： 
//
// 
//输入：ages = [20,30,100,110,120]
//输出：3
//解释：产生的好友请求为 110 -> 100 ，120 -> 110 ，120 -> 100 。
// 
//
// 
//
// 提示： 
//
// 
// n == ages.length 
// 1 <= n <= 2 * 10⁴ 
// 1 <= ages[i] <= 120 
// 
// Related Topics 数组 双指针 二分查找 排序 👍 124 👎 0


package io.hjforever.leetcode.editor.cn;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Q825ShiLingDePengYou {
    public static void main(String[] args) {
        Solution solution = new Q825ShiLingDePengYou().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        //   age[y] <= 0.5 * age[x] + 7
        //   age[y] > age[x]
        //   age[y] > 100 && age[x] < 100

        //   y<= x <= 2y -14

        public int numFriendRequests(int[] ages) {
            if (ages == null || ages.length <= 1) {
                return 0;
            }
            int n = ages.length;
            Arrays.sort(ages);
            int left = 0;
            int right = 0;
            int res = 0;
            for (int i = 0; i < n; i++) {
                int age = ages[i];
                //y<= x <= 2y -14 // 左边边界扩充
                //因 age>0则 age>15
                if (age < 15) {
                    continue;
                }
                while (ages[left] <= 0.5 * age + 7) {
                    left++;
                }
                //右侧边界扩充
                while (right + 1 < n && ages[right + 1] <= age) {
                    right++;
                }
                //因排序，当age往后移，则age越大，则边界也是在当前的基础上扩充。所以虽然两层循环依然时间是o(n)
                res += right - left;
            }
            return res ;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
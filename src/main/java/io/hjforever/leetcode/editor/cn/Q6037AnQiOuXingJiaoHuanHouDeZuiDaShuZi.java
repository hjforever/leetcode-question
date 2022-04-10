//给你一个正整数 num 。你可以交换 num 中 奇偶性 相同的任意两位数字（即，都是奇数或者偶数）。
//
// 返回交换 任意 次之后 num 的 最大 可能值。 
//
// 
//
// 示例 1： 
//
// 输入：num = 1234
//输出：3412
//解释：交换数字 3 和数字 1 ，结果得到 3214 。
//交换数字 2 和数字 4 ，结果得到 3412 。
//注意，可能存在其他交换序列，但是可以证明 3412 是最大可能值。
//注意，不能交换数字 4 和数字 1 ，因为它们奇偶性不同。
// 
//
// 示例 2： 
//
// 输入：num = 65875
//输出：87655
//解释：交换数字 8 和数字 6 ，结果得到 85675 。
//交换数字 5 和数字 7 ，结果得到 87655 。
//注意，可能存在其他交换序列，但是可以证明 87655 是最大可能值。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= num <= 10⁹ 
// 
// 👍 2 👎 0


package io.hjforever.leetcode.editor.cn;

public class Q6037AnQiOuXingJiaoHuanHouDeZuiDaShuZi {
    public static void main(String[] args) {
        Solution solution = new Q6037AnQiOuXingJiaoHuanHouDeZuiDaShuZi().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int largestInteger(int num) {
            //冒泡排序
            String s = String.valueOf(num);
            int n = s.length();
            char[] ch = s.toCharArray();
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    if ((ch[i] - '0') % 2 == (ch[j] - '0') % 2 && ch[i] < ch[j]) {
                        char temp = ch[j];
                        ch[j] = ch[i];
                        ch[i] = temp;
                    }
                }
            }
            return Integer.parseInt(new String(ch));
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
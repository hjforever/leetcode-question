//给定一个数组 A[0,1,…,n-1]，请构建一个数组 B[0,1,…,n-1]，其中 B[i] 的值是数组 A 中除了下标 i 以外的元素的积, 即 B[
//i]=A[0]×A[1]×…×A[i-1]×A[i+1]×…×A[n-1]。不能使用除法。 
//
// 
//
// 示例: 
//
// 
//输入: [1,2,3,4,5]
//输出: [120,60,40,30,24] 
//
// 
//
// 提示： 
//
// 
// 所有元素乘积之和不会溢出 32 位整数 
// a.length <= 100000 
// 
// Related Topics 数组 前缀和 👍 163 👎 0


package io.hjforever.leetcode.editor.cn;

public class QJianZhiOffer66GouJianChengJiShuZu {
    public static void main(String[] args) {
        Solution solution = new QJianZhiOffer66GouJianChengJiShuZu().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] constructArr(int[] a) {
            if (a == null || a.length == 0) {
                return new int[0];
            }

            int[] pre = new int[a.length];
            int[] after = new int[a.length];

            pre[0] = 1;
            after[a.length - 1] = 1;
            for (int i = 1; i < a.length; i++) {
                pre[i] = a[i - 1] * pre[i - 1];
            }
            for (int i = a.length - 2; i >= 0; i--) {
                after[i] = a[i + 1] * after[i + 1];
            }

            for (int i = 0; i < pre.length; i++) {
                pre[i] = pre[i] * after[i];
            }
            return pre;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
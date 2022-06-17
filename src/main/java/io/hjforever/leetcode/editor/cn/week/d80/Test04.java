package io.hjforever.leetcode.editor.cn.week.d80;

import com.sun.xml.internal.org.jvnet.mimepull.CleanUpExecutorFactory;

public class Test04 {
    public static void main(String[] args) {
        Test04 t = new Test04();
    }

        public long countSubarrays(int[] nums, long k) {
            int n = nums.length;
            long[] pre = new long[n + 1];
            for (int i = 0; i < n; i++) {
                pre[i + 1] = nums[i] + pre[i];
            }
            int ans = 0;
            int l = 0;
            int r = 0;
            while (r < n) {
                long t = (pre[r + 1] - pre[l]) * (r - l + 1);
                while (t >= k && l <= r) {
                    l++;
                    t = (pre[r + 1] - pre[l]) * (r - l + 1);
                }
                ans += (r - l + 1);
                r++;
            }
            return ans;
        }
}

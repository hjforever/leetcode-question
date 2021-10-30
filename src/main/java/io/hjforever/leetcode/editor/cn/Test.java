package io.hjforever.leetcode.editor.cn;

import io.hjforever.leetcode.editor.cn.common.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {
    public int[] analysisHistogram(int[] heights, int cnt) {
        if (heights.length <= cnt) {
            return heights;
        }
        Arrays.sort(heights);
        int minHeights = Integer.MAX_VALUE;
        int[] result = new int[cnt];
        for (int i = 0; i <= heights.length - cnt; i++) {
            int h = heights[i + cnt - 1] - heights[i];
            if (h < minHeights) {
                minHeights = h;
                int k = i;
                for (int j = 0; j < cnt; j++) {
                    result[j] = heights[k];
                    k++;
                }
            }
        }
        return result;
    }
}

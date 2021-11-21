package io.hjforever.leetcode.editor.cn.week.w268;

import java.util.*;

public class Question01 {
    public static void main(String[] args) {
        Question01 t = new Question01();
        int[] col = {1, 8, 3, 8, 3};
        System.out.println(t.maxDistance(col));
    }

    //暴力搜索
    public int maxDistance(int[] colors) {
        if (colors == null || colors.length == 0 || colors.length == 1) {
            return 0;
        }
        if (colors.length == 2) {
            return 1;
        }
        int res = 0;
        for (int i = 0; i < colors.length; i++) {
            for (int j = i + 1; j < colors.length; j++) {
                if (colors[i] != colors[j]) {
                    int s = Math.abs(j - i);
                    res = Math.max(res, s);
                }
            }
        }
        return res;
    }
}

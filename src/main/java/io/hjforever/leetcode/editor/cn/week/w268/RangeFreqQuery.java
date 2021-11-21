package io.hjforever.leetcode.editor.cn.week.w268;

import java.util.HashMap;
import java.util.TreeMap;

public class RangeFreqQuery {

    // question 03
    public static void main(String[] args) {
        int arr[] = {12, 33, 4, 56, 22, 2, 34, 33, 22, 12, 34, 56};
        //RangeFreqQuery rangeFreqQuery = new RangeFreqQuery(arr);
        // System.out.println(rangeFreqQuery.query(0, 11, 33));
    }


    private HashMap<Integer, TreeMap<Integer, Integer>> map = new HashMap<>();
    TreeMap<Integer, Integer> defaultMap = new TreeMap();

    public RangeFreqQuery() {
    }

    public RangeFreqQuery(int[] arr) {
        defaultMap.put(-1, 0);
        for (int i = 0; i < arr.length; i++) {
            map.computeIfAbsent(arr[i], t -> new TreeMap<>(defaultMap))
                    .put(i, map.get(arr[i]).size());
        }
    }

    public int query(int left, int right, int value) {
        return map.computeIfAbsent(value, t -> new TreeMap<>(defaultMap))
                .floorEntry(right).getValue() - map.get(value)
                .lowerEntry(left)
                .getValue();
    }

}

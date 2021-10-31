package io.hjforever.leetcode.editor.cn;

import io.hjforever.leetcode.editor.cn.common.ListNode;

import java.util.*;

public class Test {

    public static void main(String[] args) {
        Test test = new Test();

        String[] aar = {"c", "exjk", "nbmg", "kgnas", "s", "oydx", "ghpao", "c", "r", "ohdm", "fq", "ashgg", "mm", "cc", "mymy", "w", "t", "neb", "grjdb", "cukk", "ujyhn", "dq", "hhuo", "qu", "seslw", "ybulz", "iug", "rs", "kyfu", "krz", "nw", "txnn", "r", "zpuao", "sh", "rfc", "c", "hgr", "jfia", "egm", "gmuuv", "gh", "x", "nfvgv", "ibo", "al", "wn", "o", "dyu", "zgkk", "gdzrf", "m", "ui", "xwsj", "zeld", "muowr", "d", "xgiu", "yfu"};

        System.out.println(test.kthDistinct(aar, 19));;
    }

    public String kthDistinct(String[] arr, int k) {
        Map<String, Integer> map = new HashMap();
        for (String str : arr) {
            if (map.containsKey(str)) {
                map.put(str, map.get(str) + 1);
            }else{
                map.put(str, 1);
            }
        }
        List<String> list = new ArrayList();
        for (String str : arr) {
            if (map.containsKey(str) && map.get(str)==1) {
                list.add(str);
            }
        }
        if (list.size() < k) {
            return "";
        }
        return list.get(k - 1);
    }
}

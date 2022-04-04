package io.hjforever.leetcode.editor.cn.datastructure;

//树形数组
public class BinaryIndexedTree {
    int[] parent;

    public BinaryIndexedTree(int n) {
        parent = new int[n];
    }

    //求区间和,1到x
    public int sum(int x) {
        int sum = 0;
        for (x++; x > 0; x -= (x & (-x))) {
            sum += parent[x];
        }
        return sum;
    }

    //增加或者更新
    public void add(int x, int val) {
        for (x++; x < parent.length; x += (x & (-x))) {
            parent[x] += val;
        }
    }


    public static void main(String[] args) {
        BinaryIndexedTree bit = new BinaryIndexedTree(5);
        for (int i = 0; i < 4; i++) {
            bit.add(i, i + 1);
        }
        System.out.println(bit.sum(3));
    }
}

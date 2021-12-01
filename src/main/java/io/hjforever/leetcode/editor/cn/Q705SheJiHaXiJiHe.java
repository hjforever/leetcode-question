//不使用任何内建的哈希表库设计一个哈希集合（HashSet）。
//
// 实现 MyHashSet 类： 
//
// 
// void add(key) 向哈希集合中插入值 key 。 
// bool contains(key) 返回哈希集合中是否存在这个值 key 。 
// void remove(key) 将给定值 key 从哈希集合中删除。如果哈希集合中没有这个值，什么也不做。 
// 
// 
//
// 示例： 
//
// 
//输入：
//["MyHashSet", "add", "add", "contains", "contains", "add", "contains", 
//"remove", "contains"]
//[[], [1], [2], [1], [3], [2], [2], [2], [2]]
//输出：
//[null, null, null, true, false, null, true, null, false]
//
//解释：
//MyHashSet myHashSet = new MyHashSet();
//myHashSet.add(1);      // set = [1]
//myHashSet.add(2);      // set = [1, 2]
//myHashSet.contains(1); // 返回 True
//myHashSet.contains(3); // 返回 False ，（未找到）
//myHashSet.add(2);      // set = [1, 2]
//myHashSet.contains(2); // 返回 True
//myHashSet.remove(2);   // set = [1]
//myHashSet.contains(2); // 返回 False ，（已移除） 
//
// 
//
// 提示： 
//
// 
// 0 <= key <= 10⁶ 
// 最多调用 10⁴ 次 add、remove 和 contains 。 
// 
//
// 
//
// 进阶：你可以不使用内建的哈希集合库解决此问题吗？ 
// Related Topics 设计 数组 哈希表 链表 哈希函数 👍 194 👎 0


package io.hjforever.leetcode.editor.cn;

import java.util.LinkedList;

public class Q705SheJiHaXiJiHe {
    public static void main(String[] args) {
        //Solution solution = new Q705SheJiHaXiJiHe().new Solution();
        System.out.println(Math.pow(2, 12));
        int keyHash = 55 ^ (55 >> 16);
        System.out.println(keyHash);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class MyHashSet {

        LinkedList<Integer>[] segment;
        Integer initSize = 769;

        public MyHashSet() {
            segment = new LinkedList[initSize];
            for (int i = 0; i < initSize; i++) {
                segment[i] = new LinkedList<>();
            }
        }

        public void add(int key) {
            int index = hashIndex(key);
            LinkedList<Integer> keyList = segment[index];
            if (keyList.contains(key)) {
                return;
            }
            keyList.add(key);
        }

        public void remove(int key) {
            int index = hashIndex(key);
            LinkedList<Integer> keyList = segment[index];
            if (!keyList.isEmpty()) {
                keyList.removeFirstOccurrence(key);
            }
        }

        public boolean contains(int key) {
            int index = hashIndex(key);
            LinkedList<Integer> keyList = segment[index];
            if (!keyList.isEmpty()) {
                return keyList.contains(key);
            }
            return false;
        }

        private int hashIndex(int key) {
            //计算hash
            int hash = key ^ (key >> 16);
            int index = hash % segment.length;
            return index;
        }
    }

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
//leetcode submit region end(Prohibit modification and deletion)

}
//运用你所掌握的数据结构，设计和实现一个 LRU (最近最少使用) 缓存机制 。
//
// 
// 
// 实现 LRUCache 类： 
//
// 
// LRUCache(int capacity) 以正整数作为容量 capacity 初始化 LRU 缓存 
// int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。 
// void put(int key, int value) 如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字-值」。当缓存容量达到上
//限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。 
// 
//
// 
// 
// 
//
// 进阶：你是否可以在 O(1) 时间复杂度内完成这两种操作？ 
//
// 
//
// 示例： 
//
// 
//输入
//["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
//[[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
//输出
//[null, null, null, 1, null, -1, null, -1, 3, 4]
//
//解释
//LRUCache lRUCache = new LRUCache(2);
//lRUCache.put(1, 1); // 缓存是 {1=1}
//lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
//lRUCache.get(1);    // 返回 1
//lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
//lRUCache.get(2);    // 返回 -1 (未找到)
//lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
//lRUCache.get(1);    // 返回 -1 (未找到)
//lRUCache.get(3);    // 返回 3
//lRUCache.get(4);    // 返回 4
// 
//
// 
//
// 提示： 
//
// 
// 1 <= capacity <= 3000 
// 0 <= key <= 10000 
// 0 <= value <= 10⁵ 
// 最多调用 2 * 10⁵ 次 get 和 put 
// 
// Related Topics 设计 哈希表 链表 双向链表 👍 1622 👎 0


package io.hjforever.leetcode.editor.cn;

import java.util.Iterator;
import java.util.LinkedHashMap;

public class Q146LruCache {
    public static void main(String[] args) {
        //Solution solution = new Q146LruCache().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class LRUCache {

        /**
         * LRU , 用linkedhashmap 实现
         */

        //记录LRU的容量大小
        int cap;
        LinkedHashMap<Integer, Integer> cache;

        public LRUCache(int capacity) {
            this.cache = new LinkedHashMap<>();
            this.cap = capacity;
        }

        /**
         * 获取后需要将key移除，然后添加到队尾
         */
        public int get(int key) {
            if (!cache.containsKey(key)) {
                return -1;
            }
            Integer value = cache.get(key);
            //更新LRU，从队列中移除，然后添加到队尾表示最近使用
            updateRecently(key);
            return value;
        }

        //更新LRU，从队列中移除，然后添加到队尾表示最近使用
        private void updateRecently(int key) {
            Integer value = cache.get(key);
            cache.remove(key);
            cache.put(key, value);
        }

        /**
         * 需要判断是更新还是新增
         * <p>
         * 新增则需要判断容量，容量不够则要移除队头元素
         * <p>
         * 在统一更新为最近使用
         **/
        public void put(int key, int value) {
            //判定是新增还是更新
            if (cache.containsKey(key)) {
                cache.put(key, value);
                //移除key,然后添加到队尾
                updateRecently(key);
                return;
            }
            if (cache.size() >= cap) {
                //需要删除队头元素
                Integer oldKey = cache.keySet().iterator().next();
                cache.remove(oldKey);
            }
            cache.put(key, value);
            updateRecently(key);
            return;
        }


    }

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
//leetcode submit region end(Prohibit modification and deletion)

}
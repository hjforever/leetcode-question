//Design a time-based key-value data structure that can store multiple values
//for the same key at different time stamps and retrieve the key's value at a 
//certain timestamp. 
//
// Implement the TimeMap class: 
//
// 
// TimeMap() Initializes the object of the data structure. 
// void set(String key, String value, int timestamp) Stores the key key with 
//the value value at the given time timestamp. 
// String get(String key, int timestamp) Returns a value such that set was 
//called previously, with timestamp_prev <= timestamp. If there are multiple such 
//values, it returns the value associated with the largest timestamp_prev. If there 
//are no values, it returns "". 
// 
//
// 
// Example 1: 
//
// 
//Input
//["TimeMap", "set", "get", "get", "set", "get", "get"]
//[[], ["foo", "bar", 1], ["foo", 1], ["foo", 3], ["foo", "bar2", 4], ["foo", 4]
//, ["foo", 5]]
//Output
//[null, null, "bar", "bar", null, "bar2", "bar2"]
//
//Explanation
//TimeMap timeMap = new TimeMap();
//timeMap.set("foo", "bar", 1);  // store the key "foo" and value "bar" along 
//with timestamp = 1.
//timeMap.get("foo", 1);         // return "bar"
//timeMap.get("foo", 3);         // return "bar", since there is no value 
//corresponding to foo at timestamp 3 and timestamp 2, then the only value is at 
//timestamp 1 is "bar".
//timeMap.set("foo", "bar2", 4); // store the key "foo" and value "bar2" along 
//with timestamp = 4.
//timeMap.get("foo", 4);         // return "bar2"
//timeMap.get("foo", 5);         // return "bar2"
// 
//
// 
// Constraints: 
//
// 
// 1 <= key.length, value.length <= 100 
// key and value consist of lowercase English letters and digits. 
// 1 <= timestamp <= 10⁷ 
// All the timestamps timestamp of set are strictly increasing. 
// At most 2 * 10⁵ calls will be made to set and get. 
// 
// Related Topics 设计 哈希表 字符串 二分查找 👍 166 👎 0


package io.hjforever.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q981TimeBasedKeyValueStore {
    public static void main(String[] args) {
        //Solution solution = new Q981TimeBasedKeyValueStore().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class TimeMap {

        Map<String, List<Data>> map;

        public TimeMap() {
            map = new HashMap<>();
        }

        public void set(String key, String value, int timestamp) {
            List<Data> list = map.getOrDefault(key, new ArrayList<>());
            Data data = new Data(value, timestamp);
            list.add(data);
            map.put(key, list);
        }

        public String get(String key, int timestamp) {
            List<Data> list = map.get(key);
            if (list == null) return "";

            // binary search
            int left = 0;
            int right = list.size()-1;

            while (left < right) {
                int mid = (right + left + 1)/2;
                if (list.get(mid).getTime() <= timestamp) {
                    left = mid;
                } else {
                    right = mid - 1;
                }
            }
            return list.get(left).getTime() <= timestamp ? list.get(left).getValue() : "";
        }
    }

    class Data {
        private String value;
        private int time;

        public Data(String value, int time) {
            this.value = value;
            this.time = time;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public int getTime() {
            return time;
        }

        public void setTime(int time) {
            this.time = time;
        }
    }

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */
//leetcode submit region end(Prohibit modification and deletion)

}
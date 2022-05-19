//You have n processes forming a rooted tree structure. You are given two
//integer arrays pid and ppid, where pid[i] is the ID of the iᵗʰ process and ppid[i] is 
//the ID of the iᵗʰ process's parent process. 
//
// Each process has only one parent process but may have multiple children 
//processes. Only one process has ppid[i] = 0, which means this process has no parent 
//process (the root of the tree). 
//
// When a process is killed, all of its children processes will also be killed. 
//
//
// Given an integer kill representing the ID of a process you want to kill, 
//return a list of the IDs of the processes that will be killed. You may return the 
//answer in any order. 
//
// 
// Example 1: 
//
// 
//Input: pid = [1,3,10,5], ppid = [3,0,5,3], kill = 5
//Output: [5,10]
//Explanation: The processes colored in red are the processes that should be 
//killed.
// 
//
// Example 2: 
//
// 
//Input: pid = [1], ppid = [0], kill = 1
//Output: [1]
// 
//
// 
// Constraints: 
//
// 
// n == pid.length 
// n == ppid.length 
// 1 <= n <= 5 * 10⁴ 
// 1 <= pid[i] <= 5 * 10⁴ 
// 0 <= ppid[i] <= 5 * 10⁴ 
// Only one process has no parent. 
// All the values of pid are unique. 
// kill is guaranteed to be in pid. 
// 
// Related Topics 树 深度优先搜索 广度优先搜索 数组 哈希表 👍 87 👎 0


package io.hjforever.leetcode.editor.cn;

import java.util.*;

public class Q582KillProcess {
    public static void main(String[] args) {
        Solution solution = new Q582KillProcess().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
            HashMap<Integer, List<Integer>> map = new HashMap<>();
            for (int i = 0; i < ppid.size(); i++) {
                if (ppid.get(i) > 0) {
                    List<Integer> l = map.getOrDefault(ppid.get(i), new ArrayList<Integer>());
                    l.add(pid.get(i));
                    map.put(ppid.get(i), l);
                }
            }
            List<Integer> l = new ArrayList<>();
            l.add(kill);
            getAllChildren(map, l, kill);
            return l;
        }

        public void getAllChildren(HashMap<Integer, List<Integer>> map, List<Integer> l, int kill) {
            if (map.containsKey(kill)) {
                for (int id : map.get(kill)) {
                    l.add(id);
                    getAllChildren(map, l, id);
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
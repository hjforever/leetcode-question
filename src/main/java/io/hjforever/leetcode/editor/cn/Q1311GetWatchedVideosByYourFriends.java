//There are n people, each person has a unique id between 0 and n-1. Given the
//arrays watchedVideos and friends, where watchedVideos[i] and friends[i] contain 
//the list of watched videos and the list of friends respectively for the person 
//with id = i. 
//
// Level 1 of videos are all watched videos by your friends, level 2 of videos 
//are all watched videos by the friends of your friends and so on. In general, the 
//level k of videos are all watched videos by people with the shortest path 
//exactly equal to k with you. Given your id and the level of videos, return the list 
//of videos ordered by their frequencies (increasing). For videos with the same 
//frequency order them alphabetically from least to greatest. 
//
// 
// Example 1: 
//
// 
//
// 
//Input: watchedVideos = [["A","B"],["C"],["B","C"],["D"]], friends = [[1,2],[0,
//3],[0,3],[1,2]], id = 0, level = 1
//Output: ["B","C"] 
//Explanation: 
//You have id = 0 (green color in the figure) and your friends are (yellow 
//color in the figure):
//Person with id = 1 -> watchedVideos = ["C"] 
//Person with id = 2 -> watchedVideos = ["B","C"] 
//The frequencies of watchedVideos by your friends are: 
//B -> 1 
//C -> 2
// 
//
// Example 2: 
//
// 
//
// 
//Input: watchedVideos = [["A","B"],["C"],["B","C"],["D"]], friends = [[1,2],[0,
//3],[0,3],[1,2]], id = 0, level = 2
//Output: ["D"]
//Explanation: 
//You have id = 0 (green color in the figure) and the only friend of your 
//friends is the person with id = 3 (yellow color in the figure).
// 
//
// 
// Constraints: 
//
// 
// n == watchedVideos.length == friends.length 
// 2 <= n <= 100 
// 1 <= watchedVideos[i].length <= 100 
// 1 <= watchedVideos[i][j].length <= 8 
// 0 <= friends[i].length < n 
// 0 <= friends[i][j] < n 
// 0 <= id < n 
// 1 <= level < n 
// if friends[i] contains j, then friends[j] contains i 
// 
// Related Topics 广度优先搜索 数组 哈希表 排序 👍 38 👎 0


package io.hjforever.leetcode.editor.cn;

import java.util.*;

public class Q1311GetWatchedVideosByYourFriends {
    public static void main(String[] args) {
        Solution solution = new Q1311GetWatchedVideosByYourFriends().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        // TODO , redo
        public List<String> watchedVideosByFriends(List<List<String>> watchedVideos, int[][] friends, int id, int level) {
            //结果存放几何
            List<String> list = new ArrayList<>();
            int len = friends.length;
            Queue<Integer> queue = new LinkedList<>();
            queue.offer(id);
            //记忆数组
            boolean[] arr = new boolean[len];
            arr[id] = true;
            while (level-- > 0) {
                int size = queue.size();
                while (size-- != 0) {
                    int temp = queue.poll();
                    for (int a : friends[temp]) {
                        if (!arr[a]) {
                            arr[a] = true;
                            queue.offer(a);
                        }
                    }
                }
            }
            Map<String, Integer> map = new HashMap<>();
            for (int a : queue) {
                for (String s : watchedVideos.get(a)) {
                    map.put(s, map.getOrDefault(s, 0) + 1);
                }
            }
            PriorityQueue<Map.Entry<String, Integer>> pri = new PriorityQueue<>(new Comparator<Map.Entry<String, Integer>>() {
                public int compare(Map.Entry<String, Integer> a, Map.Entry<String, Integer> b) {
                    return a.getValue() - b.getValue() == 0 ? a.getKey().compareTo(b.getKey()) : a.getValue() - b.getValue();
                }
            });
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                pri.offer(entry);
            }
            while (!pri.isEmpty()) {
                list.add(pri.poll().getKey());
            }
            return list;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
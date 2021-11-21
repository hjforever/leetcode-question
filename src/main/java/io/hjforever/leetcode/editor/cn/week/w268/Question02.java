package io.hjforever.leetcode.editor.cn.week.w268;

public class Question02 {
    public static void main(String[] args) {
        Question02 question02 = new Question02();
        int[] array = {1, 1, 1, 4, 2, 3};
        System.out.println(question02.wateringPlants(array, 4));
    }

    /**
     * 输入：plants = [2,2,3,3], capacity = 5
     * 输出：14
     * 解释：从河边开始，此时水罐是装满的：
     * - 走到植物 0 (1 步) ，浇水。水罐中还有 3 单位的水。
     * - 走到植物 1 (1 步) ，浇水。水罐中还有 1 单位的水。
     * - 由于不能完全浇灌植物 2 ，回到河边取水 (2 步)。
     * - 走到植物 2 (3 步) ，浇水。水罐中还有 2 单位的水。
     * - 由于不能完全浇灌植物 3 ，回到河边取水 (3 步)。
     * - 走到植物 3 (4 步) ，浇水。
     * 需要的步数是 = 1 + 1 + 2 + 3 + 3 + 4 = 14
     *
     * @param plants
     * @param capacity
     * @return
     */

    //模拟
    public int wateringPlants(int[] plants, int capacity) {
        int count = 0;
        int curCapity = capacity;
        for (int i = 0; i < plants.length; i++) {
            if (curCapity >= plants[i]) {
                count += 1;
                curCapity = curCapity - plants[i];
            } else {
                count += i;
                count += i + 1;
                curCapity = capacity - plants[i];
            }
        }
        return count;
    }
}

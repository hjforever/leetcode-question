package io.hjforever.leetcode.editor.cn.datastructure.binarysearch;

public class BinarySearch {

    static BinarySearch bs = new BinarySearch();

    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 3, 3, 3, 3, 3, 4, 5, 6};
        System.out.println(bs.leftBound(nums, 3));
        System.out.println(bs.rightBound(nums, 3));
    }

    //左边界
    public int leftBound(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = (right - left) / 2 + left;
            if (nums[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        //判断是否在数组中
        return nums[left] == target ? left : -1;
    }

    //右边界
    public int rightBound(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            //左边边界mid需要加1
            int mid = (right - left + 1) / 2 + left;
            if (nums[mid] <= target) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return nums[left] == target ? left : -1;
    }

}

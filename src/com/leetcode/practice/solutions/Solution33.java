package com.leetcode.practice.solutions;

public class Solution33 {

    public static int search(int[] nums, int target) {
        int size = nums.length;
        int offset = 0;
        int start = 0;
        int end = size;
        int mid;
        if (nums[0] > nums[size - 1]) {
            while (true) {
                mid = (end + start) / 2;
                if (mid + 1 < size && nums[mid] > nums[mid + 1]) {
                    offset = size - mid - 1;
                    break;
                }
                if (nums[mid] > nums[start]) {
                    if (start != mid) {
                        start = mid;
                    } else {
                        break;
                    }
                } else {
                    if (end != mid) {
                        end = mid;
                    } else {
                        break;
                    }
                }
            }
        }
        start = 0;
        end = nums.length;
        while (true) {
            mid = (end + start) / 2;
            if (nums[getRealIndex(mid, offset, size)] == target) {
                return getRealIndex(mid, offset, size);
            }
            if (nums[getRealIndex(mid, offset, size)] > target) {
                if (mid != end) {
                    end = mid;
                } else {
                    break;
                }
            } else {
                if (mid != start) {
                    start = mid;
                } else {
                    break;
                }
            }
        }
        return -1;
    }

    public static int getRealIndex(int index, int offset, int size) {
        if (index - offset < 0) {
            return size + (index - offset);
        } else {
            return index - offset;
        }
    }

}

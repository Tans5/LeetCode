package com.leetcode.practice.solutions;

public class Solution34 {

    public static int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        result[0] = -1;
        result[1] = -1;
        int size = nums.length;
        if (size < 1) {
            return result;
        }
        int start = 0;
        int end = size;
        while (true) {
            int mid = (start + end) / 2;
            if (nums[mid] == target) {
                result[0] = findStartIndex(start, mid + 1, nums, target);
                result[1] = findEndIndex(mid, end == size ? end : end + 1, nums, target);
                break;
            }
            if (nums[mid] > target) {
                if (end != mid) {
                    end = mid;
                } else {
                    break;
                }
            } else {
                if (start != mid) {
                    start = mid;
                } else {
                    break;
                }
            }
        }

        return result;
    }

    public static int findStartIndex(int start, int end, int[] nums, int target) {
        if (start == 0 && nums[start] == target) {
            return 0;
        } else {
            while (true) {
                int mid = (start + end) / 2;
                if (mid - 1 >= 0 && nums[mid - 1] < target && nums[mid] == target) {
                    return mid;
                }
                if (nums[mid] < target) {
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
        return -1;
    }

    public static int findEndIndex(int start, int end, int[] nums, int target) {
        if (end == nums.length && nums[end - 1] == target) {
            return end - 1;
        } else {
            while (true) {
                int mid = (start + end) / 2;
                if (mid + 1 < nums.length && nums[mid + 1] > target && nums[mid] == target) {
                    return mid;
                }
                if (nums[mid] <= target) {
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
        return -1;
    }



}

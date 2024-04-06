package com.sudipcold.slidingwindow;

import java.util.*;

/**
 * You are given an array of integers nums, there is a sliding window of size k
 * which is moving from the very left of the array to the very right. You can only
 * see the k numbers in the window. Each time the sliding window moves right by one position.
 *
 * Return the max sliding window.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
 * Output: [3,3,5,5,6,7]
 * Explanation:
 * Window position                Max
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 *  1 [3  -1  -3] 5  3  6  7       3
 *  1  3 [-1  -3  5] 3  6  7       5
 *  1  3  -1 [-3  5  3] 6  7       5
 *  1  3  -1  -3 [5  3  6] 7       6
 *  1  3  -1  -3  5 [3  6  7]      7
 * Example 2:
 *
 * Input: nums = [1], k = 1
 * Output: [1]
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 105
 * -104 <= nums[i] <= 104
 * 1 <= k <= nums.length
 */
public class MaximumInSlideWindow {
    public static Deque<Integer> cleanUp(int i, Deque<Integer> currentWindow, int[] nums) {
        while (currentWindow.size() != 0 && nums[i] >= nums[currentWindow.getLast()]) {
            currentWindow.removeLast();
        }
        return currentWindow;
    }

    // function to find the maximum in all possible windows
    public static int[] findMaxSlidingWindow(int[] nums, int w) {
        if (nums.length == 1) {
            return nums;
        }
        int [] output = new int[nums.length - w + 1];
        Deque<Integer> currentWindow = new ArrayDeque<>();
        for (int i = 0; i < w; i++) {
            cleanUp(i, currentWindow, nums);
            currentWindow.add(i);
        }
        output[0] = nums[currentWindow.getFirst()];
        for (int i = w; i < nums.length; i++) {
            cleanUp(i, currentWindow, nums);
            if (!currentWindow.isEmpty() && currentWindow.getFirst() <= (i - w)) {
                currentWindow.removeFirst();
            }
            currentWindow.add(i);
            output[i - w + 1] = nums[currentWindow.getFirst()];
        }
        return output;
    }

}

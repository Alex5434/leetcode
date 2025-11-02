/*
 * @lc app=leetcode id=2461 lang=java
 *
 * [2461] Maximum Sum of Distinct Subarrays With Length K
 *
 * https://leetcode.com/problems/maximum-sum-of-distinct-subarrays-with-length-k/description/
 *
 * algorithms
 * Medium (42.63%)
 * Likes:    2113
 * Dislikes: 46
 * Total Accepted:    217.1K
 * Total Submissions: 509.4K
 * Testcase Example:  '[1,5,4,2,9,9,9]\n3'
 *
 * You are given an integer array nums and an integer k. Find the maximum
 * subarray sum of all the subarrays of nums that meet the following
 * conditions:
 * 
 * 
 * The length of the subarray is k, and
 * All the elements of the subarray are distinct.
 * 
 * 
 * Return the maximum subarray sum of all the subarrays that meet the
 * conditions. If no subarray meets the conditions, return 0.
 * 
 * A subarray is a contiguous non-empty sequence of elements within an
 * array.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: nums = [1,5,4,2,9,9,9], k = 3
 * Output: 15
 * Explanation: The subarrays of nums with length 3 are:
 * - [1,5,4] which meets the requirements and has a sum of 10.
 * - [5,4,2] which meets the requirements and has a sum of 11.
 * - [4,2,9] which meets the requirements and has a sum of 15.
 * - [2,9,9] which does not meet the requirements because the element 9 is
 * repeated.
 * - [9,9,9] which does not meet the requirements because the element 9 is
 * repeated.
 * We return 15 because it is the maximum subarray sum of all the subarrays
 * that meet the conditions
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: nums = [4,4,4], k = 3
 * Output: 0
 * Explanation: The subarrays of nums with length 3 are:
 * - [4,4,4] which does not meet the requirements because the element 4 is
 * repeated.
 * We return 0 because no subarrays meet the conditions.
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= k <= nums.length <= 10^5
 * 1 <= nums[i] <= 10^5
 * 
 * 
 */

// @lc code=start

import java.util.*;
import java.util.HashSet;

class Solution {
    public static long maximumSubarraySum(int[] nums, int k) {
    long maxSum = 0;
    long currentSum = 0;
    int left = 0;
    HashSet<Integer> seen = new HashSet<>();

    for (int right = 0; right < nums.length; right++) {
        System.out.println("\n=== Iteration: right = " + right + " | nums[right] = " + nums[right] + " ===");

        // Remove duplicates: shrink window from left
        while (seen.contains(nums[right])) {
            System.out.println("Duplicate found: " + nums[right] + ", removing nums[" + left + "] = " + nums[left]);
            seen.remove(nums[left]);
            currentSum -= nums[left];
            left++;
        }

        // Add current number to set and sum
        seen.add(nums[right]);
        currentSum += nums[right];
        System.out.println("Window: [" + left + ", " + right + "], Current Sum: " + currentSum + ", Set: " + seen);

        // If window size == k
        if (right - left + 1 == k) {
            maxSum = Math.max(maxSum, currentSum);
            System.out.println("Window of size K found. Max Sum Updated: " + maxSum);

            // Slide window forward by removing the leftmost element
            System.out.println("Sliding window: removing nums[" + left + "] = " + nums[left]);
            seen.remove(nums[left]);
            currentSum -= nums[left];
            left++;
        }
    }

    System.out.println("\nFinal Max Sum: " + maxSum);
    return maxSum;
}

    // public static long maximumSubarraySum(int[] nums, int k) {

    //     long ans = 0;
    //     long windowSum = 0;
    //     int left = 0, right = 0;

    //     HashSet<Integer> seen = new HashSet<>();

    //     while (right < nums.length) {
    //         int currentNum = nums[right];
    //         /**
    //          * If found the duplicate in comming number then erase left most element from the set;
    //          * Reduce the window SUM if thar element exsist
    //          */
    //         while(seen.contains(currentNum)){
    //             seen.remove(nums[left]);
    //             windowSum -= nums[left];
    //             left ++;
    //         }

    //         seen.add(nums[right]);
    //         windowSum+=nums[right];

    //         // check the window size is equal to the k
    //         if(right - left + 1 == k){
    //             ans = Math.max(ans, windowSum);
    //             seen.remove(nums[left]);
    //             windowSum -= nums[left];
    //             left ++;
    //         }

    //         right++;
    //     }

    //     // long ans = 0;
    //     // long currentSum = 0;
    //     // int left = 0;
    //     // int right = 0;

    //     // HashMap<Integer, Integer> numToIndex = new HashMap<>();

    //     // while (right < nums.length) {
    //     //     int currNum = nums[right];
    //     //     int lastOccurrence = numToIndex.getOrDefault(currNum, -1);
    //     //     // if current window already has number or if window is too big, adjust window
    //     //     while (left <= lastOccurrence || right - left + 1 > k) {
    //     //         currentSum -= nums[left];
    //     //         left++;
    //     //     }
    //     //     numToIndex.put(currNum, right);
    //     //     currentSum += nums[right];
    //     //     if (right - left + 1 == k) {
    //     //         ans = Math.max(ans, currentSum);
    //     //     }
    //     //     right++;
    //     // }
    //     return ans;
    // }

    public static void main(String[] args) {
        int arr[] = { 1,5,4,2,9,9,9 };
        int k = 3;

        long result = maximumSubarraySum(arr, k);
        System.out.println("RESULT IS :: " + result);
    }
}
// @lc code=end

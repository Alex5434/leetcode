/*
 * @lc app=leetcode id=189 lang=java
 *
 * [189] Rotate Array
 *
 * https://leetcode.com/problems/rotate-array/description/
 *
 * algorithms
 * Medium (43.27%)
 * Likes:    20189
 * Dislikes: 2145
 * Total Accepted:    3.5M
 * Total Submissions: 8M
 * Testcase Example:  '[1,2,3,4,5,6,7]\n3'
 *
 * Given an integer array nums, rotate the array to the right by k steps, where
 * k is non-negative.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: nums = [1,2,3,4,5,6,7], k = 3
 * Output: [5,6,7,1,2,3,4]
 * Explanation:
 * rotate 1 steps to the right: [7,1,2,3,4,5,6]
 * rotate 2 steps to the right: [6,7,1,2,3,4,5]
 * rotate 3 steps to the right: [5,6,7,1,2,3,4]
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: nums = [-1,-100,3,99], k = 2
 * Output: [3,99,-1,-100]
 * Explanation: 
 * rotate 1 steps to the right: [99,-1,-100,3]
 * rotate 2 steps to the right: [3,99,-1,-100]
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= nums.length <= 10^5
 * -2^31 <= nums[i] <= 2^31 - 1
 * 0 <= k <= 10^5
 * 
 * 
 * 
 * Follow up:
 * 
 * 
 * Try to come up with as many solutions as you can. There are at least three
 * different ways to solve this problem.
 * Could you do it in-place with O(1) extra space?
 * 
 * 
 */

// @lc code=start

import java.util.Arrays;

class Solution {
    // brute force
    // public static void rotate(int[] arr, int k) {
    // k = k % arr.length;

    // if (k % 2 == 0) {
    // for (int i = 0; i < k; i++) {
    // System.out.println("FIRST ELEMENT :: " + arr[i] + " SWAP ELEMENT :: " + arr[i
    // + k]);
    // int temp = arr[i];
    // arr[i] = arr[i + k];
    // arr[i + k] = temp;
    // }
    // } else {
    // int result[] = arr.clone();
    // for (int i = k, j = 0; i < result.length + k; i++, j++) {
    // System.out.println("111" + i % arr.length);
    // arr[j] = result[i % arr.length];
    // }

    // }
    // }


    // Optimal apporach using the reversal technique
    public static void reverse(int[] arr, int start, int end){
        while(end > start){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    public static void rotate(int[] arr, int k) {
        k = k % arr.length;
        reverse(arr, 0, arr.length - 1);
        reverse(arr, 0, k - 1);
        reverse(arr, k, arr.length - 1);
    }

    public static void main(String[] args) {
        // int arr[] = { 1, 2 };
        // int ro =1;

        int arr[] = { -1, -100, 3, 99 };
        int ro = 2;

        rotate(arr, ro);

        System.out.println("THE SORTED ARRAY ISSS :::" + Arrays.toString(arr));
    }
}
// @lc code=end

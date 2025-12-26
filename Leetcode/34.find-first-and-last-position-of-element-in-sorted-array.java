/*
 * @lc app=leetcode id=34 lang=java
 *
 * [34] Find First and Last Position of Element in Sorted Array
 *
 * https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/description/
 *
 * algorithms
 * Medium (43.58%)
 * Likes:    22742
 * Dislikes: 615
 * Total Accepted:    3M
 * Total Submissions: 6.4M
 * Testcase Example:  '[5,7,7,8,8,10]\n8'
 *
 * Given an array of integers nums sorted in non-decreasing order, find the
 * starting and ending position of a given target value.
 * 
 * If target is not found in the array, return [-1, -1].
 * 
 * You must write an algorithm with O(log n) runtime complexity.
 * 
 * 
 * Example 1:
 * Input: nums = [5,7,7,8,8,10], target = 8
 * Output: [3,4]
 * Example 2:
 * Input: nums = [5,7,7,8,8,10], target = 6
 * Output: [-1,-1]
 * Example 3:
 * Input: nums = [], target = 0
 * Output: [-1,-1]
 * 
 * 
 * Constraints:
 * 
 * 
 * 0 <= nums.length <= 10^5
 * -10^9 <= nums[i] <= 10^9
 * nums is a non-decreasing array.
 * -10^9 <= target <= 10^9
 * 
 * 
 */

// @lc code=start
import java.util.*;
class Solution {

    public static int findFirst(int[] arr, int target){
        int l = 0, r = arr.length - 1;
        int ans = -1;

        while(l <= r){
            int mid = l + ((r - l) / 2);

            if(arr[mid] == target){
                ans = mid;
                r = mid - 1;
            } else if(arr[mid] < target){
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return ans;
    }
    public static int findLast(int[] arr, int target){
        int l = 0, r = arr.length - 1;
        int ans = -1;

        while(l <= r){
            int mid = l + ((r - l) / 2);

            if(arr[mid] == target){
                ans = mid;
                l = mid + 1;
            } else if(arr[mid] < target){
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return ans;
    }

    public static int[] searchRange(int[] nums, int target) {
        return new int[]{
            findFirst(nums, target),
            findLast(nums, target)
        };
    }


    // public static int[] searchRange(int[] nums, int target) {
    //     int[] result = {-1, -1};

    //     int firstIndex = binarySearch(nums, 0, nums.length - 1, target);

    //     result[0] = firstIndex;
    //     result[1] = firstIndex;
    //     System.out.println("THE INDEX FOUND ISSS ::" + firstIndex + "  " + nums[firstIndex] + " " + Arrays.toString(nums));



    //     return result;
    // }


    public static void main(String[] args){
        int inp[] = {8};
        int target = 8;

        int result[] = searchRange(inp, target);

        System.out.println("ARRAYS :: " + Arrays.toString(result));
    }
}
// @lc code=end



import java.util.HashMap;

/*
 * @lc app=leetcode id=219 lang=java
 *
 * [219] Contains Duplicate II
 *
 * https://leetcode.com/problems/contains-duplicate-ii/description/
 *
 * algorithms
 * Easy (44.00%)
 * Likes:    6872
 * Dislikes: 3244
 * Total Accepted:    1.4M
 * Total Submissions: 2.9M
 * Testcase Example:  '[1,2,3,1]\n3'
 *
 * Given an integer array nums and an integer k, return true if there are two
 * distinct indices i and j in the array such that nums[i] == nums[j] and abs(i - j) <= k.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: nums = [1,2,3,1], k = 3
 * Output: true
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: nums = [1,0,1,1], k = 1
 * Output: true
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: nums = [1,2,3,1,2,3], k = 2
 * Output: false
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= nums.length <= 10^5
 * -10^9 <= nums[i] <= 10^9
 * 0 <= k <= 10^5
 * 
 * 
 */

// @lc code=start
class Solution {

    // Brute force approach
    // public static boolean containsNearbyDuplicate(int[] nums, int k) {
    // for (int i = 0; i < nums.length; i++) {
    // for (int j = i + 1; Math.abs(i - j) <= k && j < nums.length; j++) {

    // // System.out.println();

    // // System.out.println("I:: " + i + " J:: " + j);
    // if(nums[i]==nums[j]){
    // System.out.println("Value I:: " + nums[i] + " Value J:: " + nums[j]);
    // }
    // // System.out.println("THE DIFFERENCE IS::" + Math.abs(i - j) + " -- " + k +
    // " == " + (Math.abs(i + 1 - j) <= k));
    // // System.out.println("COMPARING THE I :: " + nums[i] + "J :: " + nums[j]);
    // // if (nums[i] == nums[j] && (Math.abs(i + 1 - j) <= k)) {
    // // System.out.println("INSIDE THE RETUEN TRUE " + (Math.abs(i + 1 - j) <=
    // k));
    // // return true;
    // // }

    // // System.out.println();
    // }
    // }

    // return false;
    // }


    // Optimal
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> seen = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (seen.containsKey(nums[i])) {
                int indexOfDuplicate = seen.get(nums[i]);
                if (Math.abs(i - indexOfDuplicate) <= k) {
                    return true;
                }
            }
            seen.put(nums[i], i);
        }

        return false;
    }

    public static void main(String[] args) {
        int arr[] = {1,2,3,1,2,3 };
        int k = 2;

        System.out.println("RESULT ::: " + containsNearbyDuplicate(arr, k));
    }
}
// @lc code=end

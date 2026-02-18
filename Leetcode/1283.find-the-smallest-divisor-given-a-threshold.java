/*
 * @lc app=leetcode id=1283 lang=java
 *
 * [1283] Find the Smallest Divisor Given a Threshold
 *
 * https://leetcode.com/problems/find-the-smallest-divisor-given-a-threshold/description/
 *
 * algorithms
 * Medium (58.38%)
 * Likes:    3542
 * Dislikes: 225
 * Total Accepted:    424.2K
 * Total Submissions: 648.4K
 * Testcase Example:  '[1,2,5,9]\n6'
 *
 * Given an array of integers nums and an integer threshold, we will choose a
 * positive integer divisor, divide all the array by it, and sum the division's
 * result. Find the smallest divisor such that the result mentioned above is
 * less than or equal to threshold.
 * 
 * Each result of the division is rounded to the nearest integer greater than
 * or equal to that element. (For example: 7/3 = 3 and 10/2 = 5).
 * 
 * The test cases are generated so that there will be an answer.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: nums = [1,2,5,9], threshold = 6
 * Output: 5
 * Explanation: We can get a sum to 17 (1+2+5+9) if the divisor is 1. 
 * If the divisor is 4 we can get a sum of 7 (1+1+2+3) and if the divisor is 5
 * the sum will be 5 (1+1+1+2). 
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: nums = [44,22,33,11,1], threshold = 5
 * Output: 44
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= nums.length <= 5 * 10^4
 * 1 <= nums[i] <= 10^6
 * nums.length <= threshold <= 10^6
 * 
 * 
 */

// @lc code=start
class Solution {
    public static int smallestDivisor(int[] nums, int threshold) {
        // assign left and right
        int l = 1, r = 0;

        // find the maxElement in array
        for (int i : nums) {
            r = Math.max(r, i);
        }

        // for (int i=l; i<= r; i++) {
        //     System.out.println("LLLLLL :: " + i + " :: " + findDivisorSum(nums, i));
        // }

        // start the while
        while(l <= r){
            // find the mid
            int m = l + (r - l) / 2;
            int divisorSum = findDivisorSum(nums, m);
            if(divisorSum > threshold){
                l = m + 1;
            } else{
                r = m - 1;
            }
        }
        return l;
    }



    private static int findDivisorSum(int[] nums, int divisor) {
        // Create a running sum
        int divisorSum = 0;

        // Loop through the values and add
        for (int i : nums) {
            divisorSum += Math.ceilDiv(i, divisor);
        }

        // return the divisor sum
        return divisorSum;
    }

    public static void main(String[] args) {
        // int[] nums = { 1, 2, 5, 9 };
        // int threshold = 6;
        int[] nums = { 44,22,33,11,1 };
        int threshold = 5;
        // double rs = 2/4;
        int result = smallestDivisor(nums, threshold);
        System.out.println("THE DIVISION RESULT ISS ::" + result);
    }
}
// @lc code=end

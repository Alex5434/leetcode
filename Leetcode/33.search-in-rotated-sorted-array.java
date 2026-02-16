/*
 * @lc app=leetcode id=33 lang=java
 *
 * [33] Search in Rotated Sorted Array
 *
 * https://leetcode.com/problems/search-in-rotated-sorted-array/description/
 *
 * algorithms
 * Medium (43.06%)
 * Likes:    28720
 * Dislikes: 1734
 * Total Accepted:    3.9M
 * Total Submissions: 8.9M
 * Testcase Example:  '[4,5,6,7,0,1,2]\n0'
 *
 * There is an integer array nums sorted in ascending order (with distinct
 * values).
 * 
 * Prior to being passed to your function, nums is possibly left rotated at an
 * unknown index k (1 <= k < nums.length) such that the resulting array is
 * [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]
 * (0-indexed). For example, [0,1,2,4,5,6,7] might be left rotated by 3 indices
 * and become [4,5,6,7,0,1,2].
 * 
 * Given the array nums after the possible rotation and an integer target,
 * return the index of target if it is in nums, or -1 if it is not in nums.
 * 
 * You must write an algorithm with O(log n) runtime complexity.
 * 
 * 
 * Example 1:
 * Input: nums = [4,5,6,7,0,1,2], target = 0
 * Output: 4
 * Example 2:
 * Input: nums = [4,5,6,7,0,1,2], target = 3
 * Output: -1
 * Example 3:
 * Input: nums = [1], target = 0
 * Output: -1
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= nums.length <= 5000
 * -10^4 <= nums[i] <= 10^4
 * All values of nums are unique.
 * nums is an ascending array that is possibly rotated.
 * -10^4 <= target <= 10^4
 * 
 * 
 */

// @lc code=start
class Solution {

    // NOT optimal solved in O(1) need to solve it in O(logn) using binary search
    // public static int search(int[] nums, int target) {
    // int l = 0;
    // int r = nums.length - 1;
    // while (r >= l) {
    // System.out.println(" RIGHT :: " +r + " LEFT ::: " + l);
    // if(nums[r] == target){
    // return r;
    // }

    // if(nums[l] == target){
    // return l;
    // }

    // int leftTarget = nums[l] - target;
    // int rightTarget = nums[r] - target;

    // if(leftTarget < rightTarget){
    // l++;
    // } else{
    // r--;
    // }
    // }

    // return -1;
    // }
    public static int findPivot(int[] nums) {
        int l = 0;
        int r = nums.length - 1;

        while (r >= l) {
            int m = l + (r - l) / 2;
            System.out.println("LEFT :: " + l + " MIDD :: " + m + " RIGHT :: " + r);

            if (m < r && nums[m] > nums[m + 1]) {
                return m;
            }

            if (m > l && nums[m] < nums[m - 1]) {
                return m - 1;
            }

            if (nums[l] < nums[m]) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return -1;
    }

    // [4,5,6,7,0,1,2]
    public static int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        // find the pivot
        // int pivotIndex = -1;
        // while (r >= l) {
        // int m = l + (r - l) / 2;
        // System.out.println("LEFT :: " + l + " MIDD :: " + m + " RIGHT :: " + r);

        // if (nums[m] > nums[m + 1]) {
        // pivotIndex = m;
        // break;
        // }

        // if(m < r && nums[m] < nums[m - 1]){
        // pivotIndex = m - 1;
        // break;
        // }

        // if(nums[l] < nums[m]){
        // l = m + 1;
        // }
        // if(nums[m] > nums[r]){
        // r = m - 1;
        // }
        // }

        int result = findPivot(nums);

        System.out.println("THE PIVOT INDEX ISSS ::" + (result + 1));

        return -1;
    }

    public static int sqareRoot(int n, int m) {
        // // Write your code here.
        if (m == 1 || n == 1) {
            return m;
        }
        int l = 1, r = m;

        while (l <= r) {
            // System.out.println("KKKKKKKKK " + l + " " + m + " " + r);
            int mid = l + (r - l) / 2;
            // System.out.println("LKKKK " + Math.pow(mid, n));
            if(Math.pow(mid, n) == m){
                return m;
            } else if (Math.pow(mid, n) < m) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return -1;


        // using binary seach
        if (m == 1 || n == 1) {
            return m;
        }

        int l = 1, r = m;

        while (l <= r) {

            int mid = l + (r - l) / 2;

            if (Math.pow(mid, n) == m) {
                return mid;
            } else if (Math.pow(mid, n) < m) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }

        }

        return -1;
    }

    public static void main(String[] args) {
        // int[] nums = {6, 0, 1, 2, 4, 5};
        int target = 0;

        // int result = search(nums, target);
        // System.out.println("RESULT :: " + (int)Math.sqrt());
        System.out.println("RESULT :: " + sqareRoot(3, 27));
    }

}
// @lc code=end


// 2 * 2 * 2
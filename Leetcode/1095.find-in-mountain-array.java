/*
 * @lc app=leetcode id=1095 lang=java
 *
 * [1095] Find in Mountain Array
 *
 * https://leetcode.com/problems/find-in-mountain-array/description/
 *
 * algorithms
 * Hard (40.57%)
 * Likes:    3562
 * Dislikes: 153
 * Total Accepted:    192.4K
 * Total Submissions: 469.6K
 * Testcase Example:  '[1,2,3,4,5,3,1]\n3'
 *
 * (This problem is an interactive problem.)
 * 
 * You may recall that an array arr is a mountain array if and only if:
 * 
 * 
 * arr.length >= 3
 * There exists some i with 0 < i < arr.length - 1 such that:
 * 
 * arr[0] < arr[1] < ... < arr[i - 1] < arr[i]
 * arr[i] > arr[i + 1] > ... > arr[arr.length - 1]
 * 
 * 
 * 
 * 
 * Given a mountain array mountainArr, return the minimum index such that
 * mountainArr.get(index) == target. If such an index does not exist, return
 * -1.
 * 
 * You cannot access the mountain array directly. You may only access the array
 * using a MountainArray interface:
 * 
 * 
 * MountainArray.get(k) returns the element of the array at index k
 * (0-indexed).
 * MountainArray.length() returns the length of the array.
 * 
 * 
 * Submissions making more than 100 calls to MountainArray.get will be judged
 * Wrong Answer. Also, any solutions that attempt to circumvent the judge will
 * result in disqualification.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: mountainArr = [1,2,3,4,5,3,1], target = 3
 * Output: 2
 * Explanation: 3 exists in the array, at index=2 and index=5. Return the
 * minimum index, which is 2.
 * 
 * Example 2:
 * 
 * 
 * Input: mountainArr = [0,1,2,4,2,1], target = 3
 * Output: -1
 * Explanation: 3 does not exist in the array, so we return -1.
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 3 <= mountainArr.length() <= 10^4
 * 0 <= target <= 10^9
 * 0 <= mountainArr.get(index) <= 10^9
 * 
 * 
 */

// @lc code=start
/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */

interface MountainArray {
    public int get(int index) {}
    public int length() {}
}

 
class Solution {
    public static int findInMountainArray(int target, MountainArray mountainArr) {
        // find the peak element
        int peakIndex = findPeakIndex(mountainArr);
        // System.out.println("LLLL :: " + peakIndex);
        // search in ascending
        // System.out.println("SEARCH RANGE :: " + 0 + " - " + peakIndex + " ::: " + (peakIndex + 1) + " - " + (mountainArr.length() - 1));
        int asc = binarySearch(mountainArr, target, 0, peakIndex, false);

        // System.out.println("LLL :: " + asc);

        // search in decending
        int dsc = binarySearch(mountainArr, target, peakIndex + 1, mountainArr.length() - 1, true);
        // System.out.println("LLL :: " + dsc);


        // need to optimise the condition
        if(asc == -1 && dsc == -1){
            return -1;
        } else if(asc == -1 && dsc != -1){
            return dsc;
        } else if(asc != -1 && dsc == -1){
            return asc;
        } else {
            return Math.min(asc, dsc);
        }
    }

    public static int findPeakIndex(MountainArray arr){
        int l = 0, r = arr.length() - 1;
        
        while(l < r){
            int m = l + (r - l) / 2;
            if(arr.get(m) < arr.get(m + 1)){
                l = m + 1;
            } else {
                r = m;
            }
        }

        return l;
    }

    public static int binarySearch(MountainArray arr, int target, int l, int r, boolean isDescending){
        while (l <= r) {
            int m = (r -l) / 2 + l;
            if(arr.get(m) == target){
                return m;
            } 

            if(isDescending){
                if (arr.get(m) < target) {
                    r = m - 1;
                } else {
                    l = m + 1;
                }
            } else{
                if (arr.get(m) < target) {
                    l = m + 1;
                } else {
                    r = m - 1;
                }
            }
        }

        return -1;
    }



    public static void main(String[] args) {
        
    }
}
// @lc code=end


/*
 * @lc app=leetcode id=88 lang=java
 *
 * [88] Merge Sorted Array
 *
 * https://leetcode.com/problems/merge-sorted-array/description/
 *
 * algorithms
 * Easy (53.17%)
 * Likes:    18036
 * Dislikes: 2525
 * Total Accepted:    5.1M
 * Total Submissions: 9.5M
 * Testcase Example:  '[1,2,3,0,0,0]\n3\n[2,5,6]\n3'
 *
 * You are given two integer arrays nums1 and nums2, sorted in non-decreasing
 * order, and two integers m and n, representing the number of elements in
 * nums1 and nums2 respectively.
 * 
 * Merge nums1 and nums2 into a single array sorted in non-decreasing order.
 * 
 * The final sorted array should not be returned by the function, but instead
 * be stored inside the array nums1. To accommodate this, nums1 has a length of
 * m + n, where the first m elements denote the elements that should be merged,
 * and the last n elements are set to 0 and should be ignored. nums2 has a
 * length of n.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
 * Output: [1,2,2,3,5,6]
 * Explanation: The arrays we are merging are [1,2,3] and [2,5,6].
 * The result of the merge is [1,2,2,3,5,6] with the underlined elements coming
 * from nums1.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: nums1 = [1], m = 1, nums2 = [], n = 0
 * Output: [1]
 * Explanation: The arrays we are merging are [1] and [].
 * The result of the merge is [1].
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: nums1 = [0], m = 0, nums2 = [1], n = 1
 * Output: [1]
 * Explanation: The arrays we are merging are [] and [1].
 * The result of the merge is [1].
 * Note that because m = 0, there are no elements in nums1. The 0 is only there
 * to ensure the merge result can fit in nums1.
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * nums1.length == m + n
 * nums2.length == n
 * 0 <= m, n <= 200
 * 1 <= m + n <= 200
 * -10^9 <= nums1[i], nums2[j] <= 10^9
 * 
 * 
 * 
 * Follow up: Can you come up with an algorithm that runs in O(m + n) time?
 * 
 */

// @lc code=start

import java.util.Arrays;

class Solution {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int count = 0;
        for (int i = 0, j = 0; i < m + n;) {
            if(count++ > 10){
                break;
            }
            // System.out.println("LL " + i  + " JJJJ ::" + j + " PP "+ m);
            // System.out.println("NUMS111 ::" + Arrays.toString(nums1));
            // System.out.println("NUMS22222 ::" + Arrays.toString(nums2));
            // System.out.println();
            // if(i - 1 >= m){
            //     int temp = nums1[i];
            //     nums1[i] = nums2[j];
            //     nums2[j] = temp;
            //     i++;
            //     j++;
            //     System.out.println("AAAAAAAAa :: "+ Arrays.toString(nums1) + " ::: " + Arrays.toString(nums2));
            //     continue;
            // }

            // if (nums1[i] > nums2[j]) {
            //     int temp = nums1[i];
            //     nums1[i] = nums2[j];
            //     nums2[j] = temp;
            // } else{
            //     i++;
            // }


            // if first array element less than second array element and  !=0 

            System.out.println(nums1[i] > nums2[j]);
            if ((nums1[i] <= nums2[j] && nums1[i] != 0)) {
                System.out.println("IFF");
                i++;
            } else if (nums1[i] > nums2[j]) {
                System.out.println("ELSE IFF");
                int temp = nums1[i];
                nums1[i] = nums2[j];
                nums2[j] = temp;
                i++;
            } else {
                int temp = nums1[i];
                nums1[i] = nums2[j];
                nums2[j] = temp;
                i++;
                j++;
                System.out.println("ELSEEEEE");
            }

            System.out.println("NUMS 1 ::" + Arrays.toString(nums1));
            System.out.println("NUMS 2 ::" + Arrays.toString(nums2));
            System.out.println("III : "+ i + " JJJ :: " + j );
            System.out.println();
        }
    }



    // IMPORTANT cpoied from solutions NEED TO LEARN
    // public void merge(int[] a, int m, int[] b, int n) {
    //     int i = m - 1;     
    //     int j = n - 1;       
    //     int k = m + n - 1;    

    //     while (i >= 0 && j >= 0) {
    //         if (a[i] > b[j]) {
    //             a[k--] = a[i--];
    //         } else {
    //             a[k--] = b[j--];
    //         }
    //     }

    //     while (j >= 0) {
    //         a[k--] = b[j--];
    //     }

    // }


    // public static void swap(int[] first, int[] second, int i, int j){}

    public static void main(String[] args) {
        // int nums1[] = { 1, 2, 3, 0, 0, 0 };
        // int m = 3;

        // int nums2[] = { 2, 5, 6 };
        // int n = 3;

        int nums1[] = { 4, 6, 7, 0, 0, 0 };
        int m = 3;

        int nums2[] = {1, 2, 5 };
        int n = 3;

        merge(nums1, m, nums2, n);

        System.out.println("THE NUMS ARRRAY IS :: " + Arrays.toString(nums1));
    }
}
// @lc code=end

/*
 * @lc app=leetcode id=28 lang=java
 *
 * [28] Find the Index of the First Occurrence in a String
 */

// @lc code=start

import java.util.Scanner;
import java.util.*;

// Input: nums = [1,2,4], k = 5
// Input: nums = [1,4,8,13], k = 5


class Solution {
    public static void findMostFrequence(int[] arr, int k) {
        Arrays.sort(arr);
        for(int i=arr.length-1; i>=0; i--){
            System.out.println("II " + i);
            for(int j=i; j>=0; j--){
                System.out.println("JJ " + j);
            }
            System.out.println();
        }        
    }

    public static void main(String[] args) {
        int nums[] = {1,2,4};
        int k = 5;
        
        findMostFrequence(nums, k);
    }
}

/*
 * @lc app=leetcode id=744 lang=java
 *
 * [744] Find Smallest Letter Greater Than Target
 *
 * https://leetcode.com/problems/find-smallest-letter-greater-than-target/description/
 *
 * algorithms
 * Easy (54.27%)
 * Likes:    4824
 * Dislikes: 2220
 * Total Accepted:    665.4K
 * Total Submissions: 1.2M
 * Testcase Example:  '["c","f","j"]\n"a"'
 *
 * You are given an array of characters letters that is sorted in
 * non-decreasing order, and a character target. There are at least two
 * different characters in letters.
 * 
 * Return the smallest character in letters that is lexicographically greater
 * than target. If such a character does not exist, return the first character
 * in letters.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: letters = ["c","f","j"], target = "a"
 * Output: "c"
 * Explanation: The smallest character that is lexicographically greater than
 * 'a' in letters is 'c'.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: letters = ["c","f","j"], target = "c"
 * Output: "f"
 * Explanation: The smallest character that is lexicographically greater than
 * 'c' in letters is 'f'.
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: letters = ["x","x","y","y"], target = "z"
 * Output: "x"
 * Explanation: There are no characters in letters that is lexicographically
 * greater than 'z' so we return letters[0].
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 2 <= letters.length <= 10^4
 * letters[i] is a lowercase English letter.
 * letters is sorted in non-decreasing order.
 * letters contains at least two different characters.
 * target is a lowercase English letter.
 * 
 * 
 */

// @lc code=start
class Solution {
    public static char nextGreatestLetter(char[] letters, char target) {
        int l = 0, r = letters.length - 1;
        while (l <= r) {
            int mid = (r - l / 2) + l;

            if(letters[mid] < target) {
                l = mid + 1;
            } else{
                r = mid - 1;
            }
        }
        return 'a';
        
    }

    // int l = 0, r = arr.length-1;
    //     while(l<=r){
    //         int m = l+(r-l)/2;
    //         if(target<arr[m]){
    //             r = m-1;
    //         }
    //         else{
    //             l = m+1;
    //         }
    //     }
    //     if(l==arr.length){
    //         return arr[0];
    //     }
    //     return arr[l];

    public static void main(String[] args){
        char arr[] = {'c', 'f', 'j'};

        // System.out.println("RESULT :: " + ('c'< 'b'));

        System.out.println("RESULT :: " + nextGreatestLetter(arr, 'd'));

    }
}
// @lc code=end


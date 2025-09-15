/*
 * @lc app=leetcode id=567 lang=java
 *
 * [567] Permutation in String
 *
 * https://leetcode.com/problems/permutation-in-string/description/
 *
 * algorithms
 * Medium (47.45%)
 * Likes:    12442
 * Dislikes: 491
 * Total Accepted:    1.3M
 * Total Submissions: 2.7M
 * Testcase Example:  '"ab"\n"eidbaooo"'
 *
 * Given two strings s1 and s2, return true if s2 contains a permutation of s1,
 * or false otherwise.
 * 
 * In other words, return true if one of s1's permutations is the substring of
 * s2.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: s1 = "ab", s2 = "eidbaooo"
 * Output: true
 * Explanation: s2 contains one permutation of s1 ("ba").
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: s1 = "ab", s2 = "eidboaoo"
 * Output: false
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= s1.length, s2.length <= 10^4
 * s1 and s2 consist of lowercase English letters.
 * 
 * 
 */

// @lc code=start

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;

class Solution {

    // Failed brute force
    // public static boolean checkInclusion(String s1, String s2) {
    //     int windowSize = s1.length();
    //     boolean isExist = false;
    //     int left = 0, right = 0;

    //     int windowStrLength = 0, maxSize = 0;

    //     // HashMap<Character, Integer> s1Frequency = new HashMap<>();
    //     HashMap<Character, Integer> charmap = new HashMap<>();

    //     // int[] s1Frequency = new int[26];

    //     for (int i = 0; i < s1.length(); i++) {
    //         if (charmap.containsKey(s1.charAt(i))) {
    //             int currentValue = charmap.get(s1.charAt(i));
    //             charmap.put(s1.charAt(i), currentValue++);
    //         } else {
    //             charmap.put(s1.charAt(i), 1);
    //         }
    //     }

    //     System.out.println("THE CHAR MAP ISS :::: " + Arrays.asList(charmap));

    //     while (right < s2.length()) {

    //         System.out
    //                 .println("KKKKKKKKKKK  :::: " + s2.charAt(right) + " :: " + charmap.containsKey(s2.charAt(right)));
    //         if (!charmap.containsKey(s2.charAt(right))) {
    //             System.out.println("INSDIE TH FIRST IF");
    //             if (windowStrLength > 0) {
    //                 if (charmap.containsKey(s2.charAt(left))) {
    //                     int currentValue = charmap.get(s2.charAt(left));
    //                     charmap.put(s2.charAt(left), currentValue++);
    //                     windowStrLength--;
    //                 }
    //             }
    //             left++;
    //             right++;
    //             continue;
    //         }
    //         windowStrLength++;
    //         System.out.println("THE WINDOW STR LENGTH ISS :: " + windowStrLength);
    //         int currentValue = charmap.get(s2.charAt(right));
    //         charmap.put(s2.charAt(right), currentValue--);
    //         System.out.println("THE CHAR AT " + currentValue + " === " + s2.charAt(right));

    //         System.out.println(
    //                 "tue va;ie:::: " + right + " == " + left + " == " + windowSize + " == " + (right - left + 1));
    //         if (right - left + 1 == windowSize) {
    //             System.out.println("INSIDE THE ANSWER CONDITION -- " + windowStrLength);
    //             maxSize = Math.max(maxSize, windowStrLength);
    //         }

    //         right++;
    //         System.out.println("list ATH THE END ISSS :: " + Arrays.asList(charmap));
    //         System.out.println();
    //     }

    //     System.out.println("TOTA; LENGTH IS " + maxSize);
    //     return maxSize == s1.length();
    // }

    public static boolean checkInclusion(String s1, String s2) {
        if(s2.length() < s1.length()) return false;

        int windowSize = s1.length();
        int[] inpFreq = new int[26], windowFreq = new int[26];

        for (int i = 0; i < s1.length(); i++) {
            inpFreq[s1.charAt(i) - 'a']++;
        }


        for (int i = 0; i < s2.length(); i++) {
            windowFreq[s2.charAt(i) - 'a']++;

            if(i >= windowSize){
                windowFreq[s2.charAt(i - windowSize) - 'a']--;
            }

            if(Arrays.equals(inpFreq, windowFreq)){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(checkInclusion("abc", "aabcc"));
    }
}
// @lc code=end

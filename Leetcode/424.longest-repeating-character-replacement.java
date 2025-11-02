/*
 * @lc app=leetcode id=424 lang=java
 *
 * [424] Longest Repeating Character Replacement
 */

// @lc code=start

import java.util.Arrays;
import java.util.HashMap;

class Solution {
    public static int characterReplacement(String s, int k) {
        int[] freq = new int[26];
        int maxFrequency = 0, maxLength = 0, left = 0;

        for (int right = 0; right < s.length(); right++) {

            // getting the current character using char right
            char currentChar = s.charAt(right);
            int windowLength = right - left + 1;
            freq[currentChar - 'A']++;

            maxFrequency = Math.max(maxFrequency, freq[currentChar - 'A']);

            System.out.println("windowLength ::" + (windowLength - maxFrequency) + " - " + k + " : " + (windowLength - maxFrequency > k));
            if (windowLength - maxFrequency > k) {
                freq[s.charAt(left) - 'A']--;
                left++;
                continue;
            }
            System.out.println("GOING TO UPDATE THE WINDOW LENGTH " + maxLength + " : " + windowLength);
            maxLength = Math.max(maxLength, windowLength);
        }
        System.out.println(Arrays.toString(freq));
        return maxLength;
    }

    public static void main(String[] args) {
        int result = characterReplacement("AABABBA", 1);

        System.out.println(result);
    }
}
// @lc code=end

// {A:1}{A:1,B:1}

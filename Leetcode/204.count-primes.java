/*
 * @lc app=leetcode id=204 lang=java
 *
 * [204] Count Primes
 *
 * https://leetcode.com/problems/count-primes/description/
 *
 * algorithms
 * Medium (34.97%)
 * Likes:    8643
 * Dislikes: 1558
 * Total Accepted:    1.2M
 * Total Submissions: 3.3M
 * Testcase Example:  '10'
 *
 * Given an integer n, return the number of prime numbers that are strictly
 * less than n.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: n = 10
 * Output: 4
 * Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: n = 0
 * Output: 0
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: n = 1
 * Output: 0
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 0 <= n <= 5 * 10^6
 * 
 * 
 */

// @lc code=start
import java.util.*;
class Solution {

    
    // NOT Oprtimal for larger inputs
    // public static int countPrimes(int n) {
    //     int count = 0;

    //     if(n == 1 || n == 0){
    //         return 0;
    //     }

    //     for (int i = 2; i < n ; i++) {
    //         if (isPrime(i)) {
    //             // System.out.println("LLLL " + i);
    //             count++;
    //         }
    //     }

    //     return count;
    // }

    // public static boolean isPrime(int n){
    //     for (int i = 2; i * i <= n; i++) {
    //         if(n % i == 0){
    //             return false;
    //         }
    //     }

    //     return true;
    // }

    // Optimsed approach using SIEVE OF ERATOSTHENE
    public static int countPrimes(int n) {
        int[] primes = new int[n];

        Arrays.fill(primes, 1);
        
        primes[0] = 0;
        primes[1] = 0;

        for (int i = 2; i * i < n; i++) {
            System.out.println("KKKKKKK " + i);

            if(primes[i] == 1){

                for (int j = i * i; j < n ; j+= i) {
                    primes[j] = 0;
                }
            }

            System.out.println("Arrays to strings :: " + Arrays.toString(primes));
        }

        for (int i = 0; i < primes.length; i++) {
            if(primes[i] == 1){
                System.out.print(i + " ");
            }
        }

        return 1;
    }




    public static void main(String[] args) {

        
        int n = 10;

        System.out.println("LLLL  " + countPrimes(n));
    }
}
// @lc code=end


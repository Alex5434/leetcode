/*
 * @lc app=leetcode id=54 lang=java
 *
 * [54] Spiral Matrix
 *
 * https://leetcode.com/problems/spiral-matrix/description/
 *
 * algorithms
 * Medium (48.12%)
 * Likes:    16833
 * Dislikes: 1510
 * Total Accepted:    2.2M
 * Total Submissions: 3.9M
 * Testcase Example:  '[[1,2,3],[4,5,6],[7,8,9]]'
 *
 * Given an m x n matrix, return all elements of the matrix in spiral order.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * Output: [1,2,3,6,9,8,7,4,5]
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 10
 * -100 <= matrix[i][j] <= 100
 * 
 * 
 */

// @lc code=start
class Solution {
    // public List<Integer> spiralOrder(int[][] matrix) {

    // }

/*
 * 

        🚧 Need to spiral pattern

    1 2 3 
    4 5 6 
    7 8 9

    1  2  3  6  9  8  7  4  5
    00 01 02 12 22 21 20 10 11

    mat [][]

    // loop through i ultil (row.length / 2) + 1

    // parse top
        // start i+j and run until (max.length - 1 - i);

    // parse right
        // start in j=i+1; i< rows.length - 1 - i; 

    // parse bottom
        // start in j=rows.length - 1 - i; j <= 0 ; j--;
        
    // parse left

 */
    public static void spiralOrder(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int ind = 0;
        int result[] = new int[rows * cols];
        for (int i = 0; i <= rows / 2; i++) {

            // logic for TOP
            for (int j = i; j < (cols - i); j++) {
                System.out.println("THE MATRIX VALUE ISSS ::: " + matrix[i][j]);
                result[ind++] = matrix[i][j];
            }

            // logic for RIGHT

            for (int j = (rows - i - 2); j < rows - i - 1; j++) {
                System.out.println("THE I AND J ISS" + j + " " + (cols - i - 1));
                System.out.println("PPPPPPP :::: " + matrix[j][cols - i - 1]);
            }

        }
    }

    public static void main(String[] args) {
        // int matrix[][] = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } };
        int matrix[][] = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };

        spiralOrder(matrix);
    }
}
// @lc code=end

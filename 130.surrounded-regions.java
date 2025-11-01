/*
 * @lc app=leetcode id=130 lang=java
 *
 * [130] Surrounded Regions
 *
 * https://leetcode.com/problems/surrounded-regions/description/
 *
 * algorithms
 * Medium (43.24%)
 * Likes:    9616
 * Dislikes: 2171
 * Total Accepted:    1.1M
 * Total Submissions: 2.4M
 * Testcase Example:  '[["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O","X","X"]]'
 *
 * You are given an m x n matrix board containing letters 'X' and 'O', capture
 * regions that are surrounded:
 * 
 * 
 * Connect: A cell is connected to adjacent cells horizontally or
 * vertically.
 * Region: To form a region connect every 'O' cell.
 * Surround: The region is surrounded with 'X' cells if you can connect the
 * region with 'X' cells and none of the region cells are on the edge of the
 * board.
 * 
 * 
 * To capture a surrounded region, replace all 'O's with 'X's in-place within
 * the original board. You do not need to return anything.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: board =
 * [["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O","X","X"]]
 * 
 * Output:
 * [["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X","X"]]
 * 
 * Explanation:
 * 
 * In the above diagram, the bottom region is not captured because it is on the
 * edge of the board and cannot be surrounded.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: board = [["X"]]
 * 
 * Output: [["X"]]
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * m == board.length
 * n == board[i].length
 * 1 <= m, n <= 200
 * board[i][j] is 'X' or 'O'.
 * 
 * 
 */

// @lc code=start

import java.util.Arrays;

class Solution {
    public static void solve(char[][] board) {

        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                if (r == 0 || r == board.length - 1 || c == 0 || c == board[0].length - 1) {
                    dfs(board, r, c);
                }
            }
        }

        
        System.out.println("LLLLLLL : " + Arrays.deepToString(board)); 

        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                if (board[r][c] == 'O') {
                    board[r][c] = 'X';
                } else if (board[r][c] == '#') {
                    board[r][c] = 'O';
                }
            }
        }
    }

    public static void dfs(char[][] board, int sr, int sc) {
        if (sr < 0 || sc < 0 || sr >= board.length || sc >= board[0].length || board[sr][sc] != 'O') {
            return;
        }

        board[sr][sc] = '#';

        dfs(board, sr + 1, sc);
        dfs(board, sr - 1, sc);
        dfs(board, sr, sc + 1);
        dfs(board, sr, sc - 1);
    }

    public static void main(String[] args) {
        // char grid[][] = {
        //         { 'X', 'X', 'X', 'X' },
        //         { 'X', 'O', 'O', 'X' },
        //         { 'X', 'X', 'O', 'X' },
        //         { 'X', 'O', 'X', 'X' } };

        char grid[][] = {
            {'X','O','X','O','X','O'},
            {'O','X','O','X','O','X'},
            {'X','O','X','O','X','O'},
            {'O','X','O','X','O','X'}
        };

        // char grid[][] = { { 'X' } };

        solve(grid);

        System.out.println("ATTYSSS :: " + Arrays.deepToString(grid));

    }
}
// @lc code=end

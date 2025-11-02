/*
 * @lc app=leetcode id=2257 lang=java
 *
 * [2257] Count Unguarded Cells in the Grid
 *
 * https://leetcode.com/problems/count-unguarded-cells-in-the-grid/description/
 *
 * algorithms
 * Medium (65.71%)
 * Likes:    1130
 * Dislikes: 81
 * Total Accepted:    152.3K
 * Total Submissions: 224.8K
 * Testcase Example:  '4\n6\n[[0,0],[1,1],[2,3]]\n[[0,1],[2,2],[1,4]]'
 *
 * You are given two integers m and n representing a 0-indexed m x n grid. You
 * are also given two 2D integer arrays guards and walls where guards[i] =
 * [rowi, coli] and walls[j] = [rowj, colj] represent the positions of the i^th
 * guard and j^th wall respectively.
 * 
 * A guard can see every cell in the four cardinal directions (north, east,
 * south, or west) starting from their position unless obstructed by a wall or
 * another guard. A cell is guarded if there is at least one guard that can see
 * it.
 * 
 * Return the number of unoccupied cells that are not guarded.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: m = 4, n = 6, guards = [[0,0],[1,1],[2,3]], walls =
 * [[0,1],[2,2],[1,4]]
 * Output: 7
 * Explanation: The guarded and unguarded cells are shown in red and green
 * respectively in the above diagram.
 * There are a total of 7 unguarded cells, so we return 7.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: m = 3, n = 3, guards = [[1,1]], walls = [[0,1],[1,0],[2,1],[1,2]]
 * Output: 4
 * Explanation: The unguarded cells are shown in green in the above diagram.
 * There are a total of 4 unguarded cells, so we return 4.
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= m, n <= 10^5
 * 2 <= m * n <= 10^5
 * 1 <= guards.length, walls.length <= 5 * 10^4
 * 2 <= guards.length + walls.length <= m * n
 * guards[i].length == walls[j].length == 2
 * 0 <= rowi, rowj < m
 * 0 <= coli, colj < n
 * All the positions in guards and walls are unique.
 * 
 * 
 */

// @lc code=start

import java.util.Arrays;

class Solution {
    public static int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        char grid[][] = new char[m][n];
        // Arrays.fill(grid, 0);

        for (char[] row : grid) {
            Arrays.fill(row, 'O');
        }
        for (int r = 0; r < guards.length; r++) {
            int[] point = guards[r];
            grid[point[0]][point[1]] = 'G';
        }

        for (int r = 0; r < walls.length; r++) {
            int[] point = walls[r];
            grid[point[0]][point[1]] = 'W';
        }

        int directions[][] = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

        for (int[] guard : guards) {
            for (int[] dir : directions) {
                int newR = guard[0] + dir[0];
                int newC = guard[1] + dir[1];

                while (newR >= 0 && newC >= 0 && newR < m && newC < n && grid[newR][newC] != 'W' && grid[newR][newC] != 'G') {
                    if(grid[newR][newC] == 'O'){
                        grid[newR][newC] = 'N';
                    }
                    newR += dir[0];
                    newC += dir[1];
                }
            }
        }
        

        int unGuarded = 0;
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if(grid[r][c] == 'O'){
                    unGuarded++;
                }
            }
        }

        return unGuarded;
    }

    // public static void search(char[][] grid, boolean isPositive, int sr, int sc) {
    //     System.out.println("KKKKKKKKKKKK");
    //     while (true) {
    //         if (sr < 0 || sc < 0 || sr >= grid.length || sc >= grid[0].length || grid[sr][sc] == 'W'
    //                 || grid[sr][sc] == 'N') {
    //             return;
    //         }

    //         System.out.println("OOOOOOOOOO");

    //         grid[sr][sc] = 'N';
    //         sr = isPositive ? sr++ : sr--;
    //     }

    // }

    // Traditional DFS Failed
    // public static void dfs(char[][] grid, int sr, int sc, int[] source) {

    // System.out.println(
    // "IIII : " + Arrays.deepToString(grid) + " :: " + sr + " " + sc + " " +
    // Arrays.toString(source));
    // if (sr < 0 || sc < 0 || sr >= grid.length || sc >= grid[0].length ||
    // (source[0] != sr && source[1] != sc) || grid[sr][sc] == 'W'
    // ) {

    // // System.out.println("LLLLLLL: " + (source[0] != sr && source[1] != sc));
    // // System.out.println("OOOO " + (sr < 0) + " " + (sc < 0) + " " + (sr >=
    // // grid.length) + " " + (sc >= grid[0].length) + " " + (grid[sr][sc] ==
    // 'W'));
    // // System.out.println("UUUU " + ((source[0] + " " +sr + " :: " + source[1] +
    // "
    // // :: " + sc)));
    // return;
    // }

    // grid[sr][sc] = 'N';

    // dfs(grid, sr - 1, sc, source);
    // dfs(grid, sr + 1, sc, source);
    // dfs(grid, sr, sc - 1, source);
    // dfs(grid, sr, sc + 1, source);

    // }

    public static void main(String[] args) {

        // int m = 4, n = 6;
        // int guard[][] = { { 0, 0 }, { 1, 1 }, { 2, 3 } };
        // int walls[][] = { { 0, 1 }, { 2, 2 }, { 1, 4 } };

        int m = 3, n = 3;
        int guard[][] = { { 1, 1 } };
        int walls[][] = { { 0, 1 }, { 1, 0 }, { 2, 1 }, { 1, 2 } };

        int result = countUnguarded(m, n, guard, walls);

    }
}
// @lc code=end

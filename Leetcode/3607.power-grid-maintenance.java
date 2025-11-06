
import java.util.ArrayList;

/* 
You are given an integer c representing c power stations, each with a unique identifier id from 1 to c (1‑based indexing).

These stations are interconnected via n bidirectional cables, represented by a 2D array connections, where each element connections[i] = [ui, vi] indicates a connection between station ui and station vi. 
Stations that are directly or indirectly connected form a power grid.

Initially, all stations are online (operational).

You are also given a 2D array queries, where each query is one of the following two types:

[1, x]: A maintenance check is requested for station x. If station x is online, it resolves the check by itself. If station x is offline, the check is resolved by the operational station with the smallest id in the same power grid as x. If no operational station exists in that grid, return -1.

[2, x]: Station x goes offline (i.e., it becomes non-operational).

Return an array of integers representing the results of each query of type [1, x] in the order they appear.

Note: The power grid preserves its structure; an offline (non‑operational) node remains part of its grid and taking it offline does not alter connectivity.

 

Example 1:

Input: c = 5, connections = [[1,2],[2,3],[3,4],[4,5]], queries = [[1,3],[2,1],[1,1],[2,2],[1,2]]

Output: [3,2,3]

5 => power stations (1 based indexing)
connections[] => [sta1, sta2] => [1,2] (All stations are operational)
queries => 
    [1, sta] => main-check 

Explanation:

Initially, all stations {1, 2, 3, 4, 5} are online and form a single power grid.
Query [1,3]: Station 3 is online, so the maintenance check is resolved by station 3.
Query [2,1]: Station 1 goes offline. The remaining online stations are {2, 3, 4, 5}.
Query [1,1]: Station 1 is offline, so the check is resolved by the operational station with the smallest id among {2, 3, 4, 5}, which is station 2.
Query [2,2]: Station 2 goes offline. The remaining online stations are {3, 4, 5}.
Query [1,2]: Station 2 is offline, so the check is resolved by the operational station with the smallest id among {3, 4, 5}, which is station 3.
Example 2:

Input: c = 3, connections = [], queries = [[1,1],[2,1],[1,1]]

Output: [1,-1]

Explanation:

There are no connections, so each station is its own isolated grid.
Query [1,1]: Station 1 is online in its isolated grid, so the maintenance check is resolved by station 1.
Query [2,1]: Station 1 goes offline.
Query [1,1]: Station 1 is offline and there are no other stations in its grid, so the result is -1.
 

Constraints:

1 <= c <= 105
0 <= n == connections.length <= min(105, c * (c - 1) / 2)
connections[i].length == 2
1 <= ui, vi <= c
ui != vi
1 <= queries.length <= 2 * 105
queries[i].length == 2
queries[i][0] is either 1 or 2.
1 <= queries[i][1] <= c
*/

// @lc code=start

import java.util.*;

class Solution {

    public static void processQueries(int c, int[][] connections, int[][] queries) {
        List<Integer> onlineStations = new ArrayList<>();
        List<Set<Integer>> powerGrid = new ArrayList<>();

        // add online stations
        for (int i = 1; i <= c; i++) {
            onlineStations.add(i);
        }

        // formed the power grid array
        for (int i = 0; i < connections.length; i++) {
            int currentCon[] = connections[i];

            int sta1 = currentCon[0];
            int sta2 = currentCon[1];

            boolean isAdded = false;

            for (Set<Integer> row : powerGrid) {

                if (row.contains(sta1) || row.contains(sta2)) {
                    isAdded = true;
                    row.add(sta1);
                    row.add(sta2);
                    break;
                }
            }

            if (!isAdded) {
                Set<Integer> grid = new HashSet<>();
                grid.add(sta1);
                grid.add(sta2);
                powerGrid.add(grid);
            }
        }

        // perform the query operations

        System.out.println("kkkkkkk ::: " + powerGrid);

    }

    public static void main(String[] args) {
        // int c = 5;
        // int[][] connections = { { 1, 2 }, { 2, 3 }, { 3, 4 }, { 4, 5 } };
        // int[][] queries = { { 1, 3 }, { 2, 1 }, { 1, 1 }, { 2, 2 }, { 1, 2 } };

        // int c = 3;
        // int[][] connections = {};
        // int[][] queries = { { 1, 1 }, { 2, 1 }, { 1, 1 } };


        // int c = 4;
        // int[][] connections = { {1, 2}, {2, 3}, {3, 4}, {4, 1} };
        // int[][] queries = {
        //     {1, 1}, // check node 1
        //     {2, 2}, // take node 2 offline
        //     {1, 3}, // check node 3 (should still be connected)
        //     {2, 4}, // take node 4 offline
        //     {1, 1}  // check node 1 again
        // };

        // int c = 5;
        // int[][] connections = { {1, 2}, {1, 3}, {1, 4}, {1, 5} };
        // int[][] queries = {
        //     {1, 1}, // check node 1
        //     {1, 3}, // check node 3
        //     {2, 1}, // take central node offline
        //     {1, 3}, // check node 3 again (isolated)
        //     {1, 5}  // check another leaf
        // };

        int c = 6;
        int[][] connections = { {1, 2}, {2, 3}, {4, 5} };
        int[][] queries = {
            {1, 1}, // check node 1 (component of size 3)
            {1, 5}, // check node 5 (component of size 2)
            {2, 2}, // remove node 2 (breaks first component)
            {1, 3}, // check node 3 (isolated now)
            {1, 1}  // check node 1 (still connected to none)
        };

        processQueries(c, connections, queries);
    }
}
// @lc code=end

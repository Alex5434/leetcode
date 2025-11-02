package concepts;

import java.util.*;

public class Bfs {
    public static ArrayList<Integer> bfsSearch(int vertices, ArrayList<ArrayList<Integer>> adj) {
        boolean visited[] = new boolean[vertices];
        // ArrayList<Integer>
        Queue<Integer> queue = new LinkedList<>();

        ArrayList<Integer> unkBfs = new ArrayList<>();

        queue.add(0);
        visited[0] = true;

        while (!queue.isEmpty()) {
            Integer currentNode = queue.poll();
            unkBfs.add(currentNode);

            for(Integer adjNode : adj.get(currentNode)){
                if(!visited[adjNode]){
                    visited[adjNode] = true;
                    queue.add(adjNode);
                }
            }
        }

        return unkBfs;
    }

    public static void main(String[] args) {

    }
}

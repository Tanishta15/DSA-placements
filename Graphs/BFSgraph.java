import java.util.*;

public class BFSgraph {
    public static void main(String[] args) {
        // Number of vertices
        int v = 5;

        // Create adjacency list
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= v; i++) {
            adj.add(new ArrayList<>());
        }

        // Destination vertex
        int dest = 4;

        // Initialize pred and dist arrays
        int pred[] = new int[v + 1];
        int dist[] = new int[v + 1];

        // Visited array for counting components
        boolean[] vis = new boolean[v + 1];

        // Perform BFS
        boolean isReached = BFS(adj, 1, dest, v, pred, dist);

        // Output the result of BFS
        if (isReached) {
            System.out.println("Path exists from source to destination");
        } else {
            System.out.println("No path exists from source to destination");
        }

        // Counting number of connected components
        int components = 0;
        for (int i = 1; i <= v; i++) {
            if (!vis[i]) {
                components++;
                BFS(adj, i, dest, v, pred, dist, vis);
            }
        }

        System.out.println("Number of connected components: " + components);
    }

    private static boolean BFS(ArrayList<ArrayList<Integer>> adj, int src, int dest, int v, int[] pred, int[] dist) {
        // dist[] will store distance from node
        // pred[] is which node was previously used to reach that node
        LinkedList<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[v + 1]; // Corrected array size

        // Initialize arrays
        for (int i = 0; i <= v; i++) {
            visited[i] = false;              // Mark all nodes as not visited
            dist[i] = Integer.MAX_VALUE;     // Initially fill with max value
            pred[i] = -1;                    // Initially -1 (no predecessor)
        }

        visited[src] = true;                // Mark the source as visited
        dist[src] = 0;                      // Distance from src to src is 0
        queue.add(src);                     // Add source to queue

        // BFS algorithm
        while (!queue.isEmpty()) {
            int cur = queue.remove();       // Remove the first element from the queue
            for (int i = 0; i < adj.get(cur).size(); i++) {
                int neighbor = adj.get(cur).get(i);
                if (!visited[neighbor]) {  // If neighbor is not visited
                    visited[neighbor] = true;     // Mark it as visited
                    dist[neighbor] = dist[cur] + 1;  // Update the distance
                    pred[neighbor] = cur;           // Set the predecessor
                    queue.add(neighbor);            // Add neighbor to queue

                    if (neighbor == dest) { // If destination is reached
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private static void BFS(ArrayList<ArrayList<Integer>> adj, int src, int dest, int v, int[] pred, int[] dist, boolean[] vis) {
        // Similar to the BFS above but uses the passed `vis` array to track visited nodes across multiple calls
        LinkedList<Integer> queue = new LinkedList<>();
        vis[src] = true;
        dist[src] = 0;
        queue.add(src);

        while (!queue.isEmpty()) {
            int cur = queue.remove();
            for (int i = 0; i < adj.get(cur).size(); i++) {
                int neighbor = adj.get(cur).get(i);
                if (!vis[neighbor]) {
                    vis[neighbor] = true;
                    dist[neighbor] = dist[cur] + 1;
                    pred[neighbor] = cur;
                    queue.add(neighbor);
                }
            }
        }
    }
}

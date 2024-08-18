import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> dfsOfGraph(int V, List<List<Integer>> adj) {
        boolean[] visited = new boolean[V]; // Track visited nodes
        List<Integer> result = new ArrayList<>(); // Store DFS result
        for (int i = 0; i < V; i++) { // To handle disconnected graphs
            if (!visited[i]) {
                dfs(i, visited, adj, result); // Start DFS from node i if not visited
            }
        }
        return result; // Return the result of DFS traversal
    }

    private void dfs(int v, boolean[] visited, List<List<Integer>> adj, List<Integer> result) {
        visited[v] = true; // Mark the current node as visited
        result.add(v); // Add the current node to the result list
        // Traverse all the neighbors of the current node
        for (int neighbor : adj.get(v)) {
            if (!visited[neighbor]) { // If the neighbor is not visited
                dfs(neighbor, visited, adj, result); // Recursively visit the neighbor
            }
        }
    }
}

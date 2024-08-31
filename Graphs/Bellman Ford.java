
import java.util.*;

class GFG {
	static class Edge {
		int src, dest, w;
	}

	static class Graph {
		int V, E;
		Edge edge[];
	}

	static Graph createGraph(int V, int E)
	{
		Graph graph = new Graph();
		graph.V = V;
		graph.E = E;
		graph.edge = new Edge[graph.E];

		for (int i = 0; i < graph.E; i++) {
			graph.edge[i] = new Edge();
		}

		return graph;
	}

	static boolean isNegCycleBellmanFord(Graph graph, int src, int dist[])
	{
		int V = graph.V;
		int E = graph.E;

		//Initialize distances from src to all other vertices as INFINITE
		for (int i = 0; i < V; i++)
		dist[i] = Integer.MAX_VALUE;
		dist[src] = 0;

        // A simple shortest path from src to any other vertex can have at-most |V| - 1 edges
		for (int i = 1; i <= V - 1; i++) {
			for (int j = 0; j < E; j++) {
				int u = graph.edge[j].src;
				int v = graph.edge[j].dest;
				int w = graph.edge[j].w;

				if (dist[u] != Integer.MAX_VALUE && dist[u] + w < dist[v])
					dist[v] = dist[u] + w;
			}
		}

		// The above step guarantees shortest distances if graph doesn't contain negative weight cycle.
		// If we get a shorter path, then there is a cycle.
		for (int i = 0; i < E; i++) {
			int u = graph.edge[i].src;
			int v = graph.edge[i].dest;
			int w = graph.edge[i].w;

			if (dist[u] != Integer.MAX_VALUE
				&& dist[u] + w < dist[v])
				return true;
		}

		return false;
	}

	// Returns true if given graph has negative weight cycle.
	static boolean isNegCycleDisconnected(Graph graph)
	{
		int V = graph.V;

		// To keep track of visited vertices to avoid recomputations.
		boolean visited[] = new boolean[V];
		Arrays.fill(visited, false);

		// This array is filled by Bellman-Ford
		int dist[] = new int[V];

		// Call Bellman-Ford for all those vertices that are not visited
		for (int i = 0; i < V; i++) {
			if (visited[i] == false) {

				// If cycle found
				if (isNegCycleBellmanFord(graph, i, dist))
					return true;

				// Mark all vertices that are visited in above call.
				for (int j = 0; j < V; j++)
					if (dist[j] != Integer.MAX_VALUE)
						visited[j] = true;
			}
		}
		return false;
	}

	// Driver Code
	public static void main(String[] args)
	{
		int V = 5, E = 8;
		Graph graph = createGraph(V, E);

		// Add edge 0-1 (or A-B in above figure)
		graph.edge[0].src = 0;
		graph.edge[0].dest = 1;
		graph.edge[0].w = -1;

		// Add edge 0-2 (or A-C in above figure)
		graph.edge[1].src = 0;
		graph.edge[1].dest = 2;
		graph.edge[1].w = 4;

		// Add edge 1-2 (or B-C in above figure)
		graph.edge[2].src = 1;
		graph.edge[2].dest = 2;
		graph.edge[2].w = 3;

		// Add edge 1-3 (or B-D in above figure)
		graph.edge[3].src = 1;
		graph.edge[3].dest = 3;
		graph.edge[3].w = 2;

		// Add edge 1-4 (or A-E in above figure)
		graph.edge[4].src = 1;
		graph.edge[4].dest = 4;
		graph.edge[4].w = 2;

		// Add edge 3-2 (or D-C in above figure)
		graph.edge[5].src = 3;
		graph.edge[5].dest = 2;
		graph.edge[5].w = 5;

		// Add edge 3-1 (or D-B in above figure)
		graph.edge[6].src = 3;
		graph.edge[6].dest = 1;
		graph.edge[6].w = 1;

		// Add edge 4-3 (or E-D in above figure)
		graph.edge[7].src = 4;
		graph.edge[7].dest = 3;
		graph.edge[7].w = -3;

		if (isNegCycleDisconnected(graph))
			System.out.println("Yes");
		else
			System.out.println("No");
	}
}
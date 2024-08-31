class Solution
{
    public void shortest_distance(int[][] matrix)
    {
	int n=matrix.length;
	for(int i=0;i<n;i++){
		for(int j=0;j<n;j++){
			if(matrix[i][j]==-1){
				matrix[i][j]=(int)(1e8);//100,000,000
			}
			if(i==j){
				matrix[i][j]=0;
			}
		}
	}
	for(int k=0;k<n;k++){
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				matrix[i][j]=Math.min(matrix[i][j],matrix[i][k]+matrix[k][j]);
			}
		}
	}
	for(int i=0;i<n;i++){
		for(int j=0;j<n;j++){
			if(matrix[i][j]==(int)(1e8)){//100,000,000
				matrix[i][j]=-1;
			}
		}
	}
    }
}
//DETECTING CYCLE

class GFG
{
	static final int V = 4;
	static final int INF = 99999;
	
	// Returns true if graph has negative weight cycle else false.
	static boolean negCyclefloydWarshall(int graph[][])
	{
		int dist[][] = new int[V][V], i, j, k;

		for (i = 0; i < V; i++)
			for (j = 0; j < V; j++)
				dist[i][j] = graph[i][j];
	
		for (k = 0; k < V; k++)
		{
			// Pick all vertices as source one by one
			for (i = 0; i < V; i++)
			{
				// Pick all vertices as destination for the above picked source
				for (j = 0; j < V; j++)
				{
					
					// update the value of dist[i][j]
					if (dist[i][k] + dist[k][j] < dist[i][j])
							dist[i][j] = dist[i][k] + dist[k][j];
				}
			}
		}
	
		// If distance of any vertex from itself becomes negative, then there is a negative weight cycle.
		for (i = 0; i < V; i++)
			if (dist[i][i] < 0)
				return true;

		return false; 
	}
			public static void main (String[] args)
	{
		int graph[][] = { {0, 1, INF, INF},
						{INF, 0, -1, INF},
						{INF, INF, 0, -1},
						{-1, INF, INF, 0}};
		
		if (negCyclefloydWarshall(graph))
			System.out.print("Yes");
		else
			System.out.print("No"); 
	}
}
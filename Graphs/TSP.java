import java.io.*;
import java.util.*;

class TSP {
	static int n = 4;
	static int MAX = 1000000;

	static int[][] dist = {
		{ 0, 0, 0, 0, 0 }, 
        { 0, 0, 10, 15, 20 },
		{ 0, 10, 0, 25, 25 }, 
        { 0, 15, 25, 0, 30 },
		{ 0, 20, 25, 30, 0 },
	};
	//memoization table used to store results of subproblems
	//1 << (n + 1) represents the number of subsets of cities, since each city can either be included or excluded in a subset, represented by a bitmask
	//memo[i][mask] stores the minimum cost to visit a set of cities
	static int[][] memo = new int[n + 1][1 << (n + 1)];
	//mask is a bitmask representing the set of cities visited so far.
	//if mask = 1011, then cities represented by the 1-bits are visited: city 1, city 2, and city 4
	static int fun(int i, int mask)
	{
	//1 << i shifts 1 to the left by i positions, representing city i.
	// | 3 ensures that cities 1 and i are visited. If this is true, it returns the distance from city 1 to city i
		if (mask == ((1 << i) | 3))
			return dist[1][i];
	//If subproblem has already been solved, the result is fetched from the memo
		if (memo[i][mask] != 0)
			return memo[i][mask];

		int res = MAX; 

		for (int j = 1; j <= n; j++)
		//(mask & (1 << j)) != 0 checks if city j is visited
		//j != i ensures not to move to the same city
		//mask & (~(1 << i)) removes city i from the set of visited cities to compute min cost path ending at city i
			if ((mask & (1 << j)) != 0 && j != i && j != 1)
			res = Math.min(res,fun(j, mask & (~(1 << i)))+ dist[j][i]);
		return memo[i][mask] = res;
	}
	public static void main(String[] args)
	{
		int ans = MAX;
		for (int i = 1; i <= n; i++)
		//creates a bitmask with all cities marked as visited + cost of returning to the starting city from the current city i
			ans = Math.min(ans, fun(i, (1 << (n + 1)) - 1)+ dist[i][1]);

		System.out.println(
			"The cost of most efficient tour = " + ans);
	}
}
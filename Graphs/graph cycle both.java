import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        int vis[]=new int[V];
        for(int i=0;i<V;i++){
            if(vis[i]==0){
                if(dfs(i,-1,vis,adj)==true) 
                return true;
            }
        }
        return false;
    }
    
    private boolean dfs(int node,int parent,int vis[],ArrayList<ArrayList<Integer>> adj){
        vis[node]=1;
        for(int adjacentNode:adj.get(node)){
            if(vis[adjacentNode]==0){
                if(dfs(adjacentNode,node,vis,adj)==true)
                    return true;
            }
                else if(adjacentNode!=parent) return true; 
        }
        return false;
    }


    // Function to detect cycle in a directed graph.
    
    public boolean dfs(int node,int visited [], int pathVisited [],ArrayList<ArrayList<Integer>> adj){
        visited[node] = 1;
        pathVisited[node] = 1;
        
        for(int i : adj.get(node)){
            if(visited[i] == 0){
                if(dfs(i,visited,pathVisited,adj)){
                    return true;
                }
            }
            else if(pathVisited[i] == 1){
                return true;
            }
        }
       pathVisited[node] = 0;
       return false;
    }
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        
        int visited [] = new int[V];
        int pathVisited[] = new int[V];
        Arrays.fill(visited,0);
        Arrays.fill(pathVisited,0);
        for(int i = 0; i < V ; i++){
            if(visited[i] == 0){
                if(dfs(i,visited, pathVisited,adj))return true;
            }
        }
        return false;
    }
}

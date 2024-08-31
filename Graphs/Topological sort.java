import java.util.*;
class Solution
{
    //Function to return list containing vertices in Topological order.
    static void topoDFS(int node , ArrayList<ArrayList<Integer>> adj , boolean[] visited , Stack<Integer> s){
        visited[node] = true;
        for(Integer x : adj.get(node)){
            if(!visited[x]){
                topoDFS(x , adj , visited , s);
            }
        }
        s.push(node);
    }
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
    {
        // add your code here
        List<Integer> topoList = new ArrayList<>();
        boolean[] visited = new boolean[V];
        Arrays.fill(visited , false);
        Stack<Integer> s = new Stack<>();
        for(int i = 0; i < V; i++){
            if(!visited[i]){
                topoDFS(i , adj , visited , s);
            }
        }
        while(!s.isEmpty()){
            int e = s.pop();
            topoList.add(e);
        }
        int[] ans = new int[topoList.size()];
        for(int i = 0; i < ans.length; i++){
            ans[i] = topoList.get(i);
        }
        return ans;
    }
}
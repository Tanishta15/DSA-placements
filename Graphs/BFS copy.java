import java.util.*;

public class BFS {
    static class Edge {
        int src;
        int dest;

        public Edge(int s, int d) {
            this.src = s;
            this.dest = d;
        }
    }

    public static void createGraph(ArrayList<Edge> graph[]) {// storing arraylists in an array
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<Edge>();// every index has an empty arraylist
        }
        graph[0].add(new Edge(0, 2));
        graph[1].add(new Edge(1, 2));
        graph[1].add(new Edge(1, 3));
        graph[2].add(new Edge(2, 1));
        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 3));
        graph[3].add(new Edge(3, 2));
        graph[3].add(new Edge(3, 1));
    }

    public static void BFS(ArrayList<Edge> graph[], int v, boolean visited[], int start) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);// starting point is defined
        while (!q.isEmpty()) {// while q is not empty
            int curr = q.remove();
            if (visited[curr] == false) {// if not visited then only visit
                System.out.println(curr);
                visited[curr] = true;

                for (int i = 0; i < graph[curr].size(); i++) {// finding currents neighbor
                    Edge e = graph[curr].get(i);// find the edge
                    q.add(e.dest);// adding the neighbor
                }
            }
        }
    }

    public static void DFS(ArrayList<Edge> graph[], int curr, boolean visited[]){
        System.out.println(curr);
        visited[curr]=true;
        for(int i=0;i<graph[curr].size();i++){//loop to visit all the neighbours
Edge e=graph[curr].get(i);
if (visited[e.dest]==false) {
    DFS(graph,e.dest,visited); 
}
        }
    }

    //time complexity is O(v^v), exponential
    public static void printPath(ArrayList<Edge> graph[],boolean visited[],int curr,String path,int tar){
if(curr==tar){
    System.out.println(path);
    return;
}
for(int i=0;i<graph[curr].size();i++){
Edge e=graph[curr].get(i);
if (!visited[e.dest]) {//if the current node is not visited
    visited[curr]=true;//set current node as true i.e visited
    printPath(graph, visited, e.dest, path+e.dest, tar);//path+e.dest is adding all prev traversed nodes
    visited[curr]=false;//when we are going back we make nodes false so we can also explore other paths
}
}
    }

    public static boolean isCycle(ArrayList<Edge> graph[],boolean visited[],int curr,boolean recur[]){//boolean recursion stack to tell if any cycle is same
    visited[curr]=true;//when reach the node make it current
    recur[curr]=true;//add it to the recursion stack
    for(int i=0;i<graph[curr].size();i++){
        Edge e=graph[curr].get(i);//get edge
        if (recur[e.dest]) {//e.dest is neighbour,if it already exists in stack
            return true;
        }
        else if(!visited[e.dest]){//if not visited then visit
            if(isCycle(graph, visited, e.dest, recur)){
                return true;
            }
        }
    }
    recur[curr]=false;//remove while going back
    return false;//if no cycle detected
    }

        public static void topology(ArrayList<Edge>[] graph, int curr, boolean[] visited, Stack<Integer> stack) {
            visited[curr] = true;
            for (int i = 0; i < graph[curr].size(); i++) {
                Edge e = graph[curr].get(i); // get edge
                if (!visited[e.dest]) { // if not visited then visit
                    topology(graph, e.dest, visited, stack);
                }
            }
            stack.push(curr);
        }
    
        public static void topsort(ArrayList<Edge>[] graph, int v) {
            boolean[] visited = new boolean[v];
            Stack<Integer> stack = new Stack<>();
            for (int i = 0; i < v; i++) {
                if (!visited[i]) {
                    topology(graph, i, visited, stack);
                }
            }
            while (!stack.isEmpty()) {
                System.out.println(stack.pop());
            }
        }

        public static boolean cycleUndirected(ArrayList<Edge>[] graph, int curr, boolean[] visited, int parent){
            visited[curr]=true;
            for(int i=0;i<graph[curr].size();i++){
                Edge e=graph[curr].get(i);//get edge

                 if(visited[e.dest]&&e.dest!=parent){//if not visited then visit
                    if(cycleUndirected(graph, e.dest, visited, curr)){
                        return true;
                    }
                }
                else if(!visited[e.dest]) {
                    if (cycleUndirected(graph, e.dest, visited, parent)) {
                        return true;
                    }
                }
            }
            return false;

        }
    public static void main(String[] args) {
        int v = 4;
        ArrayList<Edge> graph[] = new ArrayList[v];

        boolean visited[] = new boolean[v];
        createGraph(graph);
        for (int i = 0; i < v; i++) {// use specially for disconnected graph
            if (visited[i] == false) {
                BFS(graph, v, visited, i);
                DFS(graph,0,visited);
            }
        }
        int src=0,tar=3;
        printPath(graph, new boolean[v], src, "0", tar);

boolean recur[]=new boolean[v];
for(int i=0;i<v;i++){//path for disconnected graph
    if(!visited[i]){
        boolean isCycle=isCycle(graph, visited, 0, recur);
        if (isCycle) {
            System.out.println(isCycle);
            break;
        }
    }
}
topsort(graph, v);
System.out.println(cycleUndirected(graph, 0, new boolean[v], -1));
        }
    }

//Topological sorting works for directed acyclic graph.
//It is a linear order of vertices such that every directed edge u->v is in order
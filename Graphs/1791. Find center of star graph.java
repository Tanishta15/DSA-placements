class Solution {
    public int findCenter(int[][] edges) {
        if(edges[0][0]==edges[1][0]||edges[0][0]==edges[1][1])
        //If the first node of the first edge is equal to the first or second node of the second edge, it is the center.
        //Otherwise, the second node of the first edge is the center.
            return edges[0][0];
        else
            return edges[0][1];
    }
}
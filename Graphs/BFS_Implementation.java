// { Driver Code Starts
// Initial Template for Java
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < V; i++) adj.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                // adj.get(v).add(u);
            }
            Solution obj = new Solution();
            ArrayList<Integer> ans = obj.bfsOfGraph(V, adj);
            for (int i = 0; i < ans.size(); i++)
                System.out.print(ans.get(i) + " ");
            System.out.println();
        }
    }
}
// } Driver Code Ends



class Solution {
    // Function to return Breadth First Traversal of given graph.
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        
        boolean[] visited = new boolean[V];
        ArrayList<Integer> result = new ArrayList<Integer>(V);
        
        for(int i=0; i<V; i++){
            if(visited[i] == false){
                bfs(i, adj, visited, result);
            }
        }
        
        return result;
        
    }
    
    public ArrayList<Integer> bfs(int s, ArrayList<ArrayList<Integer>> adj, boolean[] visited, ArrayList<Integer> result){
        Queue<Integer> queue = new LinkedList<Integer>();
        visited[s] = true;
        queue.add(s);
        
        while(queue.isEmpty() == false){
            int u = queue.poll();
            result.add(u);
            for(int v: adj.get(u)){
                if(visited[v] == false){
                    visited[v] = true;
                    queue.add(v);
                }
            }
        }  
        return result;
    }
}


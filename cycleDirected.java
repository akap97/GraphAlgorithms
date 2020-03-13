import java.util.ArrayList;
import java.util.Scanner;
import java.util.Iterator;
import java.util.List;

public class Acyclicity {
    private static int acyclic(ArrayList<Integer>[] adj) {
        //write your code here
	boolean[] visited=new boolean[adj.length];
	boolean[] recStack=new boolean[adj.length];
	for(int i=0;i<adj.length;i++)
			if(isCyclicUtil(i,visited,recStack,adj))
				return 1;
        return 0;
	}
    private static boolean isCyclicUtil(int i, boolean[] visited, 
                                      boolean[] recStack,ArrayList<Integer>[] adj)  
    { 
          
        // Mark the current node as visited and 
        // part of recursion stack 
        if (recStack[i]) 
            return true; 
  
        if (visited[i]) 
            return false; 
              
        visited[i] = true; 
  
        recStack[i] = true; 
        ArrayList<Integer> children = adj[i]; 
          
        for (Integer c: children) 
            if (isCyclicUtil(c, visited, recStack,adj)) 
                return true; 
                  
        recStack[i] = false; 
  
        return false; 
    } 

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        ArrayList<Integer>[] adj = (ArrayList<Integer>[])new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < m; i++) {
            int x, y;
            x = scanner.nextInt();
            y = scanner.nextInt();
            adj[x - 1].add(y - 1);
        }
        System.out.println(acyclic(adj));
    }
}

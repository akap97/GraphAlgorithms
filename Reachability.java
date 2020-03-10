import java.util.ArrayList;
import java.util.Scanner;

public class Reachability {
    private static int reach(ArrayList<Integer>[] adj, int x, int y, int[] visited) {
        //write your code here
	if(x==y)
		return 1;
	for(int i=0;i<adj[x].size();i++)
	{
		int it=adj[x].get(i);
		if(visited[it]==0)
		{
			visited[it]=1;
			int reached=reach(adj,it,y,visited);
			if(reached==1)
				return 1;
		}
	
	}	
        return 0;
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
            adj[y - 1].add(x - 1);
        }
        int x = scanner.nextInt() - 1;
        int y = scanner.nextInt() - 1;
	int visited[]=new int[n];
        System.out.println(reach(adj, x, y,visited));
    }
}

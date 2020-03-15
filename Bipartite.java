import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Bipartite {
    private static int bipartite(ArrayList<Integer>[] adj) {
        //write your code here
	int[] colors=new int[adj.length];	
	if(!bfs(adj,colors,0,1))
		return 0;
	
        return 1;
    }
     private static boolean bfs(ArrayList<Integer>[] adj,int[] colors,int i,int color)
	{
		Queue<Integer> q=new LinkedList<>();
		colors[i]=color;
		q.add(i);
		while(!q.isEmpty())
		{
			int u=q.poll();
			for(int v:adj[u])
			{
				if(colors[v]==0)
				{
					q.add(v);
					colors[v]=-colors[u];
				}
				else if(colors[v]==colors[u])
					return false;
			}
		}
		return true;
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
        System.out.println(bipartite(adj));
    }
}

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Iterator;

public class ConnectedComponents {
    private static int numberOfComponents(ArrayList<Integer>[] adj) {
        //write your code here
	int v[]=new int[adj.length];
	int cc=0;
	for(int i=0;i<adj.length;i++)
	{
		if(v[i]==0)
		{
			cc++;
			v[i]=1;
			xplore(adj,i,v);
		}
	}
        return cc;
    }
  private static void xplore(ArrayList<Integer>[] adj, int i,int[] v)
	{
		Iterator<Integer> it=adj[i].iterator();
		while(it.hasNext())
		{
			int next=it.next();
			if(v[next]==0)
			{
				v[next]=1;
				xplore(adj,next,v);
			}
		}
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
        System.out.println(numberOfComponents(adj));
    }
}

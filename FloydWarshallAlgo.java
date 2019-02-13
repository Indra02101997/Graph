import java.util.*;
class FloydWarshallAlgo
{
	static int INF=Integer.MAX_VALUE;
	static int V;
	static void floydwarshall(int dist[][])
	{
		int path[][]=new int[V][V];
		int i,j,k,m,n;
		for(i=0;i<V;i++)
		{
			for(j=0;j<V;j++)
			{
				if(dist[i][j]==INF || (i==j))
					path[i][j]=-1;
				else
					path[i][j]=i;
			}
		}
		for(k=0;k<V;k++)
		{
			for(i=0;i<V;i++)
			{
				for(j=0;j<V;j++)
				{
					if(dist[i][k] == INF || dist[k][j] == INF)
                        continue;
					if(dist[i][j]>(dist[i][k]+dist[k][j]))
					{
						dist[i][j]=dist[i][k]+dist[k][j];
						path[i][j]=path[k][j];
					}
				}
			}
		}
		for(i=0;i<V;i++)
		{
			if(dist[i][i]<0)
			{
				System.out.println("There is a negative weight cycle in the graph");
				System.exit(0);
			}
		}
		for(i=0;i<V;i++)
		{
			for(j=0;j<V;j++)
			{
				if(dist[i][j]!=INF)
					System.out.println("Shortest distance between "+i+" and "+j+" is "+dist[i][j]);
			}
		}
		int start=3;
		int end=2;
		Stack<Integer> stack=new Stack<Integer>();
		stack.push(end);
		while(true)
		{
			if(path[start][end]==-1)
			{
				System.out.println("There is no path between start and end");
				System.exit(0);
			}
			else if(path[start][end]== start)
			{
				stack.push(start);
				break;
			}
			else
			{
				stack.push(path[start][end]);
				end--;
			}
		}
		System.out.println("Shortest path between 3 and 2 is ");
		while(!stack.isEmpty())
		{
			System.out.print(stack.pop()+" --> ");
		}

	}
	public static void main(String[] args) 
	{
		 int[][] graph = {
                {0,   3,   6,   15},
                {INF, 0,  -2,   INF},
                {INF, INF, 0,   2},
                {1,   INF, INF, 0}
        };
        V=4;
        floydwarshall(graph);
	}
}
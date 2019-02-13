import java.util.*;
class PrimMST
{
	static class Graph
	{
		static int V;
		Graph(int v)
		{
			V=v;
		}
		static int getminheap(int key[],boolean mstset[])
		{
			int min_index=-1,min=Integer.MAX_VALUE;
			for(int v=0;v<V;v++)
			{
				if(mstset[v]==false && key[v]<min)
				{
					min=key[v];
					min_index=v;
				}
			}
			return min_index;
		}
		static void prim(int graph[][])
		{
			boolean mstset[]=new boolean[V];
			int key[]=new int[V];
			int parent[]=new int[V];
			for(int i=0;i<V;i++)
			{
				key[i]=Integer.MAX_VALUE;
				mstset[i]=false;
			}
			key[0]=0;
			parent[0]=-1;
			for(int count=0;count<V-1;count++)
			{
				int u=getminheap(key,mstset);
				mstset[u]=true;
				for(int v=0;v<V;v++)
				{
					if(graph[u][v]!=0 && mstset[v]==false && graph[u][v]<key[v])
					{
						key[v]=graph[u][v];
						parent[v]=u;
					}
				}
			}
			for(int v=1;v<V;v++)
			{
				System.out.println(parent[v]+" -- "+v+" = "+key[v]);
			}
		}
	}
	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		int graph[][] = new int[][] {{0, 2, 0, 6, 0}, 
                                    {2, 0, 3, 8, 5}, 
                                    {0, 3, 0, 0, 7}, 
                                    {6, 8, 0, 0, 9}, 
                                    {0, 5, 7, 9, 0}};

        Graph g=new Graph(5);
        g.prim(graph);
	}
}
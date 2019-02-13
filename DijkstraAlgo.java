import java.util.*;
class DijkstraAlgo
{
	static class Graph
	{
		static int V;
		Graph(int v)
		{
			V=v;
		}
		static int getmindistance(boolean sptset[],int dist[])
		{
			int min=Integer.MAX_VALUE;
			int min_index=-1;
			for(int i=0;i<V;i++)
			{
				if(!sptset[i] && dist[i]<=min)
				{
					min=dist[i];
					min_index=i;
				}
			}
			return min_index;
		}
		static void dijkstra(int graph[][],int src)
		{
			boolean sptset[]=new boolean[V];
			int dist[]=new int[V];
			for(int i=0;i<V;i++)
			{
				sptset[i]=false;
				dist[i]=Integer.MAX_VALUE;
			}
			dist[src]=0;
			for(int c=0;c<V-1;c++)
			{
				int u=getmindistance(sptset,dist);
				sptset[u]=true;
				for(int v=0;v<V;v++)
				{
					if(!sptset[v] && graph[u][v]!=0 && graph[u][v]<Integer.MAX_VALUE && (dist[u]+graph[u][v]<dist[v]))
						dist[v]=dist[u]+graph[u][v];
				}
			}
			for(int i=0;i<V;i++)
			{
				System.out.println(i+" :: "+dist[i]);
			}
		}
	}
	public static void main(String[] args) 
	{
		int graph[][] = new int[][]{{0, 4, 0, 0, 0, 0, 0, 8, 0}, 
                                  {4, 0, 8, 0, 0, 0, 0, 11, 0}, 
                                  {0, 8, 0, 7, 0, 4, 0, 0, 2}, 
                                  {0, 0, 7, 0, 9, 14, 0, 0, 0}, 
                                  {0, 0, 0, 9, 0, 10, 0, 0, 0}, 
                                  {0, 0, 4, 14, 10, 0, 2, 0, 0}, 
                                  {0, 0, 0, 0, 0, 2, 0, 1, 6}, 
                                  {8, 11, 0, 0, 0, 0, 1, 0, 7}, 
                                  {0, 0, 2, 0, 0, 0, 6, 7, 0} 
                                 }; 
        int src=0;
        Graph g=new Graph(9);
        g.dijkstra(graph,src);
	}
}
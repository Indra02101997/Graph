import java.util.*;
class Graph
{
	int src,dest,weight;
	Graph(int src,int dest,int weight)
	{
		this.src=src;
		this.dest=dest;
		this.weight=weight;
	}
}
class BellmanFordAlgo
{
	static int V,E;
	static void BellmanFord(Graph graph[],int src)
	{
		int dist[]=new int[V];
		int i,j,k;
		Arrays.fill(dist,Integer.MAX_VALUE);
		dist[src]=0;
		for(j=1;j<V;j++)
		{
			for(i=0;i<E;i++)
			{
				int u=graph[i].src;
				int v=graph[i].dest;
				int weight=graph[i].weight;
				if(dist[u]+weight<dist[v])
					dist[v]=dist[u]+weight;
			}
		}
		for(i=0;i<E;i++)
		{
			int u=graph[i].src;
			int v=graph[i].dest;
			int weight=graph[i].weight;
			if(dist[u]+weight<dist[v])
			{
				System.out.println("Graph contains negative weight cycles");
			}
		}
		System.out.println("The distances are as follows ;");
		for(i=0;i<V;i++)
			System.out.println(i+" :: "+dist[i]);

	}
	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter no of vertices and edges");
		V=sc.nextInt();
		E=sc.nextInt();
		Graph graph[]=new Graph[E];
		for(int i=0;i<E;i++)
		{
			System.out.println("Enter source, weight and destination :");
			int src=sc.nextInt();
			int dest=sc.nextInt();
			int weight=sc.nextInt();
			graph[i]=new Graph(src,dest,weight);
		}
		System.out.println("Enter source node : ");
		int src=sc.nextInt();
		BellmanFord(graph,src);
	}
}
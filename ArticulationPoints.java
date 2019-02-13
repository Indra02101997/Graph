import java.util.*;
class ArticulationPoints
{
	static class Graph
	{
		static int V;
		static Map<Integer,List<Integer>> adj;
		static int nil=-1;
		static int time=0;
		Graph(int v)
		{
			this.V=v;
			this.adj=new HashMap<Integer,List<Integer>>();
		}
		static void addEdge(int u,int v)
		{
			if(!adj.containsKey(u))
				adj.put(u,new ArrayList<Integer>());
			adj.get(u).add(v);
		}
		static void aputil(int u,boolean visited[],int disctime[],int lowtime[],int parent[],boolean ap[])
		{
			int children=0;
			visited[u]=true;
			disctime[u]=lowtime[u]=++time;
			List<Integer> vertices=adj.get(u);
			for(Integer v:vertices)
			{
				if(!visited[v])
				{
					children++;
					parent[v]=u;
					aputil(v,visited,disctime,lowtime,parent,ap);
					lowtime[u]=Math.min(lowtime[u],lowtime[v]);
					if(parent[u]==nil && children>1)
						ap[u]=true;
					if(parent[u]!=nil && disctime[u]<=lowtime[v])
						ap[u]=true;
				}
				else if(v!=parent[u])
					lowtime[u]=Math.min(lowtime[u],disctime[v]); // Checking if there is a back edge then adjust low time of child

			}
		}
		static void AP()
		{
			boolean visited[]=new boolean[V];
			int parent[]=new int[V];
			int disctime[]=new int[V];
			int lowtime[]=new int[V];
			boolean ap[]=new boolean[V];
			Arrays.fill(parent,nil);
			Arrays.fill(visited,false);
			Arrays.fill(ap,false);
			for(int i=0;i<V;i++)
			{
				if(!visited[i])
					aputil(i,visited,disctime,lowtime,parent,ap);
			}
			for(int i=0;i<V;i++)
			{
				if(ap[i])
					System.out.print(i+" ");
			}
		}
	}
	public static void main(String[] args) 
	{
		System.out.println("Articulation points in first graph "); 
        Graph g1 = new Graph(5); 
        g1.addEdge(1, 0);
        g1.addEdge(0, 1); 
        g1.addEdge(0, 2); 
        g1.addEdge(2, 0);
        g1.addEdge(2, 1);
        g1.addEdge(1, 2); 
        g1.addEdge(0, 3);
        g1.addEdge(3, 0); 
        g1.addEdge(3, 4);
        g1.addEdge(4, 3); 
        g1.AP(); 
        System.out.println(); 
  
        System.out.println("Articulation points in Second graph"); 
        Graph g2 = new Graph(4); 
        g2.addEdge(0, 1); 
        g1.addEdge(1, 0);
        g2.addEdge(1, 2); 
        g1.addEdge(2, 1);
        g2.addEdge(2, 3); 
        g1.addEdge(3, 2);
        g2.AP(); 
        System.out.println(); 
  
        System.out.println("Articulation points in Third graph "); 
        Graph g3 = new Graph(7); 
        g3.addEdge(0, 1);
        g1.addEdge(1, 0); 
        g3.addEdge(1, 2);
        g1.addEdge(2, 1); 
        g3.addEdge(2, 0);
        g1.addEdge(0, 2); 
        g3.addEdge(1, 3); 
        g1.addEdge(3, 1);
        g3.addEdge(1, 4); 
        g1.addEdge(4, 1);
        g3.addEdge(1, 6);
        g1.addEdge(6, 1); 
        g3.addEdge(3, 5); 
        g1.addEdge(5, 3);
        g3.addEdge(4, 5); 
        g1.addEdge(5, 4);
        g3.AP(); 
    } 
} 


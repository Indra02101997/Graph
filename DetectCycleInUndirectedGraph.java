import java.util.*;
class DetectCycleInUndirectedGraph 
{
	static class Graph
	{
		static int V;
		static Map<Integer,List<Integer>> adj;
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
		static boolean halfcycleutil(int v,boolean visited[],int parent)
		{
			visited[v]=true;
			List<Integer> vertices=adj.get(v);
			for(Integer i:vertices)
			{
				if(!visited[i])
				{
					if(halfcycleutil(i,visited,v))
						return true;
				}
				else if(i!=parent)
					return true;
			}
			return false;
		}
		static boolean iscycle()
		{
			boolean visited[]=new boolean[V];
			Arrays.fill(visited,false);
			for(int i=0;i<V;i++)
			{
				if(!visited[i])
					if(halfcycleutil(i,visited,-1))
						return true;
			}
			return false;
		}
	}
	public static void main(String[] args) 
	{
		Graph g1 = new Graph(5); 
        g1.addEdge(1, 0);
        g1.addEdge(0, 1);
        g1.addEdge(1, 2);
        g1.addEdge(2, 1);
        g1.addEdge(0, 2); 
        g1.addEdge(2, 0); 
        g1.addEdge(0, 3);
        g1.addEdge(3, 0); 
        g1.addEdge(3, 4);
        g1.addEdge(4, 3); 
        if (g1.iscycle()) 
            System.out.println("Graph contains cycle"); 
        else
            System.out.println("Graph doesn't contains cycle"); 
  
        Graph g2 = new Graph(3); 
        g2.addEdge(0, 1);
        g2.addEdge(1, 0); 
        g2.addEdge(1, 2); 
        g2.addEdge(2, 1);
        if (g2.iscycle()) 
            System.out.println("Graph contains cycle"); 
        else
            System.out.println("Graph doesn't contains cycle"); 
	}
}
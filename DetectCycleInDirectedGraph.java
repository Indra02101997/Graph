import java.util.*;
class DetectCycleInDirectedGraph
{
	static class Graph
	{
		static int V;
		static Map<Integer,List<Integer>> adj;
		Graph(int v)
		{
			V=v;
			adj=new HashMap<Integer,List<Integer>>();
		}
		static void addEdge(int u,int v)
		{
			if(!adj.containsKey(u))
				adj.put(u,new ArrayList<Integer>());
			adj.get(u).add(v);
		}
		static boolean hascycle()
		{
			boolean visited[]=new boolean[V];
			boolean recstack[]=new boolean[V];
			Arrays.fill(visited,false);
			Arrays.fill(recstack,false);
			for(int i=0;i<V;i++)
			{
				if(hascycleutil(i,visited,recstack))
					return true;
			}
			return false;
		}
		static boolean hascycleutil(int i,boolean visited[],boolean recstack[])
		{
			if(recstack[i])
				return true;
			if(visited[i])
				return false;
			visited[i]=true;
			recstack[i]=true;
			List<Integer> vertices=adj.get(i);
			for(Integer c:vertices)
			{
				if(hascycleutil(c,visited,recstack))
					return true;
			}
			recstack[i]=false;
			return false;
		}
	}
	public static void main(String[] args) 
	{
		Graph graph = new Graph(4); 
        graph.addEdge(0, 1); 
        graph.addEdge(0, 2); 
        graph.addEdge(1, 2); 
        graph.addEdge(2, 0); 
        graph.addEdge(2, 3); 
        graph.addEdge(3, 3); 
          
        if(graph.hascycle()) 
            System.out.println("Graph contains cycle"); 
        else
            System.out.println("Graph doesn't "
                                    + "contain cycle"); 
	}
}
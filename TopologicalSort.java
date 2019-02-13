import java.util.*;
class TopologicalSort
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
		static void topologicalsort()
		{
			Stack<Integer> stack=new Stack<Integer>();
			boolean visited[]=new boolean[V];
			Arrays.fill(visited,false);
			for(int i=0;i<V;i++)
			{
				if(!visited[i])
					topologicalsortutil(i,visited,stack);
			}
			while(!stack.isEmpty())
				System.out.print(stack.pop()+" ");
		}
		static void topologicalsortutil(int u,boolean visited[], Stack<Integer> stack)
		{
			visited[u]=true;
			if(adj.containsKey(u))
			{
				for(Integer i:adj.get(u))
				{
					if(!visited[i])
						topologicalsortutil(i,visited,stack);
				}
			}
			stack.push(u);
		}
	}
	public static void main(String[] args) 
	{
		Graph g = new Graph(6); 
        g.addEdge(5, 2); 
        g.addEdge(5, 0); 
        g.addEdge(4, 0); 
        g.addEdge(4, 1); 
        g.addEdge(2, 3); 
        g.addEdge(3, 1); 
  
        System.out.println("Following is a Topological " + 
                           "sort of the given graph"); 
        g.topologicalsort(); 
	}
}
import java.util.*;
class Kosaraju
{
	static class Graph
	{
		static int V;
		static Map<Integer,List<Integer>> adj;
		static Map<Integer,List<Integer>> adjtranspose;
		Graph(int v)
		{
			V=v;
			adj=new HashMap<Integer,List<Integer>>();
			adjtranspose=new HashMap<Integer,List<Integer>>();
		}
		static void addEdge(int u,int v)
		{
			if(!adj.containsKey(u))
				adj.put(u,new ArrayList<Integer>());
			if(!adjtranspose.containsKey(v))
				adjtranspose.put(v,new ArrayList<Integer>());
			adj.get(u).add(v);
			adjtranspose.get(v).add(u);
		}
		static void fillorder(int u,boolean visited[],Stack<Integer> stack)
		{
			visited[u]=true;
			if(adj.containsKey(u))
			{
				for(Integer i:adj.get(u))
				{
					if(!visited[i])
						fillorder(i,visited,stack);
				}
			}
			stack.push(u);
		}
		static void dfsutil(int u, boolean visited[])
		{
			visited[u]=true;
			System.out.print(u+" ");
			if(adjtranspose.containsKey(u))
			{
				for(Integer i: adjtranspose.get(u))
				{
					if(!visited[i])
						dfsutil(i,visited);
				}
			}
		}
		static void SCC(Graph graph)
		{
			boolean visited[]=new boolean[V];
			Arrays.fill(visited,false);
			Stack<Integer> stack=new Stack<Integer>();
			int i,j,k,l;
			for(i=0;i<V;i++)
			{
				if(!visited[i])
					fillorder(i,visited,stack);
			}
			Arrays.fill(visited,false);
			while(!stack.isEmpty())
			{
				int v=stack.pop();
				if(!visited[v])
				{
					dfsutil(v,visited);
					System.out.println();
				}
			}
		}
	}
	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		Graph graph=new Graph(7);
		graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(1, 3);
        graph.addEdge(3, 4);
        graph.addEdge(4, 5);
        graph.addEdge(5, 3);
        graph.addEdge(5, 6);
        graph.SCC(graph);
	}
}
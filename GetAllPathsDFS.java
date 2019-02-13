import java.util.*;
class GetAllPathsDFS
{
	static class Graph
	{
		int V;
		Map<Integer,List<Integer>> adj;
		Graph(int v)
		{
			V=v;
			adj=new HashMap<Integer,List<Integer>>();
		}
		static void addEdge(int u,int v)
		{
			if(!adj.containsKey(u))
			{
				adj.put(u,new ArrayList<Integer>());
			}
			adj.get(u).add(v);
		}
		static List<List<Integer>> getallpaths(int u,int v)
		{
			List<List<Integer>> result=new ArrayList<List<Integer>>();
			if(u==v)
			{
				List<Integer> temp=new ArrayList<Integer>();
				temp.add(u);
				result.add(temp);
				return result;
			}
			boolean visited[]=new boolean[V];
			Deque<Integer> path=new Deque<Integer>();
			getallpathsDFS(u,v,path,visited,result);
			return result;
		}
		static void getallpathsDFS(int u,int v,Deque<Integer> path,boolean visited[], List<List<Integer>>)
		{
			visited[u]=true;
			path.add(u);
			if(u==v)
			{
				result.add(new ArrayList<Integer>(path));
			}
			else
			{
				if(adj.containsKey(u))
				{
					for(Integer i: adj.get(u))
					{
						if(!visited[i])
							getallpathsDFS(i,v,path,visited,result);
					}
				}
			}
			path.removeLast();
			visited[u]=false;
		}
	}
	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		Graph g = new Graph(4);
		g.addEdge(0,1);
		g.addEdge(0,2);
		g.addEdge(0,3);
		g.addEdge(2,0);
		g.addEdge(2,1);
		g.addEdge(1,3);
		List<List<Integer>> results = g.getallpaths(2,3);
		for(List<Integer> l : results){
			System.out.println(l);
	}
}
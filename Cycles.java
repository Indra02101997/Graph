import java.util.*;
class Cycles
{
	static class Graph
	{
		static Map<Integer,List<Integer>> adj;
		static int cycleno=0;
		Graph()
		{
			adj=new HashMap<Integer,List<Integer>>();
		}
		static void addEdge(int u,int v)
		{
			if(!adj.containsKey(u))
				adj.put(u,new ArrayList<Integer>());
			adj.get(u).add(v);
		}
		static void dfs(int u,int p,int color[],Map<Integer,Integer> parent,Map<Integer,Integer> mark)
		{
			if(color[u]==2)
				return;
			if(color[u]==1)
			{
				cycleno++;
				int cur=p;
				mark.put(cur,cycleno);
				while (cur!=u) 
				{
					cur=parent.get(cur);
					mark.put(cur,cycleno);
				}
				return;
			}
			parent.put(u,p);
			color[u]=1;
			List<Integer> vertices=adj.get(u);
			for(Integer i:vertices)
			{
				if(i==parent.get(u))
					continue;
				dfs(i,u,color,parent,mark);
			}
			color[u]=2;
		}
		static void printcycles(Map<Integer,Integer> mark,Map<Integer,Integer> parent,int edges)
		{
			Map<Integer,List<Integer>> cycles=new HashMap<Integer,List<Integer>>();
			for(Map.Entry<Integer,Integer> e:mark.entrySet())
			{
				int curr=e.getKey();
				int cycleno=e.getValue();
				if(!cycles.containsKey(cycleno))
					cycles.put(cycleno,new ArrayList<Integer>());
				cycles.get(cycleno).add(curr);
			}
			for(Map.Entry<Integer,List<Integer>> e:cycles.entrySet())
			{
				int cycleno=e.getKey();
				List<Integer> cycle=e.getValue();
				System.out.print(cycleno+" :: ");
				for(Integer i1:cycle)
					System.out.print(i1+" ");
				System.out.println();
			}
		}
	}
	public static void main(String[] args) 
	{
		Graph g=new Graph();
		g.addEdge(1, 2); 
		g.addEdge(2, 1);
    	g.addEdge(2, 3); 
    	g.addEdge(3, 2);
    	g.addEdge(3, 4);
    	g.addEdge(4, 3); 
    	g.addEdge(4, 6);
    	g.addEdge(6, 4); 
    	g.addEdge(4, 7); 
    	g.addEdge(7, 4);
    	g.addEdge(5, 6);
    	g.addEdge(6, 5); 
    	g.addEdge(3, 5); 
    	g.addEdge(5, 3);
    	g.addEdge(7, 8); 
    	g.addEdge(8, 7);
    	g.addEdge(6, 10); 
    	g.addEdge(10, 6);
    	g.addEdge(5, 9);
    	g.addEdge(9, 5); 
    	g.addEdge(10, 11);
    	g.addEdge(11, 10); 
    	g.addEdge(11, 12); 
    	g.addEdge(12, 11);
    	g.addEdge(11, 13); 
    	g.addEdge(13, 11);
    	g.addEdge(12, 13); 
    	g.addEdge(13, 12);
		int edges=13;
		Map<Integer,Integer> parent=new HashMap<Integer,Integer>();
		Map<Integer,Integer> mark=new HashMap<Integer,Integer>();
		int color[]=new int[2*edges+1];
		g.dfs(1,0,color,parent,mark);
		g.printcycles(mark,parent,edges);
	}
}
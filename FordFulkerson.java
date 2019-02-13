import java.util.*;
class FordFulkerson
{
	static void maxflow(int capacity[][],int source,int sink)
	{
		int residualcapacity[][]=new int[capacity.length][capacity[0].length];
		int i,j,k,l,m,n,u,v;
		for(i=0;i<capacity.length;i++)
		{
			for(j=0;j<capacity[0].length;j++)
			{
				residualcapacity[i][j]=capacity[i][j];
			}
		}
		Map<Integer,Integer> parent=new HashMap<Integer,Integer>();
		List<List<Integer>> paths=new ArrayList<List<Integer>>();
		int max=0;
		while(BFS(residualcapacity,parent,source,sink))
		{
			v=sink;
			List<Integer> path=new ArrayList<Integer>();
			int flow=Integer.MAX_VALUE;
			while(v!=source)
			{
				path.add(v);
				u=parent.get(v);
				if(flow>residualcapacity[u][v])
					flow=residualcapacity[u][v];
				v=u;
			}
			path.add(source);
			Collections.reverse(path);
			paths.add(path);
			max+=flow;
			v=sink;
			while(v!=source)
			{
				u=parent.get(v);
				residualcapacity[u][v]-=flow;
				residualcapacity[v][u]+=flow;
				v=u;
			}
		}
		System.out.println("The maximum load that can be sent from source to sink  is "+max);
		System.out.println("The paths are :");
		for(List<Integer> path : paths)
		{
			System.out.println(path);
		}
	}
	static boolean BFS(int residualcapacity[][],Map<Integer,Integer> parent, int source,int sink)
	{
		Set<Integer> visited=new HashSet<Integer>();
		Queue<Integer> queue=new LinkedList<Integer>();
		visited.add(source);
		queue.add(source);
		boolean foundpath=false;
		while(!queue.isEmpty())
		{
			int u=queue.poll();
			for(int v=0;v<residualcapacity.length;v++)
			{
				if(!visited.contains(v) && residualcapacity[u][v]>0)
				{
					visited.add(v);
					parent.put(v,u);
					queue.add(v);
					if(v==sink)
					{
						foundpath=true;
						break;
					}
				}
			}
		}
		return foundpath;
	}
	public static void main(String[] args) 
	{
		int[][] capacity = {{0, 3, 0, 3, 0, 0, 0},
                            {0, 0, 4, 0, 0, 0, 0},
                            {3, 0, 0, 1, 2, 0, 0},
                            {0, 0, 0, 0, 2, 6, 0},
                            {0, 1, 0, 0, 0, 0, 1},
                            {0, 0, 0, 0, 0, 0, 9},
                            {0, 0, 0, 0, 0, 0, 0}};
        maxflow(capacity,0,6);
	}
}
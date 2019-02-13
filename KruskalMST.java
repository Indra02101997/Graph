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
class KruskalMST
{
	static int find(Map<Integer,List<Integer>> sets,int src)
	{
		int res=-1;
		for(Map.Entry<Integer,List<Integer>> e:sets.entrySet())
		{
			List<Integer> ans=e.getValue();
			if(ans.contains(src))
			{
				res=e.getKey();
				break;
			}
		}
		return res;
	}
	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		int i,j,k,l,m,n,t,p,q;
		System.out.println("Enter the no of vertices and edges ");
		n=sc.nextInt();
		m=sc.nextInt();
		Graph graph[]=new Graph[m];
		for(i=0;i<m;i++)
		{
			System.out.println("Enter source,weight,destination");
			p=sc.nextInt();
			q=sc.nextInt();
			l=sc.nextInt();
			graph[i]=new Graph(p,q,l);
		}
		for(i=0;i<m-1;i++)
		{
			for(j=i+1;j<m;j++)
			{
				if(graph[i].weight>graph[j].weight)
				{
					Graph temp=graph[i];
					graph[i]=graph[j];
					graph[j]=temp;
				}
			}
		}
		Map<Integer,List<Integer>> sets=new HashMap<Integer,List<Integer>>();
		for(i=0;i<n;i++)
		{
			sets.put(i,new ArrayList<Integer>());
			sets.get(i).add(i);
		}
		List<Graph> fans=new ArrayList<Graph>();
		for(i=0;i<m;i++)
		{
			int src=graph[i].src;
			int dest=graph[i].dest;
			int x=find(sets,src);
			int y=find(sets,dest);
			if(x!=y)
			{
				List<Integer> t1=sets.get(y);
				sets.get(x).addAll(t1);
				sets.remove(y);
				fans.add(graph[i]);
			}
		}
		System.out.println("Following are the edges of the constructed MST");
		for(i=0;i<fans.size();i++)
		{
			System.out.println(fans.get(i).src+" --> "+fans.get(i).dest+" == "+fans.get(i).weight);
		}
	}
}
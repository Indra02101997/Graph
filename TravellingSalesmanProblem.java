import java.util.*;
class TravellingSalesmanProblem
{
	static void tsp(int adj[][],int src,int n)
	{
		boolean visited[]=new boolean[n];
		Arrays.fill(visited,false);
		visited[src]=true;
		System.out.print(src+ " ");
		Stack<Integer> stack=new Stack<Integer>();
		stack.push(src);
		int i=0, element=src, dst=src, sum=0;
		int min=Integer.MAX_VALUE;
		boolean flag=false;
		while(!stack.isEmpty())
		{
			element=stack.peek();
			min=Integer.MAX_VALUE;
			i=0;
			while(i<n)
			{
				if(adj[element][i]!=0 && visited[i]==false)
				{
					if(adj[element][i]<min)
					{
						min=adj[element][i];
						dst=i;
						flag=true;
					}
				}
				i++;
			}
			if(flag)
			{
				flag=false;
				stack.push(dst);
				visited[dst]=true;
				System.out.print(dst+ " ");
				sum+=adj[element][dst];
				continue;
			}
			stack.pop();
		}
		System.out.print(src+" ");
		System.out.println();
		System.out.println("The weights are : "+(sum+adj[dst][src]));
	}
	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		int i,j,k,n;
		System.out.println("Enter the no of nodes : ");
		n=sc.nextInt();
		int adj[][]=new int[n][n];
		System.out.println("Enter the adjacency matrix : ");
		for(i=0;i<n;i++)
		{
			for(j=0;j<n;j++)
			{
				adj[i][j]=sc.nextInt();
			}
		}
		System.out.println("Enter the source node : ");
		int src=sc.nextInt();
		tsp(adj,src,n);
	}
}
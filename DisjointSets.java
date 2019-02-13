import java.util.*;
class Node
{
	long data;
	int rank;
	Node parent;
}
class DisjointSets
{
	static public Map<Long,Node> map=new HashMap<Long,Node>();
	static void makeset(long data)
	{
		Node node=new Node();
		node.data=data;
		node.rank=0;
		node.parent=node;
		map.put(data,node);
	}
	static boolean union(long data1,long data2)
	{
		Node node1=map.get(data1);
		Node node2=map.get(data2);
		Node parent1=findset(node1);
		Node parent2=findset(node2);
		if(parent1.data==parent2.data)
			return false;
		if(parent1.rank>=parent2.rank)
		{
			parent1.rank=(parent1.rank==parent2.rank)?parent1.rank+1:parent2.rank;
			parent2.parent=parent1;
		}
		else
			parent1.parent=parent2;
		return true;
	}
	static Node findset(Node node)
	{
		Node par=node.parent;
		if(par==node)
			return par;
		node.parent=findset(node.parent);
		return node.parent;
	}
	static long find(long data)
	{
		return findset(map.get(data)).data;
	}
	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		int i,j,k,l,m,n,t,p,q;
		makeset(1);
		makeset(2);
		makeset(3);
		makeset(4);
		makeset(5);
		makeset(6);
		makeset(7);
		union(1,2);
		union(2,3);
		union(4,5);
		union(6,7);
		union(5,6);
		union(3,7);
		System.out.println(find(1));
		System.out.println(find(2));
		System.out.println(find(3));
		System.out.println(find(4));
		System.out.println(find(5));
		System.out.println(find(6));
		System.out.println(find(7));
	}
}
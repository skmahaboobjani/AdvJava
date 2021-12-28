package graphs;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
public class Graph {
	private int V;
	private int E;
	private boolean[][] adjMatrix; 
	public Graph(int V,int E) throws Exception {
		this.V=V;
		if(E > ( V*(V-1))/2+V )
		{
			throw new Exception("No of Edges are exceded");
		}
		this.E=E;
		this.adjMatrix=new boolean[V][V];
	}
	private void addEdge(int i, int j) {
		adjMatrix[i][j]=true;
		adjMatrix[j][i]=true;
	}
	public static void main(String[] args) throws Exception {
		int V=8;
		int E=8;
		Graph g=new Graph(V,E);
		g.addEdge(0,1);
		g.addEdge(1,2);
		g.addEdge(1,3);
		g.addEdge(3,4);
		g.addEdge(2,4);
		g.addEdge(3,6);
		g.addEdge(4,7);
		g.addEdge(4,5);
		g.DFS();
		g.BFS();
		
	}
	private void BFS() {
		System.out.println("BFS Order of A Graph");
		Queue<Integer> que=new LinkedList<Integer>();
		boolean visited[]=new boolean[V];
		que.offer(0);
		visited[0]=true;
		while(!que.isEmpty())
		{
			int nextE=que.remove();
			System.out.println(nextE);
			for(int i=0;i<V;i++)
			{
				if(adjMatrix[nextE][i]==true&&!visited[i])
				{
					que.offer(i);
					visited[i]=true;
				}
			}
		}
		
	}
	private void DFS() {
		System.out.println("DFS Order of A Graph");
		Stack<Integer> stack=new Stack<Integer>();
		boolean visited[]=new boolean[V];
		stack.push(0);
		visited[0]=true;
		while(!stack.isEmpty())
		{
			int nextE=stack.pop();
			System.out.println(nextE);
			for(int i=0;i<V;i++)
			{
				if(adjMatrix[nextE][i]==true&&!visited[i])
				{
					stack.push(i);
					visited[i]=true;
				}
			}
		}
	}
}
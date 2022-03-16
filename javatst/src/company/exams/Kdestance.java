package company.exams;

import java.util.ArrayList;
import java.util.List;

class Node
{
	int val;
	Node left=null;
	Node right=null;
	Node(int val)
	{
		this.val=val;
	}
}

public class Kdestance {

	public Kdestance() {
		// 
	}
	public static void main(String[] args) {
		Node root=null;
		
		root=new Node(1);
		root.left=new Node(2);
		root.left.left=new Node(4);
		root.left.right=new Node(5);
		root.right=new Node(3);
		 List<Integer> list=new ArrayList<Integer>();
		 list.add(1);
		 list.add(2);
		 System.out.println(list);
		 
	}

}

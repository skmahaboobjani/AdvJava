import java.util.*;
interface Queue1
{
     void queueEnqueue(int item);
     void queueDequeue(); 
     void queueDisplay();
     void queueFront();
}
class LinkedList1 implements Queue1
{
	static int front=0, rear=0, capacity=-1;  
	public LinkedList1() {
		// TODO Auto-generated constructor stub
	}
 	static LinkedList<Integer> list=new LinkedList<Integer>();
	  public void queueEnqueue(int item)  { 
	        // check if the queue is full
	        if (capacity == rear) { 
	            System.out.printf("\nQueue is full\n"); 
	            return; 
	        } 
	        else { 
	            list.add(item);
	            rear++; 
	        } 
	        return; 
	    } 
	    //remove an element from the queue
	   public void queueDequeue()  { 
	        // check if queue is empty 
	        if (front == rear) { 
	            System.out.printf("\nQueue is empty\n"); 
	            return; 
	        } 
	        // shift elements to the right by one place uptil rear 
	        else { 
	            for (int i = 0; i < rear - 1; i++) { 
	               
	            	list.set(i,list.get(i+1));
	            	//queue[i] = queue[i + 1]; 
	            }  
	      // set queue[rear] to 0
	            if (rear < capacity) 
	               // queue[rear] = 0;
	            	list.set(rear,0);
	   
	            // decrement rear 
	            rear--; 
	        } 
	        return; 
	    } 
	    // print queue elements 
	    public  void queueDisplay() 
	    { 
	        int i; 
	        if (front == rear) { 
	            System.out.printf("Queue is Empty\n"); 
	            return; 
	        } 
	        // traverse front to rear and print elements 
	        for (i = front; i < rear; i++) { 
	            System.out.printf(" %d , ", list.get(i)); 
	        } 
	        return; 
	    } 
	    // print front of queue 
	    public void queueFront() 
	    { 
	        if (front == rear) { 
	            System.out.printf("Queue is Empty\n"); 
	            return; 
	        } 
	        System.out.printf("\nFront Element of the queue: %d", list.get(front)); 
	        System.out.println(); 
	        return; 
	    } 
}
public class QueueImplementation {
	public QueueImplementation() {
		// TODO Auto-generated constructor stub
	}
	public static void main(String[] args) {	
		// TODO Auto-generated method stu
		//List<Integer> list=new LinkedList<Integer>();
		Queue1 q=new LinkedList1();
		//Queue1.queueEnqueue(11);
		q.queueEnqueue(11);
		q.queueEnqueue(12);
		q.queueEnqueue(13);
		q.queueEnqueue(14);
		
	    q.queueDisplay();
	    q.queueDequeue();
	    q.queueFront();
	    q.queueDisplay();
	}
}

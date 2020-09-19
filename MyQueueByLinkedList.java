
public class MyQueueByLinkedList {

	QueueNode front, rear;
	
	void push(int a) {
		QueueNode temp = new QueueNode(a);
		
		if(front != null) {
			front = temp;
			rear = temp;
			return;
		}

		rear.next = temp;
		rear = rear.next;
	}
	
	int pop() {
		int a = 0;
		if(rear == null) {
			a = -1;
		} else {
			a = front.data;
			front = front.next;
		}
		
		// This case :- when the last element is removed, queue becomes empty but the rear node is still referring to something. 
		// Either change (front == null) in 21 line or add this condition.
		if(front == null){
		    rear = null;
		}
		return a;
	}
}

class QueueNode
{
	int data;
	QueueNode next;
	QueueNode(int a)
	{
	    data = a;
	    next = null;
	}
}
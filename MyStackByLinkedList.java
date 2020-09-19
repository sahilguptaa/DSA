
public class MyStackByLinkedList {

	LLNode top ;
	
	void push(int data) {
		if(top == null) {
			top = new LLNode(data);
			return;
		}
		LLNode newTop = new LLNode(data);
		
		// We can combine the creation of new NOde at the top of function.
		
		newTop.next = top;
		top = newTop;
		
	}
	
	int pop() {
		
		if(top == null) {
			return -1;
		}
		int data = top.data;
		top = top.next;
		
		return data;
	}
}

class LLNode{
	 int data;
	 LLNode next;
	 LLNode(int a)
	    {
	       data = a;
	       next = null;
	    }
}

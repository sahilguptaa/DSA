
public class TestLinkedList {
	
	Node head;
	Node head1;

		
	public static void main(String args[]) {
		TestLinkedList list = new TestLinkedList(); 
	       // creating first linked list 
        list.head1 = new Node(3); 
        list.head1.next = new Node(6); 
        list.head1.next.next = new Node(9); 
        list.head1.next.next.next = new Node(15); 
        list.head1.next.next.next.next = new Node(30); 
  
        // creating second linked list 
        list.head = new Node(10); 
        list.head.next = list.head1.next.next.next; 
        list.head.next.next = list.head1.next.next.next.next; 
        
        System.out.println(list.getIntersectionNodeOfYShapedLL(list.head1, list.head).data);
	}
	
	Node getIntersectionNodeOfYShapedLL (Node headA, Node headB) {
		
		Node ptrA = headA;
		while(ptrA.next != null) {
			ptrA = ptrA.next;
		}
		Node lastNode = ptrA;
		ptrA.next = headB;
		
		Node slowNode = headA;
		Node fastNode = headA;
		Node loopNode = null;
		while(fastNode != null && fastNode.next != null) {
			
			slowNode = slowNode.next;
			fastNode = fastNode.next.next;
			
			if(slowNode == fastNode) {
				loopNode = fastNode;
				break;
			}
		}
		
		int k = 1;
		while(slowNode.next != fastNode) {
			k++;
			slowNode = slowNode.next;
		}
		slowNode = headA;
		fastNode = headA;
		while(k>0) {
			slowNode = slowNode.next;
			k--;
		}
		
		while(slowNode != fastNode) {
			slowNode = slowNode.next;
			fastNode = fastNode.next;
		}
		lastNode.next = null;
		return slowNode;
	}
	
	boolean isPalindrome(Node head) {
		
		Node fast = head;
		Node slow = head;
		
		// ToDO construct th original LL back.
		Node prevOfSlow = null;
		
		Node midNode = null;
		while(fast != null && fast.next != null) {
			fast = fast.next.next;
			prevOfSlow = slow;
			slow = slow.next;
		}
		if(fast != null) {
			midNode = slow;
			slow = slow.next;
		}
		fast = head;
		slow = reverse(slow);
		prevOfSlow = null;
		
		while(slow != null) {
			if(slow.data != fast.data) {
				return false;
			}
			slow = slow.next;
			fast = fast.next;
		}
		
		return true;
	}
	
    Node reverse(Node head){
        Node prev = null;
        Node right = null;
        Node curr = head;
        while(curr != null){
            right = curr.next;
            curr.next = prev;
            prev = curr;
            curr = right;
        }
        return prev;
    }
	
	// Function to print the linked list 
    void printList(Node node) 
    { 
        while (node != null) { 
            System.out.print(node.data + " "); 
            node = node.next; 
        } 
    } 
    
	int intersectPoint(Node headA, Node headB)
	{
         // code here
		return -1;
	}
    
    void detectAndRemoveLoop (Node head) {
    	  if(head.next != null){
              
    	        
    	        Node slowNode = head;
    	        Node fastNode = head;
    	        Node loopNode = null;
    	        boolean loop = false;
    	        while(fastNode != null && fastNode.next != null ){
    	            slowNode = slowNode.next;
    	            fastNode = fastNode.next.next;
    	            if(fastNode == slowNode){
    	                loopNode = fastNode;
    	                loop = true;
    	                break;
    	            }

    	        }
    	        if(!loop) {
    	        	return;
    	        }
    	        slowNode = loopNode;
    	        int k = 1;
    	        while(slowNode.next != loopNode){
    	            slowNode = slowNode.next;
    	            k++;
    	        }
    	         
    	        // Bring slowNode to 'k' nodes after head.
    	        slowNode = head;
    	        while(k>0){
    	            slowNode= slowNode.next;
    	            k--;
    	        }
    	       fastNode = head;
    	        // Find the starting node of loop.
    	        while(fastNode != slowNode) {
    	        	fastNode = fastNode.next;
    	        	slowNode = slowNode.next;
    	        }
    	        
    	        while(slowNode.next!=fastNode){
//    	            head = head.next;
    	            slowNode = slowNode.next;
    	        }
    	        slowNode.next = null;
    	         }
    }

    int getNthFromLast(Node head, int n)
    {
    	// Your code here	
    	Node curr = head;
    	Node start = head;
    	while(n-1>0){
    	    n--;

    	    curr = curr.next;
    	    if(curr == null){
    	        return -1;
    	    }
    	    
    	}
    	while(curr.next != null){
    	    start = start.next;
    	    curr = curr.next;
    	}
    	return start.data;
    }
}

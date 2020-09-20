import java.util.HashSet;

public class TestLinkedList {
	
	Node head;
	Node head1;

		
	public static void main(String args[]) {
		TestLinkedList list = new TestLinkedList(); 
	       // creating first linked list 
        list.head1 = new Node(9); 
        list.head1.next = new Node(1); 
//        list.head1.next.next = new Node(5); 
//        list.head1.next.next.next = new Node(4); 
//        list.head1.next.next.next.next = new Node(9);
//        list.head1.next.next.next.next.next = new Node(6);
  
        // creating second linked list 
        list.head = new Node(6); 
//        list.head.next = new Node(6); 
//        list.head.next.next = new Node(5); 
        Node x = list.mergeSortLinkedList(list.head1);
        System.out.println(x);
	}
	
	
	
	private Node mergeSortLinkedList(Node head) {
		
		if(head == null || head.next == null) {
			return head;
		}
		
		Node currHead = head;
		Node temp = null;
		Node slow = head;
		Node fast = head;
		
		while(fast != null && fast.next != null) {
			temp = slow;
			slow = slow.next;
			fast = fast.next.next;
		}
		
		temp.next = null;
		
		Node headA = mergeSortLinkedList(head);
		Node headB = mergeSortLinkedList(slow);
		
		
		return sortedMerge(headA, headB);
	}



	private Node removeDuplicatesFromUnsortedLL(Node head) {
		Node ptr = head;
		
		// Use hash set in order not to break the order of existing elements.
		HashSet<Integer> numbers = new HashSet<>();
		Node prevPtr = null;
		while(ptr != null) {
			if(numbers.contains(ptr.data)) {
//				ptr.data = ptr.next.data;
//				ptr.next= ptr.next.next;
				prevPtr.next = ptr.next;
			} else {
				numbers.add(ptr.data);
				prevPtr = ptr;
			}
			ptr = ptr.next;
			
		}
		
		
		return head;
	}
	
	private Node sumOfTwoLL(Node head1, Node head2) {
		
		if(head1 == null) {
			return head2;
		} if(head2 == null) {
			return head1;
		}
		
		Node headA = reverse(head1);
		Node headB = reverse(head2);
		
		Node sumNode = new Node(0);
		Node newNode = sumNode;
		
		int carry = 0;
		
		while(headA != null || headB != null) {
			int valueA = (headA != null) ? headA.data : 0;
			int valueB = (headB != null) ? headB.data : 0;
			
			int currSum = (valueA + valueB + carry);
			
			int sum = currSum % 10;
			carry = currSum / 10;
			
			Node lastNode = new Node(sum);
			newNode.next = lastNode;
			newNode = newNode.next;
			
			if(headA != null) {
				headA = headA.next;
			}
			if(headB != null) {
				headB = headB.next;
			}
			
		}
		
		if(carry != 0) {
			Node lastNode = new Node(carry);
			newNode.next = lastNode;
		}
		
		sumNode.next = reverse(sumNode.next);
		return sumNode.next;
	}
	
	private Node sum(Node head1, Node head2) {
		// TODO Auto-generated method stub
		if(head1 == null) {
			return head2;
		} if(head2 == null) {
			return head1;
		}
		
		Node headA = reverse(head1);
		Node headB = reverse(head2);
		
		Node sumNode = new Node(0);
		Node newNode = sumNode;
		
		int carry = 0;
		while(headA != null && headB != null) {
			int sum = (headA.data + headB.data + carry) % 10;
			carry = (headA.data + headB.data + carry) / 10;
			
			headA = headA.next;
			headB = headB.next;
			
			Node newDigit = new Node(sum);
			newNode.next = newDigit;
			newNode = newNode.next;
		}
		while(headA != null) {
			int sum = (headA.data + carry) % 10;
			carry = (headA.data + carry) / 10;
			
			headA = headA.next;
//			headB = headB.next;
			
			Node newDigit = new Node(sum);
			newNode.next = newDigit;
			newNode = newNode.next;
		}
		while(headB != null) {
			int sum = (headB.data + carry) % 10;
			carry = (headB.data + carry) / 10;
			
			headB = headB.next;
//			headB = headB.next;
			
			Node newDigit = new Node(sum);
			newNode.next = newDigit;
			newNode = newNode.next;
		}
		
		if(carry != 0) {
			newNode.next = new Node(carry);
//			sumNode.data = carry;
			
		}

		
		
		return reverse(sumNode.next);
	}

	Node sortedMerge(Node headA, Node headB) {
		
		Node newNode = headA;
		Node ptrA = headA;
		Node ptrB = headB;
		Node ptrC; 
		if(ptrA.data > ptrB.data) {
			newNode = ptrB;
			ptrB = ptrB.next;
			ptrC = newNode;
//			ptrC = ptrC.next;
		} else {
			newNode = ptrA;
			ptrA = ptrA.next;
			ptrC = newNode;
//			ptrC = ptrC.next;
		}
		while(ptrA!=null && ptrB!=null) {
			if(ptrA.data > ptrB.data) {
				ptrC.next = ptrB;
				ptrB = ptrB.next;
				ptrC = ptrC.next;
			} else {
				ptrC.next = ptrA;
				ptrA = ptrA.next;
				ptrC = ptrC.next;
			}
		}
		
		while(ptrA != null) {
			ptrC.next = ptrA;
			ptrA = ptrA.next;
			ptrC = ptrC.next;
		}
		
		while(ptrB != null) {
			ptrC.next = ptrB;
			ptrB = ptrB.next;
			ptrC = ptrC.next;
		}
		
		return newNode;
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

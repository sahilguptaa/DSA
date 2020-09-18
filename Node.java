
public class Node {
	
	public int data;
	public Node next;
	public Node right;
	
	public Node(int item) 
    { 
        data = item; 
        next = null; 
    }
	// hello
	
//	public Node addNode(Node current, int value) {
//		if(current == null) {
//			return new Node(value);
//		}
//		if(value < current.data) {
//			current.left = addNode(current.left, value);
//		} else if(value > current.data) {
//			current.right = addNode(current.right, value);
//		} else {
//			return current;
//		}
//		return current;
//	}
	
	public Node rotate(Node head, int k) {
        // add code here
        Node currNode = head;
        Node newHead;
        for(int i=1;i<k;i++){
            currNode = currNode.right;
        }
        newHead = currNode.right;
        if(newHead == null){
            return head;
        }
        currNode.right = null;
        currNode = newHead;
        while(currNode.right != null){
            currNode = currNode.right;
        }
        currNode.right = head;
        return newHead;
    }
	
    public static Node reverseInGroupOfK(Node node, int k)
    {
        //Your code here
        Node prev = null;
        Node right = null;
        Node curr = node;
        
        int count = 0;
        while(count<k && curr != null){
            count++;
            right = curr.right;
            curr.right= prev;
            prev = curr;
            curr = right;
        }
        
        if(right != null){
            node.right = reverseInGroupOfK(right, k);
        }
        return prev;
        
    }
    
    Node removeAllGreaterValuesNodeOnRight(Node head)
    {
        // your code here
        head = reverse(head);
        
        int max = head.data;
        Node curr = head;
        while(curr!=null && curr.right != null){
            if(max > curr.right.data){
                curr.right = curr.right.right;
            } else {
                max = curr.right.data;
            
            curr = curr.right;
        }}
        
        head = reverse(head);
        return head;
        
    }
    
    Node reverse(Node head){
        Node prev = null;
        Node right = null;
        Node curr = head;
        while(curr != null){
            right = curr.right;
            curr.right = prev;
            prev = curr;
            curr = right;
        }
        return prev;
    }
	
}

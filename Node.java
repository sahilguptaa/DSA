
public class Node {
	
	public int data;
	public Node left;
	public Node right;
	
	public Node(int item) 
    { 
        data = item; 
        left = right = null; 
    }
	// hello
	
	public Node addNode(Node current, int value) {
		if(current == null) {
			return new Node(value);
		}
		if(value < current.data) {
			current.left = addNode(current.left, value);
		} else if(value > current.data) {
			current.right = addNode(current.right, value);
		} else {
			return current;
		}
		return current;
	}
	
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
	
}
